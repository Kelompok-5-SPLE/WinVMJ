package Restaurant.menu.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

public interface Menu {
	public UUID getMenuId();
	public void setMenuId(UUID MenuId);
	public String getName();
	public void setName(String name);
	public String getDescription();
	public void setDescription(String description);
	public int getPrice();
	public void setPrice(int price);
	public String getCategory();
	public void setCategory(String category);
	HashMap<String, Object> toHashMap();
}
