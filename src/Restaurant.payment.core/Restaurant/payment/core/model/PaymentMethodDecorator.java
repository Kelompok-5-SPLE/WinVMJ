package Restaurant.payment.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class PaymentMethodDecorator extends PaymentMethodComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected PaymentMethodComponent record;

	public PaymentMethodDecorator () {
		super();
		this.record = record;
		this.paymentIdorderId =  paymentIdorderId.randomUUID();
		
	public PaymentMethodDecorator (PaymentMethodComponent record) {
		this.paymentIdorderId =  paymentIdorderId.randomUUID();
		this.record = record;
	}

	public PaymentMethodDecorator (UUID paymentIdUUID orderId, PaymentMethodComponent record) {
		this.paymentIdorderId =  paymentIdorderId;
		this.record = record;
	}
	
	public PaymentMethodDecorator (PaymentMethodComponent record, String objectName) {
		this.paymentIdorderId =  paymentIdorderId.randomUUID();
		this.record = record;	
		this.objectName=objectName;
	}

	public PaymentMethodDecorator() { }


	public void calculateTotal() {
		return record.calculateTotal();
	}

	public void processPayment() {
		return record.processPayment();
	}

	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
