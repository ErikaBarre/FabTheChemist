package fab.chemist.dbsql.dao.interf;

import java.util.Date;



import fab.chemist.db.framework.dao.interf.IGenericDAO;
import fab.chemist.dbsql.orm.impl.ReviewPeriod;

public interface IReviewPeriodDAO extends IGenericDAO<ReviewPeriod, Long>{
	
	String BEAN_NAME = "reviewPeriodDao";
	
	ReviewPeriod getReviewPeriodForAPeriod(Date startDate,Date endDate);
	
	ReviewPeriod getByOngoingPeriod(String value);
	
	ReviewPeriod getByExercise(String exercise);
}
