package Restaurant.admindashboard.core;
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
import Restaurant.admindashboard.AdminDashboardFactory;
// import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class AdminDashboardServiceImpl extends AdminDashboardServiceComponent{



    public List<HashMap<String,Object>> saveAdminDashboard(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		AdminDashboard admindashboard = createAdminDashboard(vmjExchange.getPayload());
		this.admindashboardRepository.saveObject(admindashboard);
		return getAllAdminDashboard(vmjExchange.getPayload());
	}

    public AdminDashboard createAdminDashboard(Map<String, Object> requestBody){
		
		//to do: fix association attributes
		AdminDashboard adminDashboard = AdminDashboardFactory.createAdminDashboard(
			"Restaurant.admindashboard.core.AdminDashboardImpl",
		requestBody.get("id")
		);
		this.admindashboardRepository.saveObject(adminDashboard);
		return adminDashboard;
	}

    public AdminDashboard createAdminDashboard(Map<String, Object> requestBody, int id){
		
		//to do: fix association attributes
		
		AdminDashboard admindashboard = AdminDashboardFactory.createAdminDashboard("Restaurant.admindashboard.core.AdminDashboardImpl", id);
		return admindashboard;
	}

    public HashMap<String, Object> updateAdminDashboard(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("AdminDashboardId");
		int id = Integer.parseInt(idStr);
		AdminDashboard admindashboard = admindashboardRepository.getObject(id);
		
		
		this.admindashboardRepository.updateObject(admindashboard);
		
		//to do: fix association attributes
		
		return admindashboard.toHashMap();
		
	}

    public HashMap<String, Object> getAdminDashboard(Map<String, Object> requestBody){
		List<HashMap<String, Object>> admindashboardList = getAllAdminDashboard(requestBody);
		String idStr = ((String) requestBody.get("id"));
		int id = Integer.parseInt(idStr);
		for (HashMap<String, Object> admindashboard : admindashboardList){
			int record_id = ((Double) admindashboard.get("record_id")).intValue();
			if (record_id == id){
				return admindashboard;
			}
		}
		return null;
	}

	public HashMap<String, Object> getAdminDashboardById(int id){
		// String idStr = vmjExchange.getGETParam("AdminDashboardId"); 
		// id = Integer.parseInt(idStr);
		AdminDashboard admindashboard = this.admindashboardRepository.getObject(id);
		return admindashboard.toHashMap();
	}

    public List<HashMap<String,Object>> getAllAdminDashboard(Map<String, Object> requestBody){
		String table = (String) requestBody.get("table_name");
		List<AdminDashboard> List = this.admindashboardRepository.getAllObject(table);
		return transformListToHashMap(List);
	}

	public List<HashMap<String,Object>> transformListToHashMap(List<AdminDashboard> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deleteAdminDashboard(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get("id"));
		int id = Integer.parseInt(idStr);
		this.admindashboardRepository.deleteObject(id);
		return getAllAdminDashboard(requestBody);
	}

	public void manageEditMenu() {
		// TODO: implement this method
	}

	public AdminDashboard createAdminDashboard(Map<String, Object> requestBody, Map<String, Object> response){
		return null;
	}

	public List<HashMap<String,Object>> saveAdminDashboard(Map<String, Object> requestBody){
		return null;
	}


}
