package Restaurant.admindashboard.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

public interface AdminDashboard {
	public UUID getAdminDashboardId();
	public void setAdminDashboardId(UUID AdminDashboardId);
	public void manageEditMenu();
	HashMap<String, Object> toHashMap();
}
