<%--
  Created by IntelliJ IDEA.
  User: Dungvt22
  Date: 26/03/2024
  Time: 11:55 SA
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
<form action="/ctsp/add" method="post">
    <div class="mb-3">
        <label for="disabledSelect" class="form-label">Ten san pham</label>
        <select id="disabledSelect" class="form-select" name="sanpham">
            <c:forEach items="${sanPham}" var="sanPham">
                <option value="${sanPham.id}">${sanPham.tensanpham}</option>
            </c:forEach>
        </select>
    </div>
    <div class="mb-3">
        <label for="disabledSelectt" class="form-label">Ten mau sac</label>
        <select id="disabledSelectt" class="form-select" name="mausac">
            <c:forEach items="${mauSac}" var="mauSac">
                <option value="${mauSac.id}">${mauSac.tenmau}</option>
            </c:forEach>
        </select>
    </div>
    <div class="mb-3">
        <label for="disabledSelecttt" class="form-label">Ten size</label>
        <select id="disabledSelecttt" class="form-select" name="sizesp">
            <c:forEach items="${sizeSp}" var="sizeSp">
                <option value="${sizeSp.id}">${sizeSp.tensize}</option>
            </c:forEach>
        </select>
    </div>



    <div class="mb-3">
        <label class="form-label">gia ban </label>
        <input type="text" class="form-control" name="giaban" >
    </div>
    <div class="mb-3">
        <label class="form-label">so luong ton </label>
        <input type="text" class="form-control" name="soluongton" >
    </div>

    <div class="row">
        <p class="col-4">Trang thai
        </p>
        <div class="form-check col-4">
            <input class="form-check-input" type="radio" value="Active" name="trangthai">
            <label class="form-check-label">
                Active
            </label>
        </div>
        <div class="form-check col-4">
            <input class="form-check-input" type="radio" value="Inactive" name="trangthai">
            <label class="form-check-label">
                Inactive
            </label>
        </div>
    </div>
    <button type="submit" class="btn btn-success">Submit</button>
</form>
<table class="table">
    <thead>
    <tr>
        <th>STT</th>
        <th>ID</th>
        <th>ID_SP</th>
        <th>ID_MAU_SAC</th>
        <th>ID_SIZE</th>
        <th>GIA BAN</th>
        <th>SO LUONG</th>
        <th>TRANG THAI</th>
        <th>NGAY TAO</th>
        <th>NGAY SUA</th>

        <th>THAO TAC</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listctsp}" var="a" varStatus="i">
        <tr>

            <td>${i.index+1}</td>
            <td>${a.idctsp}</td>
            <td>${a.sanpham.tensanpham}</td>
            <td>${a.mausac.tenmau}</td>
            <td>${a.sizesp.tensize}</td>
            <td>${a.giaban}</td>
            <td>${a.soluongton}</td>
            <td>${a.trangthai}</td>
            <td>${a.ngaytao}</td>
            <td>${a.ngaysua}</td>
            <td>
                <a class="btn btn-warning" href="/ctsp/detal?id=${a.idctsp}">CHI TIET</a>
            </td>
<%--            <td>--%>
<%--                <a class="btn btn-warning" href="/ctsp/delete?id=${a.id}">XOA</a>--%>
<%--            </td>--%>


        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
