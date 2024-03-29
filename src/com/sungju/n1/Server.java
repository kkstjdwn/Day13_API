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

public class Server {

	public static void main(String[] args) {
		Scanner sn = null;
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
			ss = new ServerSocket(8282);
			while (check) {

				sn = new Scanner(System.in);
				System.out.println("대기중");

				sc = ss.accept();
				is = sc.getInputStream();
				ir = new InputStreamReader(is);
				br = new BufferedReader(ir);

				String str2 = null;
				str2 = br.readLine();
				if (str2.toLowerCase().equals("q")) {
					System.out.println("종료");
					check = !check;
					break;
				}

				System.out.println(str2);

				// sc = new Socket("211.238.142.35", 8282);
				os = sc.getOutputStream();
				ow = new OutputStreamWriter(os);
				bw = new BufferedWriter(ow);
				System.out.println("전송할 메세지");
				String str = null;
				str = sn.next();
				bw.write(str + "\r\n"); // 커서를 땡기고 enter
				bw.flush(); // 강제로 버퍼를 비움
				if (str.toLowerCase().equals("q")) {
					System.out.println("종료");
					check = !check;
					break;
				}
				System.out.println("전송완료");
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();
				ow.close();
				os.close();
				br.close();
				ir.close();
				is.close();
				sc.close();
				ss.close();

			} catch (IOException e) {

				e.printStackTrace();
			}
		}

	}

}
