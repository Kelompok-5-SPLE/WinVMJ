package Restaurant.payment.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public abstract class PaymentMethodServiceDecorator extends PaymentMethodServiceComponent{
	protected PaymentMethodServiceComponent record;

    public PaymentMethodServiceDecorator(PaymentMethodServiceComponent record) {
        this.record = record;
    }

	public PaymentMethodImpl createPaymentMethod(Map<String, Object> requestBody){
		return record.createPaymentMethod(requestBody);
	}

    public PaymentMethod createPaymentMethod(Map<String, Object> requestBody, Map<String, Object> response){
		return record.createPaymentMethod(requestBody, response);
	}

	public HashMap<String, Object> getPaymentMethod(Map<String, Object> requestBody){
		return record.getPaymentMethod(requestBody);
	}

	public List<HashMap<String,Object>> getAllPaymentMethod(Map<String, Object> requestBody){
		return record.getAllPaymentMethod(requestBody);
	}

    public List<HashMap<String,Object>> savePaymentMethod(VMJExchange vmjExchange){
		return record.savePaymentMethod(vmjExchange);
	}

    public HashMap<String, Object> updatePaymentMethod(Map<String, Object> requestBody){
		return record.updatePaymentMethod(requestBody);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<PaymentMethod> List){
		return record.transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> deletePaymentMethod(Map<String, Object> requestBody){
		return record.deletePaymentMethod(requestBody);
	}

	public HashMap<String, Object> getPaymentMethodById(int id){
        return record.getPaymentMethodById(id);
    }

	public void calculateTotal() {
		return record.calculateTotal();
	}

	public void processPayment() {
		return record.processPayment();
	}
}
