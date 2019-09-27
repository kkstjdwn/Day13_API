package com.sungju.n2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Network03 {
	
	
	public void send(Socket sk,String a, String b) throws Exception{
		OutputStream os = sk.getOutputStream();
		OutputStreamWriter ow = new OutputStreamWriter(os);
		BufferedWriter bw = new BufferedWriter(ow);
		String send = a+","+b;
		bw.write(send+"\r\n");
		
		bw.flush();
		
		
		
	}
	public void send(Socket sk,String a) throws Exception{
		OutputStream os = sk.getOutputStream();
		OutputStreamWriter ow = new OutputStreamWriter(os);
		BufferedWriter bw = new BufferedWriter(ow);
		String send = a;
		bw.write(a+"\r\n");
		bw.flush();
		
		
		
	}
	
	public String receive(Socket sk) throws Exception {
		InputStream is = sk.getInputStream();
		InputStreamReader ir = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(ir);
		
		String str = br.readLine();
		
		return str;
	}

}
