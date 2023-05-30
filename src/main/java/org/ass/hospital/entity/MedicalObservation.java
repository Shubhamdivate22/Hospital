package org.ass.hospital.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "medical_observation")
public class MedicalObservation implements Serializable
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String encounter;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "medicalObservation")
	private List<Doctor> doctors;	
	
   @ManyToOne(cascade = CascadeType.ALL)
   @JoinColumn(name= "medical_id")
   //@Column(nullable = false)
   private MedicalHistory history;	
	
}
