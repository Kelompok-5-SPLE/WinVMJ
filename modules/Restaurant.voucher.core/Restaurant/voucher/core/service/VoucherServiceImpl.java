package Restaurant.voucher.core;
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
import Restaurant.voucher.VoucherFactory;
import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class VoucherServiceImpl extends VoucherServiceComponent{

    public List<HashMap<String,Object>> saveVoucher(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Voucher voucher = createVoucher(vmjExchange);
		voucherRepository.saveObject(voucher);
		return getAllVoucher(vmjExchange);
	}

    public Voucher createVoucher(Map<String, Object> requestBody){
		String voucherName = (String) requestBody.get("voucherName");
		String voucherDescription = (String) requestBody.get("voucherDescription");
		String voucherType = (String) requestBody.get("voucherType");
		String code = (String) requestBody.get("code");
		String minPurchaseAmountStr = (String) requestBody.get("minPurchaseAmount");
		int minPurchaseAmount = Integer.parseInt(minPurchaseAmountStr);
		String quotaStr = (String) requestBody.get("quota");
		int quota = Integer.parseInt(quotaStr);
		
		//to do: fix association attributes
		Voucher Voucher = VoucherFactory.createVoucher(
			"Restaurant.voucher.core.VoucherImpl",
		id
		, voucherName
		, voucherDescription
		, voucherType
		, code
		, minPurchaseAmount
		, quota
		, startDate
		, endDate
		);
		Repository.saveObject(voucher);
		return voucher;
	}

    public Voucher createVoucher(Map<String, Object> requestBody, int id){
		String voucherName = (String) vmjExchange.getRequestBodyForm("voucherName");
		String voucherDescription = (String) vmjExchange.getRequestBodyForm("voucherDescription");
		String voucherType = (String) vmjExchange.getRequestBodyForm("voucherType");
		String code = (String) vmjExchange.getRequestBodyForm("code");
		String minPurchaseAmountStr = (String) vmjExchange.getRequestBodyForm("minPurchaseAmount");
		int minPurchaseAmount = Integer.parseInt(minPurchaseAmountStr);
		String quotaStr = (String) vmjExchange.getRequestBodyForm("quota");
		int quota = Integer.parseInt(quotaStr);
		
		//to do: fix association attributes
		
		Voucher voucher = VoucherFactory.createVoucher("Restaurant.voucher.core.VoucherImpl", voucherName, voucherDescription, voucherType, code, minPurchaseAmount, quota, startDate, endDate);
		return voucher;
	}

    public HashMap<String, Object> updateVoucher(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("id");
		int id = Integer.parseInt(idStr);
		Voucher voucher = Repository.getObject(id);
		
		voucher.setVoucherName((String) requestBody.get("voucherName"));
		voucher.setVoucherDescription((String) requestBody.get("voucherDescription"));
		voucher.setVoucherType((String) requestBody.get("voucherType"));
		voucher.setCode((String) requestBody.get("code"));
		String minPurchaseAmountStr = (String) requestBody.get("minPurchaseAmount");
		voucher.setMinPurchaseAmount(Integer.parseInt(minPurchaseAmountStr));
		String quotaStr = (String) requestBody.get("quota");
		voucher.setQuota(Integer.parseInt(quotaStr));
		
		Repository.updateObject(voucher);
		
		//to do: fix association attributes
		
		return voucher.toHashMap();
		
	}

    public HashMap<String, Object> getVoucher(Map<String, Object> requestBody){
		List<HashMap<String, Object>> voucherList = getAllVoucher("voucher_impl");
		for (HashMap<String, Object> voucher : voucherList){
			int record_id = ((Double) voucher.get("record_id")).intValue();
			if (record_id == id){
				return voucher;
			}
		}
		return null;
	}

	public HashMap<String, Object> getVoucherById(int id){
		String idStr = vmjExchange.getGETParam("id"); 
		int id = Integer.parseInt(idStr);
		Voucher voucher = voucherRepository.getObject(id);
		return voucher.toHashMap();
	}

    public List<HashMap<String,Object>> getAllVoucher(Map<String, Object> requestBody){
		String table = (String) requestBody.get("table_name");
		List<Voucher> List = Repository.getAllObject(table);
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Voucher> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deleteVoucher(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get("id"));
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAllVoucher(requestBody);
	}

	public void createVoucher() {
		// TODO: implement this method
	}

	public void deleteVoucher() {
		// TODO: implement this method
	}

	public void calculatePrice() {
		// TODO: implement this method
	}
}
