package Restaurant.menu.spicymenu;

import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;

import Restaurant.menu.MenuFactory;
import Restaurant.menu.core.*;
import Restaurant.menu.spicymenu.MenuImpl;
import Restaurant.menu.spicymenu.MenuServiceImpl;

public class MenuResourceImpl extends MenuResourceDecorator {
    private MenuServiceImpl menuServiceImpl;

    public MenuResourceImpl(MenuResourceComponent recordResource, MenuServiceComponent recordService) {
        super(recordResource);
        this.menuServiceImpl = new MenuServiceImpl(recordService);
    }
    
    // @Restriced(permission = "")
    @Route(url="call/spicymenu")
    public HashMap<String,Object> menu(VMJExchange vmjExchange) {
        if (vmjExchange.getHttpMethod().equals("POST")) {
            Map<String, Object> requestBody = vmjExchange.getPayload();
            Menu result = menuServiceImpl.createMenu(requestBody);
            return result.toHashMap();
        }
        throw new NotFoundException("Route tidak ditemukan");
    }

    // @Restriced(permission = "")
    @Route(url="call/spicymenu/save")
    public List<HashMap<String,Object>> saveMenu(VMJExchange vmjExchange) {
        if (vmjExchange.getHttpMethod().equals("POST")) {
            Map<String, Object> requestBody = vmjExchange.getPayload();
            Menu result = menuServiceImpl.createMenu(requestBody);
            return List.of(result.toHashMap());

        }
        throw new NotFoundException("Route tidak ditemukan");
    }
    
    public HashMap<String,Object> createMenu(VMJExchange vmjExchange) {
        if (vmjExchange.getHttpMethod().equals("POST")) {
            Map<String, Object> requestBody = vmjExchange.getPayload();
            Menu result = menuServiceImpl.createMenu(requestBody);
            return result.toHashMap();
        }
        throw new NotFoundException("Route tidak ditemukan");
    }

    public Menu createMenu(VMJExchange vmjExchange, int id) {
        if (vmjExchange.getHttpMethod().equals("POST")) {
            Map<String, Object> requestBody = vmjExchange.getPayload();
            Menu result = menuServiceImpl.createMenu(requestBody, id);
            return result;
        }
        throw new NotFoundException("Route tidak ditemukan");
    }

    // @Restriced(permission = "")
    @Route(url="call/spicymenu/update")
    public HashMap<String, Object> updateMenu(VMJExchange vmjExchange) {
        Map<String, Object> requestBody = vmjExchange.getPayload();
        if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
            return null;
        }
        return menuServiceImpl.updateMenu(requestBody);
        
    }

    // @Restriced(permission = "")
    @Route(url="call/spicymenu/detail")
    public HashMap<String, Object> getMenu(VMJExchange vmjExchange) {
        Map<String, Object> requestBody = vmjExchange.getPayload();
        return menuServiceImpl.getMenu(requestBody);
    }

    // @Restriced(permission = "")
    @Route(url="call/spicymenu/list")
    public List<HashMap<String,Object>> getAllMenu(VMJExchange vmjExchange) {
        Map<String, Object> requestBody = vmjExchange.getPayload();
        return menuServiceImpl.getAllMenu(requestBody);
    }

    // @Restriced(permission = "")
    @Route(url="call/spicymenu/delete")
    public List<HashMap<String,Object>> deleteMenu(VMJExchange vmjExchange) {
        Map<String, Object> requestBody = vmjExchange.getPayload();
        if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
            return null;
        }
        return menuServiceImpl.deleteMenu(requestBody);
    }
}
