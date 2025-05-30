package Restaurant.menu.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public abstract class MenuServiceDecorator extends MenuServiceComponent{
	protected MenuServiceComponent record;

    public MenuServiceDecorator(MenuServiceComponent record) {
        this.record = record;
    }

	public Menu createMenu(Map<String, Object> requestBody){
		return record.createMenu(requestBody);
	}

	public HashMap<String, Object> getMenu(Map<String, Object> requestBody){
		return record.getMenu(requestBody);
	}

	public List<HashMap<String,Object>> getAllMenu(){
		return record.getAllMenu();
	}

    public HashMap<String, Object> updateMenu(Map<String, Object> requestBody){
		return record.updateMenu(requestBody);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Menu> List){
		return record.transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> deleteMenu(Map<String, Object> requestBody){
		return record.deleteMenu(requestBody);
	}

	public HashMap<String, Object> getMenuById(UUID id){
        return record.getMenuById(id);
    }
}