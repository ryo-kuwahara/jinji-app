package com.example.demo.repository;

import org.springframework.stereotype.Repository;

@Repository
public class ShainServiceRepository implements ShainServiceRepositoryImpl{

	@Override
	public String selectByNo(String number) {
		
		String name;
		
		switch (number) {
		case "100":
		name = "佐藤"; break;
		case "101":
		name = "鈴木"; break;
		default :
		name = "登録されていません。"; break;
		
		}
		
		return name;
	}
	
}
