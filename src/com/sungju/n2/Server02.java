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
		InputStream is = null;
		InputStreamReader ir = null;
		BufferedReader br = null;
		ServerSocket ss = null;
		String str = null;
		FileReader fr = null;
		String out = null;
		OutputStream os = null;
		OutputStreamWriter ow = null;
		BufferedWriter bw = null;
		StringTokenizer st = null;
		boolean check = true;
		String time = null;
		String trim = null;

		try {
			System.out.println("전송 대기중");
			ss = new ServerSocket(8282);
			Socket sk = ss.accept();
			is = sk.getInputStream();
			ir = new InputStreamReader(is);
			br = new BufferedReader(ir);
			int r = br.read();
			if (r == 1) {
				System.out.print("점심메뉴 추천은 ");
				time = "lunch.txt";
				trim = "-";
			} else if (r == 2) {
				System.out.print("저녁메뉴 추천은 ");
				time = "dinner.txt";
				trim = ",";

			}
			Random random = new Random();
			int index = 0;

			///////////////////////////////

			File fd = new File("c:\\test", time);
			ArrayList<String> fda = new ArrayList<String>();
			fr = new FileReader(fd);
			BufferedReader brfd = new BufferedReader(fr);
			while (check) {
				str = brfd.readLine();
				if (str == null) {
					break;
				}
				st = new StringTokenizer(str, trim);
				while (st.hasMoreTokens()) {
					str = st.nextToken().trim();
					fda.add(str);
				}

			}

			index = random.nextInt(fda.size());
			out = fda.get(index);
			System.out.println(out);
			os = sk.getOutputStream();
			ow = new OutputStreamWriter(os);
			bw = new BufferedWriter(ow);
			bw.write(out);
			bw.flush();
			brfd.close();

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
