<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="head.jsp"%>
</head>
  <body>
        <%@include file="navbar.jsp"%>
            <%
                String error = (String)request.getAttribute("owibka");
                if(error!=null) {
            %>
        <div class="container mt-5">
            <div class="row justify-content-center">
                <div class="col-md-6">
                    <div class="card">
                        <div class="alert alert-danger alert-dismissible fade show" role="alert">
                            <strong>Error: Incorrect login or password!</strong>
                            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                        </div>
                        <div class="card-body">
                            <h3 class="card-title text-center">Login page</h3>
                            <hr class="border-top border-secondary">
                            <form action="/signpage" method="post">
                                <div class="form-group">
                                    <label>Email:</label>
                                    <input type="text" name="user_email" class="form-control mt-1">
                                </div>
                                <div class="form-group mt-2">
                                    <label>Password:</label>
                                    <input type="text" name="user_password" class="form-control mt-1">
                                </div>
                                <button type="submit" class="btn btn-success btn-sm mt-2">Submit</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%
            } else {
        %>
        <div class="container mt-5">
          <div class="row justify-content-center">
            <div class="col-md-6">
              <div class="card">
                <div class="card-body">
                  <h3 class="card-title text-center">Login page</h3>
                  <hr class="border-top border-secondary">
                  <form action="/signpage" method="post">
                    <div class="form-group">
                      <label>Email:</label>
                      <input type="text" name="user_email" class="form-control mt-1">
                    </div>
                    <div class="form-group mt-2">
                      <label>Password:</label>
                      <input type="text" name="user_password" class="form-control mt-1">
                    </div>
                    <button type="submit" class="btn btn-success btn-sm mt-2">Submit</button>
                  </form>
                </div>
              </div>
            </div>
          </div>
        </div>
  <%
      }
  %>
  </body>
</html>
