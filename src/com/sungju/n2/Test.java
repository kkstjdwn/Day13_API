package com.sungju.n2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.StringTokenizer;

import com.sungju.n2.member.Member;

public class Test {
	public static void main(String[] args) {
		Info info = new Info();
		ArrayList< Member> members = new ArrayList<Member>();
		try {
			members = info.init();
			
			for (int i = 0; i < members.size(); i++) {
				System.out.println(members.get(i).getId());
				System.out.println(members.get(i).getPw());
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
