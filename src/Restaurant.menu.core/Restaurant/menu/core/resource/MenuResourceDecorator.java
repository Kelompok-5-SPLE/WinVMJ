package Restaurant.menu.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

public abstract class MenuResourceDecorator extends MenuResourceComponent{
	protected MenuResourceComponent record;

    public MenuResourceDecorator(MenuResourceComponent record) {
        this.record = record;
    }

    public List<HashMap<String,Object>> saveMenu(VMJExchange vmjExchange){
		return record.saveMenu(vmjExchange);
	}

    public Menu createMenu(VMJExchange vmjExchange){
		return record.createMenu(vmjExchange);
	}

    public Menu createMenu(VMJExchange vmjExchange, int id){
		return record.createMenu(vmjExchange, id);
	}

    public HashMap<String, Object> updateMenu(VMJExchange vmjExchange){
		return record.updateMenu(vmjExchange);
	}

    public HashMap<String, Object> getMenu(VMJExchange vmjExchange){
		return record.getMenu(vmjExchange);
	}

    public List<HashMap<String,Object>> getAllMenu(VMJExchange vmjExchange){
		return record.getAllMenu(vmjExchange);
	}

    public List<HashMap<String,Object>> deleteMenu(VMJExchange vmjExchange){
		return record.deleteMenu(vmjExchange);
	}

}
