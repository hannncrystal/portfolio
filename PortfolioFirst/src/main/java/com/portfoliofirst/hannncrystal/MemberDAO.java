package com.portfoliofirst.hannncrystal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	
/*	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost/hannncrystal?useUnicode=true&amp;";
	private String userid = "hannncrystal";
	private String userpw = "gkstnwjd0108";*/
	
	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/portfolio";
	private String userid = "root";
	private String userpw = "1234";
	
	private DriverManagerDataSource dataSource;
	private JdbcTemplate template;
	
	public MemberDAO(){
		
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driver);
		dataSource.setUrl(url);
		dataSource.setUsername(userid);
		dataSource.setPassword(userpw);
		
		template = new JdbcTemplate();
		template.setDataSource(dataSource);
		
	}
	
	//정규식
	
	public int memberInsert(MemberDTO member) {
		
		int result = 0;
		
		final String sql = "INSERT INTO member "
				+ "(member_id, member_pw, member_name, member_mobile, member_email, member_date) values (?,?,?,?,?,sysdate())";
	
		result = template.update(sql, 
				member.getMember_id(), member.getMember_pw(), member.getMember_name(), member.getMember_mobile(), member.getMember_email());
		
		return result;
		
	}

	//RowMapper
	public MemberDTO memberSelect(final MemberDTO member) {
		
		List<MemberDTO> members = null;

//		String sql = "SELECT * FROM member WHERE member_id = "+member.getMember_id()+" AND member_pw = "+member.getMember_pw();
//		template.query(sql, rowMapper)
//		
//		if(members.isEmpty()) 
//			return null;
//		return members.get(0);
				
		final String sql = "SELECT * FROM member WHERE member_id = ? AND member_pw = ?";
		members = template.query(sql, new PreparedStatementSetter() {
			
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, member.getMember_id());
				pstmt.setString(2, member.getMember_pw());
			}
		}, new RowMapper<MemberDTO>() {

			public MemberDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				MemberDTO mem = new MemberDTO();
				mem.setMember_IDX(rs.getInt("member_IDX"));
				mem.setMember_id(rs.getString("member_id"));
				mem.setMember_pw(rs.getString("member_pw"));
				mem.setMember_name(rs.getString("member_name"));
				mem.setMember_mobile(rs.getString("member_mobile"));
				mem.setMember_email(rs.getString("member_email"));
				mem.setMember_date(rs.getString("member_date"));
				mem.setMember_available(rs.getInt("member_available"));
				System.out.println("memRowMapper"+mem);
				return mem;
			}
		});
		
		if(members.isEmpty()) 
			return null;
		
		return members.get(0);
		
	}
	
	public int memberUpdate(final MemberDTO member) {
		
		int result = 0;
		
		//final String sql = "UPDATE member SET (member_pw, member_mobile, member_email) values (?,?,?) WHERE member_id = ?";
		final String sql = "UPDATE member SET member_pw =?, member_mobile = ? , member_email = ? WHERE member_id = ?";
		result = template.update(sql, member.getMember_pw(), member.getMember_mobile(), member.getMember_email(), member.getMember_id());
		
		return result;
	
	}
	
	public int memberDelete(final MemberDTO member) {
		
		int result = 0;
		
		final String sql = "DELETE FROM member WHERE member_id = ? AND member_pw = ?";
		
		result = template.update(sql, member.getMember_id(), member.getMember_pw());
		
		return result;
	}


	//available 로직
	
}