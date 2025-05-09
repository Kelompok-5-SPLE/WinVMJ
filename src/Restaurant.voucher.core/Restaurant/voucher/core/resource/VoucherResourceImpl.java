package Restaurant.voucher.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import Restaurant.voucher.VoucherFactory;
//import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class VoucherResourceImpl extends VoucherResourceComponent{
	
	private VoucherServiceImpl voucherServiceImpl = new VoucherServiceImpl();

	// @Restriced(permission = "")
    @Route(url="call/voucher")
    public HashMap<String,Object> createvoucher(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Voucher result = voucherServiceImpl.createVoucher(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    // @Restriced(permission = "")
    @Route(url="call/voucher/update")
    public HashMap<String, Object> updateVoucher(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return voucherServiceImpl.updateVoucher(requestBody);
		
	}

	// @Restriced(permission = "")
    @Route(url="call/voucher/detail")
    public HashMap<String, Object> getVoucher(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return voucherServiceImpl.getVoucher(requestBody);
	}

	// @Restriced(permission = "")
    @Route(url="call/voucher/list")
    public List<HashMap<String,Object>> getAllVoucher(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return voucherServiceImpl.getAllVoucher(requestBody);
	}

    
	// @Restriced(permission = "")
    @Route(url="call/voucher/delete")
    public List<HashMap<String,Object>> deleteVoucher(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return voucherServiceImpl.deleteVoucher(requestBody);
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
