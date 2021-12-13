package kiosk.parcel;

import java.io.Serializable;

public class DeliveryInfo implements Serializable {
	
	private String senderAdd;
	private String receiverAdd;
	private String telNo;
	private Double total;
	
	public DeliveryInfo()
	{}
	
	public String getSenderAdd() {
		return senderAdd;
	}
	public void setSenderAdd(String senderAdd) {
		this.senderAdd = senderAdd;
	}
	public String getReceiverAdd() {
		return receiverAdd;
	}
	public void setReceiverAdd(String receiverAdd) {
		this.receiverAdd = receiverAdd;
	}
	public String getTelNo() {
		return telNo;
	}
	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}


}
