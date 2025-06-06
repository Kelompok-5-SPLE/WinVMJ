package Restaurant.order.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class OrderResourceComponent implements OrderResource{
	
	public OrderResourceComponent() { }
 
    public abstract Order createOrder(VMJExchange vmjExchange);    
	public abstract HashMap<String, Object> updateOrder(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getOrder(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllOrder(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> deleteOrder(VMJExchange vmjExchange);

	public abstract void addItem();

	public abstract void removeItem();

	public abstract void getItems();

	public abstract void getSubtotal();

	public abstract void incQty();

	public abstract void decQty();

	public abstract void getOrderId();

	public abstract void getCreatedAt();
}
