package Restaurant.menu.seaonalmenu;
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
    @Route(url="call/seaonalmenu/save")
    public List<HashMap<String,Object>> save(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		MenuSeaonalMenu menuseaonalmenu = createMenuSeaonalMenu(vmjExchange);
		menuseaonalmenuRepository.saveObject(menuseaonalmenu);
		return getAllMenuSeaonalMenu(vmjExchange);
	}

    public Menu createMenuSeaonalMenu(VMJExchange vmjExchange){
		
		MenuSeaonalMenu menuseaonalmenu = record.createMenuSeaonalMenu(vmjExchange);
		MenuSeaonalMenu menuseaonalmenudeco = MenuSeaonalMenuFactory.createMenuSeaonalMenu("Restaurant.seaonalmenu.core.MenuImpl", menuseaonalmenu, MenuId, name, description, price, category
		starSeasonDate, endSeasonDate
		);
			return menuseaonalmenudeco;
	}


    public Menu createMenuSeaonalMenu(VMJExchange vmjExchange, int id){
		MenuSeaonalMenu menuseaonalmenu = menuseaonalmenuRepository.getObject(id);
		int recordMenuSeaonalMenuId = (((MenuSeaonalMenuDecorator) savedMenuSeaonalMenu.getRecord()).getId();
		
		MenuSeaonalMenu menuseaonalmenu = record.createMenuSeaonalMenu(vmjExchange);
		MenuSeaonalMenu menuseaonalmenudeco = MenuSeaonalMenuFactory.createMenuSeaonalMenu("Restaurant.seaonalmenu.core.MenuImpl", id, menuseaonalmenu, MenuId, name, description, price, category
		starSeasonDate, endSeasonDate
		);
			return menuseaonalmenudeco;
	}

	// @Restriced(permission = "")
    @Route(url="call/seaonalmenu/update")
    public HashMap<String, Object> updateMenuSeaonalMenu(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String idStr = (String) vmjExchange.getRequestBodyForm("MenuId");
		int id = Integer.parseInt(idStr);
		
		MenuSeaonalMenu menuseaonalmenu = menuseaonalmenuRepository.getObject(id);
		menuseaonalmenu = createMenuSeaonalMenu(vmjExchange, id);
		
		menuseaonalmenuRepository.updateObject(menuseaonalmenu);
		menuseaonalmenu = menuseaonalmenuRepository.getObject(id);
		//to do: fix association attributes
		
		return menuseaonalmenu.toHashMap();
		
	}

	// @Restriced(permission = "")
    @Route(url="call/seaonalmenu/detail")
    public HashMap<String, Object> getMenuSeaonalMenu(VMJExchange vmjExchange){
		return record.getMenuSeaonalMenu(vmjExchange);
	}

	// @Restriced(permission = "")
    @Route(url="call/seaonalmenu/list")
    public List<HashMap<String,Object>> getAllMenuSeaonalMenu(VMJExchange vmjExchange){
		List<MenuSeaonalMenu> menuseaonalmenuList = menuseaonalmenuRepository.getAllObject("menuseaonalmenu_impl");
		return transformMenuSeaonalMenuListToHashMap(menuseaonalmenuList);
	}

    public List<HashMap<String,Object>> transformMenuSeaonalMenuListToHashMap(List<MenuSeaonalMenu> MenuSeaonalMenuList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < MenuSeaonalMenuList.size(); i++) {
            resultList.add(MenuSeaonalMenuList.get(i).toHashMap());
        }

        return resultList;
	}

	// @Restriced(permission = "")
    @Route(url="call/seaonalmenu/delete")
    public List<HashMap<String,Object>> deleteMenuSeaonalMenu(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("MenuId");
		int id = Integer.parseInt(idStr);
		menuseaonalmenuRepository.deleteObject(id);
		return getAllMenuSeaonalMenu(vmjExchange);
	}

	
}
