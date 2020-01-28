<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="ssi.jsp" %>
<!-- 본문시작  -->
	<h3>* 사진 삭제 *</h3>
	
<form method="post" action="pdsDelProc.jsp" onsubmit="return pwCheck(this)">
	<input type="hidden"
       name="pdsno"
       value="<%=request.getParameter("pdsno")%>">  
		<table class="table">
				<tr>
					<th>비밀번호</th>
					<td><input style="color: black" type="password" name="passwd" required></td>
				</tr>
				<tr>
					<td colspan="2">
					  <input style="color: black" type="submit" value="확인">
					</td>
				</tr>
		</table>
	</form>
	
<!-- 본문끝  -->
<%@ include file="../footer.jsp"%>
