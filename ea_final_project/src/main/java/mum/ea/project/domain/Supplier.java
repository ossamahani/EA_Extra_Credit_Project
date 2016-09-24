package mum.ea.project.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="ROLE_SUPPLIER")
public class Supplier extends User{

}
