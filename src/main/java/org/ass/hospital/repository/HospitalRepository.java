package org.ass.hospital.repository;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import org.ass.hospital.entity.Doctor;
import org.ass.hospital.entity.Person;
import org.ass.hospital.util.SessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class HospitalRepository
{
	public void save(List<Doctor> doctor)
	{
     	SessionFactory sf = SessionFactoryUtil.getSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		
		doctor.forEach(e->{
			
			List<Person> p = e.getPerson();
			p.forEach(e2->{
				e2.setDoctors(doctor);
			});
			
			   session.save(e);
		});
		
		transaction.commit();
	}
	
	public Doctor getById(int id)
	{
    	SessionFactory sf = SessionFactoryUtil.getSessionFactory();
    	
		Session session = sf.openSession();
		
	    Doctor doctor = session.get(Doctor.class, id);
	
		
		return doctor;
		
	}
	public Doctor delete(int id)
	{
			SessionFactory sf = SessionFactoryUtil.getSessionFactory();
			Session session = sf.openSession();
			Transaction transaction = session.beginTransaction();
			Doctor doctor = session.get(Doctor.class,id);
			
			session.delete(doctor);
			
			transaction.commit();
			
		
		return doctor;
	}

}
