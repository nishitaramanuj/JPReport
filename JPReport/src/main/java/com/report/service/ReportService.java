package com.report.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;

import com.report.bean.ReportBean;
import com.report.util.USDCpmparator;

public class ReportService {
    private final static long MILLISECONDS_PER_DAY = 1000L * 60 * 60 * 24;

    public static float GetUsd(float pricePerUnit, int units, float agreedFx) {
	return (pricePerUnit * units * agreedFx);
    }

    public static List<ReportBean> updateDate(List<ReportBean> list) {
	for (ReportBean obj : list) {

	    if ((obj.getCurrency() == "AED" || obj.getCurrency() == "SAR")) {
		if (obj.getSettlementDate().getDay() == 5) {
		    shiftDate(obj.getSettlementDate(), 2);
		}
		if (obj.getSettlementDate().getDay() == 6) {
		    shiftDate(obj.getSettlementDate(), 1);
		}
	    } else {
		if (obj.getSettlementDate().getDay() == 6) {
		    shiftDate(obj.getSettlementDate(), 2);
		}
		if (obj.getSettlementDate().getDay() == 0) {
		    shiftDate(obj.getSettlementDate(), 1);
		}
	    }
	}
	return list;
    }

    public static void displayTable(List<ReportBean> data) {
	System.out.println("Data table");
	System.out.println("Entity - Buy/sell - AgreedFx - Currency - InstDate - SetDate - Units - Price/unit ");
	System.out.println("------------------------------------------------------------------------------------------------");
	for (ReportBean obj : data) {

	    System.out.println(obj.getEntity() + " - " + obj.getBuyOrSell() + " - " + obj.getAgreedFx() + " - " + obj.getCurrency() + " - "
		    + obj.getInstructionDate() + " - " + obj.getSettlementDate() + " - " + obj.getUnits() + " - " + obj.getPricePerUnit());
	}
    }

    public static void displayReport(List<ReportBean> data,String buy_or_sell) {
	System.out.println("*Data table for "+buy_or_sell+"*");
	System.out.println("Rank - Entity  - SetDate - USD ");
	System.out.println("------------------------------------------------------------------------------------------------");
	int i = 0;
	for (ReportBean obj : data) {
	    i++;
	    System.out.println(i + " - " + obj.getEntity() + " - " + obj.getSettlementDate() + " - " + obj.getUsd());
	}
    }

    public static Date shiftDate(Date d, int day) {
	long time = d.getTime();
	time += MILLISECONDS_PER_DAY * day;
	d.setTime(time);
	return d;
    }

    public static List<ReportBean> rankEntry(Collection<ReportBean> beans, String buy) {
	// Duplicate input list
	List<ReportBean> sortedEntry = new ArrayList<ReportBean>(beans.size());
	sortedEntry.addAll(beans);
	for (ReportBean b : sortedEntry) {
	    b.setUsd(GetUsd(b.getPricePerUnit(), b.getUnits(), b.getAgreedFx()));

	}
	Predicate<ReportBean> journalPredicate = p -> p.getBuyOrSell() != buy;
	sortedEntry.removeIf(journalPredicate);

	//shorting
	Collections.sort(sortedEntry, new USDCpmparator());
	
	displayReport(sortedEntry,buy=="B"?"Outgoing":"Incoming");
	return sortedEntry;
    }

}
