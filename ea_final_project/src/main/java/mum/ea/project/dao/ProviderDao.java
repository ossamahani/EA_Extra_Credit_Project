package mum.ea.project.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import mum.ea.project.domain.Provider;

public interface ProviderDao extends JpaRepository<Provider, Serializable> , CrudRepository<Provider, Serializable>{

}
