package com.vc.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vaccinationcenter")
public class VaccinationCenter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private String name;
    private String city;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	@Override
	public String toString() {
		return "VaccinationCenter [id=" + id + ", name=" + name + ", city=" + city + "]";
	}
	public VaccinationCenter() {
		super();
		// TODO Auto-generated constructor stub
	}
	public VaccinationCenter(String name, String city) {
		super();
		this.name = name;
		this.city = city;
	}

}
