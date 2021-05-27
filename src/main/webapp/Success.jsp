<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.*" %>
    <%@page import="com.gl.librarymanagement.model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%List<Library> list=(ArrayList<Library>)request.getAttribute("list");%>
<table border="2" cellspacing="0" cellpadding="10">
<tr>
<th>title</th>
<th>author</th>
<th>price</th>

</tr>
<%for(Library l : list){%>
<tr>
<td><%=l.getTitle()%></td>
<td><%=l.getAuthor()%></td>
<td><%=l.getPrice()%></td>
<td><a href="UpdateLibrary?title=<%=l.getTitle()%>"><button>Edit</button></a></td>
<td><a href="deleteLibrary?title =<%=l.getTitle()%>"><button>Delete</button></a></td>

</tr>
<%} %>
</table>


</body>
</html>