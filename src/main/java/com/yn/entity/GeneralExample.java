package com.yn.entity;

import java.util.ArrayList;
import java.util.List;

public class GeneralExample extends Base{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GeneralExample() {
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

        public Criteria andProjectNameIsNull() {
            addCriterion("project_name is null");
            return (Criteria) this;
        }

        public Criteria andProjectNameIsNotNull() {
            addCriterion("project_name is not null");
            return (Criteria) this;
        }

        public Criteria andProjectNameEqualTo(String value) {
            addCriterion("project_name =", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotEqualTo(String value) {
            addCriterion("project_name <>", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThan(String value) {
            addCriterion("project_name >", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThanOrEqualTo(String value) {
            addCriterion("project_name >=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThan(String value) {
            addCriterion("project_name <", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThanOrEqualTo(String value) {
            addCriterion("project_name <=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLike(String value) {
            addCriterion("project_name like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotLike(String value) {
            addCriterion("project_name not like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameIn(List<String> values) {
            addCriterion("project_name in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotIn(List<String> values) {
            addCriterion("project_name not in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameBetween(String value1, String value2) {
            addCriterion("project_name between", value1, value2, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotBetween(String value1, String value2) {
            addCriterion("project_name not between", value1, value2, "projectName");
            return (Criteria) this;
        }

        public Criteria andEnableRedunIsNull() {
            addCriterion("enable_redun is null");
            return (Criteria) this;
        }

        public Criteria andEnableRedunIsNotNull() {
            addCriterion("enable_redun is not null");
            return (Criteria) this;
        }

        public Criteria andEnableRedunEqualTo(Integer value) {
            addCriterion("enable_redun =", value, "enableRedun");
            return (Criteria) this;
        }

        public Criteria andEnableRedunNotEqualTo(Integer value) {
            addCriterion("enable_redun <>", value, "enableRedun");
            return (Criteria) this;
        }

        public Criteria andEnableRedunGreaterThan(Integer value) {
            addCriterion("enable_redun >", value, "enableRedun");
            return (Criteria) this;
        }

        public Criteria andEnableRedunGreaterThanOrEqualTo(Integer value) {
            addCriterion("enable_redun >=", value, "enableRedun");
            return (Criteria) this;
        }

        public Criteria andEnableRedunLessThan(Integer value) {
            addCriterion("enable_redun <", value, "enableRedun");
            return (Criteria) this;
        }

        public Criteria andEnableRedunLessThanOrEqualTo(Integer value) {
            addCriterion("enable_redun <=", value, "enableRedun");
            return (Criteria) this;
        }

        public Criteria andEnableRedunIn(List<Integer> values) {
            addCriterion("enable_redun in", values, "enableRedun");
            return (Criteria) this;
        }

        public Criteria andEnableRedunNotIn(List<Integer> values) {
            addCriterion("enable_redun not in", values, "enableRedun");
            return (Criteria) this;
        }

        public Criteria andEnableRedunBetween(Integer value1, Integer value2) {
            addCriterion("enable_redun between", value1, value2, "enableRedun");
            return (Criteria) this;
        }

        public Criteria andEnableRedunNotBetween(Integer value1, Integer value2) {
            addCriterion("enable_redun not between", value1, value2, "enableRedun");
            return (Criteria) this;
        }

        public Criteria andIp1IsNull() {
            addCriterion("IP1 is null");
            return (Criteria) this;
        }

        public Criteria andIp1IsNotNull() {
            addCriterion("IP1 is not null");
            return (Criteria) this;
        }

        public Criteria andIp1EqualTo(String value) {
            addCriterion("IP1 =", value, "ip1");
            return (Criteria) this;
        }

        public Criteria andIp1NotEqualTo(String value) {
            addCriterion("IP1 <>", value, "ip1");
            return (Criteria) this;
        }

        public Criteria andIp1GreaterThan(String value) {
            addCriterion("IP1 >", value, "ip1");
            return (Criteria) this;
        }

        public Criteria andIp1GreaterThanOrEqualTo(String value) {
            addCriterion("IP1 >=", value, "ip1");
            return (Criteria) this;
        }

        public Criteria andIp1LessThan(String value) {
            addCriterion("IP1 <", value, "ip1");
            return (Criteria) this;
        }

        public Criteria andIp1LessThanOrEqualTo(String value) {
            addCriterion("IP1 <=", value, "ip1");
            return (Criteria) this;
        }

        public Criteria andIp1Like(String value) {
            addCriterion("IP1 like", value, "ip1");
            return (Criteria) this;
        }

        public Criteria andIp1NotLike(String value) {
            addCriterion("IP1 not like", value, "ip1");
            return (Criteria) this;
        }

        public Criteria andIp1In(List<String> values) {
            addCriterion("IP1 in", values, "ip1");
            return (Criteria) this;
        }

        public Criteria andIp1NotIn(List<String> values) {
            addCriterion("IP1 not in", values, "ip1");
            return (Criteria) this;
        }

        public Criteria andIp1Between(String value1, String value2) {
            addCriterion("IP1 between", value1, value2, "ip1");
            return (Criteria) this;
        }

        public Criteria andIp1NotBetween(String value1, String value2) {
            addCriterion("IP1 not between", value1, value2, "ip1");
            return (Criteria) this;
        }

        public Criteria andIp2IsNull() {
            addCriterion("IP2 is null");
            return (Criteria) this;
        }

        public Criteria andIp2IsNotNull() {
            addCriterion("IP2 is not null");
            return (Criteria) this;
        }

        public Criteria andIp2EqualTo(String value) {
            addCriterion("IP2 =", value, "ip2");
            return (Criteria) this;
        }

        public Criteria andIp2NotEqualTo(String value) {
            addCriterion("IP2 <>", value, "ip2");
            return (Criteria) this;
        }

        public Criteria andIp2GreaterThan(String value) {
            addCriterion("IP2 >", value, "ip2");
            return (Criteria) this;
        }

        public Criteria andIp2GreaterThanOrEqualTo(String value) {
            addCriterion("IP2 >=", value, "ip2");
            return (Criteria) this;
        }

        public Criteria andIp2LessThan(String value) {
            addCriterion("IP2 <", value, "ip2");
            return (Criteria) this;
        }

        public Criteria andIp2LessThanOrEqualTo(String value) {
            addCriterion("IP2 <=", value, "ip2");
            return (Criteria) this;
        }

        public Criteria andIp2Like(String value) {
            addCriterion("IP2 like", value, "ip2");
            return (Criteria) this;
        }

        public Criteria andIp2NotLike(String value) {
            addCriterion("IP2 not like", value, "ip2");
            return (Criteria) this;
        }

        public Criteria andIp2In(List<String> values) {
            addCriterion("IP2 in", values, "ip2");
            return (Criteria) this;
        }

        public Criteria andIp2NotIn(List<String> values) {
            addCriterion("IP2 not in", values, "ip2");
            return (Criteria) this;
        }

        public Criteria andIp2Between(String value1, String value2) {
            addCriterion("IP2 between", value1, value2, "ip2");
            return (Criteria) this;
        }

        public Criteria andIp2NotBetween(String value1, String value2) {
            addCriterion("IP2 not between", value1, value2, "ip2");
            return (Criteria) this;
        }

        public Criteria andIp3IsNull() {
            addCriterion("IP3 is null");
            return (Criteria) this;
        }

        public Criteria andIp3IsNotNull() {
            addCriterion("IP3 is not null");
            return (Criteria) this;
        }

        public Criteria andIp3EqualTo(String value) {
            addCriterion("IP3 =", value, "ip3");
            return (Criteria) this;
        }

        public Criteria andIp3NotEqualTo(String value) {
            addCriterion("IP3 <>", value, "ip3");
            return (Criteria) this;
        }

        public Criteria andIp3GreaterThan(String value) {
            addCriterion("IP3 >", value, "ip3");
            return (Criteria) this;
        }

        public Criteria andIp3GreaterThanOrEqualTo(String value) {
            addCriterion("IP3 >=", value, "ip3");
            return (Criteria) this;
        }

        public Criteria andIp3LessThan(String value) {
            addCriterion("IP3 <", value, "ip3");
            return (Criteria) this;
        }

        public Criteria andIp3LessThanOrEqualTo(String value) {
            addCriterion("IP3 <=", value, "ip3");
            return (Criteria) this;
        }

        public Criteria andIp3Like(String value) {
            addCriterion("IP3 like", value, "ip3");
            return (Criteria) this;
        }

        public Criteria andIp3NotLike(String value) {
            addCriterion("IP3 not like", value, "ip3");
            return (Criteria) this;
        }

        public Criteria andIp3In(List<String> values) {
            addCriterion("IP3 in", values, "ip3");
            return (Criteria) this;
        }

        public Criteria andIp3NotIn(List<String> values) {
            addCriterion("IP3 not in", values, "ip3");
            return (Criteria) this;
        }

        public Criteria andIp3Between(String value1, String value2) {
            addCriterion("IP3 between", value1, value2, "ip3");
            return (Criteria) this;
        }

        public Criteria andIp3NotBetween(String value1, String value2) {
            addCriterion("IP3 not between", value1, value2, "ip3");
            return (Criteria) this;
        }

        public Criteria andModifyIsNull() {
            addCriterion("modify is null");
            return (Criteria) this;
        }

        public Criteria andModifyIsNotNull() {
            addCriterion("modify is not null");
            return (Criteria) this;
        }

        public Criteria andModifyEqualTo(Integer value) {
            addCriterion("modify =", value, "modify");
            return (Criteria) this;
        }

        public Criteria andModifyNotEqualTo(Integer value) {
            addCriterion("modify <>", value, "modify");
            return (Criteria) this;
        }

        public Criteria andModifyGreaterThan(Integer value) {
            addCriterion("modify >", value, "modify");
            return (Criteria) this;
        }

        public Criteria andModifyGreaterThanOrEqualTo(Integer value) {
            addCriterion("modify >=", value, "modify");
            return (Criteria) this;
        }

        public Criteria andModifyLessThan(Integer value) {
            addCriterion("modify <", value, "modify");
            return (Criteria) this;
        }

        public Criteria andModifyLessThanOrEqualTo(Integer value) {
            addCriterion("modify <=", value, "modify");
            return (Criteria) this;
        }

        public Criteria andModifyIn(List<Integer> values) {
            addCriterion("modify in", values, "modify");
            return (Criteria) this;
        }

        public Criteria andModifyNotIn(List<Integer> values) {
            addCriterion("modify not in", values, "modify");
            return (Criteria) this;
        }

        public Criteria andModifyBetween(Integer value1, Integer value2) {
            addCriterion("modify between", value1, value2, "modify");
            return (Criteria) this;
        }

        public Criteria andModifyNotBetween(Integer value1, Integer value2) {
            addCriterion("modify not between", value1, value2, "modify");
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