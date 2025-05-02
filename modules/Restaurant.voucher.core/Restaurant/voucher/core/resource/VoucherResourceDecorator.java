package Restaurant.voucher.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

public abstract class VoucherResourceDecorator extends VoucherResourceComponent{
	protected VoucherResourceComponent record;

    public VoucherResourceDecorator(VoucherResourceComponent record) {
        this.record = record;
    }

    public Voucher createVoucher(VMJExchange vmjExchange){
		return record.createVoucher(vmjExchange);
	}

    public HashMap<String, Object> updateVoucher(VMJExchange vmjExchange){
		return record.updateVoucher(vmjExchange);
	}

    public HashMap<String, Object> getVoucher(VMJExchange vmjExchange){
		return record.getVoucher(vmjExchange);
	}

    public List<HashMap<String,Object>> getAllVoucher(VMJExchange vmjExchange){
		return record.getAllVoucher(vmjExchange);
	}

    public List<HashMap<String,Object>> deleteVoucher(VMJExchange vmjExchange){
		return record.deleteVoucher(vmjExchange);
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
