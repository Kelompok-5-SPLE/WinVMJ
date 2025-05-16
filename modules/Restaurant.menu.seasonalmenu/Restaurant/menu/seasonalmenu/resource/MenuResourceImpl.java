package Restaurant.menu.seasonalmenu;
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
    @Route(url="call/seasonalmenu/save")
    public List<HashMap<String,Object>> save(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		MenuSeasonalMenu menuseasonalmenu = createMenuSeasonalMenu(vmjExchange);
		menuseasonalmenuRepository.saveObject(menuseasonalmenu);
		return getAllMenuSeasonalMenu(vmjExchange);
	}

    public Menu createMenuSeasonalMenu(VMJExchange vmjExchange){
		
		MenuSeasonalMenu menuseasonalmenu = record.createMenuSeasonalMenu(vmjExchange);
		MenuSeasonalMenu menuseasonalmenudeco = MenuSeasonalMenuFactory.createMenuSeasonalMenu("Restaurant.seasonalmenu.core.MenuImpl", menuseasonalmenu, MenuId, name, description, price, category
		starSeasonDate, endSeasonDate
		);
			return menuseasonalmenudeco;
	}


    public Menu createMenuSeasonalMenu(VMJExchange vmjExchange, int id){
		MenuSeasonalMenu menuseasonalmenu = menuseasonalmenuRepository.getObject(id);
		int recordMenuSeasonalMenuId = (((MenuSeasonalMenuDecorator) savedMenuSeasonalMenu.getRecord()).getId();
		
		MenuSeasonalMenu menuseasonalmenu = record.createMenuSeasonalMenu(vmjExchange);
		MenuSeasonalMenu menuseasonalmenudeco = MenuSeasonalMenuFactory.createMenuSeasonalMenu("Restaurant.seasonalmenu.core.MenuImpl", id, menuseasonalmenu, MenuId, name, description, price, category
		starSeasonDate, endSeasonDate
		);
			return menuseasonalmenudeco;
	}

	// @Restriced(permission = "")
    @Route(url="call/seasonalmenu/update")
    public HashMap<String, Object> updateMenuSeasonalMenu(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String idStr = (String) vmjExchange.getRequestBodyForm("MenuId");
		int id = Integer.parseInt(idStr);
		
		MenuSeasonalMenu menuseasonalmenu = menuseasonalmenuRepository.getObject(id);
		menuseasonalmenu = createMenuSeasonalMenu(vmjExchange, id);
		
		menuseasonalmenuRepository.updateObject(menuseasonalmenu);
		menuseasonalmenu = menuseasonalmenuRepository.getObject(id);
		//to do: fix association attributes
		
		return menuseasonalmenu.toHashMap();
		
	}

	// @Restriced(permission = "")
    @Route(url="call/seasonalmenu/detail")
    public HashMap<String, Object> getMenuSeasonalMenu(VMJExchange vmjExchange){
		return record.getMenuSeasonalMenu(vmjExchange);
	}

	// @Restriced(permission = "")
    @Route(url="call/seasonalmenu/list")
    public List<HashMap<String,Object>> getAllMenuSeasonalMenu(VMJExchange vmjExchange){
		List<MenuSeasonalMenu> menuseasonalmenuList = menuseasonalmenuRepository.getAllObject("menuseasonalmenu_impl");
		return transformMenuSeasonalMenuListToHashMap(menuseasonalmenuList);
	}

    public List<HashMap<String,Object>> transformMenuSeasonalMenuListToHashMap(List<MenuSeasonalMenu> MenuSeasonalMenuList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < MenuSeasonalMenuList.size(); i++) {
            resultList.add(MenuSeasonalMenuList.get(i).toHashMap());
        }

        return resultList;
	}

	// @Restriced(permission = "")
    @Route(url="call/seasonalmenu/delete")
    public List<HashMap<String,Object>> deleteMenuSeasonalMenu(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("MenuId");
		int id = Integer.parseInt(idStr);
		menuseasonalmenuRepository.deleteObject(id);
		return getAllMenuSeasonalMenu(vmjExchange);
	}

	
}
