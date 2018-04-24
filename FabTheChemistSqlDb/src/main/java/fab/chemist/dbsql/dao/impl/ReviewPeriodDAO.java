package fab.chemist.dbsql.dao.impl;

import java.util.Date;

import javax.persistence.criteria.CriteriaBuilder;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import fab.chemist.db.framework.dao.impl.GenericDAO;
import fab.chemist.dbsql.dao.interf.IReviewPeriodDAO;
import fab.chemist.dbsql.orm.impl.ReviewPeriod;
import fab.chemist.dbsql.orm.interf.IReviewPeriod;

@Service
@Component 
@Repository(IReviewPeriodDAO.BEAN_NAME)
public class ReviewPeriodDAO extends GenericDAO<ReviewPeriod, Long> implements IReviewPeriodDAO {
	
	@SuppressWarnings({"unused"})
	private static Logger LOGGER = LoggerFactory.getLogger(ReviewPeriod.class); 
	
	
	public String getEntityName() {
		return IReviewPeriod.ENTITY_NAME;
	}


	@Override
	public Class<ReviewPeriod> getEntityClass() {
		return ReviewPeriod.class;
	}


	public ReviewPeriod getReviewPeriodForAPeriod(Date startDate,Date endDate){
		Session session = sessionFactory.openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();

		// Create CriteriaQuery
		CriteriaQuery<ReviewPeriod> criteria = builder.createQuery(ReviewPeriod.class);
		
		Criteria criteria = getSession().getcreateCriteria(ReviewPeriod.class);
		if(startDate!=null){
			criteria.add(Restrictions.ge("startDate",startDate));
		}
		if(endDate!=null){
			criteria.add(Restrictions.le("endDate",endDate));
		}
		
		//List list = criteria.list();
		
		//Object obj = criteria.uniqueResult();
		
		return (ReviewPeriod) criteria.uniqueResult();
		
	}
	
	public ReviewPeriod getByExercise(String exercise) {
		Criteria criteria = getSession().createCriteria(ReviewPeriod.class)
				.add(Restrictions.like("exercice", exercise));
				
		return (ReviewPeriod) criteria.uniqueResult();
	}
	

	public ReviewPeriod getByOngoingPeriod(String value) {
		Criteria criteria = getSession().createCriteria(ReviewPeriod.class)
				.add(Restrictions.like("ongoingPeriod", value));
				
		return (ReviewPeriod) criteria.uniqueResult();
	}

	
}
