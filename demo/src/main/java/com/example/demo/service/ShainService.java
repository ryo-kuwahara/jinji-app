package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.repository.ShainServiceRepository;

@Service
public class ShainService implements ShainServiceImp{
	
	private ShainServiceRepository shainServiceRipository;
	
	public ShainService(ShainServiceRepository shainServiceRipository) {
		this.shainServiceRipository = shainServiceRipository;
	}
	
	@Override
	public String findByNo(String number) {
		
		String name = shainServiceRipository.selectByNo(number);
		
		return name;
	}
}
