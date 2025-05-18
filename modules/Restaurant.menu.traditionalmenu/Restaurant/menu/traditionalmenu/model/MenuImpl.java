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
    
    public MenuImpl() {
        super();
        this.objectName = MenuImpl.class.getName();
    }
    
    public MenuImpl(String origin) {
        super();
        this.origin = origin;
        this.objectName = MenuImpl.class.getName();
    }
    
    // Add this constructor that matches the MenuFactory.createMenu() call pattern
	public MenuImpl(Menu baseMenu, String origin) {
        // Copy properties from the base menu
        this.MenuId = baseMenu.getMenuId();
        this.name = baseMenu.getName();
        this.description = baseMenu.getDescription();
        this.price = baseMenu.getPrice();
        this.category = baseMenu.getCategory();
        // Set kids menu specific property
        this.origin = origin;
    }
    
    // Add this constructor to handle all fields including origin
    public MenuImpl(String name, String description, int price, String category, String origin) {
        super();
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.origin = origin;
        this.MenuId = UUID.randomUUID();
        this.objectName = MenuImpl.class.getName();
    }
    
    public MenuImpl(MenuComponent record, String origin) {
        super(record);
        this.origin = origin;
        this.objectName = MenuImpl.class.getName();
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    // Rest of the methods remain the same
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