<jsp:include page="../include/header.jsp" />

<form action="/user/registerSubmit" method="post">

<%--    Hidden variable--%>
    <input type="hidden" name="id" value="${form.id}">

    Email <input type="email" name="email" id="emailId" value="${form.email}">
    <br>
    First Name <input type="text" name="firstName" id="firstNameId" value="${form.firstName}">
    <br>
    Last Name <input type="text" name="lastName" id="lastNameId" value="${form.lastName}">
    <br>
    Password <input type="text" name="password" id="passwordId" value="${form.password}">
    <br>
    Confirm Password <input type="password" name="confirmPassword" id="confirmPasswordId" value="${form.confirmPassword}">
    <br><br>

    <button type="submit">Submit</button>


</form>

<jsp:include page="../include/footer.jsp" />