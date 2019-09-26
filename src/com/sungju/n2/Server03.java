package com.sungju.n2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import com.sungju.n2.member.Member;

public class Server03 {

	public static void main(String[] args) {
	/**
	 * 전송받은 문자열 id,pw 분리
	 * 저장되어있는 id,pw 비교
	 * 리턴으로 신호
	 */
		ServerSocket ss = null;
		Socket sk = null;
		Network03 network03 = new Network03();
		Info info = new Info();
		Member mem = new Member();
		ArrayList<Member> memar = new ArrayList<Member>();
		String str = null;
		String pass = null;
		InputStream is = null;
		InputStreamReader ir = null;
		BufferedReader br = null;
		String check = null;
		
		try {
			System.out.println("수신 대기중...");
			ss = new ServerSocket(8282);
			sk = ss.accept();
			System.out.println("비교중...");
			memar = info.init();
			str = network03.receive(sk);
//			is = sk.getInputStream();
//			ir = new InputStreamReader(is);
//			br = new BufferedReader(ir);
//			br.readLine();
			System.out.println("user정보 조회...");
			mem = info.cut(str);
			System.out.println("점검중...");
			pass = info.compare(memar, mem);
			System.out.println("결과 전송중...");
			
			network03.send(sk, pass);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
