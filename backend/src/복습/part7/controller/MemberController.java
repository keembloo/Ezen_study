package 복습.part7.controller;

import 복습.part7.model.dao.MemberDao;
import 복습.part7.model.dto.MemberDto;

public class MemberController {
	private static MemberController memberController = new MemberController();
	public static MemberController getInstance() {return memberController;}
	private MemberController() {}
	
	
	public boolean signUp(String id , String pw , String name , String phone , int age) {
		MemberDto member = new MemberDto(id, pw, name, phone, age);
		for (int i = 0; i < MemberDao.memberList.length; i++) {
			if (MemberDao.memberList[i] == null) {
				MemberDao.memberList[i]=member;
				return true;
			}
		} // for end
		return false;
	} // signup e
	
	public int login(String id , String pw) {
		for (int i = 0 ; i< MemberDao.memberList.length; i++) {
			if (MemberDao.memberList[i] !=null && MemberDao.memberList[i].getId().equals(id) && MemberDao.memberList[i].getPw().equals(pw)){
				return 1;
			}
		} // for end
		return 2;
	}
	
	
}
