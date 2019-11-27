package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.User;


@Repository
public class UserDaoImpl implements UserDao {
	
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public User createUser(User user) {
		Session session = this.sessionFactory.openSession();
		session.save(user);
		return user;
	}

	@Override
	public List<User> readUser() {
		Session session = this.sessionFactory.openSession();
		//HQL Query
		String readUser = "from User";
		List<User> user = session.createQuery(readUser).list();
		return user;
	}

	@Override
	public User readUserById(int userId) {
		Session session = this.sessionFactory.openSession();
//		String hqlRead = "FROM User alais WHERE alais.userId = 1";
//		List<User> users = session.createQuery(hqlRead).list();
		
		String hqlRead = "from User U WHERE U.userId = :userId";
		List<User> users = session.createQuery(hqlRead)
		.setParameter("userId", userId)
		.list();
		return users.get(0);
	}

	@Override
	public User readUserByName(int userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateUser(User user) {
		Session session = this.sessionFactory.openSession();
		session.saveOrUpdate(user);
		return user;
	}

	@Override
	public User deleteUserById(int userId) {
		Session session = this.sessionFactory.openSession();
		//session.load(User.class, new Integer(userId));
		//autoboxing
		User obj = session.load(User.class,userId);
		if(obj!=null)
		{
			
		}
		session.delete(obj);
		return obj;
	}

}
