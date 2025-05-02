package Restaurant.payment.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

public abstract class PaymentMethodResourceDecorator extends PaymentMethodResourceComponent{
	protected PaymentMethodResourceComponent record;

    public PaymentMethodResourceDecorator(PaymentMethodResourceComponent record) {
        this.record = record;
    }

    public PaymentMethod createPaymentMethod(VMJExchange vmjExchange){
		return record.createPaymentMethod(vmjExchange);
	}

    public HashMap<String, Object> updatePaymentMethod(VMJExchange vmjExchange){
		return record.updatePaymentMethod(vmjExchange);
	}

    public HashMap<String, Object> getPaymentMethod(VMJExchange vmjExchange){
		return record.getPaymentMethod(vmjExchange);
	}

    public List<HashMap<String,Object>> getAllPaymentMethod(VMJExchange vmjExchange){
		return record.getAllPaymentMethod(vmjExchange);
	}

    public List<HashMap<String,Object>> deletePaymentMethod(VMJExchange vmjExchange){
		return record.deletePaymentMethod(vmjExchange);
	}

	public void calculateTotal() {
		return record.calculateTotal();
	}

	public void processPayment() {
		return record.processPayment();
	}
}
