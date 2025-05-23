package Restaurant.menu.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface MenuResource {
    HashMap<String,Object> createMenu(VMJExchange vmjExchange);
    HashMap<String, Object> updateMenu(VMJExchange vmjExchange);
    HashMap<String, Object> getMenu(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllMenu(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteMenu(VMJExchange vmjExchange);
}
