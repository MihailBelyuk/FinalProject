<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Copyright</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/5.2/assets/css/docs.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

</body>
<footer style="padding-top: 600px;padding-bottom: 50px; width: 1000px; position: center">
    <div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="true">
        <div class="carousel-indicators">
            <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active"
                    aria-current="true" aria-label="Slide 1"></button>
            <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1"
                    aria-label="Slide 2"></button>
            <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2"
                    aria-label="Slide 3"></button>
            <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="3"
                    aria-label="Slide 4"></button>
        </div>
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img src="${pageContext.request.contextPath}/css/pictures/brands/daiwalbl.jpg" class="d-block w-100"
                     alt="..." style="height: 260px">
            </div>
            <div class="carousel-item">
                <img src="${pageContext.request.contextPath}/css/pictures/brands/shimanolbl.jpg" class="d-block w-100"
                     alt="..." style="height: 260px">
            </div>
            <div class="carousel-item">
                <img src="${pageContext.request.contextPath}/css/pictures/brands/LuckyJohnlogo.jpg"
                     class="d-block w-100" alt="..." style="height: 260px">
            </div>
            <div class="carousel-item">
                <img src="${pageContext.request.contextPath}/css/pictures/brands/owner_logo.jpg" class="d-block w-100"
                     alt="..." style="height: 260px">
            </div>
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators"
                data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators"
                data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
        </button>
    </div>
    <c:out value="© M.Belyuk,2022"/>
</footer>
</html>
