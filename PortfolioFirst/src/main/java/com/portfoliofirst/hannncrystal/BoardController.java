package com.portfoliofirst.hannncrystal;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.taglibs.standard.tag.common.xml.ForEachTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
//@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	BoardService boardservice;
	
	@ModelAttribute("cp")
	public String getContextPath(HttpServletRequest request) {
		return request.getContextPath();
	}
	
	// List
	@RequestMapping("/list")
	public String listGo(Model model) {
		
		
		List<BoardDTO> boards = boardservice.boardAll();
		ArrayList<String> writers = new ArrayList<String>();
		for (int i = 0; i < boards.size(); i++) {	
			String writer = boardservice.writerName(boards.get(i));
			writers.add(writer);
		};	

		model.addAttribute("boards",boards);
		System.out.println(boards);
		model.addAttribute("writers",writers);
		return "/board/list";
	}
	
	// View
	@RequestMapping("/view")
	public String viewGo(BoardDTO board, Model model) {

		//hit 유효성 여부?
		boardservice.hitPlus(board);
		BoardDTO bo = boardservice.boardSearch(board);
		String writer = boardservice.writerName(bo);
		
		model.addAttribute("bo", bo);
		model.addAttribute("writer",writer);
		
		return "/board/view";
	}
	
	// Write
	@RequestMapping("/writeForm")
	public String writeForm(HttpSession session, Model model) {
		
		MemberDTO member = (MemberDTO) session.getAttribute("membersession");
		
		model.addAttribute("mem",member);
		
		return "/board/writeForm";
	}
	
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String writeGo(BoardDTO board, Model model){
		
		int IDX = boardservice.boardRegister(board);
		board.setBoard_IDX(IDX);
		
		if(IDX == 0) {
			return("/writeForm");
		} else {
			//합치기?
			BoardDTO bo = boardservice.boardSearch(board);
			String writer = boardservice.writerName(bo);
			
			model.addAttribute("bo", bo);
			model.addAttribute("writer",writer);
			
			return "/board/view";
		}
		
	}
	
	// Modify
	@RequestMapping("/articleModifyForm")
	public String modifyForm(BoardDTO board, Model model, HttpSession session) {
		//view 통합?
		BoardDTO bo = boardservice.boardSearch(board);
		MemberDTO member = (MemberDTO) session.getAttribute("membersession");
		
		model.addAttribute("mem",member);
		model.addAttribute("bo", bo);
		
		return "/board/modifyForm";
	}
	
	@RequestMapping(value = "/articleModify", method = RequestMethod.POST)
	public String modifyGo(BoardDTO board, Model model) {
		int result = boardservice.boardModify(board);
		if(result == 0) {
			return("/modifyForm");
		} else { 
			//view 메소드?
			BoardDTO bo = boardservice.boardSearch(board);
			String writer = boardservice.writerName(bo);
			
			model.addAttribute("bo", bo);
			model.addAttribute("writer",writer);
			return "/board/view";
		}
	}
	
	// Delete
	//삭제 확인 페이지?
	@RequestMapping("/articleDelete")
	public String deleteGo(BoardDTO board, Model model) {
		//세션?
		boardservice.boardRemove(board);

		listGo(model);
		
		return "/board/list";
	}
	
	// Reply
	@RequestMapping("/replyForm")
	public String replyForm(BoardDTO board, HttpSession session, Model model) {
		
		MemberDTO member = (MemberDTO) session.getAttribute("membersession");
		BoardDTO bo = boardservice.boardSearch(board);
		
		model.addAttribute("bo", bo);
		model.addAttribute("mem",member);
		
		System.out.println("replyForm:"+bo);
		
		return "/board/replyForm";
	}
	
	@RequestMapping("/reply")
	public String replyGo(BoardDTO board, Model model) {
		
//		int result = boardservice.boardAnswer(board);
//		
//		if(result == 0) {
//			return("/replyForm");
//		} else {
//			BoardDTO bo = boardservice.articleSearch(board);
//			model.addAttribute("bo", bo);
//			
//			return "/board/view";
//		}
//		
		System.out.println("reply 전:"+board);
		int IDX = boardservice.boardAnswer(board);
		board.setBoard_IDX(IDX);
		System.out.println("reply 중:"+board);
		if(IDX == 0) {
			return("/replyForm");
		} else {
			BoardDTO bo = boardservice.boardSearch(board);
			String writer = boardservice.writerName(bo);
			
			model.addAttribute("bo", bo);
			model.addAttribute("writer",writer);
			
			System.out.println("reply 후:"+bo);
			
			return "/board/view";
		}
		
	}
	
/*
	@Autowired
	BoardService boardservice;
	
	@ModelAttribute("cp")
	public String getContextPath(HttpServletRequest request) {
		return request.getContextPath();
	}
	
	@RequestMapping("/board")
	public String boardList(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum, Model model) {
		
		model.addAttribute("boardArticleDto", bListCommand.execute(sqlSession, pageNum));
		return "Board/list";
	}
	
	//글쓰기 페이지 호출
	@RequestMapping("/board/write_view.do")
	public String write_view() {
		return "Board/write_view";
	}
	
	
	//글쓰기
	@RequestMapping(value="/board/write.do", method=RequestMethod.POST)
	public String write(WriteFieldDto dto , Model model, HttpServletRequest request) {
		if(request.getSession().getAttribute("kakaoSession") == null && request.getSession().getAttribute("login") == null){
			System.out.println("로그인 세션 없음");
			return "redirect:/member/member_login.do";
		}else{
			String page = "redirect:/board/list.do";
			if(request.getSession().getAttribute("login") != null){
				System.out.println("write : " + dto.getbName() + dto.getbTitle() + dto.getbContent() + dto.getProduct_ID());
				bWriteCommand.execute(dto.getbName(), dto.getbTitle(), dto.getbContent(), dto.getMember_IDX(), dto.getProduct_ID(), sqlSession);	
				Q:write를 호출하면 기존에 있던 list.jsp로 돌아간다. 스택처럼 호출받았던 페이지로 돌아가는방법은 없을까?
				A:히든(where_board)으로 값을 받아오고 숫자를 정한뒤 분기 시켜주면 될거같다.
				if(dto.getWhere_board()==1){
					page = "redirect:/Product/product_view.do?product_ID="+dto.getProduct_ID();
				}		
				return page;
			}else{
				request.getSession().getAttribute("kakaoSession");
				page = "redirect:/member/join.do";
				return page;
			}
		}
	}
	
	//게시물 내용 보기
	@RequestMapping("/board/content_view.do")
	public String content_view(@RequestParam("bId") int bId,@RequestParam(value="product_ID", defaultValue="0") int product_ID ,Model model) {
		
		if(product_ID == 0){
			System.out.println("일반 게시글 호출");
			model.addAttribute("content_view", bContentCommand.execute(bId, sqlSession));
			model.addAttribute("content_Ripple_view", bContentCommand.executeRipple(sqlSession, bId));
		}else{
			model.addAttribute("content_view", bContentCommand.executeProduct(bId, product_ID, sqlSession));
			model.addAttribute("content_Ripple_view", bContentCommand.executeRipple(sqlSession, bId));
		}
		return "Board/content_view";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/board/modify.do")
	public String modify(@RequestParam("bId") int bId, @RequestParam("bName") String bName,
			@RequestParam("bTitle") String bTitle, @RequestParam("bContent") String bContent) {
		BModifyCommand.execute(bId, bName, bTitle, bContent, sqlSession);
		return "redirect:/board/list.do";
	}
	
	//게시물 삭제
	@RequestMapping("/board/delete.do")
	public String delete(@RequestParam("bId") int bId, HttpServletRequest request, 
			@RequestParam("where_board") int where_board, @RequestParam(value="product_ID", defaultValue="0") int product_ID) {
		MemberDto dto = (MemberDto) request.getSession().getAttribute("login");
		System.out.println("세션 인덱스 : " + dto.getMember_IDX());
		bDeleteCommand.execute(bId, dto.getMember_IDX(), sqlSession);
		
		String page = "redirect:/board/list.do";
		if(where_board==1){
			page = "redirect:/Product/product_view.do?product_ID="+product_ID;
		}
			return page;
	}
	//답글 보기
	@RequestMapping("/board/reply_view.do")
	private String reply_view(@RequestParam("bId")int bId, @RequestParam(value="product_ID", defaultValue="0")int product_ID, Model model) {
			model.addAttribute("bId", bId);
			model.addAttribute("product_ID", product_ID);
		return "Board/reply_view";
	}
	
	//답글 등록
	@RequestMapping("/board/reply.do")
	private String reply(ReplyDto dto) {

		System.out.println("bId = " + dto.getbId());

		replyCommand.execute(sqlSession, dto);
		return "redirect:/board/list.do";
		
	}
	*/
}
