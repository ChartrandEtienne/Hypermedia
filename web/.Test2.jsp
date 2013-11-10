<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html><head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
</head>
<body>
<h1>Test2.jsp</h1>
<c:if test="${not empty message}">
<p>
${message}
</p>
</c:if>
</body></html>
