package com.portfoliofirst.hannncrystal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.crypto.dsig.keyinfo.KeyValue;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {
	
	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/portfolio?verifyServerCertificate=false&useSSL=true";
	private String userid = "root";
	private String userpw = "1234";
	
	private DriverManagerDataSource dataSource;
	private JdbcTemplate template;
	
	public BoardDAO(){
		
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driver);
		dataSource.setUrl(url);
		dataSource.setUsername(userid);
		dataSource.setPassword(userpw);
		
		template = new JdbcTemplate();
		template.setDataSource(dataSource);
		
	}
	
	//리스트 가져오기
	public List<BoardDTO> boardList(){
		
//		List<BoardDTO> boards = null;
//		final String sql = "SELECT * FROM board order by board_group";
//		boards = template.query(sql, new RowMapper<BoardDTO>() {
//
//			public BoardDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
//				BoardDTO board = new BoardDTO();
//				board.setBoard_IDX(rs.getInt("board_IDX"));
//				board.setBoard_title(rs.getString("board_title"));
//				board.setBoard_content(rs.getString("board_content"));
//				board.setBoard_hit(rs.getInt("board_hit"));
//				board.setBoard_group(rs.getInt("board_group"));
//				board.setBoard_depth(rs.getInt("board_depth"));
//				board.setBoard_date(rs.getString("board_date"));
//				board.setMember_IDX(rs.getInt("member_IDX"));
//				return board;
//			}
//		});
//		
//		if(boards.isEmpty()) 
//			return null;
//		System.out.println(boards);
//		return boards;
		
		String sql = "SELECT * FROM board ORDER BY board_group desc, board_step;";
		
		RowMapper<BoardDTO> mapper = new BeanPropertyRowMapper<BoardDTO>(BoardDTO.class);	
		return template.query(sql, mapper);
		
	}
	
	//member_IDX로 name만 불러오기 board.getMember_IDX()
	//파라미터?
	public String boardWirter(final BoardDTO board){
		
		String writer = null; 
		
		final String sql = "SELECT member_name FROM member WHERE member_IDX = ?";
		
//		writer = template.query(sql, new PreparedStatementSetter() {
//			
//			public void setValues(PreparedStatement pstmt) throws SQLException {
//				pstmt.setInt(1, board.getMember_IDX());
//			}		
//		}, new ResultSetExtractor<String>() {
//
//			@Override
//			public String extractData(ResultSet rs) throws SQLException, DataAccessException {
//				// TODO Auto-generated method stub
//				
//				return rs.getString("member_name");
//				
//			}
//		});
		
		writer = template.queryForObject(sql, String.class, board.getMember_IDX());
		
		return writer;
		
	}
	
	//member_IDX로 member정보 불러오기
//	public MemberDTO memberInfo(final BoardDTO board){
//		
//		List<MemberDTO> members = null;
//		
//		final String sql = "SELECT * FROM member WHERE member_IDX = ?";
//		members = template.query(sql, new PreparedStatementSetter() {
//			
//			public void setValues(PreparedStatement pstmt) throws SQLException {
//				pstmt.setInt(1, board.getMember_IDX());
//			}		
//		}, new RowMapper<MemberDTO>() {
//
//			public MemberDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
//				MemberDTO mem = new MemberDTO();
//				mem.setMember_IDX(rs.getInt("member_IDX"));
//				mem.setMember_id(rs.getString("member_id"));
//				mem.setMember_pw(rs.getString("member_pw"));
//				mem.setMember_name(rs.getString("member_name"));
//				mem.setMember_mobile(rs.getString("member_mobile"));
//				mem.setMember_email(rs.getString("member_email"));
//				mem.setMember_date(rs.getString("member_date"));
//				mem.setMember_available(rs.getInt("member_available"));
//				return mem;
//			}
//		});
//		
//		if(members.isEmpty()) 
//			return null;
//		
//		return members.get(0);
//		
//	}
	
	//member_IDX -> service.search -> getName?
	
	//hit count +1
	public int boardHit(BoardDTO board){
		
		int result = 0;
		final String sql = "UPDATE board SET board_hit = board_hit+1 WHERE board_IDX = ?";
		
		result = template.update(sql, board.getBoard_IDX());
		
		return result;
	
	}
	
	//뷰페이지
	public BoardDTO boardView(final BoardDTO board){
		List<BoardDTO> boards = null;
		final String sql = "SELECT * FROM board WHERE board_IDX = ?";
		//하나?
		boards = template.query(sql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setInt(1, board.getBoard_IDX());
			}
		}, new RowMapper<BoardDTO>() {

			public BoardDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				BoardDTO bo = new BoardDTO();
				bo.setBoard_IDX(rs.getInt("board_IDX"));
				bo.setBoard_title(rs.getString("board_title"));
				bo.setBoard_content(rs.getString("board_content"));
				bo.setBoard_hit(rs.getInt("board_hit"));
				bo.setBoard_group(rs.getInt("board_group"));
				bo.setBoard_depth(rs.getInt("board_depth"));
				bo.setBoard_step(rs.getInt("board_step"));
				bo.setBoard_date(rs.getString("board_date"));
				bo.setMember_IDX(rs.getInt("member_IDX"));
				return bo;
			}
		});
		
		if(boards.isEmpty()) 
			return null;
		
		return boards.get(0);
		
	}

	//글쓰기
	public int boardWrite(final BoardDTO board){
		
		//IDX 먼저 구하기 + IDX 전달
//		final KeyHolder keyHolder = new GeneratedKeyHolder();
//
//		
//		final String sql = "INSERT INTO board "
//				+ "(board_title, board_content, board_group, board_depth, board_date, member_IDX) "
//				+ "VALUES (?, ?, ?, 1, sysdate(), ?) ";
//		template.update(new PreparedStatementCreator() {
//			
//			@Override
//			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
//				// TODO Auto-generated method stub
//				
//				PreparedStatement pstmt = con.prepareStatement(sql, new String[]{"board_IDX"});
//			
//				pstmt.setString(1, board.getBoard_title());
//				pstmt.setString(2, board.getBoard_content());
//				pstmt.setInt(3, 127);
//				pstmt.setInt(4, board.getMember_IDX());
//				
//				return pstmt;
//				
//			}
//		}, keyHolder);
//		
//		final int idx = keyHolder.getKey().intValue();
//
//		return idx;
		
		final KeyHolder keyHolder = new GeneratedKeyHolder();
		final String sql = "INSERT INTO board "
				+ "(board_title, board_content, board_depth, board_step, board_date, member_IDX) "
				+ "VALUES (?, ?, 1, 1, sysdate(), ?) ";
		template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(sql, new String[]{"board_IDX"});
				pstmt.setString(1, board.getBoard_title());
				pstmt.setString(2, board.getBoard_content());
				pstmt.setInt(3, board.getMember_IDX());
				return pstmt;
			}
		}, keyHolder);
		final int idx = keyHolder.getKey().intValue();
		
		String groupsql = "UPDATE board SET board_group = ? WHERE board_IDX = ?";
		template.update(groupsql, idx, idx);

		//LAST_INSERT_ID??
		//template.update("UPDATE board SET board_group = (SELECT LAST_INSERT_ID())");
		
		return idx;
		
		// MAX 먼저 구하기 + IDX 전달
		// queryForObject값이 없을 때 null 값을 반환하도록 try/catch 'EmptyResultDataAccessException e'
		 
//		int max = 0;
//		String presql = "SELECT IFNULL(MAX(board_IDX),0)+1 FROM board";
//		max = template.queryForObject(presql, int.class);
//		
//		final String sql = "INSERT INTO board "
//			+ "(board_title, board_content, board_group, board_depth, board_date, member_IDX) "
//			//+ "VALUES (?, ?, ?, ?, sysdate(), ?) ";
//			+ "VALUES (?, ?, ?, ?, now(), ?) ";
//			//+ "VALUES (?, ?, ?, ?, date_format(sysdate(),'%y,%m,%d'), ?) ";
//		
//		template.update(sql, 
//				board.getBoard_title(), board.getBoard_content(), max, "1", board.getMember_IDX());
//		
//		return max;
		
//		int result = 0;
//		//서브쿼리 alias
//		final String sql = "INSERT INTO board(board_title, board_content, board_group, board_depth, board_date, member_IDX)"
//		                       +"VALUES(?, ?, (SELECT IFNULL(MAX(board_IDX),0)+1 FROM board X), ?, sysdate(), ?)";
//		
//		result = template.update(sql, 
//				board.getBoard_title(), board.getBoard_content(),"1", board.getMember_IDX());
//		
//		return result;
		
	}
	
	//board의 max IDX값을 구하는 로직
//	public int boardIDX{
//		final String sql = "SELECT MAX(board_IDX) AS max_board_IDX FROM board";
//  	final String sql = "SELECT MAX(board_IDX) FROM board";
//		result = template.queryForMap(sql);
//	}
	
	//글수정
	public int boardUpdate(BoardDTO board){
		
		int result = 0;
		//date 수정? 노수정?
		final String sql = "UPDATE board SET board_title = ?, board_content = ? WHERE board_IDX = ?";
		
		result = template.update(sql, 
				board.getBoard_title(), board.getBoard_content(), board.getBoard_IDX());
		
		return result;
	
	}
	
	//글삭제
	public int boardDelete(final BoardDTO board) {
		
		int result = 0;
		
		final String sql = "DELETE FROM board WHERE board_IDX = ?";
		
		result = template.update(sql, board.getBoard_IDX());
		
		return result;
	}

	
	//답글등록
	//파라미터??
	public int boardReply(final BoardDTO board){

		System.out.println("depth1:"+board);
		
		String presql = "UPDATE board SET board_step = board_step+1 "
				+ "WHERE board_group = ? and board_step > ?";
		
		template.update(presql, board.getBoard_group(), board.getBoard_step());
		
		System.out.println("depth2:"+board);
		
		final KeyHolder keyHolder = new GeneratedKeyHolder();
		final String sql = "INSERT INTO board "
				+ "(board_title, board_content, board_group, board_depth, board_step, board_date, member_IDX) "
				+ "VALUES (?, ?, ?, ?, ?, sysdate(), ?) ";
		
		template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(sql, new String[]{"board_IDX"});
				pstmt.setString(1, board.getBoard_title());
				pstmt.setString(2, board.getBoard_content());
				pstmt.setInt(3, board.getBoard_group());
				pstmt.setInt(4, board.getBoard_depth()+1);
				pstmt.setInt(5, board.getBoard_step()+1);
				pstmt.setInt(6, board.getMember_IDX());
				return pstmt;
			}
		}, keyHolder);
		final int idx = keyHolder.getKey().intValue();
		System.out.println("depth3:"+board);
		//IDX값 다시 설정?
		//board.setBoard_IDX(idx);
		return idx;
		
//		int max = 0;
//		String presql = "SELECT IFNULL(MAX(board_IDX),0)+1 FROM board";
//		max = template.queryForObject(presql, int.class);
//		
//		final String sql = "INSERT INTO board "
//				+ "(board_title, board_content, board_group, board_depth, board_date, member_IDX) values (?,?,?,?,sysdate(),?)";
//		
//		template.update(sql, 
//				board.getBoard_title(), board.getBoard_content(), board.getBoard_group(), board.getBoard_depth()+1, board.getMember_IDX());
//		
//		return max;
		
	}
		
	
}
