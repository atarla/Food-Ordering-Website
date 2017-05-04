<%-- 
    Document   : buyer
    Created on : May 2, 2017, 5:01:08 PM
    Author     : anusha
--%>

<%@ include file="header.jsp" %>

  <c:if test="${sessionScope.usertype == 'Buyer'}" ><button class="btn btn-success"><a href="OrderServlet?action=view">Order Food</a></button></c:if>
  <%--<c:if test="${sessionScope.usertype == 'Buyer'}" ><a href="OrderServlet?action=view">Order Food</a></c:if>--%>

  <h3>Order Food</h3>
  <input type="text" data-provide="typeahead" placeholder="Search Cuisine" data-source='["American", "Chinese", "Indian","Italian","Thai","Mexican","Japanese"]'>
  <table class="table table-inverse table-bordered">
      <thead class="thead-inverse">
    <tr>   
          <th>ITEM NAME</th><th>DESCRIPTION</th><th>POSTED BY</th><th>AVAILABLE AT</th><th>PRICE</th><th>CUISINE</th><th>ADD TO CART</th>
       </tr>
  </thead>
  <tbody>
  <c:forEach items="${list}" var="current" varStatus="i">
  <TR>
      <TD><h4>${current.item_name}</h4></TD>
    <td>${current.description}</td><td>${current.posted_by}</td><td>${current.address}</td><td>${current.item_price}</td><td>${current.cuisine}</td>
    
    <td class="btn btn-success">
        <a href="<c:url value="OrderServlet?action=addtocart"><c:param name="curr_item" value="${current.item_name}"/><c:param name="curr_price" value="${current.item_price}"/>
           <c:param name="curr_address" value="${current.address}"/>
                                   </c:url>">Add To Cart</a></td>
                                                  

  </TR>
    </c:forEach>
</tbody>

  </table>
<%@ include file="footer.jsp" %>
