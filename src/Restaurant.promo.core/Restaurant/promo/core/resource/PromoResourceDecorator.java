package Restaurant.promo.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

public abstract class PromoResourceDecorator extends PromoResourceComponent{
	protected PromoResourceComponent record;

    public PromoResourceDecorator(PromoResourceComponent record) {
        this.record = record;
    }

    public Promo createPromo(VMJExchange vmjExchange){
		return record.createPromo(vmjExchange);
	}

    public HashMap<String, Object> updatePromo(VMJExchange vmjExchange){
		return record.updatePromo(vmjExchange);
	}

    public HashMap<String, Object> getPromo(VMJExchange vmjExchange){
		return record.getPromo(vmjExchange);
	}

    public List<HashMap<String,Object>> getAllPromo(VMJExchange vmjExchange){
		return record.getAllPromo(vmjExchange);
	}

    public List<HashMap<String,Object>> deletePromo(VMJExchange vmjExchange){
		return record.deletePromo(vmjExchange);
	}

	public void reducePrice() {
		return record.reducePrice();
	}

	public void calculatePrice() {
		return record.calculatePrice();
	}
}
