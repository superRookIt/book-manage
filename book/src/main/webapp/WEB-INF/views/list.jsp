<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>

</head>

<body>

	<table>
	
	<c:forEach items="${book_list}" var="blist">
	
		<tr>
			<td>${blist.bnum}</td>
			<td>${blist.title}</td>
			<td>${blist.writer}</td>
			<td>${blist.company}</td>
		</tr>
		
	</c:forEach>

	</table>



</body>



</html>