package Restaurant.menu.core;

import java.lang.Math;
import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity(name="menu_impl")
@Table(name="menu_impl")
public class MenuImpl extends MenuComponent {

	public MenuImpl(UUID MenuId, String name, String desc, int price, String category) {
		this.MenuId = MenuId;
		this.name = name;
		this.desc = desc;
		this.price = price;
		this.category = category;
	}

	public MenuImpl(UUID MenuId, String name, String desc, int price, String category) {
		this.MenuId =  MenuId.randomUUID();;
		this.MenuId = MenuId;
		this.name = name;
		this.desc = desc;
		this.price = price;
		this.category = category;
	}

	public MenuImpl() { }


	public void createMenu() {
		// TODO: implement this method
	}

	public void deleteMenu() {
		// TODO: implement this method
	}

	public void getPrice() {
		// TODO: implement this method
	}
	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> menuMap = new HashMap<String,Object>();
		menuMap.put("MenuId",getMenuId());
		menuMap.put("name",getName());
		menuMap.put("desc",getDesc());
		menuMap.put("price",getPrice());
		menuMap.put("category",getCategory());

        return menuMap;
    }

}
