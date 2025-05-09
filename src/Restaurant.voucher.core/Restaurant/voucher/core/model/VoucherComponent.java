package Restaurant.voucher.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="voucher_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class VoucherComponent implements Voucher{
	@Id
	public UUID id; 
	public String voucherName;
	public String voucherDescription;
	public String voucherType;
	public String code;
	public int minPurchaseAmount;
	public int quota;
	public EDate startDate;
	public EDate endDate;
	protected String objectName = VoucherComponent.class.getName();

	public VoucherComponent() {

	} 

	public VoucherComponent(
        UUID id, String voucherName, String voucherDescription, String voucherType, String code, int minPurchaseAmount, int quota, EDate startDate, EDate endDate
    ) {
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

	public abstract UUID getId();
	public abstract void setId(UUID id);
	
	public abstract String getVoucherName();
	public abstract void setVoucherName(String voucherName);
	
	public abstract String getVoucherDescription();
	public abstract void setVoucherDescription(String voucherDescription);
	
	public abstract String getVoucherType();
	public abstract void setVoucherType(String voucherType);
	
	public abstract String getCode();
	public abstract void setCode(String code);
	
	public abstract int getMinPurchaseAmount();
	public abstract void setMinPurchaseAmount(int minPurchaseAmount);
	
	public abstract int getQuota();
	public abstract void setQuota(int quota);
	
	public abstract EDate getStartDate();
	public abstract void setStartDate(EDate startDate);
	
	public abstract EDate getEndDate();
	public abstract void setEndDate(EDate endDate);
	
 
	public abstract void createVoucher();

	public abstract void deleteVoucher();

	public abstract void calculatePrice();

	@Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            " voucherName='" + getVoucherName() + "'" +
            " voucherDescription='" + getVoucherDescription() + "'" +
            " voucherType='" + getVoucherType() + "'" +
            " code='" + getCode() + "'" +
            " minPurchaseAmount='" + getMinPurchaseAmount() + "'" +
            " quota='" + getQuota() + "'" +
            " startDate='" + getStartDate() + "'" +
            " endDate='" + getEndDate() + "'" +
            "}";
    }
	
}
