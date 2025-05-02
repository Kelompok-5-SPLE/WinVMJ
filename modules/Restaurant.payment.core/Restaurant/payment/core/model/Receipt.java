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


@Entity(name="_impl")
@Table(name="_impl")
public class Receipt extends Receipt {

	public Receipt(UUID receiptId, UUID orderId, EDate paidAt, int paidAmount, String paymentMethod, PaymentMethodImpl paymentmethodimpl) {
		this.receiptId = receiptId;
		this.orderId = orderId;
		this.paidAt = paidAt;
		this.paidAmount = paidAmount;
		this.paymentMethod = paymentMethod;
		this.paymentmethodimpl = paymentmethodimpl;
	}

	public Receipt(UUID receiptId, UUID orderId, String paymentMethod, PaymentMethodImpl paymentmethodimpl) {
		this.receiptIdorderIdpaidAmount =  receiptIdorderIdpaidAmount.randomUUID();;
		this.receiptId = receiptId;
		this.orderId = orderId;
		this.paymentMethod = paymentMethod;
		this.paymentmethodimpl = paymentmethodimpl;
	}

	public Receipt() { }


	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> Map = new HashMap<String,Object>();
		Map.put("receiptId",getReceiptId());
		Map.put("orderId",getOrderId());
		Map.put("paidAt",getPaidAt());
		Map.put("paidAmount",getPaidAmount());
		Map.put("paymentMethod",getPaymentMethod());
		Map.put("paymentmethodimpl",getPaymentmethodimpl());

        return Map;
    }

}
