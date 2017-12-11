package org.learning.hb.model.inheritance;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor

@Entity
//@DiscriminatorValue("vehicle_truck")
public class Truck extends VehicleInheritance {

	@Getter @Setter
	private float maxLoadWeight; 
}
