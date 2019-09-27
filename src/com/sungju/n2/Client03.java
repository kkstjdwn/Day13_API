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
			System.out.println("ID를 입력하세요");
			String id = sn.next();
			System.out.println("PW를 입력하세요");
			String pw = sn.next();
			Socket sk = new Socket("211.238.142.34", 8282);
			network03.send(sk, id, pw);
			System.out.println("로그인 중...");
			String result = network03.receive(sk);
			System.out.println(result);
			if (result.equals("로그인 성공")) {
				client02.getinp(sk);

			}

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
