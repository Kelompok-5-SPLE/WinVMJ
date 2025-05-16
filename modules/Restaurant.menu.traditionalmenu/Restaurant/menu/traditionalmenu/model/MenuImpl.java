package Restaurant.menu.traditionalmenu;

import Restaurant.menu.core.MenuDecorator;
import Restaurant.menu.core.Menu;
import Restaurant.menu.core.MenuComponent;

public class MenuImpl extends MenuDecorator {

	protected String Origin;
	public MenuImpl(MenuComponent record, String Origin) {
		super(record);
		this.Origin = Origin;
	}

	public String getOrigin() {
		return this.Origin;
	}

	public void setOrigin(String Origin) {
		this.Origin = Origin;
	}

}
