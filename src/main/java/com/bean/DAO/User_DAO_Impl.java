package com.bean.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bean.Entity.UserDetails;
import com.bean.Hashing.Password;

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
			/*
			 * Encoding the password
			 */
			Password pw = new Password();

			String password = pw.getSaltedHash(userData.getPassword());
			userData.setPassword(password);

			/* Save or Update */
			session.save(userData);

			return "You are registerd with email id :" + userData.getEmail() + "";

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			return "Error :" + e;
		}
	}

	@Transactional
	public UserDetails login(UserDetails userData) {
		// TODO Auto-generated method stub

		Session session = sessionFactory.getCurrentSession();
		Query<UserDetails> query = null;

		try {

			String q = "from UserDetails s where s.email='" + userData.getEmail() + "' ";
			query = session.createQuery(q, UserDetails.class);
			/*
			 * The new method called uniqueResult() , returns either a user if
			 * available.......... or null when not available
			 */
			UserDetails user = query.uniqueResult();

			/*
			 * Decoding the password
			 */
			Password pw = new Password();
			/*
			 * If the password match then it will return true otherwise false
			 */
			Boolean passwordMatch = pw.check(userData.getPassword(), user.getPassword());

			if (passwordMatch == true) {
				return user;
			} else {
				return null;
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Transactional
	public UserDetails checkUser(UserDetails userData) {
		// TODO Auto-generated method stub

		Query<UserDetails> query = null;

		Session session = sessionFactory.getCurrentSession();

		String q = "from UserDetails s where s.email='" + userData.getEmail() + "' ";
		query = session.createQuery(q, UserDetails.class);
		/*
		 * query null means no user !! true == exists && false == doesn't exists
		 */
		UserDetails user = query.uniqueResult();

		return user;
	}

	@Transactional
	public UserDetails getIndividualuser(int userId) {
		// TODO Auto-generated method stub

		Session session = sessionFactory.getCurrentSession();

		UserDetails userData = session.get(UserDetails.class, userId);

		return userData;
	}

}
