package com.sungju.n1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		/**
		 * 1단계 통신
		 */
		Scanner sn = new Scanner(System.in);
		ServerSocket ss = null;
		Socket sc = null;
		InputStream is = null;
		InputStreamReader ir = null;
		BufferedReader br = null;
		OutputStream os = null;
		OutputStreamWriter ow = null;
		BufferedWriter bw = null;
		boolean check = true;
		try {
			while (check) {
				sc = new Socket("211.238.142.35", 8282);
				// ss = new ServerSocket(8282);
				System.out.println("전송할 메세지");

				String str = null;
				str = sn.next();
				os = sc.getOutputStream();
				ow = new OutputStreamWriter(os);
				bw = new BufferedWriter(ow);

				bw.write(str + "\r\n"); // 커서를 땡기고 enter
				bw.flush(); // 강제로 버퍼를 비움
				System.out.println("전송완료");
				if (str.toLowerCase().equals("q")) {
					check = !check;
					break;
				}

				// sc = ss.accept();

				System.out.println("대기중");

				// sc = ss.accept();
				is = sc.getInputStream();
				ir = new InputStreamReader(is);
				br = new BufferedReader(ir);

				String str2 = null;
				str2 = br.readLine();
				if (str2.toLowerCase().equals("q")) {
					check = !check;
					break;
					
				}

				System.out.println(str2);

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				br.close();
				ir.close();
				is.close();
				bw.close();
				ow.close();
				os.close();
				sc.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}

	}

}
