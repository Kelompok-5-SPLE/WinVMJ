package Restaurant.admindashboard.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class AdminDashboardServiceComponent implements AdminDashboardService{
	protected RepositoryUtil<AdminDashboard> Repository;

    public AdminDashboardServiceComponent(){
        this.Repository = new RepositoryUtil<AdminDashboard>(Restaurant.admindashboard.core.AdminDashboardComponent.class);
    }	

    public abstract List<HashMap<String,Object>> saveAdminDashboard(VMJExchange vmjExchange);
    public abstract AdminDashboard createAdminDashboard(Map<String, Object> requestBodye);
	public abstract AdminDashboard createAdminDashboard(Map<String, Object> requestBody, Map<String, Object> response);    
	public abstract HashMap<String, Object> updateAdminDashboard(Map<String, Object> requestBody);
    public abstract HashMap<String, Object> getAdminDashboard(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> getAllAdminDashboard(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<AdminDashboard> List);
    public abstract List<HashMap<String,Object>> deleteAdminDashboard(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> getAdminDashboardById(int id);

	public abstract void manageEditMenu();
}
