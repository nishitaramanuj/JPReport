package com.report.bean;
import java.util.Date;



public class ReportBean {
    private float usd;
    private String entity;
    private String buyOrSell;
    private float agreedFx;
    private String currency;
    private Date instructionDate;
    private Date settlementDate;
    private int units;
    private float pricePerUnit;
    public ReportBean(String entity,String buyOrSell,float agreedFx, String currency,Date instructionDate,Date settlementDate,int units,float pricePerUnit){
	this.entity=entity;
	this.buyOrSell=buyOrSell;
	this.agreedFx=agreedFx;
	this.currency=currency;
	this.instructionDate=instructionDate;
	this.settlementDate=settlementDate;
	this.units=units;
	this.pricePerUnit=pricePerUnit;
	
    }

    public ReportBean(String entity, float usd) {
	this.entity = entity;
	this.usd = usd;

    }
    public String getEntity() {
	return entity;
    }

    public void setEntity(String entity) {
	this.entity = entity;
    }

    public String getBuyOrSell() {
	return buyOrSell;
    }

    public void setBuyOrSell(String buyOrSell) {
	this.buyOrSell = buyOrSell;
    }

    public float getAgreedFx() {
	return agreedFx;
    }

    public void setAgreedFx(float agreedFx) {
	this.agreedFx = agreedFx;
    }

    public String getCurrency() {
	return currency;
    }

    public void setCurrency(String currency) {
	this.currency = currency;
    }

    public Date getInstructionDate() {
	return instructionDate;
    }

    public void setInstructionDate(Date instructionDate) {
	this.instructionDate = instructionDate;
    }

    public Date getSettlementDate() {
	return settlementDate;
    }

    public void setSettlementDate(Date settlementDate) {
	this.settlementDate = settlementDate;
    }

    public int getUnits() {
	return units;
    }

    public void setUnits(int units) {
	this.units = units;
    }

    public float getPricePerUnit() {
	return pricePerUnit;
    }

    public void setPricePerUnit(float pricePerUnit) {
	this.pricePerUnit = pricePerUnit;
    }
  
    public float getUsd() {
	return usd;
    }
    public void setUsd(float usd) {
	this.usd = usd;
    }
    

}
