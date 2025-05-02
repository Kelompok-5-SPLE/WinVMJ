package Restaurant.payment.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class PaymentMethodResourceComponent implements PaymentMethodResource{
	
	public PaymentMethodResourceComponent() { }
 
    public abstract PaymentMethod createPaymentMethod(VMJExchange vmjExchange);    
	public abstract HashMap<String, Object> updatePaymentMethod(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getPaymentMethod(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllPaymentMethod(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> deletePaymentMethod(VMJExchange vmjExchange);

	public abstract void calculateTotal();

	public abstract void processPayment();
}
