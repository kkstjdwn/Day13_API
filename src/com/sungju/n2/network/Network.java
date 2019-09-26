package com.sungju.n2.network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;


public class Network {
	
	public String receive(Socket sk) throws Exception {
		
		InputStream is = sk.getInputStream();
		InputStreamReader ir = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(ir);
		String str = br.readLine();
		
		return str;
		
	}
	
	public void send(Socket sk,String str) throws Exception {
		
		
		
		OutputStream os = sk.getOutputStream();
		OutputStreamWriter ow = new OutputStreamWriter(os);
		BufferedWriter bw = new BufferedWriter(ow);
		bw.write(str);
	}
	
	

}
