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


@Entity(name="_impl")
@Table(name="_impl")
public class OrderItemImpl extends OrderItemComponent {

	public OrderItemImpl(UUID OrderItemId, MenuImpl item, int quantity) {
		this.OrderItemId = OrderItemId;
		this.item = item;
		this.quantity = quantity;
	}

	public OrderItemImpl(UUID OrderItemId, MenuImpl item, int quantity) {
		this.OrderItemId =  OrderItemId.randomUUID();;
		this.OrderItemId = OrderItemId;
		this.item = item;
		this.quantity = quantity;
	}

	public OrderItemImpl() { }


	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> Map = new HashMap<String,Object>();
		Map.put("OrderItemId",getOrderItemId());
		Map.put("item",getItem());
		Map.put("quantity",getQuantity());

        return Map;
    }

}
