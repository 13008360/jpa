package fr.istic.tpjpa.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="Maison")
public class Home {

	private Long id;
	private String  adresse;
	private int superficie;
	private String IP;
	private Person proprietaire;

	private List<ElectronicDevice> equipements = new ArrayList<ElectronicDevice>();
	private List<Heater> chauffages = new ArrayList<Heater>();




	public Home(){
		super();
	}


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

	@OneToMany(mappedBy="equipements",cascade=CascadeType.PERSIST)
	public List<ElectronicDevice> getEquipements() {
		return equipements;
	}


	public void setEquipements(List<ElectronicDevice> equipements) {
		this.equipements = equipements;
	}

	@OneToMany(mappedBy="chauffages",cascade=CascadeType.PERSIST)
	public List<Heater> getChauffages() {
		return chauffages;
	}


	public void setChauffages(List<Heater> chauffages) {
		this.chauffages = chauffages;
	}

	@Override
	public String toString() {
		return "Home [id=" + id + ", adresse=" + adresse + ", superficie="
				+ superficie + ", IP=" + IP + "]";
	}


}
