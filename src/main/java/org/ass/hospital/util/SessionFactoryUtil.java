package org.ass.hospital.util;

import org.ass.hospital.entity.Doctor;
import org.ass.hospital.entity.MedicalHistory;
import org.ass.hospital.entity.Person;
import org.ass.hospital.entity.MedicalObservation;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class SessionFactoryUtil 
{
	private static SessionFactory sessionFactory= null;
	
	public static SessionFactory getSessionFactory()
	{
		if(sessionFactory== null)
		{
		   Configuration cfg = new Configuration();
		   cfg.setProperties(ConnectionUtil.getDbProperties());
		   cfg.addAnnotatedClass(Doctor.class);
		   cfg.addAnnotatedClass(MedicalHistory.class);
		   cfg.addAnnotatedClass(Person.class);
		   cfg.addAnnotatedClass(MedicalObservation.class);
		    sessionFactory = cfg.buildSessionFactory();
		}
		return sessionFactory;
	}

}
