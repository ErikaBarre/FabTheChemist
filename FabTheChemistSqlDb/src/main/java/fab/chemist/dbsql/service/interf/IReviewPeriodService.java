package fab.chemist.dbsql.service.interf;

import java.util.Date;

import fab.chemist.db.framework.service.interf.IGenericService;
import fab.chemist.dbsql.orm.impl.ReviewPeriod;

public interface IReviewPeriodService extends IGenericService<ReviewPeriod, Long>{

	String BEAN_NAME = "reviewPeriodService";
	
	ReviewPeriod getReviewPeriodForAPeriod(Date startDate,Date endDate);
	
	ReviewPeriod getByOngoingPeriod(String value);
	
	ReviewPeriod getByExercise(String exercise);
}
