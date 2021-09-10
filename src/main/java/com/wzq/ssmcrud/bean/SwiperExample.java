package com.wzq.ssmcrud.bean;

import java.util.ArrayList;
import java.util.List;

public class SwiperExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SwiperExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

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

        public Criteria andSwiperIdIsNull() {
            addCriterion("swiper_id is null");
            return (Criteria) this;
        }

        public Criteria andSwiperIdIsNotNull() {
            addCriterion("swiper_id is not null");
            return (Criteria) this;
        }

        public Criteria andSwiperIdEqualTo(Integer value) {
            addCriterion("swiper_id =", value, "swiperId");
            return (Criteria) this;
        }

        public Criteria andSwiperIdNotEqualTo(Integer value) {
            addCriterion("swiper_id <>", value, "swiperId");
            return (Criteria) this;
        }

        public Criteria andSwiperIdGreaterThan(Integer value) {
            addCriterion("swiper_id >", value, "swiperId");
            return (Criteria) this;
        }

        public Criteria andSwiperIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("swiper_id >=", value, "swiperId");
            return (Criteria) this;
        }

        public Criteria andSwiperIdLessThan(Integer value) {
            addCriterion("swiper_id <", value, "swiperId");
            return (Criteria) this;
        }

        public Criteria andSwiperIdLessThanOrEqualTo(Integer value) {
            addCriterion("swiper_id <=", value, "swiperId");
            return (Criteria) this;
        }

        public Criteria andSwiperIdIn(List<Integer> values) {
            addCriterion("swiper_id in", values, "swiperId");
            return (Criteria) this;
        }

        public Criteria andSwiperIdNotIn(List<Integer> values) {
            addCriterion("swiper_id not in", values, "swiperId");
            return (Criteria) this;
        }

        public Criteria andSwiperIdBetween(Integer value1, Integer value2) {
            addCriterion("swiper_id between", value1, value2, "swiperId");
            return (Criteria) this;
        }

        public Criteria andSwiperIdNotBetween(Integer value1, Integer value2) {
            addCriterion("swiper_id not between", value1, value2, "swiperId");
            return (Criteria) this;
        }

        public Criteria andSwiperNameIsNull() {
            addCriterion("swiper_name is null");
            return (Criteria) this;
        }

        public Criteria andSwiperNameIsNotNull() {
            addCriterion("swiper_name is not null");
            return (Criteria) this;
        }

        public Criteria andSwiperNameEqualTo(String value) {
            addCriterion("swiper_name =", value, "swiperName");
            return (Criteria) this;
        }

        public Criteria andSwiperNameNotEqualTo(String value) {
            addCriterion("swiper_name <>", value, "swiperName");
            return (Criteria) this;
        }

        public Criteria andSwiperNameGreaterThan(String value) {
            addCriterion("swiper_name >", value, "swiperName");
            return (Criteria) this;
        }

        public Criteria andSwiperNameGreaterThanOrEqualTo(String value) {
            addCriterion("swiper_name >=", value, "swiperName");
            return (Criteria) this;
        }

        public Criteria andSwiperNameLessThan(String value) {
            addCriterion("swiper_name <", value, "swiperName");
            return (Criteria) this;
        }

        public Criteria andSwiperNameLessThanOrEqualTo(String value) {
            addCriterion("swiper_name <=", value, "swiperName");
            return (Criteria) this;
        }

        public Criteria andSwiperNameLike(String value) {
            addCriterion("swiper_name like", value, "swiperName");
            return (Criteria) this;
        }

        public Criteria andSwiperNameNotLike(String value) {
            addCriterion("swiper_name not like", value, "swiperName");
            return (Criteria) this;
        }

        public Criteria andSwiperNameIn(List<String> values) {
            addCriterion("swiper_name in", values, "swiperName");
            return (Criteria) this;
        }

        public Criteria andSwiperNameNotIn(List<String> values) {
            addCriterion("swiper_name not in", values, "swiperName");
            return (Criteria) this;
        }

        public Criteria andSwiperNameBetween(String value1, String value2) {
            addCriterion("swiper_name between", value1, value2, "swiperName");
            return (Criteria) this;
        }

        public Criteria andSwiperNameNotBetween(String value1, String value2) {
            addCriterion("swiper_name not between", value1, value2, "swiperName");
            return (Criteria) this;
        }

        public Criteria andSwiperUrlIsNull() {
            addCriterion("swiper_url is null");
            return (Criteria) this;
        }

        public Criteria andSwiperUrlIsNotNull() {
            addCriterion("swiper_url is not null");
            return (Criteria) this;
        }

        public Criteria andSwiperUrlEqualTo(String value) {
            addCriterion("swiper_url =", value, "swiperUrl");
            return (Criteria) this;
        }

        public Criteria andSwiperUrlNotEqualTo(String value) {
            addCriterion("swiper_url <>", value, "swiperUrl");
            return (Criteria) this;
        }

        public Criteria andSwiperUrlGreaterThan(String value) {
            addCriterion("swiper_url >", value, "swiperUrl");
            return (Criteria) this;
        }

        public Criteria andSwiperUrlGreaterThanOrEqualTo(String value) {
            addCriterion("swiper_url >=", value, "swiperUrl");
            return (Criteria) this;
        }

        public Criteria andSwiperUrlLessThan(String value) {
            addCriterion("swiper_url <", value, "swiperUrl");
            return (Criteria) this;
        }

        public Criteria andSwiperUrlLessThanOrEqualTo(String value) {
            addCriterion("swiper_url <=", value, "swiperUrl");
            return (Criteria) this;
        }

        public Criteria andSwiperUrlLike(String value) {
            addCriterion("swiper_url like", value, "swiperUrl");
            return (Criteria) this;
        }

        public Criteria andSwiperUrlNotLike(String value) {
            addCriterion("swiper_url not like", value, "swiperUrl");
            return (Criteria) this;
        }

        public Criteria andSwiperUrlIn(List<String> values) {
            addCriterion("swiper_url in", values, "swiperUrl");
            return (Criteria) this;
        }

        public Criteria andSwiperUrlNotIn(List<String> values) {
            addCriterion("swiper_url not in", values, "swiperUrl");
            return (Criteria) this;
        }

        public Criteria andSwiperUrlBetween(String value1, String value2) {
            addCriterion("swiper_url between", value1, value2, "swiperUrl");
            return (Criteria) this;
        }

        public Criteria andSwiperUrlNotBetween(String value1, String value2) {
            addCriterion("swiper_url not between", value1, value2, "swiperUrl");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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
}