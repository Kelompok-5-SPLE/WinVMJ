package Restaurant.menu.kidsmenu;
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
    @Route(url="call/kidsmenu/save")
    public List<HashMap<String,Object>> save(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		MenuKidsMenu menukidsmenu = createMenuKidsMenu(vmjExchange);
		menukidsmenuRepository.saveObject(menukidsmenu);
		return getAllMenuKidsMenu(vmjExchange);
	}

    public Menu createMenuKidsMenu(VMJExchange vmjExchange){
		String AgeRestrictionStr = (String) vmjExchange.getRequestBodyForm("AgeRestriction");
		int AgeRestriction = Integer.parseInt(AgeRestrictionStr);
		
		MenuKidsMenu menukidsmenu = record.createMenuKidsMenu(vmjExchange);
		MenuKidsMenu menukidsmenudeco = MenuKidsMenuFactory.createMenuKidsMenu("Restaurant.kidsmenu.core.MenuImpl", menukidsmenu, MenuId, name, description, price, category
		AgeRestriction
		);
			return menukidsmenudeco;
	}


    public Menu createMenuKidsMenu(VMJExchange vmjExchange, int id){
		String AgeRestrictionStr = (String) vmjExchange.getRequestBodyForm("AgeRestriction");
		int AgeRestriction = Integer.parseInt(AgeRestrictionStr);
		MenuKidsMenu menukidsmenu = menukidsmenuRepository.getObject(id);
		int recordMenuKidsMenuId = (((MenuKidsMenuDecorator) savedMenuKidsMenu.getRecord()).getId();
		
		MenuKidsMenu menukidsmenu = record.createMenuKidsMenu(vmjExchange);
		MenuKidsMenu menukidsmenudeco = MenuKidsMenuFactory.createMenuKidsMenu("Restaurant.kidsmenu.core.MenuImpl", id, menukidsmenu, MenuId, name, description, price, category
		AgeRestriction
		);
			return menukidsmenudeco;
	}

	// @Restriced(permission = "")
    @Route(url="call/kidsmenu/update")
    public HashMap<String, Object> updateMenuKidsMenu(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String idStr = (String) vmjExchange.getRequestBodyForm("MenuId");
		int id = Integer.parseInt(idStr);
		
		MenuKidsMenu menukidsmenu = menukidsmenuRepository.getObject(id);
		menukidsmenu = createMenuKidsMenu(vmjExchange, id);
		
		menukidsmenuRepository.updateObject(menukidsmenu);
		menukidsmenu = menukidsmenuRepository.getObject(id);
		//to do: fix association attributes
		
		return menukidsmenu.toHashMap();
		
	}

	// @Restriced(permission = "")
    @Route(url="call/kidsmenu/detail")
    public HashMap<String, Object> getMenuKidsMenu(VMJExchange vmjExchange){
		return record.getMenuKidsMenu(vmjExchange);
	}

	// @Restriced(permission = "")
    @Route(url="call/kidsmenu/list")
    public List<HashMap<String,Object>> getAllMenuKidsMenu(VMJExchange vmjExchange){
		List<MenuKidsMenu> menukidsmenuList = menukidsmenuRepository.getAllObject("menukidsmenu_impl");
		return transformMenuKidsMenuListToHashMap(menukidsmenuList);
	}

    public List<HashMap<String,Object>> transformMenuKidsMenuListToHashMap(List<MenuKidsMenu> MenuKidsMenuList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < MenuKidsMenuList.size(); i++) {
            resultList.add(MenuKidsMenuList.get(i).toHashMap());
        }

        return resultList;
	}

	// @Restriced(permission = "")
    @Route(url="call/kidsmenu/delete")
    public List<HashMap<String,Object>> deleteMenuKidsMenu(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("MenuId");
		int id = Integer.parseInt(idStr);
		menukidsmenuRepository.deleteObject(id);
		return getAllMenuKidsMenu(vmjExchange);
	}

	
}
