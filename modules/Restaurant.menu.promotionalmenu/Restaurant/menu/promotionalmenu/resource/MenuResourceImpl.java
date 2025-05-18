package Restaurant.menu.promotionalmenu;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import Restaurant.menu.core.*;

import Restaurant.menu.core.MenuResourceDecorator;
import Restaurant.menu.core.MenuResourceComponent;
import Restaurant.menu.core.MenuServiceComponent;
import Restaurant.menu.promotionalmenu.MenuImpl;
import Restaurant.menu.promotionalmenu.MenuServiceImpl;

import vmj.routing.route.exceptions.*;

public class MenuResourceImpl extends MenuResourceDecorator {
	private MenuServiceImpl menuServiceImpl;
    public MenuResourceImpl (MenuResourceComponent recordResource, MenuServiceComponent recordService) {
        super(recordResource);
		this.menuServiceImpl = new MenuServiceImpl(recordService);
    }

    // @Restriced(permission = "")
    @Route(url="call/promotionalmenu/save")
    public List<HashMap<String,Object>> saveMenu(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		List<HashMap<String,Object>> menu = menuServiceImpl.saveMenu(vmjExchange);
		
		return menu;
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
    @Route(url="call/promotionalmenu/update")
    public HashMap<String, Object> updateMenu(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return menuServiceImpl.updateMenu(requestBody);
		
	}

	// @Restriced(permission = "")
    @Route(url="call/promotionalmenu/detail")
    public HashMap<String, Object> getMenu(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return menuServiceImpl.getMenu(requestBody);
	}

	// @Restriced(permission = "")
    @Route(url="call/promotionalmenu/list")
    public List<HashMap<String,Object>> getAllMenu(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return menuServiceImpl.getAllMenu(requestBody);
	}

	// @Restriced(permission = "")
    @Route(url="call/promotionalmenu/delete")
    public List<HashMap<String,Object>> deleteMenu(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return menuServiceImpl.deleteMenu(requestBody);
	}

	
}
