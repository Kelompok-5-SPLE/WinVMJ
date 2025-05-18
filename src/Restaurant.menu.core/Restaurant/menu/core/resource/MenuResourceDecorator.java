package Restaurant.menu.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

public abstract class MenuResourceDecorator extends MenuResourceComponent{
	protected MenuResourceComponent menuRepository;

    public MenuResourceDecorator(MenuResourceComponent menuRepository) {
        this.menuRepository = menuRepository;
    }

    public List<HashMap<String,Object>> saveMenu(VMJExchange vmjExchange){
		return menuRepository.saveMenu(vmjExchange);
	}

    public Menu createMenu(VMJExchange vmjExchange){
		return menuRepository.createMenu(vmjExchange);
	}

    public Menu createMenu(VMJExchange vmjExchange, int id){
		return menuRepository.createMenu(vmjExchange, id);
	}

    public HashMap<String, Object> updateMenu(VMJExchange vmjExchange){
		return menuRepository.updateMenu(vmjExchange);
	}

    public HashMap<String, Object> getMenu(VMJExchange vmjExchange){
		return menuRepository.getMenu(vmjExchange);
	}

    public List<HashMap<String,Object>> getAllMenu(VMJExchange vmjExchange){
		return menuRepository.getAllMenu(vmjExchange);
	}

    public List<HashMap<String,Object>> deleteMenu(VMJExchange vmjExchange){
		return menuRepository.deleteMenu(vmjExchange);
	}

}
