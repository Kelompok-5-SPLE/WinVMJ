package Restaurant.menu.spicymenu;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import Restaurant.menu.core.MenuDecorator;
import Restaurant.menu.core.Menu;
import Restaurant.menu.core.MenuComponent;

@Entity(name="menu_spicymenu")
@Table(name="menu_spicymenu")
public class MenuImpl extends MenuDecorator {

    public int spiceLevel;
    
    public MenuImpl() {
        super();
    }
    
    public MenuImpl(int spiceLevel) {
        super();
        this.spiceLevel = spiceLevel;
    }
    
    public MenuImpl(MenuComponent record, int spiceLevel) {
        super(record);
        this.spiceLevel = spiceLevel;
    }

	public MenuImpl(Menu record, int spiceLevel) {
	    super((MenuComponent) record);
	    this.spiceLevel = spiceLevel;
	}
	
    public int getSpiceLevel() {
        return spiceLevel;
    }

    public void setSpiceLevel(int spiceLevel) {
        this.spiceLevel = spiceLevel;
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
		menuMap.put("spicyMenuId", getMenuId());
		menuMap.put("spiceLevel", getSpiceLevel());
		return menuMap;
	}
}
