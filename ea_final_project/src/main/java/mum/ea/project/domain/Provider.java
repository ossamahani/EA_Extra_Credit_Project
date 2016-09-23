package mum.ea.project.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="ROLE_PROVIDER")
public class Provider extends User{

}
