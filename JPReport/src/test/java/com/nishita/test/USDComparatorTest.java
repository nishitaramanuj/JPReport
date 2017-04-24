package com.nishita.test;

import static junit.framework.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.report.bean.ReportBean;
import com.report.util.USDCpmparator;

public class USDComparatorTest {

    ReportBean beanA, beanB, beanC, beanD, beanE;
    USDCpmparator obj_USDCpmparator;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() {

	beanA = new ReportBean("boo", 13025.0f);
	beanB = new ReportBean("foo", 10025.0f);
	beanC = new ReportBean("too", 13625.0f);
	beanD = new ReportBean("voo", 13025.0f);
	obj_USDCpmparator = new USDCpmparator();
    }

    @Test
    public void testFirstHigher() {
	int result = obj_USDCpmparator.compare(beanA, beanB);
	assertEquals("1st Bean should be higher in rank", -1, result);
    }

    @Test
    public void testFirstLower() {
	int result = obj_USDCpmparator.compare(beanB, beanA);
	assertEquals("1st Bean should be lower in rank", 1, result);
    }

    @Test
    public void testEqual() {
	int result = obj_USDCpmparator.compare(beanA, beanD);
	assertEquals("Journals should be ordered alphabetically on the journal’s name", -20, result);
    }

}
