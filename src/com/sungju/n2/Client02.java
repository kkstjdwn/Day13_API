package com.sungju.n2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client02 {
	public static void main(String[] args) {
		/**
		 * 1. 점심메뉴 2. 저녁메뉴
		 * 
		 */

		Scanner sn = new Scanner(System.in);
		OutputStream os = null;
		OutputStreamWriter ow = null;
		BufferedWriter bw = null;
		InputStream is = null;
		InputStreamReader ir = null;
		BufferedReader br = null;
		try {
			Socket sk = new Socket("211.238.142.34", 8282);
			System.out.println("고르고 싶은 시간대");
			System.out.println("1.점심메뉴\t2.저녁메뉴");
			int n = sn.nextInt();
			os = sk.getOutputStream();
			ow = new OutputStreamWriter(os);
			bw = new BufferedWriter(ow);
			bw.write(n);
			bw.flush();

			is = sk.getInputStream();
			ir = new InputStreamReader(is);
			br = new BufferedReader(ir);
			String in = br.readLine();
			if (n==1) {
				System.out.println("추천 받은 점심메뉴는 "+ in);
			}else {
				System.out.println("추천 받은 저녁메뉴는 "+ in);
			}

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			try {
				br.close();
				ir.close();
				is.close();
				bw.close();
				ow.close();
				os.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}