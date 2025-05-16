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

	public String Origin;
	public MenuImpl(
        super();
        this.objectName = MenuImpl.class.getName();
    }
    
    public MenuImpl(String Origin) {
    	super();
		this.Origin = Origin;
		this.objectName = MenuImpl.class.getName();
    }
	
	public MenuImpl(MenuComponent record, String Origin) {
		super(record);
		this.Origin = Origin;
		this.objectName = MenuImpl.class.getName();
	}



}
