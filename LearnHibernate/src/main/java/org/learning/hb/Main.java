package org.learning.hb;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.learning.hb.model.Address;
import org.learning.hb.model.Brands;
import org.learning.hb.model.Country;
import org.learning.hb.model.Food;
import org.learning.hb.model.Friend;
import org.learning.hb.model.Interests;
import org.learning.hb.model.UserDetails;
import org.learning.hb.model.Vehicle;
import org.learning.hb.model.cascade.UserDetailsCascade;
import org.learning.hb.model.inheritance.Car;
import org.learning.hb.model.inheritance.Truck;
import org.learning.hb.model.inheritance.VehicleInheritance;

public class Main {

	public static void main(String[] args) {
		long before = System.currentTimeMillis(); 
		
//		hiberbateBasics();		    
//		hibernateCascade();
//		hibernateInheritance();
		System.out.println(System.currentTimeMillis() - before);
	}

	private static void hibernateInheritance() {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		
		VehicleInheritance vehicleInheritance = new VehicleInheritance();
		vehicleInheritance.setName("Small vehicle");
		vehicleInheritance.setProducer("BMW");
		vehicleInheritance.setModel("175-AZ");
		
		Car car = new Car();
		car.setName("Red one");
		car.setProducer("Toyota");
		car.setModel("Corolla");
		car.setType("sedan");
		
		Truck truck = new Truck();
		truck.setName("HeavyHammer");
		truck.setProducer("Volvo");
		truck.setModel("SX450");
		truck.setMaxLoadWeight(45.3f);
		
		session.save(vehicleInheritance);
		session.save(car);
		session.save(truck);
		
		
		
		session.getTransaction().commit();
		session.close();
	}


	private static void hibernateCascade() {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		
		UserDetailsCascade user = new UserDetailsCascade();
			user.setName("User Cascade");
			user.setEmail("user@cascade.hb");
			user.getVehicles().add(new Vehicle("MG", "CHINA_CAR"));
			user.getVehicles().add(new Vehicle("ZAZ", "UA_ZAZ"));
			
			session.persist(user);
			session.getTransaction().commit();
			session.close();
	}


	private static void hiberbateBasics() {
		Session session = getSessionFactory().openSession();
	    session.beginTransaction();

    	UserDetails user = new UserDetails();
    		user.setName("User1");
	    	user.setEmail("mail@mail");
	    	user.setDate(new Date());
	    	user.setDescription("Some LARGE description");
    	
    	Friend bob = new Friend("Bob", (short)14);
    	Friend ammy = new Friend("Ammy", (short)12);
    	
	    	user.setBestFriendMale(bob);
	    	user.setBestFriendFemale(ammy);
	
    	Country countryUa = new Country("UA", "ukrainian");
    	Address workAddress = new Address(countryUa, "city", "state", 556);
    	Address homeAddress = new Address(countryUa, "city", "state", 355);
	    	
    		user.getAdresses().add(workAddress);
	    	user.getAdresses().add(homeAddress);

    	Vehicle vehicle = new Vehicle(Brands.MERCEDES.toString(), "Vito");
    		vehicle.setOwner(user);
    		
    		user.setVehicle(vehicle);
    		
    	Interests ride = new Interests();
    		ride.setInterest("Riding");
    	Interests dance = new Interests();
    		dance.setInterest("Dancing");
    	
    		user.getInterests().add(ride);
    		user.getInterests().add(dance);
    	
    	Food chips = new Food();
    		chips.setName("frighted chips with fish");
    		chips.getUsers().add(user);
		Food turkey = new Food();
    		turkey.setName("grilled turkey with tomatoes");
    		turkey.getUsers().add(user);
    	
    		user.getFavouriteFoods().add(chips);
    		user.getFavouriteFoods().add(turkey);
    		
    	
		session.save(user);
    	session.save(vehicle);
    	session.save(chips);
    	session.save(turkey);
    	session.save(ride);
    	session.save(dance);
    	session.getTransaction().commit();
	    session.close();
	    
	    user = null;
	    
	    session = getSessionFactory().openSession();
	    user = (UserDetails) session.get(UserDetails.class, 1);

	    System.out.println(user.getAdresses().size());
	    session.close();
	    
	    HibernateUtil.shutdown();
	}
	

	private static SessionFactory getSessionFactory(){
		return HibernateUtil.getSessionFactory();
	}
}
