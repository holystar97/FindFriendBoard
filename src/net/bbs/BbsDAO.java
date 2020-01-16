package net.bbs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import net.utility.DBClose;
import net.utility.DBOpen;

public class BbsDAO {

	private DBOpen dbopen=null;
	private Connection con=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	private StringBuilder sql=null;
	
	public BbsDAO() {
		dbopen=new DBOpen();
	}
	
	public int insert(BbsDTO dto) {
		int cnt=0;
		
		try {
			con=dbopen.getConnection();
			sql=new StringBuilder();
			
			sql.append(" INSERT INTO tb_bbsf(bbsno, wname, subject, content, passwd, grpno, ip) ");
			sql.append(" VALUES ( (select nvl(max(bbsno),0)+1 from tb_bbsf) ");
			sql.append(",?,?,?,?,(select nvl(max(bbsno),0)+1 from tb_bbsf),? )");
			
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getWname());
			pstmt.setString(2, dto.getSubject());
			pstmt.setString(3, dto.getContent());
			pstmt.setString(4,dto.getPasswd());
			pstmt.setString(5,dto.getIp());
			
			cnt=pstmt.executeUpdate();
			
		}catch(Exception e){
			System.out.println("데이터 추가 실패 : " +e);
		}finally {
			DBClose.close(con,pstmt);
		}
		return cnt; // 행 추가 성공 여부 리턴 
		
	}
	
public ArrayList<BbsDTO> list(){
		
		ArrayList<BbsDTO> list=null;
	
		try {
		      con=dbopen.getConnection();
		      sql=new StringBuilder();
		      sql.append(" SELECT bbsno, wname, subject, readcnt, indent, regdt");
		      sql.append(" FROM tb_bbsf");
		      sql.append(" ORDER BY grpno DESC, ansnum ASC");
		      
		      pstmt=con.prepareStatement(sql.toString());
		      rs=pstmt.executeQuery();
		      if(rs.next()){
		        //전체행 저장
		        list=new ArrayList<>();
		        do {
		          //한줄저장
		          BbsDTO dto=new BbsDTO();
		          dto.setBbsno(rs.getInt("bbsno"));
		          dto.setWname(rs.getString("wname"));
		          dto.setSubject(rs.getString("subject"));
		          dto.setReadcnt(rs.getInt("readcnt"));
		          dto.setIndent(rs.getInt("indent"));
		          dto.setRegdt(rs.getString("regdt"));    
		          list.add(dto);
		        }while(rs.next());
		        
		      }else {
		        list=null;
		      }//if end
		      
		    }catch (Exception e) {
		      System.out.println("목록실패:"+e);
		    }finally {
		      DBClose.close(con, pstmt, rs);
		    }//try end
		    
		    return list;
		
		
		
	}
	
	
	
	
	
}
