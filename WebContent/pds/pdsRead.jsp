<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="ssi.jsp"%>
<!-- 본문시작 pdsForm.jsp-->
<h3>* 포토 상세보기 *</h3>
<p><a href="pdsList.jsp">[사진 목록]</a></p>

<%
	int pdsno=Integer.parseInt(request.getParameter("pdsno"));
	dto=dao.read(pdsno);
	if(dto==null){
	    out.println("글없음!!");
	  }else{	  
		  //조회수 증가 
		  dao.incrementCnt(pdsno);
%>

	<table class="table table-hover">
		<tr>
			<th>제목</th>
			<td><%=dto.getSubject() %></td>
		</tr>
		<tr>
			<th>사진</th>
			<td><img style="width:300px; height:300px"src="../storage/<%=dto.getFilename()%>"></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><%=dto.getWname()%></td>
		</tr>
		<tr>	
			<th>조회수</th>
			<td><%=dto.getReadcnt()%></td>
		</tr>
		<tr>	
			<th>작성일</th>
			<td><%=dto.getRegdate().substring(0,10)%></td>
		</tr>
	</table>

<%
	  }
%>

<!-- 본문끝 -->
<%@ include file="../footer.jsp"%>