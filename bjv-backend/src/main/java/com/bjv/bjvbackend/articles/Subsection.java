package com.bjv.bjvbackend.articles;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="subsections")
public class Subsection {
	
	@Id
	String name;
	String sectionName;
	
	public Subsection() {}
	
	public Subsection(String name, String sectionName) {
		super();
		this.name = name;
		this.sectionName = sectionName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}
	

}
