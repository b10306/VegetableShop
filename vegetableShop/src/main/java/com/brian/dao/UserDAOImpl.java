package com.brian.dao;

import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.brian.entity.User;

@Repository
public class UserDAOImpl extends BaseDAO implements UserDAO{

	@Override
	public void addUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(user);
	}

	@Override
	public User getUserByName(String userName) {
		Session session = sessionFactory.getCurrentSession();
		User user;
		try {
			Query query = session.createQuery("from User where userName = :userName", User.class);
			query.setParameter("userName", userName);
			user = (User) query.getSingleResult();
			return user;
		} catch (Exception e) {
			//沒找到資料，回傳空值
			return null;
		}
	}

	@Override
	public User getUserByNameAndPwd(String userName, String pwd) {
		Session session = sessionFactory.getCurrentSession();
		User user;
		try {
			Query query = session.createQuery("from User where userName = :userName and pwd = :pwd", User.class);
			query.setParameter("userName", userName);
			query.setParameter("pwd", pwd);
			user = (User) query.getSingleResult();
			return user;
		} catch (Exception e) {
			//沒找到資料，回傳空值
			return null;
		}
	}

	@Override
	public User getUserById(int id) {
		Session session = sessionFactory.getCurrentSession();
		User user = session.get(User.class, id);
		return user;
	}

}
