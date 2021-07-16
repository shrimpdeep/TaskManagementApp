package com.auth0.samples.authapi.springbootauthupdated.task;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.auth0.samples.authapi.springbootauthupdated.user.ApplicationUser;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 
 * @author: Shramdeep Chamlagai
 * @date: 15.07.2021
 * 
 */


@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String description;
    private LocalDateTime date;
    
   
    @ManyToOne
    @JoinColumn(name = "task_id", referencedColumnName = "id")
    @JsonIgnore
    private ApplicationUser applicationUser; 

    protected Task() { 
    	
    }

    public Task(String description) {
        this.description = description;
    }
    
    public Task(String description, LocalDateTime date) {
		this.description = description;
		this.date = date;
	}

    
    public Task(String description, LocalDateTime date, ApplicationUser applicationUser) {
		this.description = description;
		this.date = date;
		this.applicationUser = applicationUser;
	}

	public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

	public ApplicationUser getApplicationUser() {
		return applicationUser;
	}

	public void setApplicationUser(ApplicationUser applicationUser) {
		this.applicationUser = applicationUser;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	

	
    
    
}