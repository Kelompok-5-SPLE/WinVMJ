package Restaurant.payment.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="paymentmethod_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class PaymentMethodComponent implements PaymentMethod{
	@Id
	public UUID paymentId; public UUID orderId; 
	public UUID paymentId;
	public EDate createdAt;
	public String paymentMethod;
	public int total;
	public Receipt receipt;
	public UUID orderId;
	protected String objectName = PaymentMethodComponent.class.getName();

	public PaymentMethodComponent() {

	} 

	public PaymentMethodComponent(
        UUID paymentId, EDate createdAt, String paymentMethod, int total, Receipt receipt, UUID orderId
    ) {
        this.paymentId = paymentId;
        this.createdAt = createdAt;
        this.paymentMethod = paymentMethod;
        this.total = total;
        this.receipt = receipt;
        this.orderId = orderId;
    }

	public abstract UUID getPaymentId();
	public abstract void setPaymentId(UUID paymentId);
	
	public abstract EDate getCreatedAt();
	public abstract void setCreatedAt(EDate createdAt);
	
	public abstract String getPaymentMethod();
	public abstract void setPaymentMethod(String paymentMethod);
	
	public abstract int getTotal();
	public abstract void setTotal(int total);
	
	public abstract Receipt getReceipt();
	public abstract void setReceipt(Receipt receipt);
	
	public abstract UUID getOrderId();
	public abstract void setOrderId(UUID orderId);
	
 
	public abstract void calculateTotal();

	public abstract void processPayment();

	@Override
    public String toString() {
        return "{" +
            " paymentId='" + getPaymentId() + "'" +
            " createdAt='" + getCreatedAt() + "'" +
            " paymentMethod='" + getPaymentMethod() + "'" +
            " total='" + getTotal() + "'" +
            " receipt='" + getReceipt() + "'" +
            " orderId='" + getOrderId() + "'" +
            "}";
    }
	
}
