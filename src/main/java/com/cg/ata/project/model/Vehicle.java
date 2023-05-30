package com.cg.ata.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "vehicle_table")
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int vehId;

	@Column(name = "vehicleNo")
	private String vehNo;

	@Column(name = "vehicleName")
	private String vehName;

	@Column(name = "vehicleType")
	private String vehType;

	@Column(name = "vehicleSeatCapacity")
	private int vehSeatCapacity;

	@Column(name = "farePerKM")
	private double farePerKM;

	@ManyToOne
	@JoinColumn(name = "Fk_routeId")
	private Route route;

	@ManyToOne
	@JoinColumn(name = "FK_driverId")
	private Driver driver;

	public Vehicle() {
		super();

	}

	public Vehicle(int vehId, String vehNo, String vehName, String vehType, int vehSeatCapacity, double farePerKM,
			Route route, Driver driver) {
		super();
		this.vehId = vehId;
		this.vehNo = vehNo;
		this.vehName = vehName;
		this.vehType = vehType;
		this.vehSeatCapacity = vehSeatCapacity;
		this.farePerKM = farePerKM;
		this.route = route;
		this.driver = driver;
	}

	public int getVehId() {
		return vehId;
	}

	public void setVehId(int vehId) {
		this.vehId = vehId;
	}

	public String getVehNo() {
		return vehNo;
	}

	public void setVehNo(String vehNo) {
		this.vehNo = vehNo;
	}

	public String getVehName() {
		return vehName;
	}

	public void setVehName(String vehName) {
		this.vehName = vehName;
	}

	public String getVehType() {
		return vehType;
	}

	public void setVehType(String vehType) {
		this.vehType = vehType;
	}

	public int getVehSeatCapacity() {
		return vehSeatCapacity;
	}

	public void setVehSeatCapacity(int vehSeatCapacity) {
		this.vehSeatCapacity = vehSeatCapacity;
	}

	public double getFarePerKM() {
		return farePerKM;
	}

	public void setFarePerKM(double farePerKM) {
		this.farePerKM = farePerKM;
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	@Override
	public String toString() {
		return "Vehicle [vehId=" + vehId + ", vehNo=" + vehNo + ", vehName=" + vehName + ", vehType=" + vehType
				+ ", vehSeatCapacity=" + vehSeatCapacity + ", farePerKM=" + farePerKM + ", route=" + route + ", driver="
				+ driver + "]";
	}

}
