package Restaurant.voucher.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class VoucherServiceComponent implements VoucherService{
	protected RepositoryUtil<Voucher> Repository;

    public VoucherServiceComponent(){
        this.Repository = new RepositoryUtil<Voucher>(Restaurant.voucher.core.VoucherComponent.class);
    }	

    public abstract List<HashMap<String,Object>> saveVoucher(VMJExchange vmjExchange);
    public abstract Voucher createVoucher(Map<String, Object> requestBodye);
	public abstract Voucher createVoucher(Map<String, Object> requestBody, Map<String, Object> response);    
	public abstract HashMap<String, Object> updateVoucher(Map<String, Object> requestBody);
    public abstract HashMap<String, Object> getVoucher(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> getAllVoucher(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<Voucher> List);
    public abstract List<HashMap<String,Object>> deleteVoucher(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> getVoucherById(int id);

	public abstract void createVoucher();

	public abstract void deleteVoucher();

	public abstract void calculatePrice();
}
