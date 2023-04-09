<%@ page import="java.util.ArrayList" %>
<%@ page import="kz.bitlab.sprinttask.db.Items" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="head.jsp"%>
    <title><%=siteName%></title>
</head>
    <body>
        <%@include file="navbar.jsp"%>
        <div class="container">
            <h1 class="display-4 text-dark text-center" style="font-weight: bold;">Welcome to <%=siteName%></h1>
            <h6 class="text-muted text-center">Electronic devices with high quality and service</h6>
        </div>
        <div class="container">
            <div class="d-flex justify-content-between ms-5 me-5">
                <%
                    ArrayList<Items> items = (ArrayList<Items>)request.getAttribute("vewi");
                    if(items!=null) {
                        for(int i = 0; i < items.size() / 2; i++) {
                %>
                <div class="card shadow-lg" style="width: 18rem;">
                    <div class="card-body">
                        <h5 class="card-title text-center"><%=items.get(i).getName()%></h5>
                        <hr class="border-top border-secondary">
                        <p class="card-text my-text mt-3">$<%=items.get(i).getPrice()%></p>
                        <p class="card-text text-center lol"><%=items.get(i).getDescription()%></p>
                        <a href="#" class="d-block text-center bg-success text-white p-2 text-decoration-none rounded">Buy Now</a>
                    </div>
                </div>
                <%
                    }
                %>
            </div>
        </div>
    <div class="container">
        <div class="d-flex justify-content-between ms-5 me-5 mt-5">
            <%
                for(int i = 3; i < items.size(); i++) {
            %>
            <div class="card shadow-lg" style="width: 18rem;">
                <div class="card-body">
                    <h5 class="card-title text-center"><%=items.get(i).getName()%></h5>
                    <hr class="border-top border-secondary" style="margin: 0px">
                    <p class="card-text my-text mt-3">$<%=items.get(i).getPrice()%></p>
                    <p class="card-text text-center lol"><%=items.get(i).getDescription()%></p>
                    <a href="#" class="d-block text-center bg-success text-white p-2 text-decoration-none rounded">Buy Now</a>
                </div>
            </div>
            <%
                    }
                }
            %>
        </div>
     </div>
    </body>
</html>
