package Restaurant.voucher.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class VoucherResourceComponent implements VoucherResource{
	
	public VoucherResourceComponent() { }
 
    public abstract Voucher createVoucher(VMJExchange vmjExchange);    
	public abstract HashMap<String, Object> updateVoucher(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getVoucher(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllVoucher(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> deleteVoucher(VMJExchange vmjExchange);

	public abstract void createVoucher();

	public abstract void deleteVoucher();

	public abstract void calculatePrice();
}
