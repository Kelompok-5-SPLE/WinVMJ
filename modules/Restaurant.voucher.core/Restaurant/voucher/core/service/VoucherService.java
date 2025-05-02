package Restaurant.voucher.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface VoucherService {
	Voucher createVoucher(Map<String, Object> requestBody);
	Voucher createVoucher(Map<String, Object> requestBody, Map<String, Object> response);
	HashMap<String, Object> getVoucher(Map<String, Object> requestBody);
    List<HashMap<String,Object>> saveVoucher(Map<String, Object> requestBody);
    HashMap<String, Object> updateVoucher(Map<String, Object> requestBody);
    HashMap<String, Object> getVoucherById(int id);
    List<HashMap<String,Object>> getAllVoucher(Map<String, Object> requestBody);
    List<HashMap<String,Object>> deleteVoucher(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<Disbursement> List);
}
