package cn.edu.nsu.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
   private static SessionFactory sessionFactory;
   
   static{
	   try{
		   Configuration cfg=new Configuration().configure();
		   StandardServiceRegistry sr=
				   new StandardServiceRegistryBuilder()
				   .applySettings(cfg.getProperties()).build();
		   sessionFactory=cfg.buildSessionFactory(sr);
	   }catch(Exception e){
		   e.printStackTrace();
	   }
   }
   public static SessionFactory getSessionFactory(){
	   return sessionFactory;
   }
}