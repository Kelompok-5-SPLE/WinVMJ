package Restaurant.voucher.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public abstract class VoucherServiceDecorator extends VoucherServiceComponent{
	protected VoucherServiceComponent record;

    public VoucherServiceDecorator(VoucherServiceComponent record) {
        this.record = record;
    }

	public VoucherImpl createVoucher(Map<String, Object> requestBody){
		return record.createVoucher(requestBody);
	}

    public Voucher createVoucher(Map<String, Object> requestBody, Map<String, Object> response){
		return record.createVoucher(requestBody, response);
	}

	public HashMap<String, Object> getVoucher(Map<String, Object> requestBody){
		return record.getVoucher(requestBody);
	}

	public List<HashMap<String,Object>> getAllVoucher(Map<String, Object> requestBody){
		return record.getAllVoucher(requestBody);
	}

    public List<HashMap<String,Object>> saveVoucher(VMJExchange vmjExchange){
		return record.saveVoucher(vmjExchange);
	}

    public HashMap<String, Object> updateVoucher(Map<String, Object> requestBody){
		return record.updateVoucher(requestBody);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Voucher> List){
		return record.transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> deleteVoucher(Map<String, Object> requestBody){
		return record.deleteVoucher(requestBody);
	}

	public HashMap<String, Object> getVoucherById(int id){
        return record.getVoucherById(id);
    }

	public void createVoucher() {
		return record.createVoucher();
	}

	public void deleteVoucher() {
		return record.deleteVoucher();
	}

	public void calculatePrice() {
		return record.calculatePrice();
	}
}
