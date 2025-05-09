package Restaurant.payment.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface PaymentMethodService {
	PaymentMethod createPaymentMethod(Map<String, Object> requestBody);
	PaymentMethod createPaymentMethod(Map<String, Object> requestBody, Map<String, Object> response);
	HashMap<String, Object> getPaymentMethod(Map<String, Object> requestBody);
    List<HashMap<String,Object>> savePaymentMethod(Map<String, Object> requestBody);
    HashMap<String, Object> updatePaymentMethod(Map<String, Object> requestBody);
    HashMap<String, Object> getPaymentMethodById(int id);
    List<HashMap<String,Object>> getAllPaymentMethod(Map<String, Object> requestBody);
    List<HashMap<String,Object>> deletePaymentMethod(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<Disbursement> List);
}
