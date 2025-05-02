package Restaurant.promo.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="promo_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class PromoComponent implements Promo{
	@Id
	public UUID PromoId; 
	public UUID PromoId;
	public String eventName;
	public EDate eventStartDate;
	public EDate eventFinishDate;
	public Map<MenuImpl, int> menuPromo;
	protected String objectName = PromoComponent.class.getName();

	public PromoComponent() {

	} 

	public PromoComponent(
        UUID PromoId, String eventName, EDate eventStartDate, EDate eventFinishDate, Map<MenuImpl, int> menuPromo
    ) {
        this.PromoId = PromoId;
        this.eventName = eventName;
        this.eventStartDate = eventStartDate;
        this.eventFinishDate = eventFinishDate;
        this.menuPromo = menuPromo;
    }

	public abstract UUID getPromoId();
	public abstract void setPromoId(UUID PromoId);
	
	public abstract String getEventName();
	public abstract void setEventName(String eventName);
	
	public abstract EDate getEventStartDate();
	public abstract void setEventStartDate(EDate eventStartDate);
	
	public abstract EDate getEventFinishDate();
	public abstract void setEventFinishDate(EDate eventFinishDate);
	
	public abstract Map<MenuImpl, int> getMenuPromo();
	public abstract void setMenuPromo(Map<MenuImpl, int> menuPromo);
	
 
	public abstract void reducePrice();

	public abstract void calculatePrice();

	@Override
    public String toString() {
        return "{" +
            " PromoId='" + getPromoId() + "'" +
            " eventName='" + getEventName() + "'" +
            " eventStartDate='" + getEventStartDate() + "'" +
            " eventFinishDate='" + getEventFinishDate() + "'" +
            " menuPromo='" + getMenuPromo() + "'" +
            "}";
    }
	
}
