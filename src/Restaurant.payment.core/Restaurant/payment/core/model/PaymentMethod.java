package Restaurant.payment.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

public interface PaymentMethod {
	public UUID getPaymentId();
	public void setPaymentId(UUID paymentId);
	public EDate getCreatedAt();
	public void setCreatedAt(EDate createdAt);
	public String getPaymentMethod();
	public void setPaymentMethod(String paymentMethod);
	public int getTotal();
	public void setTotal(int total);
	public Receipt getReceipt();
	public void setReceipt(Receipt receipt);
	public UUID getOrderId();
	public void setOrderId(UUID orderId);
	public UUID getReceiptId();
	public void setReceiptId(UUID receiptId);
	public UUID getOrderId();
	public void setOrderId(UUID orderId);
	public EDate getPaidAt();
	public void setPaidAt(EDate paidAt);
	public int getPaidAmount();
	public void setPaidAmount(int paidAmount);
	public String getPaymentMethod();
	public void setPaymentMethod(String paymentMethod);
	public PaymentMethodImpl getPaymentmethodimpl();
	public void setPaymentmethodimpl(PaymentMethodImpl paymentmethodimpl);
	public void calculateTotal();
	public void processPayment();
	HashMap<String, Object> toHashMap();
}
