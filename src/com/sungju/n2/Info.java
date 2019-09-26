package com.sungju.n2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import com.sungju.n2.member.Member;

public class Info {

	public ArrayList<Member> init() throws Exception {
		ArrayList<Member> memar = new ArrayList<Member>();
		File file = new File("c:\\test", "member.txt");
		//System.out.println(file.exists());
		FileReader fr = null;
		fr = new FileReader(file);
		BufferedReader br = null;
		br = new BufferedReader(fr);
		String str = null;
		boolean check = true;
		while (check) {
			str = br.readLine();
			if (str == null) {
				break;
			}
			StringTokenizer st = new StringTokenizer(str, ",");
			while (st.hasMoreTokens()) {
				Member member = new Member();
				member.setId(st.nextToken().trim());
				member.setPw(st.nextToken().trim());
				memar.add(member);
			}
		}
		fr.close();
		br.close();
		return memar;
	}

	public Member cut(String str) {
		Member member = new Member();
		String[] sta = str.split(",");
		String id = sta[0];
		String pw = sta[1];
		member.setId(id);
		member.setPw(pw);
		return member;
	}

	public String compare(ArrayList<Member> memar, Member member) {
		String id = member.getId();
		String pw = member.getPw();
		String pass = "로그인 실패";

		for (int i = 0; i < memar.size(); i++) {
			if (id.equals(memar.get(i).getId()) && pw.equals(memar.get(i).getPw())) {
				pass = "로그인 성공";
			}

		}

		return pass;

	}

}
