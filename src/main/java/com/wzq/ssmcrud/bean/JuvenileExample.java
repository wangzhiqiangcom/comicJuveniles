package com.wzq.ssmcrud.bean;

import java.util.ArrayList;
import java.util.List;

public class JuvenileExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public JuvenileExample() {
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

        public Criteria andJuvenileIdIsNull() {
            addCriterion("juvenile_id is null");
            return (Criteria) this;
        }

        public Criteria andJuvenileIdIsNotNull() {
            addCriterion("juvenile_id is not null");
            return (Criteria) this;
        }

        public Criteria andJuvenileIdEqualTo(Integer value) {
            addCriterion("juvenile_id =", value, "juvenileId");
            return (Criteria) this;
        }

        public Criteria andJuvenileIdNotEqualTo(Integer value) {
            addCriterion("juvenile_id <>", value, "juvenileId");
            return (Criteria) this;
        }

        public Criteria andJuvenileIdGreaterThan(Integer value) {
            addCriterion("juvenile_id >", value, "juvenileId");
            return (Criteria) this;
        }

        public Criteria andJuvenileIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("juvenile_id >=", value, "juvenileId");
            return (Criteria) this;
        }

        public Criteria andJuvenileIdLessThan(Integer value) {
            addCriterion("juvenile_id <", value, "juvenileId");
            return (Criteria) this;
        }

        public Criteria andJuvenileIdLessThanOrEqualTo(Integer value) {
            addCriterion("juvenile_id <=", value, "juvenileId");
            return (Criteria) this;
        }

        public Criteria andJuvenileIdIn(List<Integer> values) {
            addCriterion("juvenile_id in", values, "juvenileId");
            return (Criteria) this;
        }

        public Criteria andJuvenileIdNotIn(List<Integer> values) {
            addCriterion("juvenile_id not in", values, "juvenileId");
            return (Criteria) this;
        }

        public Criteria andJuvenileIdBetween(Integer value1, Integer value2) {
            addCriterion("juvenile_id between", value1, value2, "juvenileId");
            return (Criteria) this;
        }

        public Criteria andJuvenileIdNotBetween(Integer value1, Integer value2) {
            addCriterion("juvenile_id not between", value1, value2, "juvenileId");
            return (Criteria) this;
        }

        public Criteria andJNameIsNull() {
            addCriterion("j_name is null");
            return (Criteria) this;
        }

        public Criteria andJNameIsNotNull() {
            addCriterion("j_name is not null");
            return (Criteria) this;
        }

        public Criteria andJNameEqualTo(String value) {
            addCriterion("j_name =", value, "jName");
            return (Criteria) this;
        }

        public Criteria andJNameNotEqualTo(String value) {
            addCriterion("j_name <>", value, "jName");
            return (Criteria) this;
        }

        public Criteria andJNameGreaterThan(String value) {
            addCriterion("j_name >", value, "jName");
            return (Criteria) this;
        }

        public Criteria andJNameGreaterThanOrEqualTo(String value) {
            addCriterion("j_name >=", value, "jName");
            return (Criteria) this;
        }

        public Criteria andJNameLessThan(String value) {
            addCriterion("j_name <", value, "jName");
            return (Criteria) this;
        }

        public Criteria andJNameLessThanOrEqualTo(String value) {
            addCriterion("j_name <=", value, "jName");
            return (Criteria) this;
        }

        public Criteria andJNameLike(String value) {
            addCriterion("j_name like", value, "jName");
            return (Criteria) this;
        }

        public Criteria andJNameNotLike(String value) {
            addCriterion("j_name not like", value, "jName");
            return (Criteria) this;
        }

        public Criteria andJNameIn(List<String> values) {
            addCriterion("j_name in", values, "jName");
            return (Criteria) this;
        }

        public Criteria andJNameNotIn(List<String> values) {
            addCriterion("j_name not in", values, "jName");
            return (Criteria) this;
        }

        public Criteria andJNameBetween(String value1, String value2) {
            addCriterion("j_name between", value1, value2, "jName");
            return (Criteria) this;
        }

        public Criteria andJNameNotBetween(String value1, String value2) {
            addCriterion("j_name not between", value1, value2, "jName");
            return (Criteria) this;
        }

        public Criteria andGenderIsNull() {
            addCriterion("gender is null");
            return (Criteria) this;
        }

        public Criteria andGenderIsNotNull() {
            addCriterion("gender is not null");
            return (Criteria) this;
        }

        public Criteria andGenderEqualTo(String value) {
            addCriterion("gender =", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotEqualTo(String value) {
            addCriterion("gender <>", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThan(String value) {
            addCriterion("gender >", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThanOrEqualTo(String value) {
            addCriterion("gender >=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThan(String value) {
            addCriterion("gender <", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThanOrEqualTo(String value) {
            addCriterion("gender <=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLike(String value) {
            addCriterion("gender like", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotLike(String value) {
            addCriterion("gender not like", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderIn(List<String> values) {
            addCriterion("gender in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotIn(List<String> values) {
            addCriterion("gender not in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderBetween(String value1, String value2) {
            addCriterion("gender between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotBetween(String value1, String value2) {
            addCriterion("gender not between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andWeaponIsNull() {
            addCriterion("weapon is null");
            return (Criteria) this;
        }

        public Criteria andWeaponIsNotNull() {
            addCriterion("weapon is not null");
            return (Criteria) this;
        }

        public Criteria andWeaponEqualTo(String value) {
            addCriterion("weapon =", value, "weapon");
            return (Criteria) this;
        }

        public Criteria andWeaponNotEqualTo(String value) {
            addCriterion("weapon <>", value, "weapon");
            return (Criteria) this;
        }

        public Criteria andWeaponGreaterThan(String value) {
            addCriterion("weapon >", value, "weapon");
            return (Criteria) this;
        }

        public Criteria andWeaponGreaterThanOrEqualTo(String value) {
            addCriterion("weapon >=", value, "weapon");
            return (Criteria) this;
        }

        public Criteria andWeaponLessThan(String value) {
            addCriterion("weapon <", value, "weapon");
            return (Criteria) this;
        }

        public Criteria andWeaponLessThanOrEqualTo(String value) {
            addCriterion("weapon <=", value, "weapon");
            return (Criteria) this;
        }

        public Criteria andWeaponLike(String value) {
            addCriterion("weapon like", value, "weapon");
            return (Criteria) this;
        }

        public Criteria andWeaponNotLike(String value) {
            addCriterion("weapon not like", value, "weapon");
            return (Criteria) this;
        }

        public Criteria andWeaponIn(List<String> values) {
            addCriterion("weapon in", values, "weapon");
            return (Criteria) this;
        }

        public Criteria andWeaponNotIn(List<String> values) {
            addCriterion("weapon not in", values, "weapon");
            return (Criteria) this;
        }

        public Criteria andWeaponBetween(String value1, String value2) {
            addCriterion("weapon between", value1, value2, "weapon");
            return (Criteria) this;
        }

        public Criteria andWeaponNotBetween(String value1, String value2) {
            addCriterion("weapon not between", value1, value2, "weapon");
            return (Criteria) this;
        }

        public Criteria andSectIsNull() {
            addCriterion("sect is null");
            return (Criteria) this;
        }

        public Criteria andSectIsNotNull() {
            addCriterion("sect is not null");
            return (Criteria) this;
        }

        public Criteria andSectEqualTo(String value) {
            addCriterion("sect =", value, "sect");
            return (Criteria) this;
        }

        public Criteria andSectNotEqualTo(String value) {
            addCriterion("sect <>", value, "sect");
            return (Criteria) this;
        }

        public Criteria andSectGreaterThan(String value) {
            addCriterion("sect >", value, "sect");
            return (Criteria) this;
        }

        public Criteria andSectGreaterThanOrEqualTo(String value) {
            addCriterion("sect >=", value, "sect");
            return (Criteria) this;
        }

        public Criteria andSectLessThan(String value) {
            addCriterion("sect <", value, "sect");
            return (Criteria) this;
        }

        public Criteria andSectLessThanOrEqualTo(String value) {
            addCriterion("sect <=", value, "sect");
            return (Criteria) this;
        }

        public Criteria andSectLike(String value) {
            addCriterion("sect like", value, "sect");
            return (Criteria) this;
        }

        public Criteria andSectNotLike(String value) {
            addCriterion("sect not like", value, "sect");
            return (Criteria) this;
        }

        public Criteria andSectIn(List<String> values) {
            addCriterion("sect in", values, "sect");
            return (Criteria) this;
        }

        public Criteria andSectNotIn(List<String> values) {
            addCriterion("sect not in", values, "sect");
            return (Criteria) this;
        }

        public Criteria andSectBetween(String value1, String value2) {
            addCriterion("sect between", value1, value2, "sect");
            return (Criteria) this;
        }

        public Criteria andSectNotBetween(String value1, String value2) {
            addCriterion("sect not between", value1, value2, "sect");
            return (Criteria) this;
        }

        public Criteria andPortraitUrlIsNull() {
            addCriterion("portrait_url is null");
            return (Criteria) this;
        }

        public Criteria andPortraitUrlIsNotNull() {
            addCriterion("portrait_url is not null");
            return (Criteria) this;
        }

        public Criteria andPortraitUrlEqualTo(String value) {
            addCriterion("portrait_url =", value, "portraitUrl");
            return (Criteria) this;
        }

        public Criteria andPortraitUrlNotEqualTo(String value) {
            addCriterion("portrait_url <>", value, "portraitUrl");
            return (Criteria) this;
        }

        public Criteria andPortraitUrlGreaterThan(String value) {
            addCriterion("portrait_url >", value, "portraitUrl");
            return (Criteria) this;
        }

        public Criteria andPortraitUrlGreaterThanOrEqualTo(String value) {
            addCriterion("portrait_url >=", value, "portraitUrl");
            return (Criteria) this;
        }

        public Criteria andPortraitUrlLessThan(String value) {
            addCriterion("portrait_url <", value, "portraitUrl");
            return (Criteria) this;
        }

        public Criteria andPortraitUrlLessThanOrEqualTo(String value) {
            addCriterion("portrait_url <=", value, "portraitUrl");
            return (Criteria) this;
        }

        public Criteria andPortraitUrlLike(String value) {
            addCriterion("portrait_url like", value, "portraitUrl");
            return (Criteria) this;
        }

        public Criteria andPortraitUrlNotLike(String value) {
            addCriterion("portrait_url not like", value, "portraitUrl");
            return (Criteria) this;
        }

        public Criteria andPortraitUrlIn(List<String> values) {
            addCriterion("portrait_url in", values, "portraitUrl");
            return (Criteria) this;
        }

        public Criteria andPortraitUrlNotIn(List<String> values) {
            addCriterion("portrait_url not in", values, "portraitUrl");
            return (Criteria) this;
        }

        public Criteria andPortraitUrlBetween(String value1, String value2) {
            addCriterion("portrait_url between", value1, value2, "portraitUrl");
            return (Criteria) this;
        }

        public Criteria andPortraitUrlNotBetween(String value1, String value2) {
            addCriterion("portrait_url not between", value1, value2, "portraitUrl");
            return (Criteria) this;
        }

        public Criteria andCIdIsNull() {
            addCriterion("c_id is null");
            return (Criteria) this;
        }

        public Criteria andCIdIsNotNull() {
            addCriterion("c_id is not null");
            return (Criteria) this;
        }

        public Criteria andCIdEqualTo(Integer value) {
            addCriterion("c_id =", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdNotEqualTo(Integer value) {
            addCriterion("c_id <>", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdGreaterThan(Integer value) {
            addCriterion("c_id >", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("c_id >=", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdLessThan(Integer value) {
            addCriterion("c_id <", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdLessThanOrEqualTo(Integer value) {
            addCriterion("c_id <=", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdIn(List<Integer> values) {
            addCriterion("c_id in", values, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdNotIn(List<Integer> values) {
            addCriterion("c_id not in", values, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdBetween(Integer value1, Integer value2) {
            addCriterion("c_id between", value1, value2, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdNotBetween(Integer value1, Integer value2) {
            addCriterion("c_id not between", value1, value2, "cId");
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

    @Override
    public String toString() {
        return "JuvenileExample{" +
                "orderByClause='" + orderByClause + '\'' +
                ", distinct=" + distinct +
                ", oredCriteria=" + oredCriteria +
                '}';
    }
}