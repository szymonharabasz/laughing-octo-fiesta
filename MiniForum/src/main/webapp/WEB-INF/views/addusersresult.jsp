<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Result</title>

</head>
<body>
<c:if test="${success == true}">
Users successfully inserted to the database
</c:if>
<c:if test="${success == false}">
Error while adding users to the database: <br />
${errorMessage}
</c:if>
</body>
</html>