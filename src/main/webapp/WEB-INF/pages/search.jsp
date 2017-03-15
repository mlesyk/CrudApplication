<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search Results</title>
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

<h2 style="margin-top: 10px; text-align: center">
    Search result:
</h2>
<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Age</th>
        <th>Admin</th>
        <th>Created date</th>
        <th>Edit</th>
        <th>Remove</th>
    </tr>
    <c:if test="${!empty resultPages.pageList}">
    <c:forEach items="${resultPages.pageList}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.age}</td>
            <td>
                <c:if test="${user.admin}">
                    Yes
                </c:if>
                <c:if test="${!user.admin}">
                    No
                </c:if>

            </td>
            <td><fmt:formatDate value="${user.createdDate}" pattern="dd-MM-yyyy HH:mm:ss"/></td>
            <td><a href="/edit/${user.id}">Edit</a></td>
            <td><a href="/remove/${user.id}">Remove</a></td>
        </tr>
    </c:forEach>
    </c:if>
    <c:if test="${empty resultPages.pageList}">
        <tr>
            <td style="border-style:hidden">No matches found</td>
            <td style="border-style:hidden"></td>
            <td style="border-style:hidden"></td>
            <td style="border-style:hidden"></td>
            <td style="border-style:hidden"></td>
            <td style="border-style:hidden"></td>
            <td style="border-style:hidden"></td>
        </tr>
    </c:if>
</table>
<div class="inline" style="margin-top: 10px">
<a <c:if test="${resultPages.firstPage}">hidden</c:if>  href="/search${prevPageRequest}" ><< Prev  </a>
<span <c:if test="${!resultPages.firstPage}">hidden</c:if>><< Prev  </span>
<a <c:if test="${resultPages.lastPage}">hidden</c:if>  href="/search${nextPageRequest}">Next >></a>
<span <c:if test="${!resultPages.lastPage}">hidden</c:if>> Next >> </span>
</div>


<br>
<a href="/users"> << Back to Users list</a>
</body>
</html>