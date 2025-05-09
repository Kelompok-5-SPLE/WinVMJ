package Restaurant.payment.core;
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
import Restaurant.payment.PaymentMethodFactory;
import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class PaymentMethodServiceImpl extends PaymentMethodServiceComponent{

    public List<HashMap<String,Object>> savePaymentMethod(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		PaymentMethod paymentmethod = createPaymentMethod(vmjExchange);
		paymentmethodRepository.saveObject(paymentmethod);
		return getAllPaymentMethod(vmjExchange);
	}

    public PaymentMethod createPaymentMethod(Map<String, Object> requestBody){
		String paymentMethod = (String) requestBody.get("paymentMethod");
		String totalStr = (String) requestBody.get("total");
		int total = Integer.parseInt(totalStr);
		
		//to do: fix association attributes
		PaymentMethod PaymentMethod = PaymentMethodFactory.createPaymentMethod(
			"Restaurant.payment.core.PaymentMethodImpl",
		paymentId
		, createdAt
		, paymentMethod
		, total
		, receipt
		, orderId
		);
		Repository.saveObject(paymentmethod);
		return paymentmethod;
	}

    public PaymentMethod createPaymentMethod(Map<String, Object> requestBody, int id){
		String paymentMethod = (String) vmjExchange.getRequestBodyForm("paymentMethod");
		String totalStr = (String) vmjExchange.getRequestBodyForm("total");
		int total = Integer.parseInt(totalStr);
		
		//to do: fix association attributes
		
		PaymentMethod paymentmethod = PaymentMethodFactory.createPaymentMethod("Restaurant.payment.core.PaymentMethodImpl", paymentId, createdAt, paymentMethod, total, receipt, orderId);
		return paymentmethod;
	}

    public HashMap<String, Object> updatePaymentMethod(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("paymentIdorderId");
		int id = Integer.parseInt(idStr);
		PaymentMethod paymentmethod = Repository.getObject(id);
		
		paymentmethod.setPaymentMethod((String) requestBody.get("paymentMethod"));
		String totalStr = (String) requestBody.get("total");
		paymentmethod.setTotal(Integer.parseInt(totalStr));
		
		Repository.updateObject(paymentmethod);
		
		//to do: fix association attributes
		
		return paymentmethod.toHashMap();
		
	}

    public HashMap<String, Object> getPaymentMethod(Map<String, Object> requestBody){
		List<HashMap<String, Object>> paymentmethodList = getAllPaymentMethod("paymentmethod_impl");
		for (HashMap<String, Object> paymentmethod : paymentmethodList){
			int record_id = ((Double) paymentmethod.get("record_id")).intValue();
			if (record_id == id){
				return paymentmethod;
			}
		}
		return null;
	}

	public HashMap<String, Object> getPaymentMethodById(int id){
		String idStr = vmjExchange.getGETParam("paymentIdorderId"); 
		int id = Integer.parseInt(idStr);
		PaymentMethod paymentmethod = paymentmethodRepository.getObject(id);
		return paymentmethod.toHashMap();
	}

    public List<HashMap<String,Object>> getAllPaymentMethod(Map<String, Object> requestBody){
		String table = (String) requestBody.get("table_name");
		List<PaymentMethod> List = Repository.getAllObject(table);
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<PaymentMethod> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deletePaymentMethod(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get("id"));
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAllPaymentMethod(requestBody);
	}

	public void calculateTotal() {
		// TODO: implement this method
	}

	public void processPayment() {
		// TODO: implement this method
	}
}
