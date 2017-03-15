<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Add new User</title>
    <link href="/resources/css/style.css" rel="stylesheet" type="text/css">

</head>
<body>
<form:form method="POST" action="/addUser">
    <div class="newUser">
    <form:label path="name">
        <spring:message text="Name"/>
    </form:label>
        <br>
    <form:input class="plain" path="name" placeholder="Name"/>
        <br>
    <form:label path="age">
        <spring:message text="Age"/>
    </form:label>
        <br>
    <form:input class="plain" path="age" placeholder="Age"/>
        <br>
        <form:checkbox value="1" path="admin"/> Grant Admin
    <br>

    <input class="link-button" type="submit" value="<spring:message text="Add User"/>"/>
    </div>
</form:form>
<a href="/users"> << Back to Users list</a>
</body>