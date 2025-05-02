package Restaurant.admindashboard.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public abstract class AdminDashboardServiceDecorator extends AdminDashboardServiceComponent{
	protected AdminDashboardServiceComponent record;

    public AdminDashboardServiceDecorator(AdminDashboardServiceComponent record) {
        this.record = record;
    }

	public AdminDashboardImpl createAdminDashboard(Map<String, Object> requestBody){
		return record.createAdminDashboard(requestBody);
	}

    public AdminDashboard createAdminDashboard(Map<String, Object> requestBody, Map<String, Object> response){
		return record.createAdminDashboard(requestBody, response);
	}

	public HashMap<String, Object> getAdminDashboard(Map<String, Object> requestBody){
		return record.getAdminDashboard(requestBody);
	}

	public List<HashMap<String,Object>> getAllAdminDashboard(Map<String, Object> requestBody){
		return record.getAllAdminDashboard(requestBody);
	}

    public List<HashMap<String,Object>> saveAdminDashboard(VMJExchange vmjExchange){
		return record.saveAdminDashboard(vmjExchange);
	}

    public HashMap<String, Object> updateAdminDashboard(Map<String, Object> requestBody){
		return record.updateAdminDashboard(requestBody);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<AdminDashboard> List){
		return record.transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> deleteAdminDashboard(Map<String, Object> requestBody){
		return record.deleteAdminDashboard(requestBody);
	}

	public HashMap<String, Object> getAdminDashboardById(int id){
        return record.getAdminDashboardById(id);
    }

	public void manageEditMenu() {
		return record.manageEditMenu();
	}
}
