package Restaurant.menu.seasonalmenu;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import Restaurant.menu.core.MenuDecorator;
import Restaurant.menu.core.Menu;
import Restaurant.menu.core.MenuComponent;

@Entity(name="menu_seasonalmenu")
@Table(name="menu_seasonalmenu")
public class MenuImpl extends MenuDecorator {

	public EDate starSeasonDate;
	public EDate endSeasonDate;
	public MenuImpl(
        super();
        this.objectName = MenuImpl.class.getName();
    }
    
    public MenuImpl(EDate starSeasonDate, EDate endSeasonDate) {
    	super();
		this.starSeasonDate = starSeasonDate;
		this.endSeasonDate = endSeasonDate;
		this.objectName = MenuImpl.class.getName();
    }
	
	public MenuImpl(MenuComponent record, EDate starSeasonDate, EDate endSeasonDate) {
		super(record);
		this.starSeasonDate = starSeasonDate;
		this.endSeasonDate = endSeasonDate;
		this.objectName = MenuImpl.class.getName();
	}



}
