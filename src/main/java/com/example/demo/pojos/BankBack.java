package com.example.demo.pojos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Value;

@Entity
@Table(name="customerservice")
public class BankBack {
	private String depositorname;
	@Override
	public String toString() {
		return "BankBack [depositorname=" + depositorname + ", depositornumber=" + depositornumber + ", openingblc="
				+ openingblc + ", transcode=" + transcode + ", amount=" + amount + ", closingbalance=" + closingbalance
				+ "]";
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int depositornumber;
	private Integer openingblc;
	private String transcode;
	private int amount;
	public int getClosingbalance() {
		return closingbalance;
	}

	public void setClosingbalance(int closingbalance) {
		this.closingbalance = closingbalance;
	}
	private int closingbalance;
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	


	public String getDepositorname() {
		return depositorname;
	}
	public void setDepositorname(String depositorname) {
		this.depositorname = depositorname;
	}
	public int getDepositornumber() {
		return depositornumber;
	}
	public void setDepositornumber(int depositornumber) {
		this.depositornumber = depositornumber;
	}

	public Integer getOpeningblc() {
		return openingblc;
	}

	public void setOpeningblc(Integer openingblc) {
		this.openingblc = openingblc;
	}

	public String getTranscode() {
		return transcode;
	}
	public void setTranscode(String transcode) {
		this.transcode = transcode;
	}
	

	
}
