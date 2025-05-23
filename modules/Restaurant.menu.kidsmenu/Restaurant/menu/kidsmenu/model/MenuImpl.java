package Restaurant.menu.kidsmenu;

import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import Restaurant.menu.core.MenuDecorator;
import Restaurant.menu.core.Menu;
import Restaurant.menu.core.MenuComponent;

@Entity(name="menu_kidsmenu")
@Table(name="menu_kidsmenu")
public class MenuImpl extends MenuDecorator {

	public int ageRestriction;

	public MenuImpl(MenuComponent record, int ageRestriction) {
		super(record);
		this.ageRestriction = ageRestriction;
	}
	

	public MenuImpl(){
        super();
    }
    
    public MenuImpl(int ageRestriction) {
    	super();
		this.ageRestriction = ageRestriction;

    }

	
	public int getAgeRestriction() {
		return ageRestriction;
	}

	public void setAgeRestriction(int ageRestriction) {
		this.ageRestriction = ageRestriction;
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
		menuMap.put("promotionalMenuId", getMenuId());
		menuMap.put("ageRestriction", getAgeRestriction());
		return menuMap;
	}
}
