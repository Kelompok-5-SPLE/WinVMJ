package Restaurant.promo.core;
import java.util.*;
import com.google.gson.Gson;
import java.util.*;
import java.util.logging.Logger;
import java.io.File;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import Restaurant.promo.PromoFactory;
import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class PromoServiceImpl extends PromoServiceComponent{

    public List<HashMap<String,Object>> savePromo(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Promo promo = createPromo(vmjExchange);
		promoRepository.saveObject(promo);
		return getAllPromo(vmjExchange);
	}

    public Promo createPromo(Map<String, Object> requestBody){
		String eventName = (String) requestBody.get("eventName");
		
		//to do: fix association attributes
		Promo Promo = PromoFactory.createPromo(
			"Restaurant.promo.core.PromoImpl",
		PromoId
		, eventName
		, eventStartDate
		, eventFinishDate
		, menuPromo
		);
		Repository.saveObject(promo);
		return promo;
	}

    public Promo createPromo(Map<String, Object> requestBody, int id){
		String eventName = (String) vmjExchange.getRequestBodyForm("eventName");
		
		//to do: fix association attributes
		
		Promo promo = PromoFactory.createPromo("Restaurant.promo.core.PromoImpl", PromoId, eventName, eventStartDate, eventFinishDate, menuPromo);
		return promo;
	}

    public HashMap<String, Object> updatePromo(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("PromoId");
		int id = Integer.parseInt(idStr);
		Promo promo = Repository.getObject(id);
		
		promo.setEventName((String) requestBody.get("eventName"));
		
		Repository.updateObject(promo);
		
		//to do: fix association attributes
		
		return promo.toHashMap();
		
	}

    public HashMap<String, Object> getPromo(Map<String, Object> requestBody){
		List<HashMap<String, Object>> promoList = getAllPromo("promo_impl");
		for (HashMap<String, Object> promo : promoList){
			int record_id = ((Double) promo.get("record_id")).intValue();
			if (record_id == id){
				return promo;
			}
		}
		return null;
	}

	public HashMap<String, Object> getPromoById(int id){
		String idStr = vmjExchange.getGETParam("PromoId"); 
		int id = Integer.parseInt(idStr);
		Promo promo = promoRepository.getObject(id);
		return promo.toHashMap();
	}

    public List<HashMap<String,Object>> getAllPromo(Map<String, Object> requestBody){
		String table = (String) requestBody.get("table_name");
		List<Promo> List = Repository.getAllObject(table);
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Promo> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deletePromo(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get("id"));
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAllPromo(requestBody);
	}

	public void reducePrice() {
		// TODO: implement this method
	}

	public void calculatePrice() {
		// TODO: implement this method
	}
}
