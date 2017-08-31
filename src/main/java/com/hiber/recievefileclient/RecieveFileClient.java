/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hiber.recievefileclient;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author SHWETA
 */
public class RecieveFileClient {

    public static void main(String[] args) {
        String fileName = "IP.png";
        String filePath = "C:/Users/SHWETA/Downloads/" + fileName;
        byte[] fileBytes = download(fileName);
        try {
            FileOutputStream fos = new FileOutputStream(filePath);
            BufferedOutputStream outputStream = new BufferedOutputStream(fos);
            if(fileBytes != null) {
            outputStream.write(fileBytes);
            outputStream.close();             
            System.out.println("File downloaded at: " + filePath);  
            } else {
                System.out.println("File does not exist at server");
            }
        } catch(IOException ex) {
            System.out.println("Error Occured "+ ex);
        }
    }
    
    private static byte[] download(String fileName) {
        byte[] result = null;
        try { 
            com.hiber.service.UploadFile_Service service = new com.hiber.service.UploadFile_Service();
            com.hiber.service.UploadFile port = service.getUploadFilePort();            
            result = port.download(fileName);
            return result;
        } catch (Exception ex) {
            return result;
        } 
    }
}
