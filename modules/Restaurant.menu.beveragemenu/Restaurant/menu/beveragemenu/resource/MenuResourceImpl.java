package Restaurant.menu.beveragemenu;
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
    @Route(url="call/beveragemenu/save")
    public List<HashMap<String,Object>> save(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		MenuBeverageMenu menubeveragemenu = createMenuBeverageMenu(vmjExchange);
		menubeveragemenuRepository.saveObject(menubeveragemenu);
		return getAllMenuBeverageMenu(vmjExchange);
	}

    public Menu createMenuBeverageMenu(VMJExchange vmjExchange){
		boolean isIced = (boolean) vmjExchange.getRequestBodyForm("isIced");
		
		MenuBeverageMenu menubeveragemenu = record.createMenuBeverageMenu(vmjExchange);
		MenuBeverageMenu menubeveragemenudeco = MenuBeverageMenuFactory.createMenuBeverageMenu("Restaurant.beveragemenu.core.MenuImpl", menubeveragemenu, MenuId, name, description, price, category
		isIced
		);
			return menubeveragemenudeco;
	}


    public Menu createMenuBeverageMenu(VMJExchange vmjExchange, int id){
		boolean isIced = (boolean) vmjExchange.getRequestBodyForm("isIced");
		MenuBeverageMenu menubeveragemenu = menubeveragemenuRepository.getObject(id);
		int recordMenuBeverageMenuId = (((MenuBeverageMenuDecorator) savedMenuBeverageMenu.getRecord()).getId();
		
		MenuBeverageMenu menubeveragemenu = record.createMenuBeverageMenu(vmjExchange);
		MenuBeverageMenu menubeveragemenudeco = MenuBeverageMenuFactory.createMenuBeverageMenu("Restaurant.beveragemenu.core.MenuImpl", id, menubeveragemenu, MenuId, name, description, price, category
		isIced
		);
			return menubeveragemenudeco;
	}

	// @Restriced(permission = "")
    @Route(url="call/beveragemenu/update")
    public HashMap<String, Object> updateMenuBeverageMenu(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String idStr = (String) vmjExchange.getRequestBodyForm("MenuId");
		int id = Integer.parseInt(idStr);
		
		MenuBeverageMenu menubeveragemenu = menubeveragemenuRepository.getObject(id);
		menubeveragemenu = createMenuBeverageMenu(vmjExchange, id);
		
		menubeveragemenuRepository.updateObject(menubeveragemenu);
		menubeveragemenu = menubeveragemenuRepository.getObject(id);
		//to do: fix association attributes
		
		return menubeveragemenu.toHashMap();
		
	}

	// @Restriced(permission = "")
    @Route(url="call/beveragemenu/detail")
    public HashMap<String, Object> getMenuBeverageMenu(VMJExchange vmjExchange){
		return record.getMenuBeverageMenu(vmjExchange);
	}

	// @Restriced(permission = "")
    @Route(url="call/beveragemenu/list")
    public List<HashMap<String,Object>> getAllMenuBeverageMenu(VMJExchange vmjExchange){
		List<MenuBeverageMenu> menubeveragemenuList = menubeveragemenuRepository.getAllObject("menubeveragemenu_impl");
		return transformMenuBeverageMenuListToHashMap(menubeveragemenuList);
	}

    public List<HashMap<String,Object>> transformMenuBeverageMenuListToHashMap(List<MenuBeverageMenu> MenuBeverageMenuList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < MenuBeverageMenuList.size(); i++) {
            resultList.add(MenuBeverageMenuList.get(i).toHashMap());
        }

        return resultList;
	}

	// @Restriced(permission = "")
    @Route(url="call/beveragemenu/delete")
    public List<HashMap<String,Object>> deleteMenuBeverageMenu(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("MenuId");
		int id = Integer.parseInt(idStr);
		menubeveragemenuRepository.deleteObject(id);
		return getAllMenuBeverageMenu(vmjExchange);
	}

	
}
