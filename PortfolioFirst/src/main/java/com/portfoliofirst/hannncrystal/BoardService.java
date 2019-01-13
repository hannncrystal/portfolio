package com.portfoliofirst.hannncrystal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

	@Autowired
	BoardDAO boarddao;
	
	//리스트 가져오기
	public List<BoardDTO> boardAll() {
		
		List<BoardDTO> boards = boarddao.boardList();
		
		if (boards == null) {
			System.out.println("List Fail!!");
		} else {
			System.out.println("List Success!!");
		}
		
		return boards;
	}
	
	//writer 뿌려주기
	//파라미터??
	public String writerName(BoardDTO board){
		
		String name = boarddao.boardWirter(board);
		
		return name;
		
	}
	
//	//게시물 클릭 -> 뷰+힛
//	public BoardDTO boardSearch(BoardDTO board) {
//		BoardDTO article = boarddao.boardView(board);
//		
//		System.out.println("BoardService"+article);
//		
//		if (article == null) {
//			System.out.println("View Fail!!");
//		} else {
//			System.out.println("View Success!!");
//			boarddao.boardHit(board);
//			article = boarddao.boardView(board);
//		}
//		System.out.println("article"+article);
//		return article;
//	}
//	
//	//작성, 수정진입, 수정 -> 뷰 (힛X)
//	public BoardDTO articleSearch(BoardDTO board) {
//		BoardDTO article = boarddao.boardView(board);
//		
//		System.out.println("BoardService"+article);
//		
//		if (article == null) {
//			System.out.println("View Fail!!");
//		} else {
//			System.out.println("View Success!!");
//		}
//		
//		return article;
//	}
	
	//뷰페이지
	public BoardDTO boardSearch(BoardDTO board) {
		
		BoardDTO article = boarddao.boardView(board);
		
		if (article == null) {
			System.out.println("View Fail!!");
		} else {
			System.out.println("View Success!!");

		}
		
		return article;
	}
	
	//HIT+1
	public void hitPlus(BoardDTO board) {

		int result = boarddao.boardHit(board);
		
		if (result == 0) {
			System.out.println("Hit Fail!!");
		} else {
			System.out.println("Hit Success!!");
		}
		
	}
	
	//게시글 작성
	public int boardRegister(BoardDTO board) {
		
		int result = boarddao.boardWrite(board);
		
		if (result == 0) {
			System.out.println("Write Fail!!");
		} else {
			System.out.println("Write Success!!");
		}
		
		return result;
		
	}
	
	//게시글 수정
	public int boardModify(BoardDTO board) {
		
		int result = boarddao.boardUpdate(board);
		
		if(result == 0 ) {
			System.out.println("Modify Fail!!");

		} else {
			System.out.println("Modify Success!!");
		}
		
		return result;
	}

	//게시글 삭제
	public int boardRemove(BoardDTO board) {
		
		int result = boarddao.boardDelete(board);
		
		if(result == 0 ) {
			System.out.println("Remove Fail!!");
		} else {
			System.out.println("Remove Success!!");
		}
		
		return result;
	}
	
	//답글등록
	//파라미터?? origin값 없어도 되는지?
	public int boardAnswer(BoardDTO board){
		
		int result = boarddao.boardReply(board);
		
		if (result == 0) {
			System.out.println("Reply Fail!!");
		} else {
			System.out.println("Reply Success!!");
		}
		return result;
		
	}
	
}
