package com.portfoliofirst.hannncrystal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

	@Autowired
	MemberDAO memberdao;
	
	public void memberRegister(MemberDTO member) {
		
		int result = memberdao.memberInsert(member);
		
		if (result == 0) {
			System.out.println("Join Fail!!");
		} else {
			System.out.println("Join Success!!");
		}
		
	}
	
	public MemberDTO memberSearch(MemberDTO member) {
		
		MemberDTO mem = memberdao.memberSelect(member);
		
		if (mem == null) {
			System.out.println("Login Fail!!");
		} else {
			System.out.println("Login Success!!");
		}
		
		return mem;
	}
	
	public int memberModify(MemberDTO member) {
		
		int result = memberdao.memberUpdate(member);
		
		if(result == 0 ) {
			System.out.println("Modify Fail!!");
			//return null;
		} else {
			System.out.println("Modify Success!!");
		}
		
		return result;
		//return member;
	}

	public int memberRemove(MemberDTO member) {
		
		int result = memberdao.memberDelete(member);
		
		if(result == 0 ) {
			System.out.println("Remove Fail!!");
		} else {
			System.out.println("Remove Success!!");
		}
		
		return result;
	}
}
