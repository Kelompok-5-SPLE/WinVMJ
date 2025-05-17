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

	public int AgeRestriction;
	public MenuImpl(){
        super();
        this.objectName = MenuImpl.class.getName();
    }
    
    public MenuImpl(int AgeRestriction) {
    	super();
		this.AgeRestriction = AgeRestriction;
		this.objectName = MenuImpl.class.getName();
    }
	
	public MenuImpl(MenuComponent record, int AgeRestriction) {
		super(record);
		this.AgeRestriction = AgeRestriction;
		this.objectName = MenuImpl.class.getName();
	}

	
	public int getAgeRestriction() {
		return AgeRestriction;
	}

	public void setAgeRestriction(int ageRestriction) {
		this.AgeRestriction = ageRestriction;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCategory() {
		return this.category;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getPrice() {
		return this.price;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public String getDescription() {
		return this.description;
	}

	public void setName(String name) {
		this.name = name;
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
}
