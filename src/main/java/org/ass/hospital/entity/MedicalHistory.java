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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "medical_history")
public class MedicalHistory implements Serializable
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name= "patient_name")
	private String patientName;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name= "person_id")
	//@Column(nullable = false)
	private Person person;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "history")
	private List<MedicalObservation> observations;
	
	

}
