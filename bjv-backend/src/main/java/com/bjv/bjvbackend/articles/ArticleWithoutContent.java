package com.bjv.bjvbackend.articles;

public class ArticleWithoutContent {
	
	private long id;
	private String titre;
	//private String theme;
	private String section;
	private String subsection;
	private Boolean actif;
	
	public ArticleWithoutContent(long id, String titre, String section, String subsection, Boolean actif) {
		super();
		this.id = id;
		this.titre = titre;
		//this.theme = theme;
		this.section=section;
		this.subsection=subsection;
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

	public Boolean getActif() {
		return actif;
	}

	public void setActif(Boolean actif) {
		this.actif = actif;
	}
	
	
	

}
