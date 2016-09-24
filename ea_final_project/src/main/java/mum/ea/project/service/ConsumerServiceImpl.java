package mum.ea.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mum.ea.project.dao.ConsumerDao;
import mum.ea.project.domain.Consumer;

@Service
@Transactional
public class ConsumerServiceImpl implements ConsumerService{

	
	@Autowired
	private ConsumerDao consumerDao;
	
	
	public void register(Consumer consumer) {
		consumerDao.saveAndFlush(consumer);
	}

}
