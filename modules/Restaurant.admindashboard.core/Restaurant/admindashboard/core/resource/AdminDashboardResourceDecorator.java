package Restaurant.admindashboard.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

public abstract class AdminDashboardResourceDecorator extends AdminDashboardResourceComponent{
	protected AdminDashboardResourceComponent record;

    public AdminDashboardResourceDecorator(AdminDashboardResourceComponent record) {
        this.record = record;
    }

    public AdminDashboard createAdminDashboard(VMJExchange vmjExchange){
		return record.createAdminDashboard(vmjExchange);
	}

    public HashMap<String, Object> updateAdminDashboard(VMJExchange vmjExchange){
		return record.updateAdminDashboard(vmjExchange);
	}

    public HashMap<String, Object> getAdminDashboard(VMJExchange vmjExchange){
		return record.getAdminDashboard(vmjExchange);
	}

    public List<HashMap<String,Object>> getAllAdminDashboard(VMJExchange vmjExchange){
		return record.getAllAdminDashboard(vmjExchange);
	}

    public List<HashMap<String,Object>> deleteAdminDashboard(VMJExchange vmjExchange){
		return record.deleteAdminDashboard(vmjExchange);
	}

	public void manageEditMenu() {
		return record.manageEditMenu();
	}
}
