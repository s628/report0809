package sec01.ex01;

import java.sql.Date;

public class OrderVO {
	private String Order_num;
	private String Order_item;
	private String Prod_id;
	private String Prod_name;
	private String Quantity;
	private String Item_price;
	
	public String getOrder_num() {
		return Order_num;
	}

	public void setOrder_num(String order_num) {
		Order_num = order_num;
	}

	public String getOrder_item() {
		return Order_item;
	}

	public void setOrder_item(String order_item) {
		Order_item = order_item;
	}

	public String getProd_id() {
		return Prod_id;
	}

	public void setProd_id(String prod_id) {
		Prod_id = prod_id;
	}

	public String getProd_name() {
		return Prod_name;
	}

	public void setProd_name(String prod_name) {
		Prod_name = prod_name;
	}

	public String getQuantity() {
		return Quantity;
	}

	public void setQuantity(String quantity) {
		Quantity = quantity;
	}

	public String getItem_price() {
		return Item_price;
	}

	public void setItem_price(String item_price) {
		Item_price = item_price;
	}

	public OrderVO() {
		System.out.println("MemberVO 생성자 호출");
	}
	
	
	
	

	
	}


