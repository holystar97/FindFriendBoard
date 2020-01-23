<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="ssi.jsp" %>

<!-- 본문시작  -->
<!-- 본문시작 bbsUpdateForm.jsp-->
<h3>*글 수정*</h3>
<p><a href="bbsList.jsp">[글 목록]</a></p>
<form name="bbsfrm"
      method="post"
      action="bbsUpdateProc2.jsp"
      onsubmit="return bbsCheck(this)">
      
 <input type="hidden"
  name="bbsno"
  value="<%=request.getParameter("bbsno")%>">  
  
  <%
  String passwd =request.getParameter("passwd").trim();
	int bbsno     =Integer.parseInt(request.getParameter("bbsno"));  
	
	dto.setPasswd(passwd);
	dto.setBbsno(bbsno);
	

	int check=0;
	if(dao.check(bbsno,passwd)==0){%>
	 	
		<h2>수정에 실패했습니다</h2>
	
<%
	else{

	
	BbsDTO update=dao.update(bbsno);
	dto=update;
	
	}
	
%>

<table class="table">
<tr>
  <th>작성자</th>
  <td><input type="text" name="wname" size="10" maxlength="20" required class="form-control"></td>
</tr>
<tr>
  <th>제목</th>
  <td><input type="text" name="subject" size="30" maxlength="100" required class="form-control"></td>
</tr>
<tr>
  <th>내용</th>
  <td><textarea rows="5" cols="30" name="content"  class="form-control"></textarea> </td>
</tr>
<tr>
  <th>비밀번호</th>
  <td><input type="password" name="passwd" size="10" maxlength="10" required  class="form-control"></td>
</tr>
<tr>
    <td colspan="2" align="center">
      <input type="submit" value="쓰기" class="btn btn-primary">
      <input type="reset" value="취소"  class="btn btn-primary">
    </td>
</tr> 
</table>
</form>	
	
<!-- 본문끝  -->
<%@ include file="../footer.jsp"%>
