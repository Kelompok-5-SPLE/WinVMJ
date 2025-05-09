package Restaurant.payment.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import Restaurant.payment.PaymentMethodFactory;
//import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class PaymentMethodResourceImpl extends PaymentMethodResourceComponent{
	
	private PaymentMethodServiceImpl paymentmethodServiceImpl = new PaymentMethodServiceImpl();

	// @Restriced(permission = "")
    @Route(url="call/payment")
    public HashMap<String,Object> createpaymentmethod(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			PaymentMethod result = paymentmethodServiceImpl.createPaymentMethod(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    // @Restriced(permission = "")
    @Route(url="call/payment/update")
    public HashMap<String, Object> updatePaymentMethod(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return paymentmethodServiceImpl.updatePaymentMethod(requestBody);
		
	}

	// @Restriced(permission = "")
    @Route(url="call/payment/detail")
    public HashMap<String, Object> getPaymentMethod(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return paymentmethodServiceImpl.getPaymentMethod(requestBody);
	}

	// @Restriced(permission = "")
    @Route(url="call/payment/list")
    public List<HashMap<String,Object>> getAllPaymentMethod(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return paymentmethodServiceImpl.getAllPaymentMethod(requestBody);
	}

    
	// @Restriced(permission = "")
    @Route(url="call/payment/delete")
    public List<HashMap<String,Object>> deletePaymentMethod(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return paymentmethodServiceImpl.deletePaymentMethod(requestBody);
	}

	public void calculateTotal() {
		// TODO: implement this method
	}

	public void processPayment() {
		// TODO: implement this method
	}
}
