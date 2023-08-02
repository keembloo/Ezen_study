package 복습.part5;

import java.util.Scanner;

public class Part5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Part5_member[] memberList = new Part5_member[100];
			
			while (true) {
				
				System.out.println("1.회원가입 2.로그인");
				System.out.print("입력>");
				int ch = sc.nextInt();
				
				if(ch==1) {
					System.out.print("아이디 : ");
					String id = sc.next();
					System.out.print("비밀번호 : ");
					String pw = sc.next();
					System.out.print("이름 : ");
					String name = sc.next();
					System.out.print("전화번호 : ");
					String phone = sc.next();
					System.out.print("나이 : ");
					int age = sc.nextInt();
			
					Part5_member member = new Part5_member(id, pw, name, phone, age);
					
					for (int i=0; i<memberList.length; i++) {
						if (memberList[i]==null) {
							memberList[i]=member;
							break;
						}
					} // for e
					
				} else if (ch==2) {
					System.out.print("아이디 : ");
					String id = sc.next();
					System.out.print("비밀번호 : ");
					String pw = sc.next();
					int login = -1;
					
					for (int i=0; i<memberList.length; i++) {
						if (memberList[i]!=null && memberList[i].id.equals(id) && memberList[i].pw.equals(pw)) {
							login = i;
							break;
						}
					} // for e
					if (login>-1) {
						System.out.println("로그인성공");
					} else {System.out.println("로그인실패");}
				} // if
			} //while e
	} // main e
} // class e
