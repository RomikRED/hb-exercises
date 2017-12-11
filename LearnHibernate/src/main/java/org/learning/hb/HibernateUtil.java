package org.learning.hb;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Inheritance;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

public class HibernateUtil {
	private static StandardServiceRegistry registry;
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory(){
		if( sessionFactory==null ){
			try {
				StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();
				
				Map<String, String> setting = new HashMap<String, String>();
				setting.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
				setting.put(Environment.URL, "jdbc:mysql://127.0.0.1/testdatabase?autoReconnect=true&useSSL=false");
				setting.put(Environment.USER, "testuser");
				setting.put(Environment.PASS, "password");
				setting.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
				setting.put(Environment.HBM2DDL_AUTO, "create");
				setting.put(Environment.SHOW_SQL, "true");
//				setting.put(Environment.CACHE_PROVIDER_CONFIG, "org.hibernate.cache.internal.NoCachingRegionFactory");
				
				registryBuilder.applySettings(setting);
				
				registry = registryBuilder.build();

				MetadataSources sources = new MetadataSources(registry)
						.addAnnotatedClass(org.learning.hb.model.UserDetails.class)
						.addAnnotatedClass(org.learning.hb.model.Vehicle.class)
						.addAnnotatedClass(org.learning.hb.model.Interests.class)
						.addAnnotatedClass(org.learning.hb.model.Food.class)
						.addAnnotatedClass(org.learning.hb.model.cascade.UserDetailsCascade.class)
						.addAnnotatedClass(org.learning.hb.model.inheritance.VehicleInheritance.class)
						.addAnnotatedClass(org.learning.hb.model.inheritance.Car.class)
						.addAnnotatedClass(org.learning.hb.model.inheritance.Truck.class);
				
				Metadata metadata = sources.getMetadataBuilder().build();
				
				sessionFactory = metadata.getSessionFactoryBuilder().build();
			} catch (Exception e) {
				e.printStackTrace();
				shutdown();
			}
		}
		return sessionFactory;
	}
	
	public static void shutdown(){
		if( registry!=null ) {
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}

}
