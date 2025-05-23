package Restaurant.menu.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class MenuServiceComponent implements MenuService{
	protected RepositoryUtil<Menu> menuRepository;

    public MenuServiceComponent(){
        this.menuRepository = new RepositoryUtil<Menu>(Restaurant.menu.core.MenuComponent.class);
    }	

    public abstract Menu createMenu(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> updateMenu(Map<String, Object> requestBody);
    public abstract HashMap<String, Object> getMenu(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> getAllMenu(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<Menu> List);
    public abstract List<HashMap<String,Object>> deleteMenu(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> getMenuById(UUID id);
}