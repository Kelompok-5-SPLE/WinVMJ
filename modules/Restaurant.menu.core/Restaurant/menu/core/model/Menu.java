package Restaurant.menu.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

public interface Menu {
	public UUID getMenuId();
	public void setMenuId(UUID MenuId);
	public String getName();
	public void setName(String name);
	public String getDesc();
	public void setDesc(String desc);
	public int getPrice();
	public void setPrice(int price);
	public String getCategory();
	public void setCategory(String category);
	public void createMenu();
	public void deleteMenu();
	public void getPrice();
	HashMap<String, Object> toHashMap();
}
