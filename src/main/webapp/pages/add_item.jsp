<%@ page contentType="text/html;charset=UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Add new item</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
</head>
<body>
<form action="${pageContext.request.contextPath}/controller" enctype="multipart/form-data" method="post"
      style="margin-left: 500px;border-color: #2a2a2a;border-width: 1px;margin-right: 400px; font-size: larger; background-color: rgba(240,227,221,0.73);padding-left: 30px">
     <div style="color: red">
        <c:out value="${fields_must_be_filled}"/>
    </div>
    <label for="item_category">Category</label>
    <select id="item_category" name="item_category">
        <option value="none" selected></option>
        <option value="rods">Rods</option>
        <option value="reels">Reels</option>
        <option value="lures">Lures</option>
        <option value="line">Line</option>
        <option value="hooks">Hooks</option>
    </select>
    <br>
    <label for="brand">Brand</label>
    <input type="text" id="brand" name="brand" value="">
    <br>
    <label for="picture">Picture</label>
    <input type="file" id="picture" name="picture"/>
    <br>
    <label for="name">Name</label>
    <input type="text" id="name" name="item_name" value=""/>
    <br>
    <label for="description">Description</label>
    <textarea name="description" id="description" cols="20" rows="5"></textarea>
    <br>
    <label for="price">Price</label>
    <input type="number" id="price" name="price" value="0" step=".01"/>
    <p style="margin: 0">In stock</p>
    <input type="radio" id="in_stock_yes" name="stock" value="in_stock"/>
    <label for="in_stock_yes">YES</label>
    <input type="radio" id="in_stock_no" name="stock" value="out_of_stock"/>
    <label for="in_stock_no">NO</label>
    <br>
    <input type="hidden" name="command" value="add_new_item"/>
    <input type="submit" name="add_item" value="Add new item"/>
    <a href="${pageContext.request.contextPath}/controller?command=go_to_admin_page">Return to admin page</a>
</form>
</body>
<footer style="padding-top: 200px">
    <c:out value="© M.Belyuk,2022"/>
</footer>
</html>
