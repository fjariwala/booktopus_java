package com.bean.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bean.Entity.UserDetails;

/*
 * This annotation automatically registers our DAO class into the dispatcher-servlet.xml file
 * This work of automatically registration is done by Spring in the back-end
 * */
@Repository
public class User_DAO_Impl implements User_DAO {

	/* Need to inject the session factory from dispatcher-servlet file here */
	/*
	 * We write 'Autowired' just to connect our sessionFactory object from This
	 * class to the dispatcher-servlet's step 2's id object
	 */
	@Autowired
	private SessionFactory sessionFactory;

	/*
	 * @Transactional => This annotation is used for : When we use this annotation
	 * it automatically begins the transaction and it automatically commits the
	 * transaction
	 */
	@Transactional
	public String registerUser(UserDetails userData) {
		// TODO Auto-generated method stub

		Session session = sessionFactory.getCurrentSession();

		try {

			session.saveOrUpdate(userData);

			return "You are registerd with email id :" + userData.getEmail() + "";

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			return "Error :" + e;
		}

	}

	public UserDetails login(UserDetails userData) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	public Boolean checkUser(UserDetails userData) {
		// TODO Auto-generated method stub

		Session session = sessionFactory.getCurrentSession();

		String q = "from UserDetails s where s.email='" + userData.getEmail() + "' ";
		Query<UserDetails> query = session.createQuery(q, UserDetails.class);

		/*
		 * query null means no user !! true == exists && false == doesn't exists
		 */
		if (query.getResultList() == null) {
			return false;
		} else {
			return true;
		}

	}

}
