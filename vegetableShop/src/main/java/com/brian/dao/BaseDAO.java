package com.brian.dao;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public abstract class BaseDAO {
	
	@Autowired
	protected SessionFactory sessionFactory;
}
