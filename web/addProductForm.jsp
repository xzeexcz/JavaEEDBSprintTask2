<form action="/addItem" method="post">
    <div class="form-group">
        <label>NAME:</label>
        <input type="text" class="form-control"  aria-describedby="emailHelp" name = "item_name" placeholder="Insert name">
    </div>
    <div class="form-group">
        <label>BRAND:</label>
        <select name="item_brand" class="form-control">
            <%
                ArrayList<Brands> brands = DBManager.getAllBrands();
                if(brands!=null) {
                    for (Brands brand : brands) {
            %>
            <option value="<%=brand.getId()%>"><%=brand.getName() + " - " + brand.getCountry()%></option>
            <%
                    }
                }
            %>
        </select>
    </div>
    <div class="form-group">
        <label>PRICE:</label>
        <input type="number" class="form-control" name ="item_price" placeholder="Insert price">
    </div>
    <div class="form-group">
        <label>DESCRIPTION:</label>
        <textarea name="item_descr" rows="3" class="form-control" placeholder="Insert Description"></textarea>
    </div>
    <button type="submit" class="btn btn-success btn-sm mt-3">ADD PRODUCT</button>
</form>