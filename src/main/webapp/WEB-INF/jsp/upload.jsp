
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="include/header.jsp" />

<h1>File Upload</h1>

<form action="/upload" enctype="multipart/form-data" method="post">

    Subject : <input type="text" name="subject" >
    <br>
    Select file : <input type="file" name="file">
    <br>
    <input type="submit" value="Submit">


</form>
























<jsp:include page="include/footer.jsp" />