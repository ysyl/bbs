package com.bbs.entity;

import java.util.ArrayList;
import java.util.List;

public class BroadExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table t_broad
	 * @mbg.generated  Fri May 11 21:51:15 CST 2018
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table t_broad
	 * @mbg.generated  Fri May 11 21:51:15 CST 2018
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table t_broad
	 * @mbg.generated  Fri May 11 21:51:15 CST 2018
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_broad
	 * @mbg.generated  Fri May 11 21:51:15 CST 2018
	 */
	public BroadExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_broad
	 * @mbg.generated  Fri May 11 21:51:15 CST 2018
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_broad
	 * @mbg.generated  Fri May 11 21:51:15 CST 2018
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_broad
	 * @mbg.generated  Fri May 11 21:51:15 CST 2018
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_broad
	 * @mbg.generated  Fri May 11 21:51:15 CST 2018
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_broad
	 * @mbg.generated  Fri May 11 21:51:15 CST 2018
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_broad
	 * @mbg.generated  Fri May 11 21:51:15 CST 2018
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_broad
	 * @mbg.generated  Fri May 11 21:51:15 CST 2018
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_broad
	 * @mbg.generated  Fri May 11 21:51:15 CST 2018
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_broad
	 * @mbg.generated  Fri May 11 21:51:15 CST 2018
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_broad
	 * @mbg.generated  Fri May 11 21:51:15 CST 2018
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table t_broad
	 * @mbg.generated  Fri May 11 21:51:15 CST 2018
	 */
	protected abstract static class GeneratedCriteria {
		protected List<Criterion> criteria;

		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<Criterion>();
		}

		public boolean isValid() {
			return criteria.size() > 0;
		}

		public List<Criterion> getAllCriteria() {
			return criteria;
		}

		public List<Criterion> getCriteria() {
			return criteria;
		}

		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteria.add(new Criterion(condition));
		}

		protected void addCriterion(String condition, Object value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1, Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}

		public Criteria andIdIsNull() {
			addCriterion("id is null");
			return (Criteria) this;
		}

		public Criteria andIdIsNotNull() {
			addCriterion("id is not null");
			return (Criteria) this;
		}

		public Criteria andIdEqualTo(Integer value) {
			addCriterion("id =", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotEqualTo(Integer value) {
			addCriterion("id <>", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThan(Integer value) {
			addCriterion("id >", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("id >=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThan(Integer value) {
			addCriterion("id <", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThanOrEqualTo(Integer value) {
			addCriterion("id <=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdIn(List<Integer> values) {
			addCriterion("id in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotIn(List<Integer> values) {
			addCriterion("id not in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdBetween(Integer value1, Integer value2) {
			addCriterion("id between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotBetween(Integer value1, Integer value2) {
			addCriterion("id not between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andBroadNameIsNull() {
			addCriterion("broad_name is null");
			return (Criteria) this;
		}

		public Criteria andBroadNameIsNotNull() {
			addCriterion("broad_name is not null");
			return (Criteria) this;
		}

		public Criteria andBroadNameEqualTo(String value) {
			addCriterion("broad_name =", value, "broadName");
			return (Criteria) this;
		}

		public Criteria andBroadNameNotEqualTo(String value) {
			addCriterion("broad_name <>", value, "broadName");
			return (Criteria) this;
		}

		public Criteria andBroadNameGreaterThan(String value) {
			addCriterion("broad_name >", value, "broadName");
			return (Criteria) this;
		}

		public Criteria andBroadNameGreaterThanOrEqualTo(String value) {
			addCriterion("broad_name >=", value, "broadName");
			return (Criteria) this;
		}

		public Criteria andBroadNameLessThan(String value) {
			addCriterion("broad_name <", value, "broadName");
			return (Criteria) this;
		}

		public Criteria andBroadNameLessThanOrEqualTo(String value) {
			addCriterion("broad_name <=", value, "broadName");
			return (Criteria) this;
		}

		public Criteria andBroadNameLike(String value) {
			addCriterion("broad_name like", value, "broadName");
			return (Criteria) this;
		}

		public Criteria andBroadNameNotLike(String value) {
			addCriterion("broad_name not like", value, "broadName");
			return (Criteria) this;
		}

		public Criteria andBroadNameIn(List<String> values) {
			addCriterion("broad_name in", values, "broadName");
			return (Criteria) this;
		}

		public Criteria andBroadNameNotIn(List<String> values) {
			addCriterion("broad_name not in", values, "broadName");
			return (Criteria) this;
		}

		public Criteria andBroadNameBetween(String value1, String value2) {
			addCriterion("broad_name between", value1, value2, "broadName");
			return (Criteria) this;
		}

		public Criteria andBroadNameNotBetween(String value1, String value2) {
			addCriterion("broad_name not between", value1, value2, "broadName");
			return (Criteria) this;
		}

		public Criteria andBroadDescIsNull() {
			addCriterion("broad_desc is null");
			return (Criteria) this;
		}

		public Criteria andBroadDescIsNotNull() {
			addCriterion("broad_desc is not null");
			return (Criteria) this;
		}

		public Criteria andBroadDescEqualTo(String value) {
			addCriterion("broad_desc =", value, "broadDesc");
			return (Criteria) this;
		}

		public Criteria andBroadDescNotEqualTo(String value) {
			addCriterion("broad_desc <>", value, "broadDesc");
			return (Criteria) this;
		}

		public Criteria andBroadDescGreaterThan(String value) {
			addCriterion("broad_desc >", value, "broadDesc");
			return (Criteria) this;
		}

		public Criteria andBroadDescGreaterThanOrEqualTo(String value) {
			addCriterion("broad_desc >=", value, "broadDesc");
			return (Criteria) this;
		}

		public Criteria andBroadDescLessThan(String value) {
			addCriterion("broad_desc <", value, "broadDesc");
			return (Criteria) this;
		}

		public Criteria andBroadDescLessThanOrEqualTo(String value) {
			addCriterion("broad_desc <=", value, "broadDesc");
			return (Criteria) this;
		}

		public Criteria andBroadDescLike(String value) {
			addCriterion("broad_desc like", value, "broadDesc");
			return (Criteria) this;
		}

		public Criteria andBroadDescNotLike(String value) {
			addCriterion("broad_desc not like", value, "broadDesc");
			return (Criteria) this;
		}

		public Criteria andBroadDescIn(List<String> values) {
			addCriterion("broad_desc in", values, "broadDesc");
			return (Criteria) this;
		}

		public Criteria andBroadDescNotIn(List<String> values) {
			addCriterion("broad_desc not in", values, "broadDesc");
			return (Criteria) this;
		}

		public Criteria andBroadDescBetween(String value1, String value2) {
			addCriterion("broad_desc between", value1, value2, "broadDesc");
			return (Criteria) this;
		}

		public Criteria andBroadDescNotBetween(String value1, String value2) {
			addCriterion("broad_desc not between", value1, value2, "broadDesc");
			return (Criteria) this;
		}

		public Criteria andTopicNumIsNull() {
			addCriterion("topic_num is null");
			return (Criteria) this;
		}

		public Criteria andTopicNumIsNotNull() {
			addCriterion("topic_num is not null");
			return (Criteria) this;
		}

		public Criteria andTopicNumEqualTo(Integer value) {
			addCriterion("topic_num =", value, "topicNum");
			return (Criteria) this;
		}

		public Criteria andTopicNumNotEqualTo(Integer value) {
			addCriterion("topic_num <>", value, "topicNum");
			return (Criteria) this;
		}

		public Criteria andTopicNumGreaterThan(Integer value) {
			addCriterion("topic_num >", value, "topicNum");
			return (Criteria) this;
		}

		public Criteria andTopicNumGreaterThanOrEqualTo(Integer value) {
			addCriterion("topic_num >=", value, "topicNum");
			return (Criteria) this;
		}

		public Criteria andTopicNumLessThan(Integer value) {
			addCriterion("topic_num <", value, "topicNum");
			return (Criteria) this;
		}

		public Criteria andTopicNumLessThanOrEqualTo(Integer value) {
			addCriterion("topic_num <=", value, "topicNum");
			return (Criteria) this;
		}

		public Criteria andTopicNumIn(List<Integer> values) {
			addCriterion("topic_num in", values, "topicNum");
			return (Criteria) this;
		}

		public Criteria andTopicNumNotIn(List<Integer> values) {
			addCriterion("topic_num not in", values, "topicNum");
			return (Criteria) this;
		}

		public Criteria andTopicNumBetween(Integer value1, Integer value2) {
			addCriterion("topic_num between", value1, value2, "topicNum");
			return (Criteria) this;
		}

		public Criteria andTopicNumNotBetween(Integer value1, Integer value2) {
			addCriterion("topic_num not between", value1, value2, "topicNum");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table t_broad
	 * @mbg.generated  Fri May 11 21:51:15 CST 2018
	 */
	public static class Criterion {
		private String condition;
		private Object value;
		private Object secondValue;
		private boolean noValue;
		private boolean singleValue;
		private boolean betweenValue;
		private boolean listValue;
		private String typeHandler;

		public String getCondition() {
			return condition;
		}

		public Object getValue() {
			return value;
		}

		public Object getSecondValue() {
			return secondValue;
		}

		public boolean isNoValue() {
			return noValue;
		}

		public boolean isSingleValue() {
			return singleValue;
		}

		public boolean isBetweenValue() {
			return betweenValue;
		}

		public boolean isListValue() {
			return listValue;
		}

		public String getTypeHandler() {
			return typeHandler;
		}

		protected Criterion(String condition) {
			super();
			this.condition = condition;
			this.typeHandler = null;
			this.noValue = true;
		}

		protected Criterion(String condition, Object value, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.typeHandler = typeHandler;
			if (value instanceof List<?>) {
				this.listValue = true;
			} else {
				this.singleValue = true;
			}
		}

		protected Criterion(String condition, Object value) {
			this(condition, value, null);
		}

		protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.secondValue = secondValue;
			this.typeHandler = typeHandler;
			this.betweenValue = true;
		}

		protected Criterion(String condition, Object value, Object secondValue) {
			this(condition, value, secondValue, null);
		}
	}

	/**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_broad
     *
     * @mbg.generated do_not_delete_during_merge Fri May 04 01:01:21 CST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}