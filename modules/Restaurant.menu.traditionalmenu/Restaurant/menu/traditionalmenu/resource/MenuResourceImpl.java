package Restaurant.menu.traditionalmenu;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import vmj.routing.route.exceptions.*;

import Restaurant.menu.core.*;

public class MenuResourceImpl extends MenuResourceDecorator {

    private MenuServiceImpl menuServiceImpl;

    public MenuResourceImpl(MenuResourceComponent recordResource, MenuServiceComponent recordService) {
        super(recordResource);
        this.menuServiceImpl = new MenuServiceImpl(recordService);
    }

    // @Restricted(permission = "")
    @Route(url = "call/traditionalmenu/save")
    public List<HashMap<String, Object>> saveMenu(VMJExchange vmjExchange) {
        if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
            return null;
        }
        String email = vmjExchange.getAuthPayload().getEmail();
        List<HashMap<String, Object>> menu = menuServiceImpl.saveMenu(vmjExchange);
        return menu;
    }

    @Route(url = "call/traditionalmenu/create")
    public Menu createMenu(VMJExchange vmjExchange) {
        if (vmjExchange.getHttpMethod().equals("POST")) {
            Map<String, Object> requestBody = vmjExchange.getPayload(); 
            Menu result = menuServiceImpl.createMenu(requestBody);
            return result;
        }
        throw new NotFoundException("Route tidak ditemukan");
    }

    // Removed id parameter route and replaced with a general create route that generates UUID internally
    @Route(url = "call/traditionalmenu/create-with-id")
    public Menu createMenuWithId(VMJExchange vmjExchange) {
        if (vmjExchange.getHttpMethod().equals("POST")) {
            Map<String, Object> requestBody = vmjExchange.getPayload(); 
            Menu result = menuServiceImpl.createMenuWithId(requestBody);
            return result;
        }
        throw new NotFoundException("Route tidak ditemukan");
    }

    // @Restricted(permission = "")
    @Route(url = "call/traditionalmenu/update")
    public HashMap<String, Object> updateMenu(VMJExchange vmjExchange) {
        Map<String, Object> requestBody = vmjExchange.getPayload(); 
        if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
            return null;
        }
        return menuServiceImpl.updateMenu(requestBody);
    }

    // @Restricted(permission = "")
    @Route(url = "call/traditionalmenu/detail")
    public HashMap<String, Object> getMenu(VMJExchange vmjExchange) {
        Map<String, Object> requestBody = vmjExchange.getPayload(); 
        return menuServiceImpl.getMenu(requestBody);
    }

    // @Restricted(permission = "")
    @Route(url = "call/traditionalmenu/list")
    public List<HashMap<String, Object>> getAllMenu(VMJExchange vmjExchange) {
        Map<String, Object> requestBody = vmjExchange.getPayload(); 
        return menuServiceImpl.getAllMenu(requestBody);
    }

    // @Restricted(permission = "")
    @Route(url = "call/traditionalmenu/delete")
    public List<HashMap<String, Object>> deleteMenu(VMJExchange vmjExchange) {
        Map<String, Object> requestBody = vmjExchange.getPayload(); 
        if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
            return null;
        }
        return menuServiceImpl.deleteMenu(requestBody);
    }
}