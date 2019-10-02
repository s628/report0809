package sec01.ex01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class OrderDAO {
//	private static final String driver= "oracle.jdbc.driver.OracleDriver";
//	private static final String url = "jdbc:oracle:thin:@localhost:1521:XE";
//	private static final String user ="scott";
//	private static final String pwd = "tiger";
	private Connection con;
	private PreparedStatement pstmt;
	private DataSource dataFactory ;
	
	public OrderDAO() {
		try
		{
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List listOrder(OrderVO orderVO) {
		List orderList = new ArrayList();
		String _order_num=orderVO.getOrder_num();
		try {
//			connDB();
			con = dataFactory.getConnection();
			String query = "SELECT OI.order_num, OI.order_item, OI.prod_id, p.prod_name, OI.quantity, OI.item_price"; 
			query+=	" FROM ORDERITEMS OI, PRODUCTS P";
			query+=	" WHERE OI.prod_id = P.prod_id";
			query+= " AND OI.order_num like'%" +_order_num+"%'";
//			if((_order_num!=null && _order_num.length()!=0)) {
//				query +=" where order_num=?";
//				pstmt = con.prepareStatement(query);
//				pstmt.setString(1, _order_num);
//			}else {
//				pstmt = con.prepareStatement(query);
//			}
			
			System.out.println("preparedStatement" + query);
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String order_num = rs.getString("order_num");
				String order_item = rs.getString("order_item");
				String prod_id = rs.getString("prod_id");
				String prod_name = rs.getString("prod_name");
				String quantity = rs.getString("quantity");
				String item_price = rs.getString("item_price");
				
				OrderVO vo = new OrderVO();
				vo.setOrder_num(order_num);
				vo.setOrder_item(order_item);
				vo.setProd_id(prod_id);
				vo.setProd_name(prod_name);
				vo.setQuantity(quantity);
				vo.setItem_price(item_price);
				orderList.add(vo);
			}
			rs.close();
			pstmt.close();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return orderList;
		
	}
	public List alterOrder(OrderVO orderVO) {
		List list = new ArrayList();
		try {
			Connection con = dataFactory.getConnection();
			String order_num = orderVO.getOrder_num();
			String order_item = orderVO.getOrder_item();
			String prod_id = orderVO.getProd_id();
			String quantity = orderVO.getQuantity();
			String item_price = orderVO.getItem_price();
			
			
			String query = "UPDATE ORDERITEMS SET";
			if(order_num !=null && order_num.length()!=0) {
				query +=" order_num = '"+order_num+"',";
			}
			if(order_item !=null && order_item.length()!=0) {
				query +=" order_item = '"+order_item+"',";
			}
			if(prod_id !=null && prod_id.length()!=0) {
				query +=" prod_id = '"+prod_id+"',";
			}
			if(quantity !=null && quantity.length()!=0) {
				query +=" quantity = '"+quantity+"',";
			}
			if(item_price !=null && item_price.length()!=0) {
				query +=" item_price = '"+item_price+"',";
			}
			
			query = query.substring(0, query.length()-1);
			query += " WHERE order_num='"+order_num+"' AND order_item='"+order_item+"'";
			System.out.println("prepareStatement : " + query);
			pstmt = con.prepareStatement(query);
			pstmt.executeUpdate();
			pstmt.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
		
		
		
		
	}
	



	public void delOrder(String id, String orderItem) {
		try {
			Connection con = dataFactory.getConnection();
	
       		 String query = "delete from t_member" + " where id =?";
       		 System.out.println("prepareStatement :" +query);
       		 pstmt = con.prepareStatement(query);
       		 pstmt.setString(1, id);
       		 pstmt.executeUpdate();
       		 pstmt.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
//	private void connDB() {
//		try {
//			Class.forName(driver);
//			System.out.println("Oracle 드라이버 로딩 성공");
//			con = DriverManager.getConnection(url,user,pwd);
//			System.out.println("Connection 생성 성공");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

	



		
	}


