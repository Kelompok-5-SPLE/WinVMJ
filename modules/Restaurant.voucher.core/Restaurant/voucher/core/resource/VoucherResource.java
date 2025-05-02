package Restaurant.voucher.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface VoucherResource {
    List<HashMap<String,Object>> saveVoucher(VMJExchange vmjExchange);
    HashMap<String, Object> updateVoucher(VMJExchange vmjExchange);
    HashMap<String, Object> getVoucher(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllVoucher(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteVoucher(VMJExchange vmjExchange);
	HashMap<String, Object> createVoucher(VMJExchange vmjExhange);
}
