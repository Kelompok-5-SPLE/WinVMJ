package Restaurant.admindashboard.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface AdminDashboardResource {
    List<HashMap<String,Object>> saveAdminDashboard(VMJExchange vmjExchange);
    HashMap<String, Object> updateAdminDashboard(VMJExchange vmjExchange);
    HashMap<String, Object> getAdminDashboard(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllAdminDashboard(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteAdminDashboard(VMJExchange vmjExchange);
	HashMap<String, Object> createAdminDashboard(VMJExchange vmjExhange);
}
