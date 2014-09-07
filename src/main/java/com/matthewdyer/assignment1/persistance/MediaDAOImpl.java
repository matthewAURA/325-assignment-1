package com.matthewdyer.assignment1.persistance;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.matthewdyer.assignment1.domain.Media;

@Repository("mediaDAO")
@Transactional
public class MediaDAOImpl implements MediaDAO {

	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return this.sessionFactory;
	}

	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional(readOnly=true)
	public List<Media> findAll() {
		List<Media> result = this.sessionFactory.getCurrentSession().createQuery("from Media m").list();
		return result;
	}

	public Media findById(long id) {
		return (Media) this.sessionFactory.getCurrentSession().getNamedQuery("Media.findById").setParameter("id", id).uniqueResult();
	}

	public void save(Media m) {
		// TODO Auto-generated method stub

	}

	public void delete(Media m) {
		// TODO Auto-generated method stub

	}

}
