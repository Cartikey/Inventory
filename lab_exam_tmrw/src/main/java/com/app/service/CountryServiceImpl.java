package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ICountryDao;
import com.app.dao.IUserDao;
import com.app.entities.Country;
import com.app.entities.User;

@Service
@Transactional
public class CountryServiceImpl implements ICountryService {

	@Autowired
	private ICountryDao countryDao;
	@Autowired
	private  IUserDao userDao;
	@Override
	public List<Country> getAllCountries() {
		return countryDao.findAll();
	
	}
	@Override
	public Country addCountryDetails(Country c, long id) {
		User details = userDao.findById(id).orElseThrow();
		c.setUser(details);
		
		return countryDao.save(c);
	}
	@Override
	public void deleteCountry(long ctId) {
		countryDao.deleteById(ctId);
		
	}
	

	

}
