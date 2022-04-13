<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp" />


<form action="/login/loginSubmit" method="POST">

    Username: <input type="text" name="username" >
    <br>
    Password: <input type="text" name="password" >
    <button type="submit">Login</button>

</form>


<jsp:include page="../include/footer.jsp" />