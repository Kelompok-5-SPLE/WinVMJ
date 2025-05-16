package Restaurant.menu.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface MenuService {
	Menu createMenu(Map<String, Object> requestBody);
	Menu createMenu(Map<String, Object> requestBody, Map<String, Object> response);
	HashMap<String, Object> getMenu(Map<String, Object> requestBody);
    List<HashMap<String,Object>> saveMenu(Map<String, Object> requestBody);
    HashMap<String, Object> updateMenu(Map<String, Object> requestBody);
    HashMap<String, Object> getMenuById(int id);
    List<HashMap<String,Object>> getAllMenu(Map<String, Object> requestBody);
    List<HashMap<String,Object>> deleteMenu(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<Menu> List);
}
