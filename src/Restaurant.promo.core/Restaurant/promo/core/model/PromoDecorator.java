package Restaurant.promo.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class PromoDecorator extends PromoComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected PromoComponent record;

	public PromoDecorator () {
		super();
		this.record = record;
		this.PromoId =  PromoId.randomUUID();
		
	public PromoDecorator (PromoComponent record) {
		this.PromoId =  PromoId.randomUUID();
		this.record = record;
	}

	public PromoDecorator (UUID PromoId, PromoComponent record) {
		this.PromoId =  PromoId;
		this.record = record;
	}
	
	public PromoDecorator (PromoComponent record, String objectName) {
		this.PromoId =  PromoId.randomUUID();
		this.record = record;	
		this.objectName=objectName;
	}

	public PromoDecorator() { }


	public void reducePrice() {
		return record.reducePrice();
	}

	public void calculatePrice() {
		return record.calculatePrice();
	}

	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
