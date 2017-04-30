<%--
  Author: anusha
  Created on: 4/27/2017  6:09 PM
--%>

<%@ include file="header.jsp" %>

<div class="tab">
  <button class="tablinks" onclick="openCity(event, 'London')" id="defaultOpen">User Guide</button>
  <button class="tablinks" onclick="openCity(event, 'Paris')">Order Food</button>
  <button class="tablinks" onclick="openCity(event, 'Tokyo')">Sell Food</button>
</div>

<div id="London" class="tabcontent">
  <h3>Hello User</h3>
  <p>Welcome to GoodFood. qwmdewkfnowenf jkenv env oeirnv oien neoiv noieqnv</p>
</div>

<div id="Paris" class="tabcontent">
  <h3>Order Some Food</h3>
  <input type="text" data-provide="typeahead" placeholder="Search Cuisine" data-source='["American", "Chinese", "Indian","Italian","Thai","Mexican"]'>
  <p>Entries 1 2 3 4 cards</p> 
</div>

<div id="Tokyo" class="tabcontent">
  <h3>Add an Entry for food. More Description</h3>
  <p>Form to enter details</p>
</div>
<%@ include file="footer.jsp" %>
