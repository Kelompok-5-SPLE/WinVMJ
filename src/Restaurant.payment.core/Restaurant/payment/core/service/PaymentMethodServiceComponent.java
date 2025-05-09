package Restaurant.payment.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class PaymentMethodServiceComponent implements PaymentMethodService{
	protected RepositoryUtil<PaymentMethod> Repository;

    public PaymentMethodServiceComponent(){
        this.Repository = new RepositoryUtil<PaymentMethod>(Restaurant.payment.core.PaymentMethodComponent.class);
    }	

    public abstract List<HashMap<String,Object>> savePaymentMethod(VMJExchange vmjExchange);
    public abstract PaymentMethod createPaymentMethod(Map<String, Object> requestBodye);
	public abstract PaymentMethod createPaymentMethod(Map<String, Object> requestBody, Map<String, Object> response);    
	public abstract HashMap<String, Object> updatePaymentMethod(Map<String, Object> requestBody);
    public abstract HashMap<String, Object> getPaymentMethod(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> getAllPaymentMethod(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<PaymentMethod> List);
    public abstract List<HashMap<String,Object>> deletePaymentMethod(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> getPaymentMethodById(int id);

	public abstract void calculateTotal();

	public abstract void processPayment();
}
