<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<c:set var="insertUpdateTitle" value="${!empty studentForm.std && studentForm.std != 0 ?'Update Student':'Add Student'}"/>
<html>
<head>
    <link href="<c:url value='main.css'/>" rel="stylesheet" type="text/css"/>
    <style>td { white-space:nowrap; }</style>
    <title><c:out value="${insertUpdateTitle}"/></title>
</head>
<body>
<div class="titleDiv"><fmt:message key="application.title"/></div>
<h1><c:out value="${insertUpdateTitle}"/></h1>
<html:form action="/studentProcess">
    <table>
         <tr>
            <td class="tdLabel"><fmt:message key="label.studentName"/>:</td>
            <td><html:text property="studentname" size="40"/> <html:errors property="studentname"/></td>
        </tr>
       
        <tr>
            <td class="tdLabel"><fmt:message key="label.studentregno"/>:</td>
            <td><html:text property="studentregno" size="20"/> <html:errors property="studentregno"/></td>
        </tr>
        
         <tr>
            <td class="tdLabel"><fmt:message key="label.english"/>:</td>
            <td><html:text property="english" size="20"/> <html:errors property="english"/></td>
        </tr>
         <tr>
            <td class="tdLabel"><fmt:message key="label.tamil"/>:</td>
            <td><html:text property="tamil" size="20"/> <html:errors property="tamil"/></td>
        </tr>
         <tr>
            <td class="tdLabel"><fmt:message key="label.maths"/>:</td>
            <td><html:text property="maths" size="20"/> <html:errors property="maths"/></td>
        </tr>
         <tr>
            <td class="tdLabel"><fmt:message key="label.science"/>:</td>
            <td><html:text property="science" size="20"/> <html:errors property="science"/></td>
        </tr>
         <tr>
            <td class="tdLabel"><fmt:message key="label.social"/>:</td>
            <td><html:text property="social" size="20"/> <html:errors property="social"/></td>
        </tr>
         <tr>
            <td class="tdLabel"><fmt:message key="label.totalmarks"/>:</td>
            <td><html:text property="totalmarks" size="20" disabled="true"/> <html:errors property="totalmarks"/></td>
        </tr>
       
       
       
       
        <tr>
            <td colspan="2">
                <html:hidden property="std"/>
                <input type="hidden" name="dispatch" value="insertOrUpdate"/>
                <br/>
                <input type="submit" value="<fmt:message key="button.label.submit"/>" class="butStnd"/>
                &nbsp;&nbsp;&nbsp;
                <input type="submit" value="<fmt:message key="button.label.cancel"/>"  class="butStnd" onclick="document.studentForm.dispatch.value='getStudents'"/>
            </td>
        </tr>
    </table>
</html:form>
</body>
</html>