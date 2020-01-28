package net.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import net.bbs.BbsDTO;
import net.utility.DBClose;
import net.utility.DBOpen;

public class MemberDAO {

	private DBOpen dbopen=null;
	private Connection con=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	private StringBuilder sql=null;
	
	public MemberDAO() {
		dbopen=new DBOpen();
	}
	
	public String loginProc(MemberDTO dto) {
		String mlevel=null;
		try {
			con=dbopen.getConnection();
			sql=new StringBuilder();
			sql.append(" SELECT mlevel ");
			sql.append(" FROM memberf ");
			sql.append(" WHERE id=? AND passwd=? ");
			sql.append(" AND mlevel IN ('A1' ,'B1', 'C1', 'D1') ");
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPasswd());
			rs=pstmt.executeQuery();
			if(rs.next()) {
				mlevel=rs.getString("mlevel");
			}else {
				mlevel=null;
			}
		}catch(Exception e) {
			System.out.println("로그인 실패 : "+ e);
		}finally {
			DBClose.close(con,pstmt,rs);
		}
		return mlevel;
	}
	
	public int duplecateID(String id) {
		int cnt=0;
		
		try {
			con=dbopen.getConnection();
			sql=new StringBuilder();
			sql.append(" SELECT COUNT(id) as cnt");
			sql.append(" FROM memberf" );
			sql.append(" WHERE id=?" );
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				cnt=rs.getInt("cnt");
			}
		}catch(Exception e) {
			System.out.println("아이디 중복 확인 실패: " + e);
		}finally {
			DBClose.close(con,pstmt,rs);
		}
		return cnt;
	}
	
	
	public int duplecateEmail(String email) {
		int cnt=0;
		
		try {
			con=dbopen.getConnection();
			sql=new StringBuilder();
			sql.append(" SELECT COUNT(email) as cnt");
			sql.append(" FROM memberf" );
			sql.append(" WHERE email=?" );
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, email);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				cnt=rs.getInt("cnt");
			}
		}catch(Exception e) {
			System.out.println("이메일 중복 확인 실패: " + e);
		}finally {
			DBClose.close(con,pstmt,rs);
		}
		return cnt;

	}	
	
	
	public int join(MemberDTO dto) {
		int cnt=0;
		
		try {
			con=dbopen.getConnection();
			sql=new StringBuilder();
			sql.append(" INSERT INTO memberf (id, passwd, mname, email, tel, zipcode, address1, address2, job, mlevel, mdate) ");
			sql.append(" VALUES (?,?,?,?,?,?,?,?,?,'D1',sysdate)");
			
			
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPasswd());
			pstmt.setString(3, dto.getMname());
			pstmt.setString(4,dto.getEmail());
			pstmt.setString(5,dto.getTel());
			pstmt.setString(6, dto.getZipcode());
			pstmt.setString(7,dto.getAddress1());
			pstmt.setString(8,dto.getAddress2());
			pstmt.setString(9, dto.getJob());
		
			
			cnt=pstmt.executeUpdate();
			
			
		}catch(Exception e) {
			System.out.println("등록 실패 : "+ e);
		}finally {
			DBClose.close(con,pstmt,rs);
		}
		
		return cnt;
	} 
	
	
	 public MemberDTO update(String id) {
		 MemberDTO dto=null;
		    try {
		    	
		      con=dbopen.getConnection();
		      sql=new StringBuilder();
		      sql.append(" SELECT id, passwd, mname, email, tel, zipcode, address1, address2, job ");
		      sql.append(" FROM memberf ");
		      sql.append(" WHERE id=? ");
		      
		      pstmt=con.prepareStatement(sql.toString());
		      pstmt.setString(1, id);
		      
		      rs=pstmt.executeQuery();
		      if(rs.next()){
		        dto=new MemberDTO();
		        dto.setId(rs.getString("id"));
		        dto.setPasswd(rs.getString("passwd"));
		        dto.setMname(rs.getString("mname"));
		        dto.setEmail(rs.getString("email"));
		        dto.setTel(rs.getString("tel"));
		        dto.setZipcode(rs.getString("zipcode"));
		        dto.setAddress1(rs.getString("address1"));
		        dto.setAddress2(rs.getString("address2"));
		        dto.setJob(rs.getString("job"));
		        
		        
		      }else {
		        dto=null;
		      }//if end
		    }catch (Exception e) {
		      System.out.println("수정하기 실패:"+e);
		    }finally {
		      DBClose.close(con, pstmt, rs);
		    }//try end
		    return dto;
		  }//read() end
	 
	
	
	
	
	
	public int updateProc(MemberDTO dto) {
		int cnt=0;
		  try {
			  con=dbopen.getConnection();
			  sql=new StringBuilder();
			  sql=new StringBuilder();
		      sql.append(" UPDATE memberf ");
		      sql.append(" SET id=? ");
		      sql.append(", passwd=?, mname=?, email=?, tel=?, zipcode=?, address1=?, address2=?, job=? ");
			  pstmt=con.prepareStatement(sql.toString());
			
		        pstmt.setString(1, dto.getId());
				pstmt.setString(2, dto.getPasswd());
				pstmt.setString(3, dto.getMname());
				pstmt.setString(4,dto.getEmail());
				pstmt.setString(5,dto.getTel());
				pstmt.setString(6, dto.getZipcode());
				pstmt.setString(7,dto.getAddress1());
				pstmt.setString(8,dto.getAddress2());
				pstmt.setString(9, dto.getJob());
				cnt=pstmt.executeUpdate();			      
		      
			    }catch (Exception e) {
			      System.out.println("수정실패:"+e);
			    }finally {
			      DBClose.close(con, pstmt, rs);
			    }//try end
			    
		  return cnt;
	} 
	
	
	
	
	
	
	
	 public int check(String passwd) {
		 MemberDTO dto=null;
		  int cnt=0;
		  try {
			  con=dbopen.getConnection();
			  sql=new StringBuilder();
			  sql.append("SELECT COUNT(passwd) as cnt ");
			  sql.append("FROM memberf " );
			  sql.append("WHERE passwd=? ");
			  pstmt=con.prepareStatement(sql.toString());
		
			  pstmt.setString(1, passwd);
			  rs=pstmt.executeQuery();
			  
			  if(rs.next()){
		    	  cnt=rs.getInt("cnt");
		      }
			  
		  }catch(Exception e){
			  System.out.println("확인 실패 : " + e);
		  }finally {
			  DBClose.close(con,pstmt,rs);
		  }
		  return cnt;
		 
	  }
	
	
}
