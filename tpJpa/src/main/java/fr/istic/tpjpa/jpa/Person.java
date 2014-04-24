package fr.istic.tpjpa.jpa;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="Personne")
public class Person {

	private Long id;
	private String nom;
	private String prenom;
	private String genre;
	private String mail;
	private String datenaissance;
	private String profil;
	private List<Person> friends;
	private List<Home> residences;

	public Person(){
			super();
	}

	public Person( String nom, String prenom, String genre, String mail, String datenaissance, String profil) {
		this.nom = nom;
		this.prenom = prenom;
		this.genre = genre;
		this.mail = mail;
		this.datenaissance = datenaissance;
		this.profil = profil;
		this.setFriends(null);
		this.setResidences(null);;
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
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
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getDatenaissance() {
		return datenaissance;
	}
	public void setDatenaissance(String datenaissance) {
		this.datenaissance = datenaissance;
	}
	public String getProfil() {
		return profil;
	}
	public void setProfil(String profil) {
		this.profil = profil;
	}

	@OneToMany(mappedBy = "proprietaire", cascade = CascadeType.PERSIST)
	public List<Home> getResidences() {
		return residences;
	}

	public void setResidences(List<Home> residences) {
		this.residences = residences;
	}
	
	
	@ManyToMany(mappedBy="friends", cascade = CascadeType.PERSIST)
	public List<Person> getFriends() {
		return friends;
	}

	public void setFriends(List<Person> friends) {
		this.friends = friends;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Person [id=" + id + ", nom=" + nom + ", prenom=" + prenom
				+ ", genre=" + genre + ", mail=" + mail + ", datenaissance="
				+ datenaissance + ", profil=" + profil + "]";
	}
	
	
}
