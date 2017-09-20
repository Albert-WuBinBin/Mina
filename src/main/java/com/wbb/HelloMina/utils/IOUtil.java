package com.wbb.HelloMina.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class IOUtil {
	
	public static void write(String msg){
		FileWriter fw = null;
        BufferedWriter  bw = null;
        Random random=new Random();
        String path1=IOUtil.class.getResource("/").getPath();
        String path=path1 +"/logs/temp/part/data.txt"; 
      
        try {
        	File file = new File(path);
        	if(!file.getParentFile().exists()){
        	    file.getParentFile().mkdirs();
        	}
        	file.createNewFile();
            fw = new  FileWriter(file,true);
            
            bw=new BufferedWriter(fw);
            bw.write(msg+random.nextInt(10000))   ;  
            bw.newLine();
            bw.newLine();
            bw.close();
            
        } catch (IOException e) {
            e.printStackTrace();
            
            if(bw!=null){
                try {
                    bw.close();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
            
            if(fw!=null){
                try {
                    fw.close();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        }
	}
	public static void save(String msg){
		FileWriter fw = null;
        BufferedWriter  bw = null;
       
        String path1=IOUtil.class.getResource("/").getPath();
        String path=path1 +"/logs/temp/data/"+new SimpleDateFormat("yyyy-MM-dd").format(new Date())+".txt"; 

        try {
        	File file = new File(path);
        	if(!file.getParentFile().exists()){
        	    file.getParentFile().mkdirs();
        	}
        	file.createNewFile();
            fw = new  FileWriter(file,true);
            
            bw=new BufferedWriter(fw);
            bw.write(msg);  
            bw.newLine();
            bw.newLine();
            bw.close();
            
        } catch (IOException e) {
            e.printStackTrace();
            
            if(bw!=null){
                try {
                    bw.close();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
            
            if(fw!=null){
                try {
                    fw.close();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        }
	}
}
