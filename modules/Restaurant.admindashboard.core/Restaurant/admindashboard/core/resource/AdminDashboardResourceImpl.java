package Restaurant.admindashboard.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import Restaurant.admindashboard.AdminDashboardFactory;
//import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class AdminDashboardResourceImpl extends AdminDashboardResourceComponent{
	
	private AdminDashboardServiceImpl admindashboardServiceImpl = new AdminDashboardServiceImpl();

	// @Restriced(permission = "")
    @Route(url="call/admindashboard")
    public HashMap<String,Object> createadmindashboard(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			AdminDashboard result = admindashboardServiceImpl.createAdminDashboard(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    // @Restriced(permission = "")
    @Route(url="call/admindashboard/update")
    public HashMap<String, Object> updateAdminDashboard(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return admindashboardServiceImpl.updateAdminDashboard(requestBody);
		
	}

	// @Restriced(permission = "")
    @Route(url="call/admindashboard/detail")
    public HashMap<String, Object> getAdminDashboard(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return admindashboardServiceImpl.getAdminDashboard(requestBody);
	}

	// @Restriced(permission = "")
    @Route(url="call/admindashboard/list")
    public List<HashMap<String,Object>> getAllAdminDashboard(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return admindashboardServiceImpl.getAllAdminDashboard(requestBody);
	}

    
	// @Restriced(permission = "")
    @Route(url="call/admindashboard/delete")
    public List<HashMap<String,Object>> deleteAdminDashboard(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return admindashboardServiceImpl.deleteAdminDashboard(requestBody);
	}

	public void manageEditMenu() {
		// TODO: implement this method
	}
}
