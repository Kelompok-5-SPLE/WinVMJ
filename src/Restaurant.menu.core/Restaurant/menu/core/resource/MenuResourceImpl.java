package Restaurant.menu.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import Restaurant.menu.MenuFactory;
// import prices.auth.vmj.annotations.Restricted;
//add other required packages


public class MenuResourceImpl extends MenuResourceComponent{
	
	private MenuServiceImpl menuServiceImpl = new MenuServiceImpl();

	// @Restriced(permission = "")
    @Route(url="call/menu/save")
    public List<HashMap<String,Object>> saveMenu(VMJExchange vmjExchange){
		return null;
	}

	// @Restriced(permission = "")
    @Route(url="call/menu")
    public HashMap<String,Object> menu(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Menu result = menuServiceImpl.createMenu(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    public Menu createMenu(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Menu result = menuServiceImpl.createMenu(requestBody);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    public Menu createMenu(VMJExchange vmjExchange, int id){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Menu result = menuServiceImpl.createMenu(requestBody, id);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	// @Restriced(permission = "")
    @Route(url="call/menu/update")
    public HashMap<String, Object> updateMenu(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return menuServiceImpl.updateMenu(requestBody);
		
	}

	// @Restriced(permission = "")
    @Route(url="call/menu/detail")
    public HashMap<String, Object> getMenu(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return menuServiceImpl.getMenu(requestBody);
	}

	// @Restriced(permission = "")
    @Route(url="call/menu/list")
    public List<HashMap<String,Object>> getAllMenu(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return menuServiceImpl.getAllMenu(requestBody);
	}

	// @Restriced(permission = "")
    @Route(url="call/menu/delete")
    public List<HashMap<String,Object>> deleteMenu(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return menuServiceImpl.deleteMenu(requestBody);
	}


}
