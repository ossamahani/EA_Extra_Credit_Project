package mum.ea.project.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="ROLE_CONSUMER")
public class Consumer extends User{

}
