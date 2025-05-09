package Restaurant.order.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

public abstract class OrderResourceDecorator extends OrderResourceComponent{
	protected OrderResourceComponent record;

    public OrderResourceDecorator(OrderResourceComponent record) {
        this.record = record;
    }

    public Order createOrder(VMJExchange vmjExchange){
		return record.createOrder(vmjExchange);
	}

    public HashMap<String, Object> updateOrder(VMJExchange vmjExchange){
		return record.updateOrder(vmjExchange);
	}

    public HashMap<String, Object> getOrder(VMJExchange vmjExchange){
		return record.getOrder(vmjExchange);
	}

    public List<HashMap<String,Object>> getAllOrder(VMJExchange vmjExchange){
		return record.getAllOrder(vmjExchange);
	}

    public List<HashMap<String,Object>> deleteOrder(VMJExchange vmjExchange){
		return record.deleteOrder(vmjExchange);
	}

	public void addItem() {
		return record.addItem();
	}

	public void removeItem() {
		return record.removeItem();
	}

	public void getItems() {
		return record.getItems();
	}

	public void getSubtotal() {
		return record.getSubtotal();
	}

	public void incQty() {
		return record.incQty();
	}

	public void decQty() {
		return record.decQty();
	}

	public void getOrderId() {
		return record.getOrderId();
	}

	public void getCreatedAt() {
		return record.getCreatedAt();
	}
}
