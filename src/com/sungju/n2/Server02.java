package com.sungju.n2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Server02 {
	public static void main(String[] args) {
		/**
		 * 1. lunch 에서 무작위 출력 2. dinner에서 무작위 출력
		 */
		Scanner sn = new Scanner(System.in);
		InputStream is= null;
		InputStreamReader ir= null;
		BufferedReader br = null;
		ServerSocket ss= null;
		String str = null;
		FileReader fr = null;
		String out = null;
		OutputStream os= null;
		OutputStreamWriter ow =null;
		BufferedWriter bw = null;
		StringTokenizer st = null;
		
		try {
			System.out.println("전송 대기중");
			ss = new ServerSocket(8282);
			Socket sk = ss.accept();
			is = sk.getInputStream();
			ir = new InputStreamReader(is);
			br = new BufferedReader(ir);
			int r = br.read();
			if (r==1) {
				System.out.print("점심메뉴 추천은 ");
			}else if(r == 2) {
				System.out.print("저녁메뉴 추천은 ");
				
			}
			Random random = new Random();
			int index = 0;
			boolean check = true;

			///////////////////////////////
			switch (r) {

			case 1:
				File ln = new File("c:\\test", "lunch.txt");
				ArrayList<String> lna = new ArrayList<String>();
				fr = new FileReader(ln);
				BufferedReader brln = new BufferedReader(fr);
				while (check) {
					str = brln.readLine();
					if (str == null) {
						break;
					}
					st = new StringTokenizer(str,"-");
					while (st.hasMoreTokens()) {
						str = st.nextToken();
						lna.add(str);
					}
					
				}
				
				index = random.nextInt(lna.size());
				out = lna.get(index);
				System.out.println(out);
				os = sk.getOutputStream();
				ow = new OutputStreamWriter(os);
				bw = new BufferedWriter(ow);
				bw.write(out);
				bw.flush();
				brln.close();

				break;
			case 2:
				File dn = new File("c:\\test", "dinner.txt");
				ArrayList<String> dna = new ArrayList<String>();
				fr = new FileReader(dn);
				BufferedReader brdn = new BufferedReader(fr);
				while (check) {
					str = brdn.readLine();
					if (str == null) {
						break;
					}
					st = new StringTokenizer(str,",");
					while (st.hasMoreTokens()) {
						str = st.nextToken().trim();
						dna.add(str);
					}
					
				}
				index = random.nextInt(dna.size());
				out = dna.get(index);
				System.out.println(out);

				os = sk.getOutputStream();
				ow = new OutputStreamWriter(os);
				bw = new BufferedWriter(ow);
				bw.write(out);
				bw.flush();
				brdn.close();
				break;

			default:
				str = "잘못누르셨습니다.";
				break;
			}

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			try {
				bw.close();
				ow.close();
				os.close();
				
				fr.close();
				br.close();
				ir.close();
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
