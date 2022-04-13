<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="include/header.jsp" />

<script>

</script>

<h1>AJAX Example</h1>

<div class="slidecontainer">
    <input type="range" min="1" max="100" value="50" class="slider" id="myRange">
    <div id="rangeValue"></div>
</div>



<script>
    var slider = document.getElementById("myRange");
    var output = document.getElementById("rangeValue");
    output.innerHTML = slider.value; // Display the default slider value

    // Update the current slider value (each time you drag the slider handle)
    slider.oninput = function() {
        output.innerHTML = this.value;
    }
</script>

<jsp:include page="include/footer.jsp" />








