<%--
  Created by IntelliJ IDEA.
  User: Dungvt22
  Date: 27/03/2024
  Time: 4:57 CH
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
<div class="row">
    <div class="col-7">
        <h2>Danh sách hoá đơn</h2>


        <table class="table">
            <thead>
            <tr>
                <td>STT</td>
                <td>ID</td>
                <td>Ten khach hang</td>
                <td>Ngay tao</td>
<%--                <td>Tong tien</td>--%>
                <td>Trang Thai</td>
                <td>Chuc nang</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listHoaDon}" var="a" varStatus="i">
                <tr>

                    <td>${i.index+1}</td>
                    <td>${a.id}</td>
                    <td>${a.khachHang.hoten}</td>
<%--                    <td>Ha Viet Long</td>--%>
                    <td>${a.ngaytao}</td>
<%--                    <td>0</td>--%>

                    <td>${a.trangthai}</td>

                    <td>
                        <a class="btn btn-primary" href="/taohoadon/detal?id=${a.id}">Chọn</a>


                    </td>


                </tr>
            </c:forEach>
            </tbody>
        </table>
        <h2>Danh sách hoá đơn chi tiết</h2>


        <table class="table">
            <thead>
            <tr>
                <td>STT</td>
                <td>ID</td>
                <td>Ten san pham</td>
                <td>So luong</td>
                <td>Gia ban</td>
                <td>Tong tien</td>

            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listHoaDonChiTiet}" var="a" varStatus="i">
                <tr>

                    <td>${i.index+1}</td>
                    <td>${a.id}</td>
                    <td>${a.chiTietSanPham.sanpham.tensanpham}</td>
                    <td>${a.soluong}</td>
                    <td>${a.giaban}</td>
                    <td>${a.tongtien}</td>




                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="col-5">
        <h2>Tạo hoá đơn</h2>
        <form action="/taohoadon" method="post">
        <div class="row">
            <div>
                <div>
                    <label class="mb-3 col-3">Số điện thoại</label>
                    <input type="text" class="col-7">
                </div>
                <button  class="btn btn-primary">Search</button>
            </div>
<%--            <div class="mb-3">--%>
<%--                <label class="col-3">Ten Khach hang</label>--%>
<%--                <input type="text" class="col-7" readonly >--%>
<%--            </div>--%>
            <div class="mb-3">
                <label for="disabledSelect" class=" col-3">Ten Khach hang</label>
                <select id="disabledSelect" class="col-7" name="khachHang">
                    <c:forEach items="${listkhachhang}" var="khachHang">
                        <option value="${khachHang.id}"
                                <c:if test="${hoaDondetal.khachHang.id == khachHang.id}">selected</c:if>
                        >${khachHang.hoten}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="mb-3">
                <label class="col-3">ID Hoa don</label>
                <input type="text" class="col-7" readonly name="idhoadon" value="${hoaDondetal.id}">
            </div>
            <div class="mb-3">
                <label class="col-3">Tong tien</label>
                <input type="text" class="col-7" readonly name="tongtien" value="${tongtien}">
            </div>
            <div>
                <button type="submit" class="btn btn-primary">Tạo hoá đơn</button>
                <button type="submit" class="btn btn-primary">Thanh toán</button>
            </div>
        </div>
        </form>
    </div>
</div>
<div>
    <h2>Danh sách chi tiết sản phẩm</h2>

    <table class="table">
        <thead>
        <tr>
            <td>STT</td>
            <td>ID CTSP</td>
            <td>Ten san pham</td>
            <td>Mau sac</td>
            <td>Size</td>
            <td>Gia ban</td>
            <td>So luong ton</td>

            <td>Chuc nang</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listChiTietSanPham}" var="a" varStatus="i">
            <tr>

                <td>${i.index+1}</td>
                <td>${a.idctsp}</td>
                <td>${a.sanpham.tensanpham}</td>
                <td>${a.mausac.tenmau}</td>
                <td>${a.sizesp.tensize}</td>
                <td>${a.giaban}</td>
                <td>${a.soluongton}</td>


                <td>
                    <a href="/hoadonchitiet/add?idctsp=${a.idctsp}" class="btn btn-primary">Chọn mua</a>


                </td>


            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
