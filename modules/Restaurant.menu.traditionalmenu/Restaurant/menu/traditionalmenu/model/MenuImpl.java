package Restaurant.menu.traditionalmenu;

import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import Restaurant.menu.core.MenuDecorator;
import Restaurant.menu.core.Menu;
import Restaurant.menu.core.MenuComponent;

@Entity(name="menu_traditionalmenu")
@Table(name="menu_traditionalmenu")
public class MenuImpl extends MenuDecorator {

	public String origin;

	public MenuImpl(MenuComponent record, int origin) {
		super(record);
		this.origin = origin;
	}
	

	public MenuImpl(){
        super();
    }
    
    public MenuImpl(String origin) {
    	super();
		this.origin = origin;

    }

	
	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public void setCategory(String category) {
		this.category = category;
		this.record.setCategory(category);
	}

	public String getCategory() {
		return this.category;
	}

	public void setPrice(int price) {
		this.price = price;
		this.record.setPrice(price);
		
	}

	public int getPrice() {
		return this.price;
	}

	public void setDescription(String description) {
		this.description = description;
		this.record.setDescription(description);
	}
	public String getDescription() {
		return this.description;
	}

	public void setName(String name) {
		this.name = name;
		this.record.setName(name);
	}

	public String getName() {
		return this.name;
	}

	public UUID getMenuId() {
		return this.MenuId;
	}

	public void setMenuId(UUID MenuId) {
		this.MenuId = MenuId;
	}

	@Override
	public HashMap<String, Object> toHashMap() {
		HashMap<String, Object> menuMap = super.toHashMap();
		menuMap.put("traditionalmenuId", getMenuId());
		menuMap.put("origin", getorigin());
		return menuMap;
	}
}
