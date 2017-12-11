package org.learning.hb.model.inheritance;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor

@Entity
//@DiscriminatorValue("vehicle_car")
public class Car extends VehicleInheritance {
	
	@Getter @Setter
	private String type;

}
