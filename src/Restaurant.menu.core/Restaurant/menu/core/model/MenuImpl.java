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

	public MenuImpl(String name, String description, int price, String category) {
		this.MenuId =  UUID.randomUUID();
		this.name = name;
		this.description = description;
		this.price = price;
		this.category = category;
	}



	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> menuMap = new HashMap<String,Object>();
		menuMap.put("MenuId",getMenuId());
		menuMap.put("name",getName());
		menuMap.put("description",getDescription());
		menuMap.put("price",getPrice());
		menuMap.put("category",getCategory());

        return menuMap;
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
