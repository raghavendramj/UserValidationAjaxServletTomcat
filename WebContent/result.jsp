<html>
<head>
<title>Success Page</title>
</head>
<body>
	<%
		String json = request.getParameter("json");
		String password = request.getParameter("password");
		String data = (String) session.getAttribute("session-uid");
		out.println("Welcome " + json + "!!");
	%>
</body>
</html>