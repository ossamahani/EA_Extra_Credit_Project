package mum.ea.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import mum.ea.project.dao.ProviderDao;
import mum.ea.project.domain.Provider;

public class ProviderServiceImpl implements ProviderService{

	@Autowired
	private ProviderDao providerDao;
	
	public void registerProvider(Provider provider) {
	    providerDao.save(provider);
	}

	public List<Provider> getAllProviders() {
		return providerDao.findAll();
	}

}
