package Restaurant.promo.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public abstract class PromoServiceDecorator extends PromoServiceComponent{
	protected PromoServiceComponent record;

    public PromoServiceDecorator(PromoServiceComponent record) {
        this.record = record;
    }

	public PromoImpl createPromo(Map<String, Object> requestBody){
		return record.createPromo(requestBody);
	}

    public Promo createPromo(Map<String, Object> requestBody, Map<String, Object> response){
		return record.createPromo(requestBody, response);
	}

	public HashMap<String, Object> getPromo(Map<String, Object> requestBody){
		return record.getPromo(requestBody);
	}

	public List<HashMap<String,Object>> getAllPromo(Map<String, Object> requestBody){
		return record.getAllPromo(requestBody);
	}

    public List<HashMap<String,Object>> savePromo(VMJExchange vmjExchange){
		return record.savePromo(vmjExchange);
	}

    public HashMap<String, Object> updatePromo(Map<String, Object> requestBody){
		return record.updatePromo(requestBody);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Promo> List){
		return record.transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> deletePromo(Map<String, Object> requestBody){
		return record.deletePromo(requestBody);
	}

	public HashMap<String, Object> getPromoById(int id){
        return record.getPromoById(id);
    }

	public void reducePrice() {
		return record.reducePrice();
	}

	public void calculatePrice() {
		return record.calculatePrice();
	}
}
