package com.bjv.bjvbackend.articles;

public class ArticleWithoutContent {
	
	private long id;
	private String titre;
	private String theme;
	private Boolean actif;
	
	public ArticleWithoutContent(long id, String titre, String theme, Boolean actif) {
		super();
		this.id = id;
		this.titre = titre;
		this.theme = theme;
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

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public Boolean getActif() {
		return actif;
	}

	public void setActif(Boolean actif) {
		this.actif = actif;
	}
	
	
	

}
