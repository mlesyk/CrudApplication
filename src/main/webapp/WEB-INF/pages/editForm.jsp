<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title>Edit User</title>
    <link href="/resources/css/style.css" rel="stylesheet" type="text/css">

</head>
<body>

<h2 style="margin-top: 70px; text-align: center">Edit User</h2>
<form:form method="POST" action="/editsave">
<div class="editUser">
    <form:hidden  path="id" />
    <br>
    <form:label path="name">
        <spring:message text="Name"/>
    </form:label>
    <br>
    <form:input class="plain" path="name" />
    <br>
    <form:label path="age">
        <spring:message text="Age"/>
    </form:label>
    <br>
    <form:input class="plain" path="age" />
    <br>
     Admin privileges :
    <form:checkbox path="admin"/>
    <br>
    <form:hidden  path="createdDate" />
    <br>
    <input class="link-button" type="submit" value="Edit Save" />
</div>
</form:form>
<a href="/users"> << Back to Users list</a>
</body>