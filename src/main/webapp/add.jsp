<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
form{
border : 1px solid black;
padding : 5px;
margin : 10px;
width : 300px;
float :center;
}
a{
border : 1px solid black;
padding : 5px;
margin : 10px;
width : 300px;
float : center;
}
</style>
</head>
<body>

<form action="addLibrary" method ="post">
Title: <input type = "text" name = "title" placeholder = "enter title" />
<br></br>
Author: <input type = "text" name = "author" placeholder ="enter author" />
<br></br>
Price: <input type = "text" name = "price" placeholder = "enter price"/>
<br></br>
</form>

<a href="index.jsp"><button>Save</button></a>

</body>

</html>