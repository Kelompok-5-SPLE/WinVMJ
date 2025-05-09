package Restaurant.order.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class OrderDecorator extends OrderComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected OrderComponent record;

	public OrderDecorator () {
		super();
		this.record = record;
		this.orderId =  orderId.randomUUID();
		
	public OrderDecorator (OrderComponent record) {
		this.orderId =  orderId.randomUUID();
		this.record = record;
	}

	public OrderDecorator (UUID orderId, OrderComponent record) {
		this.orderId =  orderId;
		this.record = record;
	}
	
	public OrderDecorator (OrderComponent record, String objectName) {
		this.orderId =  orderId.randomUUID();
		this.record = record;	
		this.objectName=objectName;
	}

	public OrderDecorator() { }


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

	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
