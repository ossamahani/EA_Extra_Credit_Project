package mum.ea.project.service;

import java.util.List;

import mum.ea.project.domain.Provider;

public interface ProviderService {
	
	 void registerProvider(Provider provider);
	 List<Provider> getAllProviders();


}
