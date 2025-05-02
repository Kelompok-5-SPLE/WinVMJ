package Restaurant.admindashboard.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="admindashboard_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class AdminDashboardComponent implements AdminDashboard{
	@Id
	public UUID AdminDashboardId; 
	public UUID AdminDashboardId;
	protected String objectName = AdminDashboardComponent.class.getName();

	public AdminDashboardComponent() {

	} 

	public AdminDashboardComponent(
        UUID AdminDashboardId
    ) {
        this.AdminDashboardId = AdminDashboardId;
    }

	public abstract UUID getAdminDashboardId();
	public abstract void setAdminDashboardId(UUID AdminDashboardId);
	
 
	public abstract void manageEditMenu();

	@Override
    public String toString() {
        return "{" +
            " AdminDashboardId='" + getAdminDashboardId() + "'" +
            "}";
    }
	
}
