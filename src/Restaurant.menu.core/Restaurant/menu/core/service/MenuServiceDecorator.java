package Restaurant.menu.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public abstract class MenuServiceDecorator extends MenuServiceComponent{
	protected MenuServiceComponent record;

    public MenuServiceDecorator(MenuServiceComponent record) {
        this.record = record;
    }

	public MenuImpl createMenu(Map<String, Object> requestBody){
		return record.createMenu(requestBody);
	}

    public Menu createMenu(Map<String, Object> requestBody, Map<String, Object> response){
		return record.createMenu(requestBody, response);
	}

	public HashMap<String, Object> getMenu(Map<String, Object> requestBody){
		return record.getMenu(requestBody);
	}

	public List<HashMap<String,Object>> getAllMenu(Map<String, Object> requestBody){
		return record.getAllMenu(requestBody);
	}

    public List<HashMap<String,Object>> saveMenu(VMJExchange vmjExchange){
		return record.saveMenu(vmjExchange);
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

	public HashMap<String, Object> getMenuById(int id){
        return record.getMenuById(id);
    }

	public void createMenu() {
		return record.createMenu();
	}

	public void deleteMenu() {
		return record.deleteMenu();
	}

	public void getPrice() {
		return record.getPrice();
	}
}
