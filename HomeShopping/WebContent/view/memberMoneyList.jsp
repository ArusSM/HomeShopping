<%@page import="vo.MemberMoneyVO"%>
<%@page import="vo.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/header.jsp" %>
<section>
<%
	ArrayList<MemberMoneyVO> list = (ArrayList<MemberMoneyVO>)request.getAttribute("moneyList");
%>
<div class="container">
	<p class="title">회원목록조회/수정</p>
	<table border = "1" align = "center" width = "800px">
	<tr>
		<td>회원번호</td>
		<td>회원성명</td>
		<td>고객등급</td>
		<td>매출</td>

	</tr>
	<%
	if(list != null) {
		for(MemberMoneyVO data : list) {
			

	
	%>
	<tr>
		<td><%=data.getCustno()%></a></td>
		<td><%=data.getCustname() %></td>
		<td><%=data.getGrade() %></td>
		<td><%=data.getPrice() %></td>
	</tr>
	
<%
		}
	}
%>
	</table>
	</div>
	</section>
<%@ include file="/footer.jsp" %>