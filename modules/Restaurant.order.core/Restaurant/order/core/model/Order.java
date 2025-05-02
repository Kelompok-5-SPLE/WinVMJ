package Restaurant.order.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

public interface Order {
	public UUID getOrderId();
	public void setOrderId(UUID orderId);
	public EDate getCreatedAt();
	public void setCreatedAt(EDate createdAt);
	public OrderItemImpl getOrderItems();
	public void setOrderItems(OrderItemImpl orderItems);
	public OrderItemImpl getOrderitemimpl();
	public void setOrderitemimpl(OrderItemImpl orderitemimpl);
	public UUID getOrderItemId();
	public void setOrderItemId(UUID OrderItemId);
	public MenuImpl getItem();
	public void setItem(MenuImpl item);
	public int getQuantity();
	public void setQuantity(int quantity);
	public void addItem();
	public void removeItem();
	public void getItems();
	public void getSubtotal();
	public void incQty();
	public void decQTy();
	public void getOrderId();
	public void getCreatedAt();
	HashMap<String, Object> toHashMap();
}
