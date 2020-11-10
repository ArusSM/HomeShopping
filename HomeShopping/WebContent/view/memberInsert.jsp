<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/header.jsp"%>
<style>
	#listbtn, #subbtn {
		width : 80px;
	}
	table {
		width: 800px;
	}
</style>
<section>
	<%
		int cusMaxNo = (int)request.getAttribute("cusMaxNo");
	%>
	<div class="container">
		<p class="title">홈쇼핑 회원 등록</p>
		<form action="/memberInsert.do" method="post">
			<table border="1">
				<tr>
					<td>회원번호(자동발생)</td>
					<td><input type="text" name="custno" value="<%=cusMaxNo%>"readonly></td>
				</tr>
				<tr>
					<td>회원성명</td>
					<td><input type="text" name="custname"></td>
				</tr>
				<tr>
					<td>회원전화</td>
					<td><input type="text" name="phone"></td>
				</tr>
				<tr>
					<td>회원주소</td>
					<td><input type="text" name="address"></td>
				</tr>
				<tr>
					<td>가입일자</td>
					<td><input type="date" name="joindate"></td>
				</tr>
				<tr>
					<td>고객등급 [A:VIP, B:일반, C:직원]</td>
					<td><input type="text" name="grade"></td>
				</tr>
				<tr>
					<td>도시코드</td>
					<td><input type="text" name="city"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="등록" id = "subbtn">
						<a href="/index.jsp"><button id = listbtn>조회</button></a></td>
				</tr>
			</table>
		</form>
	</div>
</section>
<%@ include file="/footer.jsp"%>