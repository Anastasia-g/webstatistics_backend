package com.webstat.backend.model;

import java.util.Date;

import javax.persistence.Column;                                                                 
import javax.persistence.Entity;                                                                 
                                                            
import javax.persistence.GeneratedValue;                                                         
import javax.persistence.GenerationType;                                                         
import javax.persistence.Id;                                                                     
                                                             
import javax.persistence.Table;                                                                  
                                                                                                 
import com.fasterxml.jackson.annotation.JsonIdentityInfo;                                        
import com.fasterxml.jackson.annotation.ObjectIdGenerators;                                      
                                                                                                 
@Entity                                                                                          
@Table(name = "siteVisitEvent")                                                                           
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")     
public class SiteVisitEvent {
	
	@Id                                                                                          
	@GeneratedValue(strategy = GenerationType.IDENTITY)                                          
	private int id;              
	
	@Column(name = "userID", nullable = false)                                                     
	private int userID; 
	
	@Column(name = "sitePageID", nullable = false)                                                     
	private String sitePageID; 
	
	@Column(name = "visitDate ", nullable = false)                                                 
	private Date visitDate =  new Date();

	public SiteVisitEvent() {
		
	}
	
	public SiteVisitEvent(int userID, String sitePageID, Date visitDate) {
		
		this.userID = userID;
		this.sitePageID = sitePageID;
		this.visitDate = visitDate;	
		
	}
	
	public int getID() {
		return id;
		
	}
	
	public void setID(int id) {
		this.id = id;
	}
	
	public int getUserID() {
		return userID;
	}
	
	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	public String getSitePageID() {
		return sitePageID;
	}
	
	public void setSitePageID(String sitePageID) {
		this.sitePageID = sitePageID;
	}
	
	public Date getVisitDate() {
		return visitDate;		
	}
	
	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}
}
