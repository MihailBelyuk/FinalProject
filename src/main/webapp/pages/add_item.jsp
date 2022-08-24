<%@ page contentType="text/html;charset=UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Add new item</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
</head>
<body style="background-color: rgba(106,155,55,0.5)">
<form action="${pageContext.request.contextPath}/controller" enctype="multipart/form-data" method="post"
      style=" border-color: #2a2a2a;
              border-width: 1px;
              position: center;
              font-size: larger;
              margin-left: 500px;
              margin-top: 50px">
    <div style="color: red">
        <c:out value="${fields_must_be_filled}"/>
    </div>
    <div>
        <label for="item_category">Category</label>
        <select id="item_category" name="item_category">
            <option value="rods" selected>RODS</option>
            <option value="reels">REELS</option>
            <option value="lures">LURES</option>
            <option value="line">LINE</option>
            <option value="hooks">HOOKS</option>
        </select>
        <label for="brand">Brand</label>
        <input type="text" id="brand" name="brand" value="">
        <br>
        <label for="picture">Picture</label>
        <input type="file" id="picture" name="picture"/>
        <br>
        <label for="name">Name</label>
        <input type="text" id="name" name="item_name" value="" style="width: 330px;margin-bottom: 2px"/>
        <br>
        <label for="description">Description</label>
        <textarea name="description" id="description" cols="36" rows="5"></textarea>
        <br>
        <label for="price">Price</label>
        <input type="number" id="price" name="price" value="" step=".01" style="width: 336px"/>
        <p style="">In stock
        <input type="radio" id="in_stock_yes" name="stock" value="in_stock"/>
        <label for="in_stock_yes">YES</label>
        <input type="radio" id="in_stock_no" name="stock" value="out_of_stock"/>
        <label for="in_stock_no">NO</label>
        </p>
        <br>
        <input type="hidden" name="command" value="add_new_item"/>
        <input type="submit" name="add_item" value="Add new item"/>
        <a href="${pageContext.request.contextPath}/controller?command=go_to_admin_page">Return to admin page</a>
    </div>
</form>
</body>
<footer>
    <c:import url="footer.jsp"/>
</footer>

</html>
