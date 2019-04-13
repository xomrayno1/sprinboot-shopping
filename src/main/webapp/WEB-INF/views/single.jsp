<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt"  prefix="c"%>

		<div class="container">
			<div class="single">
				<div class="col-md-9 top-in-single">
					<div class="col-md-5 single-top">	
						<ul id="etalage">
							<li>
								<a href="${product.url}">
									<img height=”100″ width=”100″ class="etalage_thumb_image img-responsive" src="${product.multipartFile.getOriginalFilename()}" alt="" >
									
								</a>
							</li>
							
						</ul>

					</div>	
					<div class="col-md-7 single-top-in">
						<div class="single-para">
							<h4>${product.name}</h4>
							<div class="para-grid">	
								<span  class="add-to">$${product.price}</span><br>
								<br>
								<form action="#" method="POST">
								<c:if test="${product.quantity > 0 }">							
								<input value="Add to Cart" type="submit" class="hvr-shutter-in-vertical cart-to">			
									</c:if>
								<div class="clearfix"></div>
							 </div>
							<h5> The remaining amount: ${product.quantity}</h5>
							<c:if test="${product.quantity > 0 }">
							<p style="color: blue">Tình Trạng : Còn Hàng</p>
							</c:if>
							<c:if test="${product.quantity == 0 }">
							<p style="color: red">Tình Trạng : Hết Hàng</p>
							</c:if>
							<div class="available">
								<h6>Available Options :</h6>
								<ul>	
								
								<li>Quality:</li>
								<input type="number" min="0" max="10" name="quantity" value="1" id="quantity">
								<input type="hidden" value="${product.id}" name="idproduct">
							</ul>
							</form>
						</div>
						
							<p>${product.describe}</p>
							
								<a href="#" class="hvr-shutter-in-vertical ">More details</a>
							
						</div>
					</div>
					
					
					
					
				<div class="clearfix"> </div>
				<div class="content-top-in">
						<div class="col-md-4 top-single">
							<div class="col-md">
								<img  src="images/pic8.jpg" alt="" />	
								<div class="top-content">
									<h5>Mascot Kitty - White</h5>
									<div class="white">
										<a href="#" class="hvr-shutter-in-vertical hvr-shutter-in-vertical2">ADD TO CART</a>
										<p class="dollar"><span class="in-dollar">$</span><span>2</span><span>0</span></p>
										<div class="clearfix"></div>
									</div>
								</div>							
							</div>
						</div>
						<div class="col-md-4 top-single">
							<div class="col-md">
								<img  src="images/pic9.jpg" alt="" />	
								<div class="top-content">
									<h5>Mascot Kitty - White</h5>
									<div class="white">
										<a href="#" class="hvr-shutter-in-vertical hvr-shutter-in-vertical2">ADD TO CART</a>
										<p class="dollar"><span class="in-dollar">$</span><span>2</span><span>0</span></p>
										<div class="clearfix"></div>
									</div>
								</div>							
							</div>
						</div>
						<div class="col-md-4 top-single-in">
							<div class="col-md">
								<img  src="images/pic10.jpg" alt="" />	
								<div class="top-content">
									<h5>Mascot Kitty - White</h5>
									<div class="white">
										<a href="#" class="hvr-shutter-in-vertical hvr-shutter-in-vertical2">ADD TO CART</a>
										<p class="dollar"><span class="in-dollar">$</span><span>2</span><span>0</span></p>
										<div class="clearfix"></div>
									</div>
								</div>							
							</div>
						</div>
						
					<div class="clearfix"></div>
					</div>
				</div>
				<div class="col-md-3">
					<div class="single-bottom">
						<h4>Categories</h4>
						<ul>
						<c:forEach items="${listCategory}" var="category">
						
						
						<li><a href="#"><i> </i>${category.name}</a></li>
						</c:forEach>
						
						</ul>
					</div>
					<div class="single-bottom">
						<h4>Made By</h4>
						<ul>
						<c:forEach items="${listMade}" var="made">
						<li><a href="#"><i> </i>${made.name}</a></li>
						</c:forEach>
						
						
						</ul>
					</div>
					<div class="single-bottom">
						<h4>Product Categories</h4>
							<div class="product">
								<img class="img-responsive fashion" src="images/st1.jpg" alt="">
							<div class="grid-product">
								<a href="#" class="elit">Consectetuer adipiscing elit</a>
								<span class="price price-in"><small>$500.00</small> $400.00</span>
							</div>
							<div class="clearfix"> </div>
							</div>
							<div class="product">
								<img class="img-responsive fashion" src="images/st2.jpg" alt="">
							<div class="grid-product">
								<a href="#" class="elit">Consectetuer adipiscing elit</a>
								<span class="price price-in"><small>$500.00</small> $400.00</span>
							</div>
							<div class="clearfix"> </div>
							</div>
							<div class="product">
								<img class="img-responsive fashion" src="images/st3.jpg" alt="">
							<div class="grid-product">
								<a href="#" class="elit">Consectetuer adipiscing elit</a>
								<span class="price price-in"><small>$500.00</small> $400.00</span>
							</div>
							<div class="clearfix"> </div>
							</div>
				</div>
				</div>
				<div class="clearfix"> </div>
		</div>
	</div>
	
	<script type="text/javascript">
					$(document).ready(function(){
						//alert("helloword");
						$("#quantity").change(function(){
							$.ajax({
								type : "GET",
					            url : "${pageContext.request.contextPath}/quantity-api/"+${product.id},
					            contentType: "application/json",
					           // data : data,
					            success: function(data){					            	
					                var value = $("#quantity").val();
					                if(value > data){
					                	alert("Số lượng còn lại không đủ")
					                	$("#quantity").val("1");
					                } 
					            }
								
							});
						});
						//////
						
						
						
						
						
						
					});
	</script>