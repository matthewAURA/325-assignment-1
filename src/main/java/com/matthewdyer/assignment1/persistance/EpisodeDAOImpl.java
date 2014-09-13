package com.matthewdyer.assignment1.persistance;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;






import com.matthewdyer.assignment1.domain.Episode;
import com.matthewdyer.assignment1.domain.MediaItem;
import com.matthewdyer.assignment1.domain.Rating;

@Repository("episodeDAO")
@Transactional
public class EpisodeDAOImpl implements EpisodeDAO {

	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return this.sessionFactory;
	}

	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public List<Episode> findAll() {
		List<Episode> result = this.sessionFactory.getCurrentSession().createQuery("from Episode m").list();
		return result;
	}
	
	@Override
	public Episode findById(long id) {
		return (Episode) this.sessionFactory.getCurrentSession().getNamedQuery("Episode.findById").setParameter("id", id).uniqueResult();
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public Episode save(Episode m) {
			sessionFactory.getCurrentSession().saveOrUpdate(m);
			return m;
	}
	
	@Override
	public void delete(Episode m) {
		sessionFactory.getCurrentSession().delete(m);

	}



}
