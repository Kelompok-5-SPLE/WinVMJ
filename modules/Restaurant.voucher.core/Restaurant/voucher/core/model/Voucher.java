package Restaurant.voucher.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

public interface Voucher {
	public UUID getId();
	public void setId(UUID id);
	public String getVoucherName();
	public void setVoucherName(String voucherName);
	public String getVoucherDescription();
	public void setVoucherDescription(String voucherDescription);
	public String getVoucherType();
	public void setVoucherType(String voucherType);
	public String getCode();
	public void setCode(String code);
	public int getMinPurchaseAmount();
	public void setMinPurchaseAmount(int minPurchaseAmount);
	public int getQuota();
	public void setQuota(int quota);
	public EDate getStartDate();
	public void setStartDate(EDate startDate);
	public EDate getEndDate();
	public void setEndDate(EDate endDate);
	public void createVoucher();
	public void deleteVoucher();
	public void calculatePrice();
	HashMap<String, Object> toHashMap();
}
