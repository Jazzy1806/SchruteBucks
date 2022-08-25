<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reward For Pay</title>
<link rel ="stylesheet" type ="text/css" href="CSS/adminDashboard.css">

</head>
<body>
<%@ include file="nav.jsp" %>



<div class="container-fluid">
<div class="space">
<h1>Browse the full list of prizes below:</h1>

<!-- Lists all prizes by tier or a full list of all prizes -->
<c:choose>
	<c:when test="${prizeDeleted==true}">
		<h1>${deleteMessage}</h1>
	</c:when>
	<c:otherwise>
		<h1>${deleteFail}</h1>
	</c:otherwise>
</c:choose>




<c:choose>
	<c:when test="${role==1}">
		<h1>test</h1>
		<table>
			<c:set var="count" value="1" scope="page"/>
			<c:forEach var="prize" items="${prizes}">
			

				<tr>
					<td>
					   ${count}. ${prize.name}, ${prize.points} points, Tier ${prize.tier.id}
					</td>
					<td>
						<form action="updatePrize.do" method="get">
							<input type="hidden" value="${prize.id}" name="id" /> 
							<input class="action_button" type="submit" value="Update Prize" />
						</form>
					</td>
					<td>
						<form action="deletePrize.do" method="get">
							<input type="hidden" value="${prize.id}" name="id" /> 
							<input class="action_button" type="submit" value="Delete Prize" />
						</form>
					</td>
				</tr>
				<c:set var="count" value="${count + 1}" scope="page"/>
			</c:forEach>
		</table>


	</c:when>
	<c:otherwise>
		<c:choose>
			<c:when test="${! empty prizes}">
				<c:if test="${! empty sessionScope.prizes}">
					<table>
						<tr>
							<td>
					        <h3 class="card-title" style="text-align:center">Search Prizes By Tier: </h3>
					          <form action="allPrizes.do" method="get">
								<select name="id" id="dropdown" required>
										<option value="1">Tier 1 - Copper</option>
										<option value="2">Tier 2 - Silver</option>
										<option value="3">Tier 3 - Gold</option>
								</select>
								<input type="submit" value="See Prizes" />
							</form>
							<br>
						</td>
						<td>
							<a href="allPrizes.do?id=0">See all prizes</a>
						</td>
						</tr>
						</table>
						</c:if>
				<h1>test</h1>
				<div class="row row-cols-1 row-cols-md-5 g-${numOfPrizes}">
					<c:forEach var="prize" items="${prizes}">
					  <div class="col">
					    <div class="card h-100">
					      <a href="reward.do?id=${prize.id}"><img class="card-img-top " src="${prize.image}" alt="${prize.name}"/></a>
					      <div class="card-body">
					        <h5 class="card-title">${prize.name}</h5>
					        <p class="card-text">${prize.points}, Tier ${prize.tier.id}</p>
					      </div>
					    </div>
					  </div>
					</c:forEach>
				</div>
			</c:when>
			<c:otherwise>
				<h1>${prizeError}</h1>
			</c:otherwise>
		</c:choose>
	</c:otherwise>
</c:choose>
</div>
</div>
</body>
</html>