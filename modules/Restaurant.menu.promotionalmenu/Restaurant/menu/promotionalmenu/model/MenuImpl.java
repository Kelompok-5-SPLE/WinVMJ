package Restaurant.menu.promotionalmenu;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import Restaurant.menu.core.MenuDecorator;
import Restaurant.menu.core.Menu;
import Restaurant.menu.core.MenuComponent;

@Entity(name="menu_promotionalmenu")
@Table(name="menu_promotionalmenu")
public class MenuImpl extends MenuDecorator {

	public int discountPercentage;
	public MenuImpl() {
        super();
        this.objectName = MenuImpl.class.getName();
    }

	public MenuImpl(Menu baseMenu, int discountPercentage) {
		this.MenuId = baseMenu.getMenuId();
		this.name = baseMenu.getName();
		this.description = baseMenu.getDescription();
		this.price = baseMenu.getPrice();
		this.category = baseMenu.getCategory();
		this.discountPercentage = discountPercentage;
	}
    
    public MenuImpl(int discountPercentage) {
    	super();
		this.discountPercentage = discountPercentage;
		this.objectName = MenuImpl.class.getName();
    }
	
	public MenuImpl(MenuComponent record, int discountPercentage) {
		super(record);
		this.discountPercentage = discountPercentage;
		this.objectName = MenuImpl.class.getName();
	}

	public int getDiscountPercentage() {
		return discountPercentage;
	}

	public void setDiscountPercentage(int discountPercentage) {
		this.discountPercentage = discountPercentage;
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
