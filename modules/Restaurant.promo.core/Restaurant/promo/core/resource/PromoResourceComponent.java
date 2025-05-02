package Restaurant.promo.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class PromoResourceComponent implements PromoResource{
	
	public PromoResourceComponent() { }
 
    public abstract Promo createPromo(VMJExchange vmjExchange);    
	public abstract HashMap<String, Object> updatePromo(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getPromo(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllPromo(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> deletePromo(VMJExchange vmjExchange);

	public abstract void reducePrice();

	public abstract void calculatePrice();
}
