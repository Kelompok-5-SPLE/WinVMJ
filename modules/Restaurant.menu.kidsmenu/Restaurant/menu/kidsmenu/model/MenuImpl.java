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
	public MenuImpl(
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



}
