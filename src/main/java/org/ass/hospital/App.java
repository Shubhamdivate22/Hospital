package org.ass.hospital;

import java.util.ArrayList;
import java.util.List;

import org.ass.hospital.entity.Doctor;
import org.ass.hospital.entity.MedicalHistory;
import org.ass.hospital.entity.MedicalObservation;
import org.ass.hospital.entity.Person;
import org.ass.hospital.repository.HospitalRepository;

public class App {

	public static void main(String[] args)
	{	
        Doctor doctor1 = new Doctor();
		doctor1.setName("shubham");
		doctor1.setEmail("pass@123");
		doctor1.setSpecialization("neuro surgeon");
		doctor1.setAvailability(true);
		
		Doctor doctor2 = new Doctor();
		doctor2.setName("rushi");
		doctor2.setEmail("pass@1");
		doctor2.setSpecialization("brain specialist");
		doctor2.setAvailability(true);
			
		Person person = new Person();
		person.setName("tushar");
		person.setEmail("tushar@12");
		person.setAge(22);
		person.setAddress("Latur");
		
		
		Person person2 = new Person();
		person2.setName("deepak");
		person2.setEmail("tusharu@123");
		person2.setAge(25);
		person2.setAddress("Laturuuu");
		
		
		
		MedicalHistory medicalHistory = new MedicalHistory();
		medicalHistory.setPatientName("tushar");
		medicalHistory.setPerson(person2);
		person2.setHistory(medicalHistory);
		
			
		MedicalObservation medicalObservation = new MedicalObservation();
		medicalObservation.setEncounter("fever");
		
		MedicalObservation medicalObservation1 = new MedicalObservation();
		medicalObservation1.setEncounter("cold");
		
		MedicalObservation medicalObservation2 = new MedicalObservation();
		medicalObservation2.setEncounter("headache");
		
		List<MedicalObservation> list4= new ArrayList<MedicalObservation>();
		list4.add(medicalObservation);
		list4.add(medicalObservation1);
		list4.add(medicalObservation2);
		
		medicalHistory.setObservations(list4);
	
	
		medicalObservation.setHistory(medicalHistory);
		medicalObservation1.setHistory(medicalHistory);
		medicalObservation2.setHistory(medicalHistory);
		
		List<Person> p1=new ArrayList<Person>();
		
		p1.add(person);
		p1.add(person2);
		
		List<Doctor> d1=new ArrayList<Doctor>();
		doctor1.setPerson(p1);
		doctor2.setPerson(p1);
		d1.add(doctor1);
		d1.add(doctor2);
		
		medicalObservation.setDoctors(d1);
	    doctor1.setMedicalObservation(medicalObservation);
	    doctor2.setMedicalObservation(medicalObservation);
	    
	  
		
		HospitalRepository hr=new HospitalRepository();
		
	    hr.save(d1);
		    
      //   Doctor p = hr.delete(3);
     //    System.out.println(p);
		
	}

}
