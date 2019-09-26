package com.sungju.n2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.StringTokenizer;

public class Test {
	public static void main(String[] args) {
		File ln = new File("c:\\test", "lunch.txt");
		System.out.println(ln.exists());
		
		ArrayList<String> lna = new ArrayList<String>();
		FileReader fr;
		String str;
		int index;
		Random random = new Random();
		String out = null;
		BufferedReader brln = null;
		boolean check= true;
		StringTokenizer st=null;
		try {
			
			
			fr = new FileReader(ln);
			brln = new BufferedReader(fr);
			while (check) {
				str = brln.readLine();
				if (str==null) {
					break;
				}
				st = new StringTokenizer(str);
				while (st.hasMoreTokens()) {
					st = new StringTokenizer(str, "-");
					lna.add(st.nextToken());
				}

			}
			index = random.nextInt(lna.size());
			out = lna.get(index);
			index = random.nextInt(lna.size());
			out = lna.get(index);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				brln.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
