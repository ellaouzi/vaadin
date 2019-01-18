package com.fosagri.model.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="ADHERENT")
@Data

public class Adherent {

	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer id;

	@NotNull(message="Nom doit non null")
	@Column(name="nom")
	private String nom;

	@NotNull(message="You have to specifiy prenom")
	@Column(name="prenom")
	private String prenom;

	@NotNull(message="You have to specifiy prenom")
	@Column(name="ppr")
	private String ppr;

	@NotNull(message="You have to specifiy position")
	@Column(name="position")
	private String position;

	@NotNull(message=" YOu have to specify age")
	@Min(value=0, message="Minimum value is 0")
	@Max(value=100, message="Maximum value is 100")
	@Column(name="age")
	private Integer age;

	@NotNull(message="You have to set the gender")
	@Column(name="gender")
	private String gender;

	public Adherent() {
		
	}


	

	@Override
	public String toString() {
		return this.nom +"-"+this.prenom+"-"+this.position +"-"+this.gender +"-"+this.ppr+"-"+this.age;
	}
	

}
