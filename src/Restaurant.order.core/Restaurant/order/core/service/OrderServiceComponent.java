package Restaurant.order.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class OrderServiceComponent implements OrderService{
	protected RepositoryUtil<Order> Repository;

    public OrderServiceComponent(){
        this.Repository = new RepositoryUtil<Order>(Restaurant.order.core.OrderComponent.class);
    }	

    public abstract List<HashMap<String,Object>> saveOrder(VMJExchange vmjExchange);
    public abstract Order createOrder(Map<String, Object> requestBodye);
	public abstract Order createOrder(Map<String, Object> requestBody, Map<String, Object> response);    
	public abstract HashMap<String, Object> updateOrder(Map<String, Object> requestBody);
    public abstract HashMap<String, Object> getOrder(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> getAllOrder(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<Order> List);
    public abstract List<HashMap<String,Object>> deleteOrder(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> getOrderById(int id);

	public abstract void addItem();

	public abstract void removeItem();

	public abstract void getItems();

	public abstract void getSubtotal();

	public abstract void incQty();

	public abstract void decQty();

	public abstract void getOrderId();

	public abstract void getCreatedAt();
}
