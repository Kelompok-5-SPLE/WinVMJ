package Restaurant.promo.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import Restaurant.promo.PromoFactory;
//import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class PromoResourceImpl extends PromoResourceComponent{
	
	private PromoServiceImpl promoServiceImpl = new PromoServiceImpl();

	// @Restriced(permission = "")
    @Route(url="call/promo")
    public HashMap<String,Object> createpromo(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Promo result = promoServiceImpl.createPromo(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    // @Restriced(permission = "")
    @Route(url="call/promo/update")
    public HashMap<String, Object> updatePromo(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return promoServiceImpl.updatePromo(requestBody);
		
	}

	// @Restriced(permission = "")
    @Route(url="call/promo/detail")
    public HashMap<String, Object> getPromo(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return promoServiceImpl.getPromo(requestBody);
	}

	// @Restriced(permission = "")
    @Route(url="call/promo/list")
    public List<HashMap<String,Object>> getAllPromo(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return promoServiceImpl.getAllPromo(requestBody);
	}

    
	// @Restriced(permission = "")
    @Route(url="call/promo/delete")
    public List<HashMap<String,Object>> deletePromo(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return promoServiceImpl.deletePromo(requestBody);
	}

	public void reducePrice() {
		// TODO: implement this method
	}

	public void calculatePrice() {
		// TODO: implement this method
	}
}
