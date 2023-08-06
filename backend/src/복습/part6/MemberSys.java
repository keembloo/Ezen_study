package 복습.part6;

import java.util.Scanner;

public class MemberSys {
	static Scanner sc = new Scanner(System.in);
	static Member[] memberList = new Member[100];
	static int login = -1;
	
	public static void main(String[] args) {
		while (true) {
			System.out.print("1.회원가입 2.로그인 3.아이디찾기 4.비밀번호찾기 입력 > ");
			int ch = sc.nextInt();
			
			if(ch==1) {
				회원가입();
			} else if(ch==2) {
				로그인();
			} else if (ch==3) {
				아이디찾기();
			} else if (ch==4) {
				비밀번호찾기();
			}

		} // while e
	} // main e
	
	static void 회원가입() {
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
		
		Member member = new Member(id, pw, name, phone, age);
		
		for (int i =0; i<memberList.length; i++) {
			if (memberList[i]==null) {
				memberList[i]=member;
				System.out.println("회원가입완료");
				break;
			} // if
		} // for e
	}
	static void 로그인() {
		System.out.print("아이디 : ");
		String id = sc.next();
		System.out.print("비밀번호 : ");
		String pw = sc.next();
		
		for (int i =0; i<memberList.length; i++) {
			if (memberList[i]!=null && memberList[i].id.equals(id) && memberList[i].pw.equals(pw)) {
				login = i;
				System.out.println("로그인 성공");
				return;
			} else {
				System.out.println("로그인 실패");
				break;
			} 
		} // for e
		
	}
	static void 아이디찾기() {
		System.out.print("이름 : ");
		String name = sc.next();
		System.out.print("전화번호 : ");
		String phone = sc.next();
		
		for (int i =0; i<memberList.length; i++) {
			if (memberList[i]!=null && memberList[i].name.equals(name) && memberList[i].phone.equals(phone)) {
				System.out.println("아이디 : "+memberList[i].id);
				return;
			}
		} // for e
		System.out.println("아이디찾기 실패 다시입력해주세요");
	}
	static void 비밀번호찾기() {
		System.out.print("아이디 : ");
		String id = sc.next();
		System.out.print("전화번호 : ");
		String phone = sc.next();
		
		for (int i =0; i<memberList.length; i++) {
			if (memberList[i]!=null && memberList[i].id.equals(id) && memberList[i].phone.equals(phone)) {
				System.out.println("비밀번호 : "+memberList[i].pw);
				return;
			} 
		} // for e
		System.out.println("비밀번호찾기찾기 실패 다시입력해주세요");
	}

} // class e
