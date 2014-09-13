package com.matthewdyer.assignment1.persistance;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;




import com.matthewdyer.assignment1.domain.MediaItem;
import com.matthewdyer.assignment1.domain.Rating;

@Repository("ratingDAO")
@Transactional
public class RatingDAOImpl implements RatingDAO {

	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return this.sessionFactory;
	}

	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	@Override
	public void save(Rating m) {
		sessionFactory.getCurrentSession().saveOrUpdate(m);
	}
	
	@Override
	public void delete(Rating m) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Rating> findAll() {
		List<Rating> result = this.sessionFactory.getCurrentSession().createQuery("from Rating r").list();
		return result;
	}

	@Override
	public Rating findById(long id) {
		return (Rating) this.sessionFactory.getCurrentSession().getNamedQuery("Rating.findById").setParameter("id", id).uniqueResult();
	}

}
