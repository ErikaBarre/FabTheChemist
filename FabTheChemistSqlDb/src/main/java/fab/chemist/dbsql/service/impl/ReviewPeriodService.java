package fab.chemist.dbsql.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fab.chemist.db.framework.service.impl.GenericService;
import fab.chemist.dbsql.dao.interf.IReviewPeriodDAO;
import fab.chemist.dbsql.orm.impl.ReviewPeriod;
import fab.chemist.dbsql.service.interf.IReviewPeriodService;

@Service(IReviewPeriodService.BEAN_NAME)
public class ReviewPeriodService extends GenericService<IReviewPeriodDAO, ReviewPeriod, Long> implements IReviewPeriodService {

	@Resource(name = IReviewPeriodDAO.BEAN_NAME)
	@Override
	public void setDAO(IReviewPeriodDAO dao) {
		super.setDAO(dao);
	}
	
	@Transactional
	public ReviewPeriod getReviewPeriodForAPeriod(Date startDate,Date endDate){
		return _dao.getReviewPeriodForAPeriod( startDate,  endDate);
	}
	
	@Transactional
	public ReviewPeriod getByOngoingPeriod(String value){
		return _dao.getByOngoingPeriod(value);
	}
	
	@Transactional
	public ReviewPeriod getByExercise(String exercise){
		return _dao.getByExercise(exercise);
	}
	

	
}