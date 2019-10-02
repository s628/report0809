package sec01.ex01;

//http://localhost:8090/pro07/cust.html
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/OrderServlet2")
public class OrderServlet2 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);
	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			   request.setCharacterEncoding("utf-8");
			   response.setContentType("text/html;charset=utf-8");
			   PrintWriter out = response.getWriter();
				String order_num = request.getParameter("order_num");
				String order_item = request.getParameter("orderItem"); 
				OrderDAO dao = new OrderDAO();
				
				//정보 수정
				
					System.out.println("수정 실행");
					OrderVO mv = new OrderVO();
			   mv.setOrder_num(request.getParameter("order_num"));
			   mv.setOrder_item(request.getParameter("orderItem"));
			   mv.setProd_id( request.getParameter("prod_id"));
			   mv.setQuantity(request.getParameter("quantity"));
			  mv.setItem_price(request.getParameter("item_price"));
			  
			   dao.alterOrder(mv);

			   response.sendRedirect("/report0809/ordersearch.jsp?order_num="+order_num);
			  }
	}

