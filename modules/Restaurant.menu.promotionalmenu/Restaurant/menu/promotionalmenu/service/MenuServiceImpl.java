package Restaurant.menu.promotionalmenu;

import java.util.*;

import vmj.routing.route.VMJExchange;

import Restaurant.menu.core.*;

import Restaurant.menu.MenuFactory;

public class MenuServiceImpl extends MenuServiceDecorator {
    public MenuServiceImpl (MenuServiceComponent record) {
        super(record);
    }

	public Menu createMenu(Map<String, Object> requestBody){
		String discountPercentage = (String) requestBody.get("discountPercentage");
		int discountPercentageInt = Integer.parseInt(discountPercentage);
		Menu menu = record.createMenu(requestBody);
		Menu menuPromotionalMenu = MenuFactory.createMenu("Restaurant.menu.promotionalmenu.MenuImpl", menu, discountPercentageInt);
		menuRepository.saveObject(menuPromotionalMenu);
		System.out.println(menuPromotionalMenu.toHashMap());
		return menuPromotionalMenu;
	}

    public HashMap<String, Object> updateMenu(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("menuId");
		UUID menuId = UUID.fromString(idStr);
		Menu menu =this.menuRepository.getObject(menuId);
		
		menu.setName((String) requestBody.get("name"));
		menu.setDescription((String) requestBody.get("description"));
		String priceStr = (String) requestBody.get("price");
		menu.setPrice(Integer.parseInt(priceStr));
		menu.setCategory((String) requestBody.get("category"));
		String discountPercentage = (String) requestBody.get("discountPercentage");
		((MenuImpl) menu).setDiscountPercentage(Integer.parseInt(discountPercentage));
		
		
		menuRepository.updateObject(menu);
				
		return menu.toHashMap();
		
	}

    public HashMap<String, Object> getMenu(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get("menuId"));
		UUID menuId = UUID.fromString(idStr);
		try {
    	
    	HashMap<String, Object> menu = getMenuById(menuId);
    	return menu;
		}
		
		catch(Exception e){
			return null;
		}
	}

	public HashMap<String, Object> getMenuById(UUID id){
		Menu menu = menuRepository.getObject(id);
		return menu.toHashMap();
	}

    public List<HashMap<String,Object>> getAllMenu(){
		String table = "menu_promotionalmenu";
		List<Menu> List = menuRepository.getAllObject(table);
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Menu> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deleteMenu(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get("menuId"));
		String baseMenuIdStr = (String) requestBody.get("baseMenuId");
		UUID menuId = UUID.fromString(idStr);

	    Menu promotionalMenu = this.menuRepository.getObject(menuId);
	    MenuImpl menuImpl = (MenuImpl)promotionalMenu;

    	UUID baseMenuId = UUID.fromString(baseMenuIdStr);

		menuRepository.deleteObject(menuId);
		menuRepository.deleteObject(baseMenuId);

		return getAllMenu();
	}
    
    
}
