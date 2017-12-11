package org.learning.hb.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

@Entity
@Table(name="user_details")
public class UserDetails {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int userId;

	@Column( name="user_name" )
	private String name;
	
	@Column( name="user_email" )
	private String email;
	
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@Lob
	private String description;
	
	@Embedded
	private Friend bestFriendMale; 

	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="name", column=@Column(name="friend_girl_name")),
		@AttributeOverride(name="age", column=@Column(name="friend_girl_age")),
	})
	private Friend bestFriendFemale; 
	
	@ElementCollection
	@JoinTable(name="user_address", joinColumns=@JoinColumn(name="user_id"))
	@GenericGenerator(name="sequence-gen",strategy="sequence")
	@CollectionId(columns={@Column(name="id")}, generator="sequence-gen", type=@Type(type="long")  )
	private Collection<Address> adresses = new ArrayList<Address>(); 
	
	@OneToOne
	@JoinColumn(name="vehicle_id")
	private Vehicle vehicle;
	
	@OneToMany
	@JoinTable(name="users_interests", joinColumns=@JoinColumn(name="user_id"), inverseJoinColumns=@JoinColumn(name="interests_id") )
	private Collection<Interests> interests = new ArrayList<Interests>();
	
	@ManyToMany
	@JoinTable(name="users_foods", joinColumns=@JoinColumn(name="user_id"), inverseJoinColumns=@JoinColumn(name="food_id") )
	private Collection<Food> favouriteFoods = new ArrayList<Food>();
	
}
