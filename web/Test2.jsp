<!DOCTYPE html>
<html><head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
</head>
<body>
<h1>Test2.jsp</h1>
<% 
    ServletContext sc = getServletContext();
    sc.log("jsp2: marche?");
    HttpSession sess = request.getSession(false);
    String message = sess.getAttribute("message").toString();
    sc.log("message: " + message);
%>
<%=request.getSession(false).getAttribute("message").toString() %>
<br/>split<br/>
<%=request.getSession(false).getAttribute("urls").toString() %>
</p>
</body></html>
