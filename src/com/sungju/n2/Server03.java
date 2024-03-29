package com.sungju.n2;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import com.sungju.n2.member.Member;

public class Server03 {

	public static void main(String[] args) {
		/**
		 * 전송받은 문자열 id,pw 분리 저장되어있는 id,pw 비교 리턴으로 신호
		 */
		ServerSocket ss = null;
		Socket sk = null;
		Network03 network03 = new Network03();
		MemberService info = new MemberService();
		Member mem = new Member();
		ArrayList<Member> memar = new ArrayList<Member>();
		String str = null;
		String pass = null;
		Server02 server02 = new Server02();

		try {
			System.out.println("수신 대기중...");
			ss = new ServerSocket(8282);
			sk = ss.accept();
			System.out.println("비교중...");
			memar = info.init();
			str = network03.receive(sk);

			System.out.println("user정보 조회...");
			mem = info.cut(str);
			System.out.println("점검중...");
			pass = info.compare(memar, mem);
			System.out.println("결과 전송중...");

			network03.send(sk, pass);
			if (pass.equals("1")) {
				server02.getoutp(sk);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
