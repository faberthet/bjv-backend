package com.bjv.bjvbackend.articles;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="articles")
public class Article {
	
@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
private long id;
private String titre;
//private String theme;
private String section;
private String subsection;
//@Column(columnDefinition="TEXT")
@Lob
private String content;

private Boolean actif;

public Article() {}

public Article(long id, String titre, String section, String subsection, String content, Boolean actif) {
	super();
	this.id = id;
	this.titre = titre;
	//this.theme = theme;
	this.section=section;
	this.subsection=subsection;
	this.content = content;
	this.actif = actif;
}

public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getTitre() {
	return titre;
}
public void setTitre(String titre) {
	this.titre = titre;
}
/*public String getTheme() {
	return theme;
}
public void setTheme(String theme) {
	this.theme = theme;
}*/
public String getSection() {
	return section;
}

public void setSection(String section) {
	this.section = section;
}

public String getSubsection() {
	return subsection;
}

public void setSubsection(String subsection) {
	this.subsection = subsection;
}

public String getContent() {
	return content;
}

public void setContent(String content) {
	this.content = content;
}
public Boolean getActif() {
	return actif;
}
public void setActif(Boolean actif) {
	this.actif = actif;
}



	
}
