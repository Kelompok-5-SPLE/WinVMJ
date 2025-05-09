package Restaurant.admindashboard.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class AdminDashboardResourceComponent implements AdminDashboardResource{
	
	public AdminDashboardResourceComponent() { }
 
    public abstract AdminDashboard createAdminDashboard(VMJExchange vmjExchange);    
	public abstract HashMap<String, Object> updateAdminDashboard(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getAdminDashboard(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllAdminDashboard(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> deleteAdminDashboard(VMJExchange vmjExchange);

	public abstract void manageEditMenu();
}
