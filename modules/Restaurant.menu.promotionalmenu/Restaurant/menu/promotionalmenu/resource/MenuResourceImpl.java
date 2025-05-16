package Restaurant.menu.promotionalmenu;
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
    @Route(url="call/promotionalmenu/save")
    public List<HashMap<String,Object>> save(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		MenuPromotionalMenu menupromotionalmenu = createMenuPromotionalMenu(vmjExchange);
		menupromotionalmenuRepository.saveObject(menupromotionalmenu);
		return getAllMenuPromotionalMenu(vmjExchange);
	}

    public Menu createMenuPromotionalMenu(VMJExchange vmjExchange){
		String DiscountPercentageStr = (String) vmjExchange.getRequestBodyForm("DiscountPercentage");
		int DiscountPercentage = Integer.parseInt(DiscountPercentageStr);
		
		MenuPromotionalMenu menupromotionalmenu = record.createMenuPromotionalMenu(vmjExchange);
		MenuPromotionalMenu menupromotionalmenudeco = MenuPromotionalMenuFactory.createMenuPromotionalMenu("Restaurant.promotionalmenu.core.MenuImpl", menupromotionalmenu, MenuId, name, description, price, category
		DiscountPercentage
		);
			return menupromotionalmenudeco;
	}


    public Menu createMenuPromotionalMenu(VMJExchange vmjExchange, int id){
		String DiscountPercentageStr = (String) vmjExchange.getRequestBodyForm("DiscountPercentage");
		int DiscountPercentage = Integer.parseInt(DiscountPercentageStr);
		MenuPromotionalMenu menupromotionalmenu = menupromotionalmenuRepository.getObject(id);
		int recordMenuPromotionalMenuId = (((MenuPromotionalMenuDecorator) savedMenuPromotionalMenu.getRecord()).getId();
		
		MenuPromotionalMenu menupromotionalmenu = record.createMenuPromotionalMenu(vmjExchange);
		MenuPromotionalMenu menupromotionalmenudeco = MenuPromotionalMenuFactory.createMenuPromotionalMenu("Restaurant.promotionalmenu.core.MenuImpl", id, menupromotionalmenu, MenuId, name, description, price, category
		DiscountPercentage
		);
			return menupromotionalmenudeco;
	}

	// @Restriced(permission = "")
    @Route(url="call/promotionalmenu/update")
    public HashMap<String, Object> updateMenuPromotionalMenu(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String idStr = (String) vmjExchange.getRequestBodyForm("MenuId");
		int id = Integer.parseInt(idStr);
		
		MenuPromotionalMenu menupromotionalmenu = menupromotionalmenuRepository.getObject(id);
		menupromotionalmenu = createMenuPromotionalMenu(vmjExchange, id);
		
		menupromotionalmenuRepository.updateObject(menupromotionalmenu);
		menupromotionalmenu = menupromotionalmenuRepository.getObject(id);
		//to do: fix association attributes
		
		return menupromotionalmenu.toHashMap();
		
	}

	// @Restriced(permission = "")
    @Route(url="call/promotionalmenu/detail")
    public HashMap<String, Object> getMenuPromotionalMenu(VMJExchange vmjExchange){
		return record.getMenuPromotionalMenu(vmjExchange);
	}

	// @Restriced(permission = "")
    @Route(url="call/promotionalmenu/list")
    public List<HashMap<String,Object>> getAllMenuPromotionalMenu(VMJExchange vmjExchange){
		List<MenuPromotionalMenu> menupromotionalmenuList = menupromotionalmenuRepository.getAllObject("menupromotionalmenu_impl");
		return transformMenuPromotionalMenuListToHashMap(menupromotionalmenuList);
	}

    public List<HashMap<String,Object>> transformMenuPromotionalMenuListToHashMap(List<MenuPromotionalMenu> MenuPromotionalMenuList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < MenuPromotionalMenuList.size(); i++) {
            resultList.add(MenuPromotionalMenuList.get(i).toHashMap());
        }

        return resultList;
	}

	// @Restriced(permission = "")
    @Route(url="call/promotionalmenu/delete")
    public List<HashMap<String,Object>> deleteMenuPromotionalMenu(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("MenuId");
		int id = Integer.parseInt(idStr);
		menupromotionalmenuRepository.deleteObject(id);
		return getAllMenuPromotionalMenu(vmjExchange);
	}

	
}
