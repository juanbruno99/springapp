
<%@ include file="/WEB-INF/views/include.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<head><title><fmt:message key="title"></fmt:message></title></head>
<body>
<h1><fmt:message key="heading"/></h1>
<p><fmt:message key="greeting"/> <c:out value="${myModel.now}"/></p>
<h3>Products</h3>
	<c:forEach items="${myModel.products}" var="prod">
	      <c:out value="${prod.description}"/> <i>$<c:out value="${prod.price}"/></i><br><br>
	</c:forEach>
</body>
</html>