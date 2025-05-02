package Restaurant.promo.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface PromoResource {
    List<HashMap<String,Object>> savePromo(VMJExchange vmjExchange);
    HashMap<String, Object> updatePromo(VMJExchange vmjExchange);
    HashMap<String, Object> getPromo(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllPromo(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deletePromo(VMJExchange vmjExchange);
	HashMap<String, Object> createPromo(VMJExchange vmjExhange);
}
