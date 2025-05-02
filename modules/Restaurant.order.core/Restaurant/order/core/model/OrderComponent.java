package Restaurant.order.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="order_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class OrderComponent implements Order{
	@Id
	public UUID orderId; 
	public UUID orderId;
	public EDate createdAt;
	@ManyToOne(targetEntity=Restaurant..core.Component.class)
	public  orderItems;
	@ManyToOne(targetEntity=Restaurant..core.Component.class)
	public  orderitemimpl;
	protected String objectName = OrderComponent.class.getName();

	public OrderComponent() {

	} 

	public OrderComponent(
        UUID orderId, EDate createdAt, OrderItemImpl orderItems, OrderItemImpl orderitemimpl
    ) {
        this.orderId = orderId;
        this.createdAt = createdAt;
        this.orderItems = orderItems;
        this.orderitemimpl = orderitemimpl;
    }

	public abstract UUID getOrderId();
	public abstract void setOrderId(UUID orderId);
	
	public abstract EDate getCreatedAt();
	public abstract void setCreatedAt(EDate createdAt);
	
	public abstract OrderItemImpl getOrderItems();
	public abstract void setOrderItems(OrderItemImpl orderItems);
	
	public abstract OrderItemImpl getOrderitemimpl();
	public abstract void setOrderitemimpl(OrderItemImpl orderitemimpl);
	
 
	public abstract void addItem();

	public abstract void removeItem();

	public abstract void getItems();

	public abstract void getSubtotal();

	public abstract void incQty();

	public abstract void decQty();

	public abstract void getOrderId();

	public abstract void getCreatedAt();

	@Override
    public String toString() {
        return "{" +
            " orderId='" + getOrderId() + "'" +
            " createdAt='" + getCreatedAt() + "'" +
            " orderItems='" + getOrderItems() + "'" +
            " orderitemimpl='" + getOrderitemimpl() + "'" +
            "}";
    }
	
}
