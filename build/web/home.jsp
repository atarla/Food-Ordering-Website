<%--
  Author: anusha
  Created on: 4/27/2017  6:09 PM
--%>

<%@ include file="header.jsp" %>

<div class="tab">
  <button class="tablinks" onclick="openCity(event, 'London')" id="defaultOpen" >User Guide</button>
  <c:if test="${sessionScope.usertype == 'Buyer'}" ><button class="tablinks" onclick="openCity(event, 'Paris')" ><a href="OrderServlet?action=view">Order Food</a></button></c:if>
  <%--<c:if test="${sessionScope.usertype == 'Buyer'}" ><a href="OrderServlet?action=view">Order Food</a></c:if>--%>
  
  <c:if test="${sessionScope.usertype == 'Seller'}" ><button class="tablinks" onclick="openCity(event, 'Tokyo')">Sell Food</button></c:if>
</div>

      <c:if test="${sessionScope.usertype == null}" >
      <div id="London" class="tabcontent">
  <h2>Hello ,</h2>
  <h3 style="font-family: arial">Bored of eating the same old restaurant food? Welcome to GoodFood! <br>Order something new and healthy cooked by the amazing chefs in your neighborhood. </h3>
  <img src="css/wood.png" style="opacity: 0.6" width="800">
</div>
</c:if>
      
<c:if test="${sessionScope.usertype == 'Seller'}" >
      <div id="London" class="tabcontent">
  <h3>Hello User</h3>
  <p>Welcome to GoodFood. Share your food with the world and become popular in the process. </p>
</div>
</c:if>
      
<c:if test="${sessionScope.usertype == 'Buyer'}" >
<div id="London" class="tabcontent">
  <h2>Hello User</h2>
  <h3>Bored of eating the same old restaurant food? Welcome to GoodFood! <br>Order something new and healthy cooked by the amazing chefs in your neighborhood. </h3>
</div>
</c:if>

<c:if test="${sessionScope.usertype == 'Buyer'}" >
    
<div id="Paris" class="tabcontent">
  <h3>Order Some Food</h3>
  <input type="text" data-provide="typeahead" placeholder="Search Cuisine" data-source='["American", "Chinese", "Indian","Italian","Thai","Mexican","Japanese"]'>
  
  <c:forEach items="${list}" var="current">
      
      <div class="card" style="width: 20rem;">
          <img class="card-img-top" src="css/wood.png" width="80">
  <div class="card-block">
    <h4 class="card-title">${current.item_name}</h4>
    <p class="card-text">${current.description}.</p>
    <a href="#" class="btn btn-primary">Add to Cart</a>
  </div>
  </div>
    </c:forEach>
  
</div>    
    
</c:if>
      
<c:if test="${sessionScope.usertype == 'Seller'}" >
<div id="Tokyo" class="tabcontent">
  
  <form method="post" action="FoodController?action=addfood" class="loginmodal-container offset-1">
      <h3>Add an Entry for food item.</h3>
      <input type="hidden" name="action" value="additem">
      <input type="text"  name="itemname" placeholder="Enter Food Item Name" required><br>
      <textarea name="itemDesc"  placeholder="Food Item Description"></textarea><br>
      <textarea  name="address" rows="3" placeholder="Your Address" cols="27"></textarea><br>
      <input type="text"  name="price" placeholder="Price" required><br>
      <input type="text"  name="cuisine" placeholder="Cuisine" required><br>
      <input type="submit" name="submititem" class="lbtn btn-danger" value="Submit">
  
</form>
</div>
    </c:if>
<%@ include file="footer.jsp" %>
