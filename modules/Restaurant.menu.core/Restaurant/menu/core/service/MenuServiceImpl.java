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

	public List<HashMap<String,Object>> saveMenu(Map<String, Object> requestBody){
		return null;
	}



	@Override
    public List<HashMap<String,Object>> saveMenu(VMJExchange vmjExchange) {
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Menu menu = createMenu(vmjExchange.getPayload());
		this.menuRepository.saveObject(menu);
		return getAllMenu(vmjExchange.getPayload());
	}

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

    public Menu createMenu(Map<String, Object> requestBody, int id){
		String name = (String) requestBody.get("name");
		String desc = (String) requestBody.get("description");
		String priceStr = (String) requestBody.get("price");
		int price = Integer.parseInt(priceStr);
		String category = (String) requestBody.get("category");
		
		//to do: fix association attributes
		
		Menu menu = MenuFactory.createMenu("Restaurant.menu.core.MenuImpl", name, desc, price, category);
		return menu;
	}

    public HashMap<String, Object> updateMenu(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("MenuId");
		int id = Integer.parseInt(idStr);
		Menu menu =this.menuRepository.getObject(id);
		
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
    List<HashMap<String, Object>> menuList = getAllMenu(requestBody);
    String idStr = ((String) requestBody.get("id"));
    UUID id = UUID.fromString(idStr);
    for (HashMap<String,Object> menu : menuList){
        // Convert both to string and compare
        String record_id_str = String.valueOf(((Double) menu.get("record_id")).intValue());
        if (record_id_str.equals(idStr)){
            return menu;
        }
    }
    return null;
}

	public HashMap<String, Object> getMenuById(int id){
		Menu menu = this.menuRepository.getObject(id);
		return menu.toHashMap();
	}

    public List<HashMap<String,Object>> getAllMenu(Map<String, Object> requestBody){
		String table = (String) requestBody.get("table_name");
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
		String idStr = ((String) requestBody.get("id"));
		int id = Integer.parseInt(idStr);
		this.menuRepository.deleteObject(id);
		return getAllMenu(requestBody);
	}

	public void createMenu() {
		// TODO: implement this method
	}

	public void deleteMenu() {
		// TODO: implement this method
	}

	public void getPrice() {
		// TODO: implement this method
	}

	public Menu createMenu(Map<String, Object> requestBody, Map<String, Object> response){
		return null;
	}  

}