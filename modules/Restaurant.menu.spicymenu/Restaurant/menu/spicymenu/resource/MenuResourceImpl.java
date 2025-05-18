package Restaurant.menu.spicymenu;
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
    @Route(url="call/spicymenu/save")
    public List<HashMap<String,Object>> save(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		MenuSpicyMenu menuspicymenu = createMenuSpicyMenu(vmjExchange);
		menuspicymenuRepository.saveObject(menuspicymenu);
		return getAllMenuSpicyMenu(vmjExchange);
	}

    public Menu createMenuSpicyMenu(VMJExchange vmjExchange){
		String spiceLevelStr = (String) vmjExchange.getRequestBodyForm("spiceLevel");
		int spiceLevel = Integer.parseInt(spiceLevelStr);
		
		MenuSpicyMenu menuspicymenu = record.createMenuSpicyMenu(vmjExchange);
		MenuSpicyMenu menuspicymenudeco = MenuSpicyMenuFactory.createMenuSpicyMenu("Restaurant.spicymenu.core.MenuImpl", menuspicymenu, MenuId, name, description, price, category, 
        spiceLevel);
		
        return menuspicymenudeco;
	}


    public Menu createMenuSpicyMenu(VMJExchange vmjExchange, int id){
		String spiceLevelStr = (String) vmjExchange.getRequestBodyForm("spiceLevel");
		int spiceLevel = Integer.parseInt(spiceLevelStr);
		MenuSpicyMenu menuspicymenu = menuspicymenuRepository.getObject(id);
		int recordMenuSpicyMenuId = ((MenuSpicyMenuDecorator) savedMenuSpicyMenu.getRecord()).getId();
		
		menuspicymenu = record.createMenuSpicyMenu(vmjExchange);
		MenuSpicyMenu menuspicymenudeco = MenuSpicyMenuFactory.createMenuSpicyMenu("Restaurant.spicymenu.core.MenuImpl", id, menuspicymenu, MenuId, name, description, price, category,
		spiceLevel);
		
        return menuspicymenudeco;
	}

	// @Restriced(permission = "")
    @Route(url="call/spicymenu/update")
    public HashMap<String, Object> updateMenuSpicyMenu(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String idStr = (String) vmjExchange.getRequestBodyForm("MenuId");
		int id = Integer.parseInt(idStr);
		
		MenuSpicyMenu menuspicymenu = menuspicymenuRepository.getObject(id);
		menuspicymenu = createMenuSpicyMenu(vmjExchange, id);
		
		menuspicymenuRepository.updateObject(menuspicymenu);
		menuspicymenu = menuspicymenuRepository.getObject(id);
		//to do: fix association attributes
		
		return menuspicymenu.toHashMap();
		
	}

	// @Restriced(permission = "")
    @Route(url="call/spicymenu/detail")
    public HashMap<String, Object> getMenuSpicyMenu(VMJExchange vmjExchange){
		return record.getMenuSpicyMenu(vmjExchange);
	}

	// @Restriced(permission = "")
    @Route(url="call/spicymenu/list")
    public List<HashMap<String,Object>> getAllMenuSpicyMenu(VMJExchange vmjExchange){
		List<MenuSpicyMenu> menuspicymenuList = menuspicymenuRepository.getAllObject("menuspicymenu_impl");
		return transformMenuSpicyMenuListToHashMap(menuspicymenuList);
	}

    public List<HashMap<String,Object>> transformMenuSpicyMenuListToHashMap(List<MenuSpicyMenu> MenuSpicyMenuList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < MenuSpicyMenuList.size(); i++) {
            resultList.add(MenuSpicyMenuList.get(i).toHashMap());
        }

        return resultList;
	}

	// @Restriced(permission = "")
    @Route(url="call/spicymenu/delete")
    public List<HashMap<String,Object>> deleteMenuSpicyMenu(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("MenuId");
		int id = Integer.parseInt(idStr);
		menuspicymenuRepository.deleteObject(id);
		return getAllMenuSpicyMenu(vmjExchange);
	}

	
}
