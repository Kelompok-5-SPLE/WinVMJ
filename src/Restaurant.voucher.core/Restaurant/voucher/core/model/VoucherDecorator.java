package Restaurant.voucher.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class VoucherDecorator extends VoucherComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected VoucherComponent record;

	public VoucherDecorator () {
		super();
		this.record = record;
		this.id =  id.randomUUID();
		
	public VoucherDecorator (VoucherComponent record) {
		this.id =  id.randomUUID();
		this.record = record;
	}

	public VoucherDecorator (UUID id, VoucherComponent record) {
		this.id =  id;
		this.record = record;
	}
	
	public VoucherDecorator (VoucherComponent record, String objectName) {
		this.id =  id.randomUUID();
		this.record = record;	
		this.objectName=objectName;
	}

	public VoucherDecorator() { }


	public void createVoucher() {
		return record.createVoucher();
	}

	public void deleteVoucher() {
		return record.deleteVoucher();
	}

	public void calculatePrice() {
		return record.calculatePrice();
	}

	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
