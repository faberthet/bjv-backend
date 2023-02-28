package com.bjv.bjvbackend.articles;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sections")
public class Section {
	@Id
	String name;
	
	public Section() {}

	public Section(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
