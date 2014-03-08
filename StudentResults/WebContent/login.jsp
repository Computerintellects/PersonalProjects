<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>welcome page</title>
</head>
<body>

<html:form action="/login" >
<html:errors/><br/>
User Name :<html:text property="userName" /><br/>
Password  :<html:password property="password" /><br/>
<html:submit value="Login" />
</html:form>
</body>
</html>