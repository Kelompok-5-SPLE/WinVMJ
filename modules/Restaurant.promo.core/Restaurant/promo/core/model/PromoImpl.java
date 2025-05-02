package Restaurant.promo.core;

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


@Entity(name="promo_impl")
@Table(name="promo_impl")
public class PromoImpl extends PromoComponent {

	public PromoImpl(UUID PromoId, String eventName, EDate eventStartDate, EDate eventFinishDate, Map<MenuImpl, int> menuPromo) {
		this.PromoId = PromoId;
		this.eventName = eventName;
		this.eventStartDate = eventStartDate;
		this.eventFinishDate = eventFinishDate;
		this.menuPromo = menuPromo;
	}

	public PromoImpl(UUID PromoId, String eventName, EDate eventStartDate, EDate eventFinishDate, Map<MenuImpl, int> menuPromo) {
		this.PromoId =  PromoId.randomUUID();;
		this.PromoId = PromoId;
		this.eventName = eventName;
		this.eventStartDate = eventStartDate;
		this.eventFinishDate = eventFinishDate;
		this.menuPromo = menuPromo;
	}

	public PromoImpl() { }


	public void reducePrice() {
		// TODO: implement this method
	}

	public void calculatePrice() {
		// TODO: implement this method
	}
	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> promoMap = new HashMap<String,Object>();
		promoMap.put("PromoId",getPromoId());
		promoMap.put("eventName",getEventName());
		promoMap.put("eventStartDate",getEventStartDate());
		promoMap.put("eventFinishDate",getEventFinishDate());
		promoMap.put("menuPromo",getMenuPromo());

        return promoMap;
    }

}
