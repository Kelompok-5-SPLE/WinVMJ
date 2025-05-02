package Restaurant.admindashboard.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class AdminDashboardDecorator extends AdminDashboardComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected AdminDashboardComponent record;

	public AdminDashboardDecorator () {
		super();
		this.record = record;
		this.AdminDashboardId =  AdminDashboardId.randomUUID();
	}
		
	public AdminDashboardDecorator (AdminDashboardComponent record) {
		this.AdminDashboardId =  AdminDashboardId.randomUUID();
		this.record = record;
	}

	public AdminDashboardDecorator (UUID AdminDashboardId, AdminDashboardComponent record) {
		this.AdminDashboardId =  AdminDashboardId;
		this.record = record;
	}
	
	public AdminDashboardDecorator (AdminDashboardComponent record, String objectName) {
		this.AdminDashboardId =  AdminDashboardId.randomUUID();
		this.record = record;	
		this.objectName=objectName;
	}

	public AdminDashboardDecorator() { }


	public void manageEditMenu() {
		return record.manageEditMenu();
	}

	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
