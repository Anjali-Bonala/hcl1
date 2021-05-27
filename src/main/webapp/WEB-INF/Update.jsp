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
float : left;
}
</style>
</head>
<body>
<form action="UpdateLibrary" method ="get">
Title: <input type = "text" name = "title" placeholder = "enter title" />
Author: <input type = "text" name = "author" placeholder ="enter author" />
<input type="Submit" value="SAVE" onClick="<a href="index.jsp"></a>"/>
<input type="submit" value="SAVE" onClick="save"/>


</form>
<a href="Success.jsp"><button>Save</button></a>
</body>
</html>