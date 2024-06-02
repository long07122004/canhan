<%--
  Created by IntelliJ IDEA.
  User: Dungvt22
  Date: 22/03/2024
  Time: 5:43 CH
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
<form action="/danhmuc/add" method="post">
    <div class="mb-3">
        <label class="form-label">Ma </label>
        <input type="text" class="form-control" name="madanhmuc" >
    </div>
    <div class="mb-3">
        <label class="form-label">Ten </label>
        <input type="text" class="form-control" name="tendanhmuc" >
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
    <h1>danh sach danh muc</h1>
    <thead>
    <tr>
        <th>STT</th>
        <th>ID</th>
        <th>ma danh muc</th>
        <th>ten danh muc</th>
        <th>trang thai</th>
        <th>ngay tao</th>
        <th>ngay sua</th>
        <th>thao tac</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listdm}" var="a" varStatus="i">
        <tr>

            <td>${i.index+1}</td>
            <td>${a.id}</td>
            <td>${a.madanhmuc}</td>
            <td>${a.tendanhmuc}</td>
            <td>${a.trangthai}</td>
            <td>${a.ngaytao}</td>
            <td>${a.ngaysua}</td>
            <td>
                <a class="btn btn-warning" href="/danhmuc/detal?id=${a.id}">CHI TIET</a>
            </td>
            <td>
                <a class="btn btn-warning" href="/danhmuc/delete?id=${a.id}">XOA</a>
            </td>

        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
