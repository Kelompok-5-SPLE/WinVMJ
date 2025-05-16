package Restaurant.menu.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class MenuDecorator extends MenuComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected MenuComponent record;

	public MenuDecorator () {
		super();
		this.record = record;
		this.MenuId =  MenuId.randomUUID();
	}
		
	public MenuDecorator (MenuComponent record) {
		this.MenuId =  MenuId.randomUUID();
		this.record = record;
	}

	public MenuDecorator (UUID MenuId, MenuComponent record) {
		this.MenuId =  MenuId;
		this.record = record;
	}
	
	public MenuDecorator (MenuComponent record, String objectName) {
		this.MenuId =  MenuId.randomUUID();
		this.record = record;	
		this.objectName=objectName;
	}


	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
