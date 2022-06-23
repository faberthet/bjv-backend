package contact;



public class ContactModel {
	
	private String nom;
	private String prenom;
	private String email;
	private String societe;
	private String message;
	
	public ContactModel(String nom, String prenom, String email, String societe, String message) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.societe = societe;
		this.message = message;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSociete() {
		return societe;
	}

	public void setSociete(String societe) {
		this.societe = societe;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
	//	return "nom= " + nom + ", prenom= " + prenom + ", email= " + email + ", societe= " + societe
	//			+ ", message=" + message;
		return "nom= " + nom + "\nprenom= " + prenom + "\nemail= " + email + "\nsociete= " + societe
				+ "\nmessage=" + message;
	}

}