package com.bjv.bjvbackend.articles;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="articles")
public class Article {
	
@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
private long id;
private String titre;
private String theme;
private String content;

public Article() {}

public Article(String titre, String theme, String content) {
	super();
	this.titre = titre;
	this.theme = theme;
	this.content = content;
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
public String getTheme() {
	return theme;
}
public void setTheme(String theme) {
	this.theme = theme;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}



	
}
