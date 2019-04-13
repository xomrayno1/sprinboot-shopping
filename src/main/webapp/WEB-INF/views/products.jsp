<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt"  prefix="c"%>




		<div class="container">
			<div class="products">
					<h2 class=" products-in">PRODUCTS</h2>
					<div class=" top-products">
					
					
						<div class="container">
			<div class="products">
					<h2 class=" products-in">PRODUCTS</h2>
					<div class=" top-products">		
						<c:forEach var="items" items="${listproduct}" > 
						<div class="col-md-3 md-col">
							<div class="col-md">
								<a href="/${items.url}" class="compare-in"><img  src='<c:url value="/${items.image}"></c:url>' alt="" />	
								<div class="compare">
									<span>Add </span>
									<span>Add </span>
								</div>
								</a>
								<div class="top-content">
									<h5><a href="/${items.url}">${items.name}</a></h5>
									<div class="white">
										<a href="single.html" class="hvr-shutter-in-vertical hvr-shutter-in-vertical2">ADD TO CART</a>
										<p class="dollar"><span class="in-dollar">$</span><span>${items.price}</span></p>
										<div class="clearfix"></div>
									</div>
								</div>							
							</div>
						</div>
						</c:forEach>
						
					<div class="clearfix"></div>
					</div>
					
						
					
			</div>					
					<div class="clearfix"></div>
					</div>
					<ul class="start">
					<li ><a href="#" alt="Đầu"><i></i></a></li>
					<c:forEach begin="1" end="${totalpage}" var="page" step="1"> 									
					<li  class="arrow"><a  href='<c:url value="/danh-muc/${idcategory}/${page}"></c:url>'>${page}</a></li>					
			     	</c:forEach> 
					<li ><a href="#" alt="Cuối"><i  class="next"> </i></a></li>
				</ul>
					
				
					</div>
			</div>
	<script type="text/javascript">

	</script>