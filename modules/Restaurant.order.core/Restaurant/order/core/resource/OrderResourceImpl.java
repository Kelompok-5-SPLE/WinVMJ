package Restaurant.order.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import Restaurant.order.OrderFactory;
//import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class OrderResourceImpl extends OrderResourceComponent{
	
	private OrderServiceImpl orderServiceImpl = new OrderServiceImpl();

	// @Restriced(permission = "")
    @Route(url="call/order")
    public HashMap<String,Object> createorder(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Order result = orderServiceImpl.createOrder(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    // @Restriced(permission = "")
    @Route(url="call/order/update")
    public HashMap<String, Object> updateOrder(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return orderServiceImpl.updateOrder(requestBody);
		
	}

	// @Restriced(permission = "")
    @Route(url="call/order/detail")
    public HashMap<String, Object> getOrder(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return orderServiceImpl.getOrder(requestBody);
	}

	// @Restriced(permission = "")
    @Route(url="call/order/list")
    public List<HashMap<String,Object>> getAllOrder(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return orderServiceImpl.getAllOrder(requestBody);
	}

    
	// @Restriced(permission = "")
    @Route(url="call/order/delete")
    public List<HashMap<String,Object>> deleteOrder(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return orderServiceImpl.deleteOrder(requestBody);
	}

	public void addItem() {
		// TODO: implement this method
	}

	public void removeItem() {
		// TODO: implement this method
	}

	public void getItems() {
		// TODO: implement this method
	}

	public void getSubtotal() {
		// TODO: implement this method
	}

	public void incQty() {
		// TODO: implement this method
	}

	public void decQty() {
		// TODO: implement this method
	}

	public void getOrderId() {
		// TODO: implement this method
	}

	public void getCreatedAt() {
		// TODO: implement this method
	}
}
