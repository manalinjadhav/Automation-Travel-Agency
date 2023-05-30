package com.cg.ata.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "driver_table")
public class Driver {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int driverId;

	@Column(name = "driverName")
	private String driverName;

	@Column(name = "driverAdress")
	private String driverAddress;

	@Column(name = "driverContactNo")
	private long driverContactNo;

	@Column(name = "driverLincenceNo")
	private String driLinceNo;

	public Driver() {
		super();
	}

	public Driver(int driverId, String driverName, String driverAddress, long driverContactNo, String driLinceNo) {
		super();
		this.driverId = driverId;
		this.driverName = driverName;
		this.driverAddress = driverAddress;
		this.driverContactNo = driverContactNo;
		this.driLinceNo = driLinceNo;
	}

	public int getDriverId() {
		return driverId;
	}

	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getDriverAddress() {
		return driverAddress;
	}

	public void setDriverAddress(String driverAddress) {
		this.driverAddress = driverAddress;
	}

	public long getDriverContactNo() {
		return driverContactNo;
	}

	public void setDriverContactNo(long driverContactNo) {
		this.driverContactNo = driverContactNo;
	}

	public String getDriLinceNo() {
		return driLinceNo;
	}

	public void setDriLinceNo(String driLinceNo) {
		this.driLinceNo = driLinceNo;
	}

	@Override
	public String toString() {
		return "Driver [driverId=" + driverId + ", driverName=" + driverName + ", driverAddress=" + driverAddress
				+ ", driverContactNo=" + driverContactNo + ", driLinceNo=" + driLinceNo + "]";
	}


}