package Restaurant.order.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class OrderItemDecorator extends OrderItemComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected OrderItemComponent record;

	public OrderItemDecorator () {
		super();
		this.record = record;
		this.OrderItemId =  OrderItemId.randomUUID();
		
	public OrderItemDecorator (OrderItemComponent record) {
		this.OrderItemId =  OrderItemId.randomUUID();
		this.record = record;
	}

	public OrderItemDecorator (UUID OrderItemId, OrderItemComponent record) {
		this.OrderItemId =  OrderItemId;
		this.record = record;
	}
	
	public OrderItemDecorator (OrderItemComponent record, String objectName) {
		this.OrderItemId =  OrderItemId.randomUUID();
		this.record = record;	
		this.objectName=objectName;
	}

	public OrderItemDecorator() { }



	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
