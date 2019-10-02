<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%String order_num = request.getParameter("order_num"); %>
    <%String orderItem = request.getParameter("order_item"); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>공급업체 정보 변경 창</title>
	<script type  = "text/javascript">
		function fn_OrderServlet2() {
			var frmOrder = document.frmOrder;
			
			var prod_id = frmOrder.prod_id.value;
			var quantity = frmOrder.quantity.value;
			var item_price = frmOrder.item_price.value;
			var order_num = frmOrder.order_num.value;
			var orderItem = frmOrder.orderItem.value;
			
			frmOrder.method = "post";
			frmOrder.action = "/report0809/OrderServlet2";
			frmOrder.submit();
		}
	</script>
</head>
<body>
	<form name = "frmOrder">
		<table>
			<th>주문 정보 변경</th>
			<tr>
				<td>주문번호 : <%=order_num %></td></tr> 
				<tr><td>항목번호 : <%=orderItem %></td>
			</tr>
			<tr>
				<td>제품ID</td>
				<td><input type="text" name="prod_id"></td>
			</tr>
			<tr>
				<td>항목수량</td>
				<td><input type="text" name="quantity"></td>
			</tr>
			<tr>
				<td>항목가격</td>
				<td><input type="text" name="item_price"></td>
			</tr>
		</table>
		<input type="button" value="수정" onclick= "fn_OrderServlet2()">
		<input type="reset" value="다시입력">
		<input type="hidden" name = "order_num" value=<%=order_num %> />
		<input type="hidden" name = "orderItem" value=<%=orderItem %> />
		<br><a href= '/report0809/search.jsp'>돌아가기</a>
	</form>
</body>
</html>