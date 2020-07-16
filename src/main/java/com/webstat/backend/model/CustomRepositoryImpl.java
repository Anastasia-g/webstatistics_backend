package com.webstat.backend.model;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Repository
@Transactional(readOnly = true)
public class CustomRepositoryImpl implements CustomRepository{
	 @PersistenceContext
	    EntityManager entityManager;
	    @Override
	    public int find24hrsVisits() {
	    	
	    	
	    	Query query = entityManager.createNativeQuery("SELECT COUNT(*) FROM site_visit_event as event"+
	    			" WHERE event.visit_date >= (current_timestamp - interval '24 hours')");
	    	
	    	int visits = ((Number) query.getSingleResult()).intValue();
	    	return visits;


}
		@Override
		public int findUniqueVisitors() {
	    	Query query = entityManager.createNativeQuery("SELECT COUNT(DISTINCT userid)  FROM site_visit_event as event"+
	    			" WHERE event.visit_date >= (current_timestamp - interval '24 hours')");
	    	int visitors = ((Number) query.getSingleResult()).intValue();
	    	return visitors;
		}
		@Override
		public int findVisitsByPeriod(Date startdate, Date enddate) {
			Query query = entityManager.createNativeQuery("SELECT COUNT(*) FROM site_visit_event as event"+
	    			" WHERE event.visit_date >= ? and event.visit_date <=?");
			 query.setParameter(1, startdate );
			 query.setParameter(2, enddate );
	    	
	    	int visitsByPeriod = ((Number) query.getSingleResult()).intValue();
	    	return visitsByPeriod;
		}
		@Override
		public int findUniqueVisitorsByPeriod(Date startdate, Date enddate) {
			Query query = entityManager.createNativeQuery("SELECT COUNT(DISTINCT userid) FROM site_visit_event as event"+
	    			" WHERE event.visit_date >= ? and event.visit_date <=?");
			 query.setParameter(1, startdate );
			 query.setParameter(2, enddate );
	    	
	    	int uniqueVisitorsByPeriod = ((Number) query.getSingleResult()).intValue();
	    	return uniqueVisitorsByPeriod;
		}
		@Override
		public int findRegularVisitorsByPeriod(Date startdate, Date enddate) {
			Query query = entityManager.createNativeQuery("SELECT COUNT(DISTINCT userid) FROM site_visit_event as event"+
	    			" WHERE event.visit_date >= ? and event.visit_date <=?"+ 
					" GROUP BY event.userid "+ 
	    			" HAVING(COUNT(DISTINCT(event.site_pageid)) >= 8)");
			 query.setParameter(1, startdate );
			 query.setParameter(2, enddate );
	    	
	    	int regularVisitorsByPeriod = ((Number) query.getSingleResult()).intValue();
	    	return regularVisitorsByPeriod;
		}
		}
