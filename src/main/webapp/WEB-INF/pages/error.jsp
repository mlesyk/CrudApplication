<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
    <link href="/resources/css/style.css" rel="stylesheet" type="text/css">

</head>
<body>
<div class="inline">
    <a class="link-button" href="/addForm">Add New User</a>
    <form:form method="get" action="/search" commandName="search">
        <button id="button-id" type="submit">Search</button>
        <input class="search" type="text" id="txt" name="name" placeholder="Search by name...">
    </form:form>
</div>
<div class="error">
    <h2>Error occurred. </h2>
    <p>${message}</p>
</div>



<a href="/users"> << Back to Users list</a>
</body>
</html>