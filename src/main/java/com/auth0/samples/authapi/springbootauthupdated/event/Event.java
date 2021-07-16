package com.auth0.samples.authapi.springbootauthupdated.event;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.auth0.samples.authapi.springbootauthupdated.rolle.Rolle;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 
 * @author: Shramdeep Chamlagai
 * @date: 15.07.2021
 * 
 */

@Entity
public class Event {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	private String bezeichnung;
	private LocalDateTime wann; 
	private LocalDateTime erstelltAm;
	
	@ManyToOne
	@JoinColumn(name ="event_id", referencedColumnName = "id")
	private Rolle rolleFS;

	public Event() {
	
	}

	public Event(String bezeichnung, LocalDateTime wann, LocalDateTime erstelltAm, Rolle rolleFS) {
		this.bezeichnung = bezeichnung;
		this.wann = wann;
		this.erstelltAm = erstelltAm;
		this.rolleFS = rolleFS;
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

	public Rolle getRolleFS() {
		return rolleFS;
	}

	public void setRolleFS(Rolle rolleFS) {
		this.rolleFS = rolleFS;
	}

	public LocalDateTime getWann() {
		return wann;
	}

	public void setWann(LocalDateTime wann) {
		this.wann = wann;
	}

	public LocalDateTime getErstelltAm() {
		return erstelltAm;
	}

	public void setErstelltAm(LocalDateTime erstelltAm) {
		this.erstelltAm = erstelltAm;
	}

	
	
	
}
