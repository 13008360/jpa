package fr.istic.tpjpa.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Heater {

	private int id;
	@ManyToOne
	private Home maison;
	private String nom;
	private int consoMoyWatt;

	public Heater() {
		super();
	}

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getconsoMoyWatt() {
		return consoMoyWatt;
	}
	public void setconsoMoyWatt(int consoMoyWatt) {
		this.consoMoyWatt = consoMoyWatt;
	}

	@Override
	public String toString() {
		return "Heater [id=" + id + ", nom=" + nom + ", consommation moyenne watt=" + consoMoyWatt
				+ "]";
	}
}