<%@ page import="kz.bitlab.sprinttask.db.Items" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="head.jsp"%>
</head>
<body>
    <%@include file="navbar.jsp"%>
    <%
      Items it = (Items)request.getAttribute("pluwka");
      if(it!=null) {
    %>
    <div class="container mt-5">
      <div class="row">
        <div class="col-6 mx-auto">
          <div class="row">
            <div class="col-12">
              <label>NAME: </label>
            </div>
          </div>
          <div class="row mt-2">
            <div class="col-12">
              <input type="text" class="form-control" readonly value="<%=it.getName()%>">
            </div>
          </div>
          <div class="row">
            <div class="col-12">
              <label>DESCRIPTION: </label>
            </div>
          </div>
          <div class="row mt-2">
            <div class="col-12">
              <textarea readonly rows="10" class="form-control"><%=it.getDescription()%></textarea>
            </div>
          </div>
          <div class="row">
            <div class="col-12">
              <label>PRICE: </label>
            </div>
          </div>
          <div class="row mt-2">
            <div class="col-12">
              <input type="number" class="form-control" readonly value="<%=it.getPrice()%>">
            </div>
          </div>

          <a type="button" class="btn btn-danger btn-sm ms-1 mt-3" data-bs-toggle="modal" data-bs-target="#deleteItem">
            DELETE ITEM
          </a>
          <a type="button" class="btn btn-primary btn-sm ms-1 mt-3" data-bs-toggle="modal" data-bs-target="#editItem">
            EDIT ITEM
          </a>
          <a href="/home" class="bg-success btn btn-sm mt-3 ms-1">SAVE ITEM</a>

          <div class="modal fade" id="editItem" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-lg" role="document">
              <div class="modal-content">
                <div class="modal-header">
                  <h5 class="modal-title" id="exampleModalLabel">EDITING ITEM</h5>
                  <button type="button" class="close" data-bs-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                  </button>
                </div>
                <div class="modal-body">
                  <form action="/editItem" method="post">
                    <input type="hidden" value="<%=it.getId()%>" name = "item_id">
                    <div class="row">
                      <div class="col-12">
                        <label>NAME:</label>
                      </div>
                    </div>
                    <div class="row mt-2">
                      <div class="col-12">
                        <input type="text" class="form-control" name="item_rename" value="<%=it.getName()%>">
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-12">
                        <label>DESCRIPTION:</label>
                      </div>
                    </div>
                    <div class="row mt-2">
                      <div class="col-12">
                        <textarea name="item_redescr" class="form-control" rows="10"><%=it.getDescription()%></textarea>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-12">
                        <label>PRICE:</label>
                      </div>
                    </div>
                    <div class="row mt-2">
                      <div class="col-12">
                        <input type="number" class="form-control" name ="item_reprice" value="<%=it.getPrice()%>">
                      </div>
                    </div>
                    <button class="btn btn-primary btn-sm mt-5">SAVE CHANGES</button>
                  </form>
                  </div>
                <div class="modal-footer">
                  <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Закрыть</button>
                </div>
           </div>
          </div>
        </div>
          <div class="modal fade" id="deleteItem" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
              <div class="modal-content">
                <form action="/deleteItem" method="post">
                  <input type="hidden" name="item_id" value="<%=it.getId()%>">
                  <div class="modal-header">
                    <h1 class="modal-title fs-5">CONFIRM DELETING</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                  </div>
                  <div class="modal-body">
                    <h5 class="text-center">Are you sure, my man?</h5>
                  </div>
                  <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">No</button>
                    <button type="submit" class="btn btn-danger">Yes</button>
                  </div>
                </form>
              </div>
            </div>
          </div>
    <%
      }
    %>
</body>
</html>
