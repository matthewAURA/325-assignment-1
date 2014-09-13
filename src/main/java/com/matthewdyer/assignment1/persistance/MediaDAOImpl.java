package com.matthewdyer.assignment1.persistance;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;





import com.matthewdyer.assignment1.domain.MediaItem;
import com.matthewdyer.assignment1.domain.Rating;

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
	
	@Override
	public List<MediaItem> findAll() {
		List<MediaItem> result = this.sessionFactory.getCurrentSession().createQuery("from MediaItem m").list();
		return result;
	}
	
	@Override
	public MediaItem findById(long id) {
		return (MediaItem) this.sessionFactory.getCurrentSession().getNamedQuery("MediaItem.findById").setParameter("id", id).uniqueResult();
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public MediaItem save(MediaItem m) {
			sessionFactory.getCurrentSession().saveOrUpdate(m);
			return m;
	}
	
	@Override
	public void delete(MediaItem m) {
		sessionFactory.getCurrentSession().delete(m);

	}



}
