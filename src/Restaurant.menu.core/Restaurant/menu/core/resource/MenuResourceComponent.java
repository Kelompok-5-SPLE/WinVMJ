package Restaurant.menu.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class MenuResourceComponent implements MenuResource{
	
	public MenuResourceComponent() { }
 
    public abstract List<HashMap<String,Object>> saveMenu(VMJExchange vmjExchange);
    public abstract Menu createMenu(VMJExchange vmjExchange);
	public abstract Menu createMenu(VMJExchange vmjExchange, int id);    
	public abstract HashMap<String, Object> updateMenu(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getMenu(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllMenu(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> deleteMenu(VMJExchange vmjExchange);

}
