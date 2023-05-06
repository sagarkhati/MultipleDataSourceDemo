package com.ssk.db2.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int projId;
	private String projName;

	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Project(int projId, String projName) {
		super();
		this.projId = projId;
		this.projName = projName;
	}

	public int getProjId() {
		return projId;
	}

	public void setProjId(int projId) {
		this.projId = projId;
	}

	public String getProjName() {
		return projName;
	}

	public void setProjName(String projName) {
		this.projName = projName;
	}

}
