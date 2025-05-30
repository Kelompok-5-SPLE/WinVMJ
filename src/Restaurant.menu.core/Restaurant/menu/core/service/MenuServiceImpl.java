package Restaurant.menu.core;
import java.util.*;

import com.google.gson.Gson;
import java.util.*;
import java.util.logging.Logger;
import java.io.File;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import Restaurant.menu.MenuFactory;
// import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class MenuServiceImpl extends MenuServiceComponent{

    public Menu createMenu(Map<String, Object> requestBody){
		String name = (String) requestBody.get("name");
		String desc = (String) requestBody.get("description");
		String priceStr = (String) requestBody.get("price");
		int price = Integer.parseInt(priceStr);
		String category = (String) requestBody.get("category");
		
		//to do: fix association attributes
		Menu menu = MenuFactory.createMenu(
			"Restaurant.menu.core.MenuImpl",
		name
		, desc
		, price
		, category
		);
		this.menuRepository.saveObject(menu);
		return menu;
	}

    public HashMap<String, Object> updateMenu(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("menuId");
		
		UUID menuId = UUID.fromString(idStr);
		Menu menu = this.menuRepository.getObject(menuId);
		
		menu.setName((String) requestBody.get("name"));
		menu.setDescription((String) requestBody.get("description"));
		String priceStr = (String) requestBody.get("price");
		menu.setPrice(Integer.parseInt(priceStr));
		menu.setCategory((String) requestBody.get("category"));
		
		this.menuRepository.updateObject(menu);
		
		//to do: fix association attributes
		
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
		Menu menu = this.menuRepository.getObject(id);
		return menu.toHashMap();
	}

    public List<HashMap<String,Object>> getAllMenu(){
		String table = "menu_impl";
		List<Menu> List =this.menuRepository.getAllObject(table);
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
		UUID menuId = UUID.fromString(idStr);
		this.menuRepository.deleteObject(menuId);
		return getAllMenu();
	}

}