package org.learning.hb.model.inheritance;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

@Entity

@Inheritance(strategy=InheritanceType.JOINED)

//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)

//@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name="vehicle_type", discriminatorType=DiscriminatorType.STRING)

public class VehicleInheritance {
	
	@Id
	@GeneratedValue
	private int id;
	
	private String name;
	
	private String producer;
	
	private String model;
	
}
