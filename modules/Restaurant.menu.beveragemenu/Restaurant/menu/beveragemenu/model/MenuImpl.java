package Restaurant.menu.beveragemenu;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import Restaurant.menu.core.MenuDecorator;
import Restaurant.menu.core.Menu;
import Restaurant.menu.core.MenuComponent;

@Entity(name="menu_beveragemenu")
@Table(name="menu_beveragemenu")
public class MenuImpl extends MenuDecorator {

	public boolean isIced;
	public MenuImpl(
        super();
        this.objectName = MenuImpl.class.getName();
    }
    
    public MenuImpl(boolean isIced) {
    	super();
		this.isIced = isIced;
		this.objectName = MenuImpl.class.getName();
    }
	
	public MenuImpl(MenuComponent record, boolean isIced) {
		super(record);
		this.isIced = isIced;
		this.objectName = MenuImpl.class.getName();
	}



}
