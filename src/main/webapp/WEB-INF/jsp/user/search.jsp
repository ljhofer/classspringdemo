<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp" />



<h1>Search</h1>


<form action="/user/search" method="get" >
<%--    <input type="hidden" name="id" value="${form.id}">--%>
    <input type="text" name="searchFirstName" id="searchFirstName" placeholder="Enter first name" value="${searchFirstName}">
    <br>
    <br>
    <button id="searchId" type="submit">Search</button>

</form>

<br><br>

<c:if test="${not empty searchFirstName}">
    <h2>Search results found ${users.size()}</h2>
</c:if>


<table class="table">
    <tr scope="row">
        <th>Email</th>
        <th>First Name</th>
        <th>Last Name</th>
    </tr>
    <tr></tr>

    <c:forEach items="${users}" var="user" >
        <tr scope="row">
            <td>${user.email}</td>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
        </tr>
    </c:forEach>


</table>



<jsp:include page="../include/footer.jsp" />