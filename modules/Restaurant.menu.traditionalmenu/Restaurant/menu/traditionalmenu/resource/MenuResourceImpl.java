package Restaurant.menu.traditionalmenu;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import Restaurant.menu.MenuFactory;

import vmj.routing.route.exceptions.*;



import Restaurant.menu.core.*;
import Restaurant.menu.traditionalmenu.MenuImpl;
import Restaurant.menu.traditionalmenu.MenuServiceImpl;


public class MenuResourceImpl extends MenuResourceDecorator {

	private MenuServiceImpl menuServiceImpl;

    public MenuResourceImpl (MenuResourceComponent recordResource, MenuServiceComponent recordService) {
        super(recordResource);
		this.menuServiceImpl = new MenuServiceImpl(recordService);
    }

	// @Restriced(permission = "")
    @Route(url="call/traditionalmenu")
	public HashMap<String,Object> createMenu(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Menu result = menuServiceImpl.createMenu(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	// @Restriced(permission = "")
    @Route(url="call/traditionalmenu/update")
    public HashMap<String, Object> updateMenu(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return menuServiceImpl.updateMenu(requestBody);
		
	}

	// @Restriced(permission = "")
    @Route(url="call/traditionalmenu/detail")
    public HashMap<String, Object> getMenu(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return menuServiceImpl.getMenu(requestBody);	}

	// @Restriced(permission = "")
    @Route(url="call/traditionalmenu/list")
    public List<HashMap<String,Object>> getAllMenu(VMJExchange vmjExchange){
		return menuServiceImpl.getAllMenu();
	}

	// @Restriced(permission = "")
    @Route(url="call/traditionalmenu/delete")
    public List<HashMap<String,Object>> deleteMenu(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		return menuServiceImpl.deleteMenu(requestBody);
	}

	
}
