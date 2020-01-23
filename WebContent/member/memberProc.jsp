<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="ssi.jsp" %>
<%@ include file="../header.jsp"%>
<!-- 본문시작  -->
<% 

	String id=request.getParameter("id").trim();
	String passwd=request.getParameter("passwd").trim();
 	String mname= request.getParameter("mname").trim();
	String email= request.getParameter("email").trim();
	String tel= request.getParameter("tel").trim();
	String zipcode= request.getParameter("zipcode").trim();
	String address1= request.getParameter("address1").trim();
	String address2= request.getParameter("address2").trim();
	String job= request.getParameter("job").trim();
	 
	  dto.setId(id);
	  dto.setPasswd(passwd);
	  dto.setMname(mname);
	  dto.setEmail(email);
	  dto.setTel(tel);
	  dto.setZipcode(zipcode);
	  dto.setAddress1(address1);
	  dto.setAddress2(address2);
	  dto.setJob(job);
	
	  int cnt=dao.join(dto);
	  
	  if(cnt==0){
	    out.println("<p>회원등록에 실패했습니다</p>");
	    out.println("<p><a href='javascript:history.back()'>[다시시도]</a></p>");
	  }else{
	    out.println("<script>");
	    out.println("  alert('회원등록 되었습니다');");
	    out.println("  location.href='loginForm.jsp");
	    out.println("</script>");
	  }//if end
	
  
  %>
 
<!-- 본문끝  -->
<%@ include file="../footer.jsp"%>
