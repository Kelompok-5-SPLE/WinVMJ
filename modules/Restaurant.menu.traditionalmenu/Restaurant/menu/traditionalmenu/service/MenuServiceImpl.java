package Restaurant.menu.traditionalmenu;

import java.util.*;

import vmj.routing.route.VMJExchange;

import Restaurant.menu.core.*;

import Restaurant.menu.MenuFactory;

public class MenuServiceImpl extends MenuServiceDecorator {
    public MenuServiceImpl(MenuServiceComponent record) {
        super(record);
    }

    public List<HashMap<String, Object>> saveMenu(Map<String, Object> requestBody) {
        return null;
    }

    @Override
    public List<HashMap<String, Object>> saveMenu(VMJExchange vmjExchange) {
        if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
            return null;
        }
        Menu menu = createMenu(vmjExchange.getPayload());
        this.menuRepository.saveObject(menu);
        return getAllMenu(vmjExchange.getPayload());
    }

    public Menu createMenu(Map<String, Object> requestBody){
		String origin = (String) requestBody.get("origin");
		Menu menu = record.createMenu(requestBody);
		Menu menuTraditionalMenu = MenuFactory.createMenu("Restaurant.menu.kidsmenu.MenuImpl", menu, origin);
		this.menuRepository.saveObject(menuTraditionalMenu);
		return menuTraditionalMenu;
	}

    // Removed parameter id as we'll use random UUID instead
    public Menu createMenuWithId(Map<String, Object> requestBody) {
        String name = (String) requestBody.get("name");
        String desc = (String) requestBody.get("description");
        String priceStr = (String) requestBody.get("price");
        int price = Integer.parseInt(priceStr);
        String category = (String) requestBody.get("category");
        String origin = (String) requestBody.get("origin");

        // Pass all parameters including origin directly to factory
        Menu menu = MenuFactory.createMenu(
            "Restaurant.menu.traditionalmenu.MenuImpl",
            name,
            desc,
            price,
            category,
            origin
        );
        
        return menu;
    }

    public HashMap<String, Object> updateMenu(Map<String, Object> requestBody) {
        String idStr = (String) requestBody.get("MenuId");
        UUID id = UUID.fromString(idStr);
        Menu menu = this.menuRepository.getObject(id);

        menu.setName((String) requestBody.get("name"));
        menu.setDescription((String) requestBody.get("description"));
        String priceStr = (String) requestBody.get("price");
        menu.setPrice(Integer.parseInt(priceStr));
        menu.setCategory((String) requestBody.get("category"));
        
        // Update origin for traditional menu
        if (menu instanceof MenuImpl) {
            ((MenuImpl) menu).setOrigin((String) requestBody.get("origin"));
        }

        this.menuRepository.updateObject(menu);

        return menu.toHashMap();
    }

    public HashMap<String, Object> getMenu(Map<String, Object> requestBody) {
        String idStr = ((String) requestBody.get("id"));
        UUID id = UUID.fromString(idStr);
        Menu menu = this.menuRepository.getObject(id);
        if (menu != null) {
            return menu.toHashMap();
        }
        return null;
    }

    public HashMap<String, Object> getMenuById(UUID id) {
        Menu menu = this.menuRepository.getObject(id);
        return menu.toHashMap();
    }

    public List<HashMap<String, Object>> getAllMenu(Map<String, Object> requestBody) {
        List<Menu> menuList = this.menuRepository.getAllObject("menu_traditionalmenu");
        return transformListToHashMap(menuList);
    }

    public List<HashMap<String, Object>> transformListToHashMap(List<Menu> menuList) {
        List<HashMap<String, Object>> resultList = new ArrayList<HashMap<String, Object>>();
        for (Menu menu : menuList) {
            HashMap<String, Object> menuMap = menu.toHashMap();
            // Add origin to menu hash map for traditional menu
            if (menu instanceof MenuImpl) {
                menuMap.put("origin", ((MenuImpl) menu).getOrigin());
            }
            resultList.add(menuMap);
        }
        return resultList;
    }

    public List<HashMap<String, Object>> deleteMenu(Map<String, Object> requestBody) {
        String idStr = ((String) requestBody.get("id"));
        UUID id = UUID.fromString(idStr);
        this.menuRepository.deleteObject(id);
        return getAllMenu(requestBody);
    }

    public void createMenu() {
        // Implementation not needed - using the parameterized version
    }

    public void deleteMenu() {
        // Implementation not needed - using the parameterized version
    }

    public void getPrice() {
        // Implementation not needed - using the parameterized version
    }

    public Menu createMenu(Map<String, Object> requestBody, Map<String, Object> response) {
        Menu menu = createMenu(requestBody);
        response.put("menu", menu.toHashMap());
        return menu;
    }
}