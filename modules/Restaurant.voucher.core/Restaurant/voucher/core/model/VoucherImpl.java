package Restaurant.voucher.core;

import java.lang.Math;
import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity(name="voucher_impl")
@Table(name="voucher_impl")
public class VoucherImpl extends VoucherComponent {

	public VoucherImpl(UUID id, String voucherName, String voucherDescription, String voucherType, String code, int minPurchaseAmount, int quota, EDate startDate, EDate endDate) {
		this.id = id;
		this.voucherName = voucherName;
		this.voucherDescription = voucherDescription;
		this.voucherType = voucherType;
		this.code = code;
		this.minPurchaseAmount = minPurchaseAmount;
		this.quota = quota;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public VoucherImpl(String voucherName, String voucherDescription, String voucherType, String code, int minPurchaseAmount, int quota, EDate startDate, EDate endDate) {
		this.id =  id.randomUUID();;
		this.voucherName = voucherName;
		this.voucherDescription = voucherDescription;
		this.voucherType = voucherType;
		this.code = code;
		this.minPurchaseAmount = minPurchaseAmount;
		this.quota = quota;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public VoucherImpl() { }


	public void createVoucher() {
		// TODO: implement this method
	}

	public void deleteVoucher() {
		// TODO: implement this method
	}

	public void calculatePrice() {
		// TODO: implement this method
	}
	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> voucherMap = new HashMap<String,Object>();
		voucherMap.put("id",getId());
		voucherMap.put("voucherName",getVoucherName());
		voucherMap.put("voucherDescription",getVoucherDescription());
		voucherMap.put("voucherType",getVoucherType());
		voucherMap.put("code",getCode());
		voucherMap.put("minPurchaseAmount",getMinPurchaseAmount());
		voucherMap.put("quota",getQuota());
		voucherMap.put("startDate",getStartDate());
		voucherMap.put("endDate",getEndDate());

        return voucherMap;
    }

}
