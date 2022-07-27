<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new item</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/controller" enctype="multipart/form-data" method="post">
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
    <input type="number" id="price" name="price" value=""/>
    <p style="margin: 0">In stock</p>
    <input type="radio" id="in_stock_yes" name="stock" value="in_stock"/>
    <label for="in_stock_yes">YES</label>
    <input type="radio" id="in_stock_no" name="stock" value="out_of_stock"/>
    <label for="in_stock_no">NO</label>
    <br>
    <input type="hidden" name="command" value="add_new_item"/>
    <input type="submit" name="add_item" value="Add new item"/>

</form>
</body>
</html>
