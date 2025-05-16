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

	public int DiscountPercentage;
	public MenuImpl(
        super();
        this.objectName = MenuImpl.class.getName();
    }
    
    public MenuImpl(int DiscountPercentage) {
    	super();
		this.DiscountPercentage = DiscountPercentage;
		this.objectName = MenuImpl.class.getName();
    }
	
	public MenuImpl(MenuComponent record, int DiscountPercentage) {
		super(record);
		this.DiscountPercentage = DiscountPercentage;
		this.objectName = MenuImpl.class.getName();
	}



}
