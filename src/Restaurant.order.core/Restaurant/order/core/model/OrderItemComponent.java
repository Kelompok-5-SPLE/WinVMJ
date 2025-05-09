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
@Table(name="_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class OrderItemComponent implements {
	@Id
	public UUID OrderItemId; 
	public UUID OrderItemId;
	@ManyToOne(targetEntity=Restaurant.menu.core.MenuComponent.class)
	public Menu item;
	public int quantity;
	protected String objectName = OrderItemComponent.class.getName();

	public OrderItemComponent() {

	} 

	public OrderItemComponent(
        UUID OrderItemId, MenuImpl item, int quantity
    ) {
        this.OrderItemId = OrderItemId;
        this.item = item;
        this.quantity = quantity;
    }

	public abstract UUID getOrderItemId();
	public abstract void setOrderItemId(UUID OrderItemId);
	
	public abstract MenuImpl getItem();
	public abstract void setItem(MenuImpl item);
	
	public abstract int getQuantity();
	public abstract void setQuantity(int quantity);
	
 

	@Override
    public String toString() {
        return "{" +
            " OrderItemId='" + getOrderItemId() + "'" +
            " item='" + getItem() + "'" +
            " quantity='" + getQuantity() + "'" +
            "}";
    }
	
}
