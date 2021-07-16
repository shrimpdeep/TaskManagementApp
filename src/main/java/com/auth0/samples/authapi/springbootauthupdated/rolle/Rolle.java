package com.auth0.samples.authapi.springbootauthupdated.rolle;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.auth0.samples.authapi.springbootauthupdated.event.Event;
import com.auth0.samples.authapi.springbootauthupdated.user.ApplicationUser;
import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * 
 * @author: Shramdeep Chamlagai
 * @date: 15.07.2021
 * 
 */


@Entity
public class Rolle {

	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String bezeichnung;
	
	@OneToMany(mappedBy="rolleFS")
	@JsonIgnore
	private List<Event> event;
	
	@OneToMany(mappedBy="rolleFs")
	@JsonIgnore
	private List<ApplicationUser> applicationUser;
	
	
	public Rolle() {
		
	}

	public Rolle(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getBezeichnung() {
		return bezeichnung;
	}
	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	public List<Event> getEvent() {
		return event;
	}

	public void setEvent(List<Event> event) {
		this.event = event;
	}

	public List<ApplicationUser> getApplicationUser() {
		return applicationUser;
	}

	public void setApplicationUser(List<ApplicationUser> applicationUser) {
		this.applicationUser = applicationUser;
	}
	
	
	
	
}
