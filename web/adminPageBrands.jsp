<%@ page import="kz.bitlab.sprinttask.db.Brands" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="kz.bitlab.sprinttask.db.Brands" %>
<%@ page import="kz.bitlab.sprinttask.db.DBManager" %>
<html>
<head>
    <title>Title</title>
    <%@include file="head.jsp"%>
</head>
<body>
    <%@include file="navbar.jsp"%>
    <div class="container">
      <h1 class="display-4 text-dark text-center" style="font-weight: bold;">Admin Panel - Brands</h1>
    </div>
    <div class="modal fade" id="addBrand" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">Add New Brand</h5>
            <button type="button" class="close" data-bs-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <div class="modal-body">
            <%@include file="addBrandForm.jsp"%>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-secondary btn-sm" data-bs-dismiss="modal">CANCEL</button>
          </div>
        </div>
      </div>
    </div>


    <div class="container">
      <table class="table">
        <button type="button" style="float: left" class="btn btn-success btn-sm" data-bs-toggle="modal" data-bs-target="#addBrand">
          + ADD NEW
        </button>
        <thead class="thead-dark">
        <tr>
          <th scope="col">ID</th>
          <th scope="col">NAME</th>
          <th scope="col">COUNTRY</th>
          <th scope="col">DETAILS</th>
        </tr>
        </thead>
        <tbody>
        <%
          ArrayList<Brands> brands = (ArrayList<Brands>)request.getAttribute("brendiki");
          if(brands!=null) {
            for(Brands bs : brands) {
        %>
        <tr>
          <th><%=bs.getId()%></th>
          <td><%=bs.getName()%></td>
          <td><%=bs.getCountry()%></td>
          <td><a href="/detailsBrand?id=<%=
                        bs.getId()
                        %>"class="btn btn-outline-dark">DETAILS:</a></td>
        </tr>
        <%
            }
          }
        %>
        </tbody>
      </table>
    </div>
</body>
</html>
