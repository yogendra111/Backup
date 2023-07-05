<%@ include file="/WEB-INF/views/templates/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container">
    <div class="row">
        <div class="col-sm-12 col-md-10 col-md-offset-1">
            <table class="table">
            
            <c:choose>
            <c:when test="${item==0}">
            <caption>	<h2>no item in your cart</h2></caption>
            </c:when>
            <c:when test="${item!=0}">

            <caption>
            	<h2>${item} Items found in your Cart.</h2>
            </caption>
                <thead>
                    <tr>
                        <th>Product</th>
                        <th>Quantity</th>
                        <th class="text-center">Price</th>
                        <th class="text-center">Total</th>
                        <th> </th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach var="item" varStatus="st" items="${itemList}">
                
                
                	<%-- <c:forEach var="product" items="${proList}"> --%>
                    <tr>
                    <form action="" id="myForm${st.count}">
                        <td class="col-sm-6 col-md-6">
                        <div class="media">
                            <div class="media-left">
                            	<img class="media-object" src="Resources/images/${item.value.pImg}" alt="${item.value.pImg}" style="width: 60px;height:70px;">
                            </div>
                            <div class="media-body">
                                <h4 class="media-heading"><a href="#">${item.value.pName }</a></h4>
                                <h5 class="media-heading"> by <a href="#">Supplier : ${item.value.supplier.sName}</a></h5>
                                <span>Status: </span><span class="text-success"><strong></strong></span>
                            </div>
                        </div></td>
                        <td class="col-sm-1 col-md-1" style="text-align:center">
                        	<input type="email" class="form-control" id="quantity${st.count}" value="${item.key.quantity}"/>
                        </td>
                        <td class="col-sm-1 col-md-1 text-center"><strong>${item.value.pPrice }</strong></td>
                        <td class="col-sm-1 col-md-1 text-center"><strong>${item.key.productprice}</strong></td>
                        <td class="col-sm-3 col-md-3">
                        	<button type="button" class="btn btn-info" onclick="updateFunction(${item.key.cartItem_id},${st.count})">
	                            <span class="glyphicon glyphicon-update"></span> Update
	                        </button>
	                        <button type="button" class="btn btn-danger" onclick="deleteFunction(${item.key.cartItem_id},${st.count})">
	                            <span class="glyphicon glyphicon-remove"></span> Remove
	                        </button>
                        </td>
                      </form>
                    </tr>
                    <%-- </c:forEach> --%>
                </c:forEach>
                    <tr>
                        <td>   </td>
                        <td>   </td>
                        <td>   </td>
                        <td><h5>Subtotal</h5></td>
                        <td class="text-right"><h5><strong>${total}</strong></h5></td>
                    </tr>
                    <tr>
                        <td>   </td>
                        <td>   </td>
                        <td>   </td>
                        <td><h5>Estimated shipping</h5></td>
                        <td class="text-right"><h5><strong>${(total*18)/100}</strong></h5></td>
                    </tr>
                    <tr>
                        <td>   </td>
                        <td>   </td>
                        <td>   </td>
                        <td><h3>Total</h3></td>
                        <td class="text-right"><h3><strong>${(total*118)/100}</strong></h3></td>
                    </tr>
                    <tr>
                        <td>   </td>
                        <td>   </td>
                        <td>   </td>
                        <td>
	                        <!-- <button type="button" class="btn btn-default">
	                            <span class="glyphicon glyphicon-shopping-cart"></span> Continue Shopping
	                        </button> -->
                        </td>
                        <td>
	                        <!-- <button type="button" class="btn btn-success">
	                            Checkout <span class="glyphicon glyphicon-play"></span>
	                        </button> -->
                        </td>
                    </tr>
                </tbody>
                </c:when>
            </c:choose>
            </table>
            
        </div>
    </div>
</div>
<script>
function updateFunction(cid,myId) 
{
	var myForm=document.getElementById('myForm'+myId);
	console.log(myForm)
	var quantity=document.getElementById("quantity"+myId).value;
	
	console.log(quantity);
	
	myForm.action="updateCart/"+cid+"/"+quantity;
     myForm.submit(); 
}
function deleteFunction(cid,myId){
	var myForm=document.getElementById('myForm'+myId);
	console.log(myForm)

	myForm.action="deleteCart/"+cid;
     myForm.submit(); 
}
</script>
<%@ include file="/WEB-INF/views/templates/footer.jsp" %>