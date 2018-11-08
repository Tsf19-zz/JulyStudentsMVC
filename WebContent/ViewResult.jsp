<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>ViewResult</title>
	</head>
	<body>
		<%
			HttpSession hs = request.getSession();
			String usn = (String)hs.getAttribute("USN");
			String name = (String)hs.getAttribute("NAME");
			int marks1 = (int)hs.getAttribute("MARKS1");
			int marks2 = (int)hs.getAttribute("MARKS2");
			int marks3 = (int)hs.getAttribute("MARKS3");
			float avg = (float)hs.getAttribute("AVG");
			
			out.println(usn+" "+name+" "+marks1+" "+marks2+" "+marks3+" "+avg);
			
		%>
	</body>
</html>