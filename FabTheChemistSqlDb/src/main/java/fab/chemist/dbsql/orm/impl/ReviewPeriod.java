package fab.chemist.dbsql.orm.impl;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import fab.chemist.dbsql.constant.*;
import fab.chemist.dbsql.orm.interf.IReviewPeriod;

@Entity(name = IReviewPeriod.ENTITY_NAME)
@Table(name=DBConstant.Table.NOT_REVIEW_PERIODS)
public class ReviewPeriod implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1146635257324475302L;

	@Id
	@Column(name="ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reviewPeriodGenerator")
	@SequenceGenerator(name = "reviewPeriodGenerator", sequenceName = DBConstant.Sequence.SEQ_NOT_REVIEW_PERIODS, allocationSize = 1)
	private Long id;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "START_DATE")	
	private Date startDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "END_DATE")
	private Date endDate;
	
	@Column(name = "EXERCICE")
	private String exercice;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "ONGOING_PERIOD")
	private String ongoingPeriod;

	public Long getId() {
		return id;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getExercice() {
		return exercice;
	}

	public void setExercice(String exercice) {
		this.exercice = exercice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOngoingPeriod() {
		return ongoingPeriod;
	}

	public void setOngoingPeriod(String ongoingPeriod) {
		this.ongoingPeriod = ongoingPeriod;
	}
	
	
}
