package Restaurant.menu.traditionalmenu;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import Restaurant.menu.core.MenuResourceDecorator;
import Restaurant.menu.core.MenuImpl;
import Restaurant.menu.core.MenuResourceComponent;

public class MenuResourceImpl extends MenuResourceDecorator {
    public MenuResourceImpl (MenuResourceComponent record) {
        super(record);
    }

    // @Restriced(permission = "")
    @Route(url="call/traditionalmenu/save")
    public List<HashMap<String,Object>> save(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		MenuTraditionalMenu menutraditionalmenu = createMenuTraditionalMenu(vmjExchange);
		menutraditionalmenuRepository.saveObject(menutraditionalmenu);
		return getAllMenuTraditionalMenu(vmjExchange);
	}

    public Menu createMenuTraditionalMenu(VMJExchange vmjExchange){
		String Origin = (String) vmjExchange.getRequestBodyForm("Origin");
		
		MenuTraditionalMenu menutraditionalmenu = record.createMenuTraditionalMenu(vmjExchange);
		MenuTraditionalMenu menutraditionalmenudeco = MenuTraditionalMenuFactory.createMenuTraditionalMenu("Restaurant.traditionalmenu.core.MenuImpl", menutraditionalmenu, MenuId, name, description, price, category
		Origin
		);
			return menutraditionalmenudeco;
	}


    public Menu createMenuTraditionalMenu(VMJExchange vmjExchange, int id){
		String Origin = (String) vmjExchange.getRequestBodyForm("Origin");
		MenuTraditionalMenu menutraditionalmenu = menutraditionalmenuRepository.getObject(id);
		int recordMenuTraditionalMenuId = (((MenuTraditionalMenuDecorator) savedMenuTraditionalMenu.getRecord()).getId();
		
		MenuTraditionalMenu menutraditionalmenu = record.createMenuTraditionalMenu(vmjExchange);
		MenuTraditionalMenu menutraditionalmenudeco = MenuTraditionalMenuFactory.createMenuTraditionalMenu("Restaurant.traditionalmenu.core.MenuImpl", id, menutraditionalmenu, MenuId, name, description, price, category
		Origin
		);
			return menutraditionalmenudeco;
	}

	// @Restriced(permission = "")
    @Route(url="call/traditionalmenu/update")
    public HashMap<String, Object> updateMenuTraditionalMenu(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String idStr = (String) vmjExchange.getRequestBodyForm("MenuId");
		int id = Integer.parseInt(idStr);
		
		MenuTraditionalMenu menutraditionalmenu = menutraditionalmenuRepository.getObject(id);
		menutraditionalmenu = createMenuTraditionalMenu(vmjExchange, id);
		
		menutraditionalmenuRepository.updateObject(menutraditionalmenu);
		menutraditionalmenu = menutraditionalmenuRepository.getObject(id);
		//to do: fix association attributes
		
		return menutraditionalmenu.toHashMap();
		
	}

	// @Restriced(permission = "")
    @Route(url="call/traditionalmenu/detail")
    public HashMap<String, Object> getMenuTraditionalMenu(VMJExchange vmjExchange){
		return record.getMenuTraditionalMenu(vmjExchange);
	}

	// @Restriced(permission = "")
    @Route(url="call/traditionalmenu/list")
    public List<HashMap<String,Object>> getAllMenuTraditionalMenu(VMJExchange vmjExchange){
		List<MenuTraditionalMenu> menutraditionalmenuList = menutraditionalmenuRepository.getAllObject("menutraditionalmenu_impl");
		return transformMenuTraditionalMenuListToHashMap(menutraditionalmenuList);
	}

    public List<HashMap<String,Object>> transformMenuTraditionalMenuListToHashMap(List<MenuTraditionalMenu> MenuTraditionalMenuList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < MenuTraditionalMenuList.size(); i++) {
            resultList.add(MenuTraditionalMenuList.get(i).toHashMap());
        }

        return resultList;
	}

	// @Restriced(permission = "")
    @Route(url="call/traditionalmenu/delete")
    public List<HashMap<String,Object>> deleteMenuTraditionalMenu(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("MenuId");
		int id = Integer.parseInt(idStr);
		menutraditionalmenuRepository.deleteObject(id);
		return getAllMenuTraditionalMenu(vmjExchange);
	}

	
}
