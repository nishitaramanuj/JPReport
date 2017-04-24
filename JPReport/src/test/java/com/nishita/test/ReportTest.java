package com.nishita.test;

import static junit.framework.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.report.bean.ReportBean;
import com.report.service.ReportService;

public class ReportTest {

    ReportBean beanA, beanB, beanC,beanD,beanE;
    List<ReportBean> beans;

    @Before
    public void setUp() {
	beans = new ArrayList<ReportBean>();
	beanA = new ReportBean("foo", "B", 0.50f, "AED", fromStringToDate("2017-01-02"), fromStringToDate("2017-04-05"), 200, 100.00f);
	beans.add(beanA);
	beanC = new ReportBean("boo", "S", 0.50f, "AED", fromStringToDate("2017-01-02"), fromStringToDate("2017-04-07"), 200, 110.25f);
	beans.add(beanC);
	beanD = new ReportBean("bar", "B", 0.50f, "AED", fromStringToDate("2017-01-02"), fromStringToDate("2017-04-06"), 200, 130.25f);
	beans.add(beanD);
	beanE = new ReportBean("bar", "S", 0.50f, "GBP", fromStringToDate("2017-01-02"), fromStringToDate("2017-04-07"), 200, 170.25f);
	beans.add(beanE);
    }
    @Test
    public void testFullReportScenario() {
	List<ReportBean> mylist= ReportService.updateDate(beans);
	ReportService.displayTable(mylist);
	ReportService.rankEntry(mylist, "B");
	ReportService.rankEntry(mylist, "S");
    }
    @Test
    public void testScenarioForOutgoing() {
	List<ReportBean> mylist= ReportService.updateDate(beans);
	List<ReportBean> sortedEntryList=ReportService.rankEntry(mylist, "B");
	assertEquals(sortedEntryList.get(0).getEntity(),"bar");
	
	
    }
    @Test
    public void testScenarioForIncoming() {
	List<ReportBean> mylist= ReportService.updateDate(beans);
	List<ReportBean> sortedEntryList=ReportService.rankEntry(mylist, "S");
	assertEquals(sortedEntryList.get(0).getEntity(),"bar");
	
	
    }
    private Date fromStringToDate(String dateInString) {
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	try {
	    return dateFormat.parse(dateInString);
	} catch (ParseException e) {
	    return null;
	}
    }
}
