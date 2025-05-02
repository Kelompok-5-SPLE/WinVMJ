package Restaurant.admindashboard.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface AdminDashboardService {
	AdminDashboard createAdminDashboard(Map<String, Object> requestBody);
	AdminDashboard createAdminDashboard(Map<String, Object> requestBody, Map<String, Object> response);
	HashMap<String, Object> getAdminDashboard(Map<String, Object> requestBody);
    List<HashMap<String,Object>> saveAdminDashboard(Map<String, Object> requestBody);
    HashMap<String, Object> updateAdminDashboard(Map<String, Object> requestBody);
    HashMap<String, Object> getAdminDashboardById(int id);
    List<HashMap<String,Object>> getAllAdminDashboard(Map<String, Object> requestBody);
    List<HashMap<String,Object>> deleteAdminDashboard(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<Disbursement> List);
}
