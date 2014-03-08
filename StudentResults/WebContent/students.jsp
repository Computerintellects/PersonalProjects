<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <link href="<c:url value='main.css'/>" rel="stylesheet" type="text/css"/>
    <title><fmt:message key="label.students"/></title>
</head>
<body>
<div class="titleDiv"><fmt:message key="application.title"/></div>
<h1><fmt:message key="label.students"/></h1>
<c:url var="url" scope="page" value="/studentSetUp.do">
    <c:param name="dispatch" value="setUpForInsertOrUpdate"/>
</c:url>
<a href="${url}">Add New Student</a>
<br/><br/>
<table class="borderAll">
    <tr>
        <th><fmt:message key="label.studentName"/></th>
        <th><fmt:message key="label.studentregno"/></th>
        <th><fmt:message key="label.english"/></th>
         <th><fmt:message key="label.tamil"/></th>
        <th><fmt:message key="label.maths"/></th>
        <th><fmt:message key="label.science"/></th>
        <th><fmt:message key="label.social"/></th>
        <th><fmt:message key="label.totalmarks"/></th>
       
        <th>&nbsp;</th>
    </tr>
    <c:forEach var="std" items="${students}" varStatus="status">
        <tr class="${status.index%2==0?'even':'odd'}">
             <td class="nowrap"><c:out value="${std.studentname}"/></td>
             <td class="nowrap"><c:out value="${std.studentregno}"/></td>
             <td class="nowrap"><c:out value="${std.english}"/></td>
             <td class="nowrap"><c:out value="${std.tamil}"/></td>
             <td class="nowrap"><c:out value="${std.maths}"/></td>
             <td class="nowrap"><c:out value="${std.science}"/></td>
             <td class="nowrap"><c:out value="${std.social}"/></td>
             <td class="nowrap"><c:out value="${std.totalmarks}"/></td>
          
           
            <td class="nowrap">
                <c:url var="url" scope="page" value="/studentSetUp.do">
                    <c:param name="std" value="${std.std}"/>
                    <c:param name="dispatch" value="setUpForInsertOrUpdate"/>
                </c:url>
                <a href="${url}">Edit</a>
                &nbsp;&nbsp;&nbsp;
                <c:url var="url" scope="page" value="/studentProcess.do">
                    <c:param name="std" value="${std.std}"/>
                    <c:param name="dispatch" value="delete"/>
                </c:url>
                <a href="${url}">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </table>
</body>
</html>