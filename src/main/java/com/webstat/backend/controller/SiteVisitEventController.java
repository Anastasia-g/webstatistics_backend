package com.webstat.backend.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.webstat.backend.model.SiteVisitEvent;
import com.webstat.backend.model.SiteVisitEventRepository;



@RestController
@RequestMapping("/api/v1")
public class SiteVisitEventController {
	 org.slf4j.Logger logger = LoggerFactory.getLogger(SiteVisitEventController.class);
	 
	@Autowired
	private SiteVisitEventRepository siteVisitEventRepository;
	
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/site-visit-events")
	public List<SiteVisitEvent> getAllSiteVisitEvents() {
		return siteVisitEventRepository.findAll();
	}
	
	
	@CrossOrigin(origins = "*")
	@GetMapping("/site-visit-events/{startdate}/{enddate}")
	public Map<String, String> getVisitsByPeriod(@PathVariable(value = "startdate") @DateTimeFormat(pattern="yyyy-MM-dd") Date startdate, 
			@PathVariable(value = "enddate") @DateTimeFormat(pattern="yyyy-MM-dd") Date enddate){
		//int visitsByPeriod = siteVisitEventRepository.findVisitsByPeriod(startdate, enddate);

		Map<String, String> m = new HashMap<String, String>();
		m.put("visitsByPeriod", "" + siteVisitEventRepository.findVisitsByPeriod(startdate, enddate));
		m.put("uniqueVisitorsByPeriod", "" + siteVisitEventRepository.findUniqueVisitorsByPeriod(startdate, enddate));
		m.put("regularVisitorsByPeriod", "" + siteVisitEventRepository.findRegularVisitorsByPeriod(startdate, enddate));
		return m;

	
	}


	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping("/site-visit-event")
	public Map<String, String> createSiteVisitEvent(@Valid @RequestBody SiteVisitEvent siteVisitEvent) {
		siteVisitEventRepository.save(siteVisitEvent);
		
		Map<String, String> m = new HashMap<String, String>();
		m.put("visitsLast24Hrs", "" + siteVisitEventRepository.find24hrsVisits());
		m.put("uniqueVisitorsLast24Hrs", "" + siteVisitEventRepository.findUniqueVisitors());
		return m ;
	}
	
	
}
