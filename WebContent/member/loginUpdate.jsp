<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="ssi.jsp" %>
<!-- 본문시작  -->
	<h3>* 회원정보 수정 *</h3>
	<p><a href="loginForm.jsp">[로그인]</a></p>
	
<form method="post" action="loginUpdateProc.jsp" onsubmit="return pwCheck2(this)">
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
