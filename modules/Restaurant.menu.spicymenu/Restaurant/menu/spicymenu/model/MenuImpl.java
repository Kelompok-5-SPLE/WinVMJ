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

	public int spiceLevel; // Level 1 =  Mild, Level 5 = Super Hot
	public MenuImpl() {
        super();
        this.objectName = MenuImpl.class.getName();
    }
    
    public MenuImpl(int spiceLevel) {
    	super();
		this.spiceLevel = spiceLevel;
		this.objectName = MenuImpl.class.getName();
    }
	
	public MenuImpl(MenuComponent record, int spiceLevel) {
		super(record);
		this.spiceLevel = spiceLevel;
		this.objectName = MenuImpl.class.getName();
	}



}
