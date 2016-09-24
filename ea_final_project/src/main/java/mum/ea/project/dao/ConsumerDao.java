package mum.ea.project.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mum.ea.project.domain.Consumer;


@Repository
public interface ConsumerDao extends JpaRepository<Consumer, Serializable> , CrudRepository<Consumer, Serializable>{

}
