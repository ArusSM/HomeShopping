<%@page import="java.util.ArrayList"%>
<%@page import="vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/header.jsp" %>
<section>
<%
	ArrayList<MemberVO> list = (ArrayList<MemberVO>)request.getAttribute("memberList");
%>
<div class="container">
	<p class="title">회원목록조회/수정</p>
	<table border = "1" align = "center" width = "800px">
	<tr>
		<td>회원번호</td>
		<td>회원성명</td>
		<td>전화번호</td>
		<td>주소</td>
		<td>가입일자</td>
		<td>고객등급</td>
		<td>거주지역</td>
	</tr>
	<%
	if(list != null) {
		for(MemberVO data : list) {
			

	
	%>
	<tr>
		<td><a href="/memberUpdate.do?custno=<%=data.getCustno()%>"><%=data.getCustno()%></a></td>
		<td><%=data.getCustname() %></td>
		<td><%=data.getPhone() %></td>
		<td><%=data.getAddress() %></td>
		<td><%=data.getJoindate() %></td>
		<td><%=data.getGrade() %></td>
		<td><%=data.getCity() %></td>
	</tr>
	
<%
		}
	}
%>
	</table>
	</div>
	</section>
<%@ include file="/footer.jsp" %>