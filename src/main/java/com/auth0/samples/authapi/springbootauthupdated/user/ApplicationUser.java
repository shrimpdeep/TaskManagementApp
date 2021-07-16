package com.auth0.samples.authapi.springbootauthupdated.user;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.auth0.samples.authapi.springbootauthupdated.rolle.Rolle;
import com.auth0.samples.authapi.springbootauthupdated.task.Task;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author: Shramdeep Chamlagai
 * @date: 15.07.2021
 *
 */


@Entity
public class ApplicationUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String username;
	private String password;
	
	
	@ManyToOne
	@JoinColumn(name = "rolle_id", referencedColumnName="id")
	
	private Rolle rolleFs;
	
	@OneToMany(mappedBy = "applicationUser")
	private List<Task> tasks;

	
	public ApplicationUser() {
		this.tasks = new ArrayList<Task>();
	}

	public ApplicationUser(String username, String password) {
		this.username = username;
		this.password = password;
		this.tasks = new ArrayList<Task>();

	}
	
	

	public ApplicationUser(String username, String password, Rolle rolleFs) {
		this.username = username;
		this.password = password;
		this.rolleFs = rolleFs;
		this.tasks = new ArrayList<Task>();
	}



	public long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Rolle getRolleFs() {
		return rolleFs;
	}

	public void setRolleFs(Rolle rolleFs) {
		this.rolleFs = rolleFs;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public void addTask(Task task) {
		tasks.add(task);
	}
	
	

}
