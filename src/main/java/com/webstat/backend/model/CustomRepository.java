package com.webstat.backend.model;

import java.util.Date;

public interface CustomRepository {
	
	int find24hrsVisits();
	int findUniqueVisitors();
	
	int findVisitsByPeriod(Date startdate, Date enddate);
	int findUniqueVisitorsByPeriod(Date startdate, Date enddate);
	int findRegularVisitorsByPeriod(Date startdate, Date enddate);

}
