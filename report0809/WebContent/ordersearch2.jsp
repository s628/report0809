<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="sec01.ex01.*"%>

  <%@page pageEncoding="UTF-8"
    %>
<!DOCTYPE html>
<html>
<head>
   <style>
h1 {
text-align: center;
}
</style>
<meta charset="UTF-8">
<title>주문 조회 출력창</title>
</head>

<body>
<h1>주문 조회 출력</h1>
<%
	request.setCharacterEncoding("utf-8");
		String _order_num = request.getParameter("order_num");
		OrderVO orderVO = new OrderVO();
		orderVO.setOrder_num(_order_num);
		OrderDAO dao = new OrderDAO();
		List orderList = dao.listOrder(orderVO);
%>
	

		<table border=1 width=800 align=center>
		<tr align=center bgcolor="#FFFF66">
		<td>주문번호</td>
		<td>주문항목번호</td>
		<td>제품ID</td>
		<td>제품명</td>
		<td>항목수량</td>
		<td>항목가격</td>
		<td>수정</td>
		<td>삭제</td>
		</tr>
		
		<%
					for (int i = 0; i < orderList.size(); i++) {
						OrderVO vo = (OrderVO) orderList.get(i);
							String order_num = vo.getOrder_num();
							String order_item =  vo.getOrder_item();
							String prod_id = vo.getProd_id();
							String prod_name =  vo.getProd_name();
							String quantity =  vo.getQuantity();
							String item_price = vo.getItem_price();
				%>
			
			<tr align=center>
			<td><%= order_num %></td>
			<td><%= order_item %></td>
			<td><%= prod_id %></td>
			<td><%= prod_name %></td>
			<td><%= quantity %></td>
			<td><%= item_price %></td>
			
            <td><a href='orderalter.jsp?order_num=<%=order_num%>&order_item=<%=order_item%>&prod_id=<%=prod_id%>&prod_name=<%=prod_name%>&quantity=<%=quantity%>&item_price=<%=item_price%>'>수정</a></td>
            <td><a href='/report0809/jsp?order_num=<%=order_num%>&order_item=<%=order_item%>&prod_id=<%=prod_id%>&prod_name=<%=prod_name%>&quantity=<%=quantity%>&item_price=<%=item_price%>'>삭제</a></td>
     

  </tr>
  <%
   }
  %>
 </table>
</body>
</html>