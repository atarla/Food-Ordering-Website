<%-- 
    Document   : admin
    Created on : 29 Apr, 2017, 2:02:33 AM
    Author     : Pooja
--%>

<%@ include file="header.jsp" %>


             <div class="col-lg-6">
        	<div class="panel panel-default">
            <div class="panel-heading"><h3>Entries To Be Reviewed</h3></div>
            <div class="panel-body">
<table class="table table-condensed" style="border-collapse:collapse;">
    <thead> <tr>
            <th>&nbsp;</th>
            <th id="itemname">Item Name</th>
            <th id="Actions_column">Action</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${list}" var="current">
        <tr data-toggle="collapse" data-target="#demo1" class="accordion-toggle">
            <td><button class="btn btn-default btn-xs"><span class="glyphicon glyphicon-eye-open"></span></button></td>
            <td>${current.item_name}</td>
            <td><form action="FoodController?action=approve" method="post">
                     <button type="submit" value=${current.item_name} name="approval_value">approve</button>
                    </form>
                    <form action="FoodController?action=disapprove" method="post">
                        <button type="submit" value=${current.item_name} name="approval_value">disapprove</button>
                    </form></td>
                    
                    
        </tr>
        <tr>
            <td colspan="12" class="hiddenRow"><div class="accordian-body collapse" id="demo1"> 
              <table class="table table-striped">
                      <thead>
                      
                        <tr><th>Item Description</th><th>Posted By</th><th>Status </th><th> Address</th><th> Price</th><th>Cuisine</th></tr>
                      </thead>
                      <tbody>
                        <tr><td>${current.description}</td><td>${current.posted_by}</td><td>${current.status}</td><td>${current.address}</td><td>${current.item_price}</td><td>${current.cuisine}</td></tr>
                        
                     
                    
                      </tbody>
               	</table>
              
              </div> </td>
        </tr>
        </c:forEach>
        
    </tbody>
</table>
        
        
         </div>
        
          </div> 
        
      </div>
        
<%@include file="footer.jsp" %>
