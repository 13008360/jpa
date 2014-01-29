package fr.istic.tpjpa.jpa;

import javax.persistence.*;

@Entity
public class Home {

	private Long id;
	private String  adresse;
	private int superficie;
	private String IP;
	private Person proprietaire;
	

	public Home( String adresse, int superficie, String iP, Person proprietaire) {
		this.adresse = adresse;
		this.superficie = superficie;
		this.IP = iP;
		this.proprietaire = proprietaire;
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public int getSuperficie() {
		return superficie;
	}
	public void setSuperficie(int superficie) {
		this.superficie = superficie;
	}
	public String getIP() {
		return IP;
	}
	public void setIP(String iP) {
		IP = iP;
	}

	@ManyToOne
	public Person getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(Person proprietaire) {
		this.proprietaire = proprietaire;
	}

	
	
	
}
