package Restaurant.menu.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="menu_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class MenuComponent implements Menu{
	@Id
	public UUID MenuId; 
	public String name;
	public String description;
	public int price;
	public String category;
	protected String objectName = MenuComponent.class.getName();

	public MenuComponent() {

	} 

	public MenuComponent(
        UUID MenuId, String name, String description, int price, String category
    ) {
        this.MenuId = MenuId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
    }

	public abstract UUID getMenuId();
	public abstract void setMenuId(UUID MenuId);
	
	public abstract String getName();
	public abstract void setName(String name);
	
	public abstract String getDescription();
	public abstract void setDescription(String description);
	
	public abstract int getPrice();
	public abstract void setPrice(int price);
	
	public abstract String getCategory();
	public abstract void setCategory(String category);
	
 

	@Override
    public String toString() {
        return "{" +
            " MenuId='" + getMenuId() + "'" +
            " name='" + getName() + "'" +
            " description='" + getDescription() + "'" +
            " price='" + getPrice() + "'" +
            " category='" + getCategory() + "'" +
            "}";
    }
	
}
