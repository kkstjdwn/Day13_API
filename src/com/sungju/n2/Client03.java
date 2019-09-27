package com.sungju.n2;

import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

import com.sungju.n2.member.Member;

public class Client03 {

	public static void main(String[] args) {
		/**
		 * id,pw입력 서버로 전송 신호를 받아서 성공 실패 출력
		 */
		Client02 client02 = new Client02();
		Network03 network03 = new Network03();
		Scanner sn = new Scanner(System.in);

		try {
			Socket sk = new Socket("211.238.142.34", 8282);
			System.out.println("ID를 입력하세요");
			String id = sn.next();
			System.out.println("PW를 입력하세요");
			String pw = sn.next();
			network03.send(sk, id, pw);
			System.out.println("로그인 중...");
			String result = network03.receive(sk);
			if (result.equals("1")) {
				System.out.println(id+"님 어서오세욤");
				client02.getinp(sk);

			}else {
				System.out.println("로그인 실패");
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
