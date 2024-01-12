package com.vc.entity;

import javax.persistence.*;

@Entity
public class Citizen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String city;
    private int numberOfDoses;
    private String vaccinationStatus;

    @OneToOne
    @JoinColumn(name = "vaccination_center_id")
    private VaccinationCenter vaccinationCenter;
    
    @PreUpdate
    @PrePersist
    private void updateVaccinationStatus() {
        if (numberOfDoses == 2) {
            vaccinationStatus = "fully vaccinated";
        } else if(numberOfDoses == 1) {
            vaccinationStatus = "Partially vaccinated";
        }
        else {
        	vaccinationStatus = "Not Vaccinated";
        }
    }

    // Constructors, getters, setters

    public Citizen() {
        // Default constructor
    }

    public Citizen(String name, String city, int numberOfDoses, String vaccinationStatus) {
        this.name = name;
        this.city = city;
        this.numberOfDoses = numberOfDoses;
        this.vaccinationStatus = vaccinationStatus;
    }


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

	public int getNumberOfDoses() {
		return numberOfDoses;
	}

	public void setNumberOfDoses(int numberOfDoses) {
		this.numberOfDoses = numberOfDoses;
	}

	public String getVaccinationStatus() {
		return vaccinationStatus;
	}

	public void setVaccinationStatus(String vaccinationStatus) {
		this.vaccinationStatus = vaccinationStatus;
	}

	public VaccinationCenter getVaccinationCenter() {
        return vaccinationCenter;
    }

    public void setVaccinationCenter(VaccinationCenter vaccinationCenter) {
        this.vaccinationCenter = vaccinationCenter;
    }
}