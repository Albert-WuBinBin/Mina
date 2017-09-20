package com.wbb.HelloMina;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import com.wbb.HelloMina.client.MinaClient;
import com.wbb.HelloMina.utils.IOUtil;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        final MinaClient client=new MinaClient();
        Timer timer=new Timer();
        timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				boolean b=client.connect();
			    client.sendMsgServer("message from client");
			    client.close();
			}
		}, 0,1000);
        Timer timer1=new Timer();
        timer1.schedule(new TimerTask() {
			
			@Override
			public void run() {
				 String path1=IOUtil.class.getResource("/").getPath();
			     String path=path1 +"/logs/temp/part/data.txt"; 
			     File file=new File(path);
			     FileReader read;
			     String line="";
				try {
					read = new FileReader(file);
				    BufferedReader  br=new BufferedReader(read);
				    while((line=br.readLine())!=null){
				    	IOUtil.save(line);
				    }
				    br.close();
				    if(file.exists()){
				    	file.delete();
				    }
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}, 2000,10000);
    }
}
