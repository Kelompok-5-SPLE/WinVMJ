package Restaurant.order.core;

import java.lang.Math;
import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity(name="order_impl")
@Table(name="order_impl")
public class OrderImpl extends OrderComponent {

	public OrderImpl(UUID orderId, EDate createdAt, OrderItemImpl orderItems, OrderItemImpl orderitemimpl) {
		this.orderId = orderId;
		this.createdAt = createdAt;
		this.orderItems = orderItems;
		this.orderitemimpl = orderitemimpl;
	}

	public OrderImpl(UUID orderId, EDate createdAt, OrderItemImpl orderItems, OrderItemImpl orderitemimpl) {
		this.orderId =  orderId.randomUUID();;
		this.orderId = orderId;
		this.createdAt = createdAt;
		this.orderItems = orderItems;
		this.orderitemimpl = orderitemimpl;
	}

	public OrderImpl() { }


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
	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> orderMap = new HashMap<String,Object>();
		orderMap.put("orderId",getOrderId());
		orderMap.put("createdAt",getCreatedAt());
		orderMap.put("orderItems",getOrderItems());
		orderMap.put("orderitemimpl",getOrderitemimpl());

        return orderMap;
    }

}
