package Restaurant.admindashboard.core;

import java.lang.Math;
import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity(name="admindashboard_impl")
@Table(name="admindashboard_impl")
public class AdminDashboardImpl extends AdminDashboardComponent {

	public AdminDashboardImpl(UUID AdminDashboardId) {
		this.AdminDashboardId = AdminDashboardId;
	}

	public AdminDashboardImpl(UUID AdminDashboardId) {
		this.AdminDashboardId =  AdminDashboardId.randomUUID();;
		this.AdminDashboardId = AdminDashboardId;
	}

	public AdminDashboardImpl() { }


	public void manageEditMenu() {
		// TODO: implement this method
	}
	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> admindashboardMap = new HashMap<String,Object>();
		admindashboardMap.put("AdminDashboardId",getAdminDashboardId());

        return admindashboardMap;
    }

}
