package Restaurant.payment.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface PaymentMethodResource {
    List<HashMap<String,Object>> savePaymentMethod(VMJExchange vmjExchange);
    HashMap<String, Object> updatePaymentMethod(VMJExchange vmjExchange);
    HashMap<String, Object> getPaymentMethod(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllPaymentMethod(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deletePaymentMethod(VMJExchange vmjExchange);
	HashMap<String, Object> createPaymentMethod(VMJExchange vmjExhange);
}
