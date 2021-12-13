package kiosk.parcel;

import java.io.Serializable;

public class ParcelInfo implements Serializable {
	
	private double weight;
	private String type;
	private String trackingNo;
	
	public ParcelInfo() 
	{}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTrackingNo() {
		return trackingNo;
	}
	public void setTrackingNo(String trackingNo) {
		this.trackingNo = trackingNo;
	}
	

}
