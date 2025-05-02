package Restaurant.promo.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface PromoService {
	Promo createPromo(Map<String, Object> requestBody);
	Promo createPromo(Map<String, Object> requestBody, Map<String, Object> response);
	HashMap<String, Object> getPromo(Map<String, Object> requestBody);
    List<HashMap<String,Object>> savePromo(Map<String, Object> requestBody);
    HashMap<String, Object> updatePromo(Map<String, Object> requestBody);
    HashMap<String, Object> getPromoById(int id);
    List<HashMap<String,Object>> getAllPromo(Map<String, Object> requestBody);
    List<HashMap<String,Object>> deletePromo(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<Disbursement> List);
}
