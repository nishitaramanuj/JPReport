package com.report.util;

import java.util.Comparator;

import com.report.bean.ReportBean;

public class USDCpmparator implements Comparator<ReportBean>{
    @Override
    public int compare(ReportBean bean1, ReportBean bean2) {
	if (bean1 == bean2) {
	    return 0;
	}
	Float obj1 =  bean2.getUsd();
	      Float obj2 = bean1.getUsd();
	     
	int result = obj1.compareTo(obj2);

	// If USD are same then rank alphabetically by entityname
	if (result == 0) {
	    result = bean1.getEntity().compareTo(bean2.getEntity());
	}
	return result;
    }
}
