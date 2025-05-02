package Restaurant.promo.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class PromoServiceComponent implements PromoService{
	protected RepositoryUtil<Promo> Repository;

    public PromoServiceComponent(){
        this.Repository = new RepositoryUtil<Promo>(Restaurant.promo.core.PromoComponent.class);
    }	

    public abstract List<HashMap<String,Object>> savePromo(VMJExchange vmjExchange);
    public abstract Promo createPromo(Map<String, Object> requestBodye);
	public abstract Promo createPromo(Map<String, Object> requestBody, Map<String, Object> response);    
	public abstract HashMap<String, Object> updatePromo(Map<String, Object> requestBody);
    public abstract HashMap<String, Object> getPromo(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> getAllPromo(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<Promo> List);
    public abstract List<HashMap<String,Object>> deletePromo(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> getPromoById(int id);

	public abstract void reducePrice();

	public abstract void calculatePrice();
}
