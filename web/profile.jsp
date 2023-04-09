<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="head.jsp"%>
</head>
<body>
    <%@include file="navbar.jsp"%>
    <%
      String full_name = (String)request.getAttribute("full_name");
      if(full_name!=null) {
    %>
    <div class="container">
      <h1 class="display-4 text-dark text-center" style="font-weight: bold;">Hello, <%=full_name%></h1>
      <h6 class="text-muted text-center">This is your profile page</h6>
    </div>
    <%
          }
      %>
</body>
</html>
