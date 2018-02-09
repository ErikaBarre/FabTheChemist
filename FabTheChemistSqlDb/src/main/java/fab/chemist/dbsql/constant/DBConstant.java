package fab.chemist.dbsql.constant;

public final class DBConstant {
	
	public static final class Schema {
		public static final String ERAPNOT = "ERAPNOT";
	}
	
	
	/**
	 * All SQL Tables 
	 */
	public static final class Table {
		public static final String AGENT = "POC_AGENT";
		public static final String REPORT = "POC_REPORT";
		public static final String ASSIGNED_ROLES = "ERN_ASSIGNED_ROLES";
		public static final String ROLES = "ERN_ROLES";
		
		public static final String NOT_ACT_DELAYS = "NOT_ACT_DELAYS";
		public static final String NOT_ORGANISATIONAL_ENTITIES = "NOT_ORGANISATIONAL_ENTITIES";
		public static final String NOT_SPECIFIC_USER_ROLES = "NOT_SPECIFIC_USER_ROLES";
		public static final String NOT_GRADES = "NOT_GRADES";
		public static final String NOT_CAREER_DEVELOPMENT_PLAN = "NOT_CAREER_DEVELOPMENT_PLAN";
		public static final String NOT_ROLES = "NOT_ROLES";
		public static final String NOT_ROLES_TL = "NOT_ROLES_TL";
		public static final String NOT_REP_ATTACHMENTS = "NOT_REP_ATTACHMENTS";
		public static final String NOT_JOBS_TL = "NOT_JOBS_TL";
		public static final String NOT_JOBS = "NOT_JOBS";
		public static final String NOT_FUNCTION_GROUP = "NOT_FUNCTION_GROUP";
		public static final String NOT_REVIEW_PERIODS = "NOT_REVIEW_PERIODS";
		public static final String NOT_PERSONAL_MEMBERS = "NOT_PERSONAL_MEMBERS";
		public static final String NOT_ORG_REVIEW_PERIODS = "NOT_ORG_REVIEW_PERIODS";
		public static final String NOT_APPRAISAL_ASSESSMENTS = "NOT_APPRAISAL_ASSESSMENTS";
		public static final String NOT_USER_ROLES = "NOT_USER_ROLES";
		public static final String NOT_REPORT_FUNCTION_TASKS = "NOT_REPORT_FUNCTION_TASKS";
		public static final String NOT_REPORT_FUNCTION_COMMITTEES = "NOT_REPORT_FUNCTION_COMMITTEES";
		public static final String NOT_LANGUAGES = "NOT_LANGUAGES";
		public static final String NOT_LANGUAGES_TL = "NOT_LANGUAGES_TL";
		public static final String NOT_DEFAULT_OE_ASSESSMENTS = "NOT_DEFAULT_OE_ASSESSMENTS";
		public static final String NOT_APPRAISAL_ASSESSMENTS_TL = "NOT_APPRAISAL_ASSESSMENTS_TL";
		public static final String NOT_SERVICES_TL = "NOT_SERVICES_TL";
		public static final String NOT_SERVICES = "NOT_SERVICES";
		public static final String NOT_REP_APPRAISAL_OTHERS = "NOT_REP_APPRAISAL_OTHERS";
		public static final String NOT_REP_APPRAISAL_CONSULTANTS = "NOT_REP_APPRAISAL_CONSULTANTS";
		public static final String NOT_ASSESSMENT_CRITERIAS_TL = "NOT_ASSESSMENT_CRITERIAS_TL";
		public static final String NOT_ASSESSMENT_CRITERIAS = "NOT_ASSESSMENT_CRITERIAS";
		public static final String NOT_REPORT_FUNCTION_WORKS = "NOT_REPORT_FUNCTION_WORKS";
		public static final String NOT_REP_APPRAISAL_ASSESSMENTS = "NOT_REP_APPRAISAL_ASSESSMENTS";
		public static final String NOT_REP_APPRAISAL_LANGUAGES = "NOT_REP_APPPRAISAL_LANGUAGES";
		public static final String NOT_REPORT_EMPLOYED_PERIODS= "NOT_REPORT_EMPLOYED_PERIODS";
		public static final String NOT_REPORTS = "NOT_REPORTS";
		public static final String NOT_PROPERTIES = "NOT_PROPERTIES";
		public static final String NOT_DEFAULT_SG_ASSESSMENTS = "NOT_DEFAULT_SG_ASSESSMENTS";	
		public static final String NOT_COMMITTEES = "NOT_COMMITTEES";
		public static final String NOT_COMMITTEES_TL = "NOT_COMMITTEES_TL";	
		public static final String NOT_TYPE_OF_POSTS = "NOT_TYPE_OF_POSTS";
		public static final String NOT_TYPE_OF_POSTS_TL = "NOT_TYPE_OF_POSTS_TL";
		public static final String NOT_COMMITTY_ROLES = "NOT_COMMITTY_ROLES";
		public static final String NOT_COMMITTY_ROLES_TL = "NOT_COMMITTY_ROLES_TL";
		public static final String NOT_STATUTORY_LINKS = "NOT_STATUTORY_LINKS";
		public static final String NOT_STATUTORY_LINKS_TL = "NOT_STATUTORY_LINKS_TL";
		public static final String NOT_MESSAGES = "NOT_MESSAGES";
		public static final String NOT_MESSAGES_TL = "NOT_MESSAGES_TL";
		public static final String NOT_SETTINGS = "NOT_SETTINGS";
		//public static final String  = "";
		
		public static final String PRE_USER_ROLES = "NOT_USER_ROLES";
		public static final String NOT_EXT_ACCESS_SETTINGS = "NOT_EXT_ACCESS_SETTINGS";
		public static final String NOT_ADM_SETTINGS = "NOT_ADM_SETTINGS";
		public static final String ADM_LOGS = "ADM_LOGS";
		public static final String TMP_DELEGATE_MAIL = "TMP_DELEGATE_MAIL";
		
		public static final String MPP_ACCESS_RULE = "MPP_ACCESS_RULE";		
		public static final String MPP_GROUP = "MPP_GROUP";		
		public static final String MPP_ACCESS_PLAN = "MPP_ACCESS_PLAN";		
		public static final String MPP_PROFILE = "MPP_PROFILE";		
		public static final String MPP_CHANGE_REPLY = "MPP_CHANGE_REPLY";		
		public static final String MPP_CHANGE_REQUEST = "MPP_CHANGE_REQUEST";		
		public static final String MPP_POINTS = "MPP_POINTS";	
		public static final String MPP_POSITION = "MPP_POSITION";		
		public static final String MPP_PROCESS = "MPP_PROCESS";
		public static final String MPP_REASON = "MPP_REASON";
		public static final String MPP_RIGHT = "MPP_RIGHT";
		public static final String MPP_STEP_PROC = "MPP_STEP_PROC";
		public static final String MPP_SUBJECT = "MPP_SUBJECT";
		public static final String MPP_THREAD = "MPP_THREAD";
		public static final String MPP_WAVE = "MPP_WAVE";
		public static final String MPP_BRANCH = "MPP_BRANCH";
		public static final String MPP_WFSTEP = "MPP_WFSTEP";
		public static final String MPP_HISTORY = "MPP_HISTORY";
		public static final String MPP_ROLE = "MPP_ROLE";
		public static final String MPP_FILTER = "MPP_FILTER";
		public static final String ENVELOPE = "MPP_ENVELOP";

	}
	
	/**
	 * All SQL Sequences 
	 */
	public static final class Sequence {
		public static final String SEQ_AGENT = "SEQ_POC_AGENT";
		public static final String SEQ_REPORT = "SEQ_POC_REPORT";
		public static final String SEQ_ASSIGNED_ROLES = "SEQ_ERN_ASSIGNED_ROLES";
		public static final String SEQ_ROLES = "SEQ_ERN_ROLES";
		public static final String MPP_ENVELOP_SEQ = "MPP_ENVELOP_SEQ";
		public static final String SEQ_ORGANISATIONAL_ENTITIES = "SEQ_NOT_ORGANISATIONAL_ENTITIE";
		public static final String SEQ_ERN_ASSIGNED_ROLES = "SEQ_ERN_ASSIGNED_ROLES";
		public static final String SEQ_ERN_ROLES = "SEQ_ERN_ROLES";
		public static final String SEQ_NOT_APPRAISAL_ASSESSMENTS = "SEQ_NOT_APPRAISAL_ASSESSMENTS";
		public static final String SEQ_NOT_APPRAISAL_ASSESSMENTS_TL = "SEQ_NOT_APPRAISAL_ASSESS_TL";
		public static final String SEQ_NOT_ASSESSMENT_CRITERIAS = "SEQ_NOT_ASSESSMENT_CRITERIAS";
		public static final String SEQ_NOT_ASSESSMENT_CRITERIAS_TL = "SEQ_NOT_ASSESSMENT_CRITERIA_TL";
		public static final String SEQ_NOT_GRADES = "SEQ_NOT_GRADES";
		public static final String SEQ_NOT_CAREER_DEV_PLAN = "SEQ_NOT_CAREER_DEV_PLAN";
		public static final String SEQ_NOT_JOBS = "SEQ_NOT_JOBS";
		public static final String SEQ_NOT_JOBS_TL = "SEQ_NOT_JOBS_TL";
		public static final String SEQ_NOT_FUNCTION_GROUP = "SEQ_NOT_FUNCTION_GROUP";
		public static final String SEQ_NOT_LANGUAGES = "SEQ_NOT_LANGUAGES";
		public static final String SEQ_NOT_ORG_REVIEW_PERIODS = "SEQ_NOT_ORG_REVIEW_PERIODS";
		public static final String SEQ_NOT_PERSONAL_MEMBERS = "SEQ_NOT_PERSONAL_MEMBERS";
		public static final String SEQ_NOT_REPORTS = "SEQ_NOT_REPORTS";
		public static final String SEQ_NOT_PROPERTIES = "SEQ_NOT_PROPERTIES";
		public static final String SEQ_NOT_REPORT_EMPLOYED_PERIODS = "SEQ_NOT_REPORT_EMPLOYED_PERIOD";
		public static final String SEQ_NOT_REPORT_FUNCTION_COMMITTEES = "SEQ_NOT_REPORT_FUNCTION_COMMIT";
		public static final String SEQ_NOT_REPORT_FUNCTION_TASKS = "SEQ_NOT_REPORT_FUNCTION_TASKS";
		public static final String SEQ_NOT_REPORT_FUNCTION_WORKS = "SEQ_NOT_REPORT_FUNCTION_WORKS";
		public static final String SEQ_NOT_REP_APPRAISAL_ASSESSMENTS = "SEQ_NOT_REP_APPRAISAL_ASSESS";
		public static final String SEQ_NOT_REP_APPRAISAL_CONSULTANTS = "SEQ_NOT_REP_APPRAISAL_CONSULT";
		public static final String SEQ_NOT_REP_APPRAISAL_LANGUAGES = "SEQ_NOT_REP_APPRAISAL_LANGUAGES";
		public static final String SEQ_NOT_REP_APPRAISAL_OTHERS = "SEQ_NOT_REP_APPRAISAL_OTHERS";
		public static final String SEQ_NOT_REP_ATTACHMENTS = "SEQ_NOT_REP_ATTACHMENTS";
		public static final String SEQ_NOT_REVIEW_PERIODS = "SEQ_NOT_REVIEW_PERIODS";
		public static final String SEQ_NOT_ROLES = "SEQ_NOT_ROLES";
		public static final String SEQ_NOT_ROLES_TL = "SEQ_NOT_ROLES_TL";
		public static final String SEQ_NOT_SERVICES = "SEQ_NOT_SERVICES";
		public static final String SEQ_NOT_SERVICES_TL = "SEQ_NOT_SERVICES_TL";
		public static final String SEQ_NOT_SPECIFIC_USER_ROLES = "SEQ_NOT_SPECIFIC_USER_ROLES";
		public static final String SEQ_NOT_USER_ROLES = "SEQ_NOT_USER_ROLES";
		public static final String SEQ_NOT_DEFAULT_OE_ASSESSMENTS = "SEQ_NOT_DEFAULT_OE_ASSESSMENTS";
		public static final String SEQ_NOT_DEFAULT_SG_ASSESSMENTS = "SEQ_NOT_DEFAULT_SG_ASSESSMENTS";
		public static final String SEQ_NOT_COMMITTEES = "SEQ_NOT_COMMITTEES";
		public static final String SEQ_NOT_COMMITTEES_TL = "SEQ_NOT_COMMITTEES_TL";
		public static final String SEQ_NOT_TYPE_OF_POSTS = "SEQ_NOT_TYPE_OF_POSTS";
		public static final String SEQ_NOT_TYPE_OF_POSTS_TL = "SEQ_NOT_TYPE_OF_POSTS_TL";
		public static final String SEQ_NOT_COMMITTY_ROLES = "SEQ_NOT_COMMITTY_ROLES";
		public static final String SEQ_NOT_COMMITTY_ROLES_TL = "SEQ_NOT_COMMITTY_ROLES_TL";
		public static final String SEQ_NOT_STATUTORY_LINKS = "SEQ_NOT_STATUTORY_LINK";
		public static final String SEQ_NOT_STATUTORY_LINKS_TL = "SEQ_NOT_STATUTORY_LINK_TL";
		public static final String SEQ_NOT_MESSAGES = "SEQ_NOT_MESSAGES";
		public static final String SEQ_NOT_MESSAGES_TL = "SEQ_NOT_MESSAGES_TL";
		public static final String NOT_EXT_ACCESS_SETTINGS_S = "NOT_EXT_ACCESS_SETTINGS_S";
		public static final String SEQ_NOT_ADM_SETTINGS = "SEQ_NOT_ADM_SETTINGS";
		public static final String SEQ_ADM_LOGS = "SEQ_ADM_LOGS";
		public static final String SEQ_TMP_DELEGATE_MAIL = "SEQ_TMP_DELEGATE_MAIL";
		public static final String SEQ_NOT_SETTINGS = "SEQ_NOT_SETTINGS";
		public static final String SEQ_NOT_ACT_DELAYS = "NOT_ACT_DELAYS_SEQ";
						
		public static final String MPP_THREAD_SEQ = "MPP_THREAD_SEQ";
		public static final String MPP_SUBJECT_SEQ = "MPP_SUBJECT_SEQ";
		public static final String MPP_PROCESS_SEQ = "MPP_PROCESS_SEQ";
		public static final String MPP_POSITION_SEQ = "MPP_POSITION_SEQ";
		public static final String MPP_WFSTEP_SEQ = "MPP_WFSTEP_SEQ";
		public static final String MPP_STEP_PROC_SEQ = "MPP_STEP_PROC_SEQ";
		public static final String MPP_REASON_SEQ = "MPP_REASON_SEQ";
		public static final String MPP_WAVE_SEQ = "MPP_WAVE_SEQ";
		public static final String MPP_BRANCH_SEQ = "MPP_BRANCH_SEQ";
		public static final String MPP_POINTS_SEQ = "MPP_POINTS_SEQ";
		public static final String MPP_CREQUEST_SEQ = "MPP_CREQUEST_SEQ";
		public static final String MPP_CREPLY_SEQ = "MPP_CREPLY_SEQ";
		public static final String MPP_PROFILE_SEQ = "MPP_PROFILE_SEQ";
		public static final String MPP_RIGHT_SEQ = "MPP_RIGHT_SEQ";
		public static final String MPP_ROLE_SEQ = "MPP_ROLE_SEQ";
		public static final String MPP_ACCESS_RULE_SEQ = "MPP_ACCESS_RULE_SEQ";
		public static final String MPP_HISTORY_SEQ = "MPP_HISTORY_SEQ";
		public static final String MPP_GROUP_SEQ = "MPP_GROUP_SEQ";
		public static final String MPP_ACCESS_PLAN_SEQ = "MPP_ACCESS_PLAN_SEQ";
		public static final String MPP_FILTER_SEQ = "SEQ_MPP_FILTER";
	}
	
	/**
	 * Common columns name 
	 */
	public static final class Column {
		public static final String TECH_KEY = "ID";
		public static final String UPDATE_DATE = "UPDATE_DATE";
		public static final String UPDATE_BY = "UPDATE_BY";
		public static final String CREATION_BY = "CREATION_BY";
		public static final String CREATION_DATE = "CREATION_DATE";
		
	}
	
	

}
