package com.matthewdyer.assignment1.persistance;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.matthewdyer.assignment1.domain.MediaItem;

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
	public List<MediaItem> findAll() {
		List<MediaItem> result = this.sessionFactory.getCurrentSession().createQuery("from MediaItem m").list();
		return result;
	}

	public MediaItem findById(long id) {
		return (MediaItem) this.sessionFactory.getCurrentSession().getNamedQuery("MediaItem.findById").setParameter("id", id).uniqueResult();
	}

	public void save(MediaItem m) {
		// TODO Auto-generated method stub

	}

	public void delete(MediaItem m) {
		// TODO Auto-generated method stub

	}

}
