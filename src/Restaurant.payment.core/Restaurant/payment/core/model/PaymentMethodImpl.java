package Restaurant.payment.core;

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


@Entity(name="paymentmethod_impl")
@Table(name="paymentmethod_impl")
public class PaymentMethodImpl extends PaymentMethodComponent {

	public PaymentMethodImpl(UUID paymentId, EDate createdAt, String paymentMethod, int total, Receipt receipt, UUID orderId) {
		this.paymentId = paymentId;
		this.createdAt = createdAt;
		this.paymentMethod = paymentMethod;
		this.total = total;
		this.receipt = receipt;
		this.orderId = orderId;
	}

	public PaymentMethodImpl(UUID paymentId, EDate createdAt, String paymentMethod, int total, Receipt receipt, UUID orderId) {
		this.paymentIdorderId =  paymentIdorderId.randomUUID();;
		this.paymentId = paymentId;
		this.createdAt = createdAt;
		this.paymentMethod = paymentMethod;
		this.total = total;
		this.receipt = receipt;
		this.orderId = orderId;
	}

	public PaymentMethodImpl() { }


	public void calculateTotal() {
		// TODO: implement this method
	}

	public void processPayment() {
		// TODO: implement this method
	}
	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> paymentmethodMap = new HashMap<String,Object>();
		paymentmethodMap.put("paymentId",getPaymentId());
		paymentmethodMap.put("createdAt",getCreatedAt());
		paymentmethodMap.put("paymentMethod",getPaymentMethod());
		paymentmethodMap.put("total",getTotal());
		paymentmethodMap.put("receipt",getReceipt());
		paymentmethodMap.put("orderId",getOrderId());

        return paymentmethodMap;
    }

}
