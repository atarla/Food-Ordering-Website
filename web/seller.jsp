<%-- 
    Document   : seller
    Created on : Apr 29, 2017, 2:02:50 AM
    Author     : anusha
--%>

<%@ include file="header.jsp" %>

<div class="tab">
  <button class="tablinks" onclick="openCity(event, 'London')" id="defaultOpen">User Guide</button>
  <button class="tablinks" onclick="openCity(event, 'Paris')">Order Food</button>
  <button class="tablinks" onclick="openCity(event, 'Tokyo')">Sell Food</button>
</div>

<div id="London" class="tabcontent">
  <h3>Hello User</h3>
  <p>Welcome to GoodFood. You can order ................</p>
</div>

<div id="Tokyo" class="tabcontent">
  <h3>Add an Entry for food. More Description</h3>
  <p>Form to enter details</p>
</div>
<%@ include file="footer.jsp" %>
