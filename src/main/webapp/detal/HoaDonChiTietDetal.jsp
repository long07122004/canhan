<%--
  Created by IntelliJ IDEA.
  User: Dungvt22
  Date: 03/04/2024
  Time: 3:47 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<body>
<form action="/hdct/update?id=${detal.id}" method="post">
    <div class="mb-3">
        <label for="disabledSelect" class="form-label">id hoa don</label>
        <select id="disabledSelect" class="form-select" name="hoaDon">
            <c:forEach items="${hoaDon}" var="hoaDon">
                <option value="${hoaDon.id}"
                        <c:if test="${detal.hoaDon.id == hoaDon.id}">selected</c:if>

                >${hoaDon.id}</option>
            </c:forEach>
        </select>
    </div>
    <div class="mb-3">
        <label for="disabledSelectt" class="form-label">ctsp</label>
        <select id="disabledSelectt" class="form-select" name="chiTietSanPham">
            <c:forEach items="${chiTietSanPham}" var="chiTietSanPham">
                <option value="${chiTietSanPham.sanpham.id}"
                        <c:if test="${detal.chiTietSanPham.id == chiTietSanPham.id}">selected</c:if>

                >${chiTietSanPham.sanpham.tensanpham}</option>
            </c:forEach>
        </select>
    </div>




    <div class="mb-3">
        <label class="form-label">so luong mua </label>
        <input type="text" class="form-control" name="soluong" value="${detal.soluong}">
    </div>
    <div class="mb-3">
        <label class="form-label">gia ban </label>
        <input type="text" class="form-control" name="giaban" value="${detal.giaban}">
    </div>

    <div class="row">
        <p class="col-4">Trang thai
        </p>
        <div class="form-check col-4">
            <input class="form-check-input" type="radio" value="Active" name="trangthai"
                   <c:if test="${detal.trangthai == 'Active'}">checked</c:if>
            >
            <label class="form-check-label">
                Active
            </label>
        </div>
        <div class="form-check col-4">
            <input class="form-check-input" type="radio" value="Inactive" name="trangthai"
                   <c:if test="${detal.trangthai == 'Inactive'}">checked</c:if>
            >
            <label class="form-check-label">
                Inactive
            </label>
        </div>
    </div>
    <button type="submit" class="btn btn-success">Submit</button>
</form>
</body>
</html>
