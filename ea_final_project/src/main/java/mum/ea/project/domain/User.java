package mum.ea.project.domain;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="User_Role", discriminatorType=DiscriminatorType.STRING)
public abstract class User {
	@Id
	@GeneratedValue
	private int id;
	
	private String name;
	
	private String username;
	private String password;

}
