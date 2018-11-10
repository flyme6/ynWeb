package com.yn.entity;

import java.util.ArrayList;
import java.util.List;

public class PointsExample extends Base {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PointsExample() {
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andDescIsNull() {
            addCriterion("desc is null");
            return (Criteria) this;
        }

        public Criteria andDescIsNotNull() {
            addCriterion("desc is not null");
            return (Criteria) this;
        }

        public Criteria andDescEqualTo(String value) {
            addCriterion("desc =", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescNotEqualTo(String value) {
            addCriterion("desc <>", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescGreaterThan(String value) {
            addCriterion("desc >", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescGreaterThanOrEqualTo(String value) {
            addCriterion("desc >=", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescLessThan(String value) {
            addCriterion("desc <", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescLessThanOrEqualTo(String value) {
            addCriterion("desc <=", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescLike(String value) {
            addCriterion("desc like", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescNotLike(String value) {
            addCriterion("desc not like", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescIn(List<String> values) {
            addCriterion("desc in", values, "desc");
            return (Criteria) this;
        }

        public Criteria andDescNotIn(List<String> values) {
            addCriterion("desc not in", values, "desc");
            return (Criteria) this;
        }

        public Criteria andDescBetween(String value1, String value2) {
            addCriterion("desc between", value1, value2, "desc");
            return (Criteria) this;
        }

        public Criteria andDescNotBetween(String value1, String value2) {
            addCriterion("desc not between", value1, value2, "desc");
            return (Criteria) this;
        }

        public Criteria andCDevIsNull() {
            addCriterion("c_dev is null");
            return (Criteria) this;
        }

        public Criteria andCDevIsNotNull() {
            addCriterion("c_dev is not null");
            return (Criteria) this;
        }

        public Criteria andCDevEqualTo(String value) {
            addCriterion("c_dev =", value, "cDev");
            return (Criteria) this;
        }

        public Criteria andCDevNotEqualTo(String value) {
            addCriterion("c_dev <>", value, "cDev");
            return (Criteria) this;
        }

        public Criteria andCDevGreaterThan(String value) {
            addCriterion("c_dev >", value, "cDev");
            return (Criteria) this;
        }

        public Criteria andCDevGreaterThanOrEqualTo(String value) {
            addCriterion("c_dev >=", value, "cDev");
            return (Criteria) this;
        }

        public Criteria andCDevLessThan(String value) {
            addCriterion("c_dev <", value, "cDev");
            return (Criteria) this;
        }

        public Criteria andCDevLessThanOrEqualTo(String value) {
            addCriterion("c_dev <=", value, "cDev");
            return (Criteria) this;
        }

        public Criteria andCDevLike(String value) {
            addCriterion("c_dev like", value, "cDev");
            return (Criteria) this;
        }

        public Criteria andCDevNotLike(String value) {
            addCriterion("c_dev not like", value, "cDev");
            return (Criteria) this;
        }

        public Criteria andCDevIn(List<String> values) {
            addCriterion("c_dev in", values, "cDev");
            return (Criteria) this;
        }

        public Criteria andCDevNotIn(List<String> values) {
            addCriterion("c_dev not in", values, "cDev");
            return (Criteria) this;
        }

        public Criteria andCDevBetween(String value1, String value2) {
            addCriterion("c_dev between", value1, value2, "cDev");
            return (Criteria) this;
        }

        public Criteria andCDevNotBetween(String value1, String value2) {
            addCriterion("c_dev not between", value1, value2, "cDev");
            return (Criteria) this;
        }

        public Criteria andCDevidIsNull() {
            addCriterion("c_devid is null");
            return (Criteria) this;
        }

        public Criteria andCDevidIsNotNull() {
            addCriterion("c_devid is not null");
            return (Criteria) this;
        }

        public Criteria andCDevidEqualTo(Integer value) {
            addCriterion("c_devid =", value, "cDevid");
            return (Criteria) this;
        }

        public Criteria andCDevidNotEqualTo(Integer value) {
            addCriterion("c_devid <>", value, "cDevid");
            return (Criteria) this;
        }

        public Criteria andCDevidGreaterThan(Integer value) {
            addCriterion("c_devid >", value, "cDevid");
            return (Criteria) this;
        }

        public Criteria andCDevidGreaterThanOrEqualTo(Integer value) {
            addCriterion("c_devid >=", value, "cDevid");
            return (Criteria) this;
        }

        public Criteria andCDevidLessThan(Integer value) {
            addCriterion("c_devid <", value, "cDevid");
            return (Criteria) this;
        }

        public Criteria andCDevidLessThanOrEqualTo(Integer value) {
            addCriterion("c_devid <=", value, "cDevid");
            return (Criteria) this;
        }

        public Criteria andCDevidIn(List<Integer> values) {
            addCriterion("c_devid in", values, "cDevid");
            return (Criteria) this;
        }

        public Criteria andCDevidNotIn(List<Integer> values) {
            addCriterion("c_devid not in", values, "cDevid");
            return (Criteria) this;
        }

        public Criteria andCDevidBetween(Integer value1, Integer value2) {
            addCriterion("c_devid between", value1, value2, "cDevid");
            return (Criteria) this;
        }

        public Criteria andCDevidNotBetween(Integer value1, Integer value2) {
            addCriterion("c_devid not between", value1, value2, "cDevid");
            return (Criteria) this;
        }

        public Criteria andCInaddrIsNull() {
            addCriterion("c_inaddr is null");
            return (Criteria) this;
        }

        public Criteria andCInaddrIsNotNull() {
            addCriterion("c_inaddr is not null");
            return (Criteria) this;
        }

        public Criteria andCInaddrEqualTo(String value) {
            addCriterion("c_inaddr =", value, "cInaddr");
            return (Criteria) this;
        }

        public Criteria andCInaddrNotEqualTo(String value) {
            addCriterion("c_inaddr <>", value, "cInaddr");
            return (Criteria) this;
        }

        public Criteria andCInaddrGreaterThan(String value) {
            addCriterion("c_inaddr >", value, "cInaddr");
            return (Criteria) this;
        }

        public Criteria andCInaddrGreaterThanOrEqualTo(String value) {
            addCriterion("c_inaddr >=", value, "cInaddr");
            return (Criteria) this;
        }

        public Criteria andCInaddrLessThan(String value) {
            addCriterion("c_inaddr <", value, "cInaddr");
            return (Criteria) this;
        }

        public Criteria andCInaddrLessThanOrEqualTo(String value) {
            addCriterion("c_inaddr <=", value, "cInaddr");
            return (Criteria) this;
        }

        public Criteria andCInaddrLike(String value) {
            addCriterion("c_inaddr like", value, "cInaddr");
            return (Criteria) this;
        }

        public Criteria andCInaddrNotLike(String value) {
            addCriterion("c_inaddr not like", value, "cInaddr");
            return (Criteria) this;
        }

        public Criteria andCInaddrIn(List<String> values) {
            addCriterion("c_inaddr in", values, "cInaddr");
            return (Criteria) this;
        }

        public Criteria andCInaddrNotIn(List<String> values) {
            addCriterion("c_inaddr not in", values, "cInaddr");
            return (Criteria) this;
        }

        public Criteria andCInaddrBetween(String value1, String value2) {
            addCriterion("c_inaddr between", value1, value2, "cInaddr");
            return (Criteria) this;
        }

        public Criteria andCInaddrNotBetween(String value1, String value2) {
            addCriterion("c_inaddr not between", value1, value2, "cInaddr");
            return (Criteria) this;
        }

        public Criteria andCIntypeIsNull() {
            addCriterion("c_intype is null");
            return (Criteria) this;
        }

        public Criteria andCIntypeIsNotNull() {
            addCriterion("c_intype is not null");
            return (Criteria) this;
        }

        public Criteria andCIntypeEqualTo(String value) {
            addCriterion("c_intype =", value, "cIntype");
            return (Criteria) this;
        }

        public Criteria andCIntypeNotEqualTo(String value) {
            addCriterion("c_intype <>", value, "cIntype");
            return (Criteria) this;
        }

        public Criteria andCIntypeGreaterThan(String value) {
            addCriterion("c_intype >", value, "cIntype");
            return (Criteria) this;
        }

        public Criteria andCIntypeGreaterThanOrEqualTo(String value) {
            addCriterion("c_intype >=", value, "cIntype");
            return (Criteria) this;
        }

        public Criteria andCIntypeLessThan(String value) {
            addCriterion("c_intype <", value, "cIntype");
            return (Criteria) this;
        }

        public Criteria andCIntypeLessThanOrEqualTo(String value) {
            addCriterion("c_intype <=", value, "cIntype");
            return (Criteria) this;
        }

        public Criteria andCIntypeLike(String value) {
            addCriterion("c_intype like", value, "cIntype");
            return (Criteria) this;
        }

        public Criteria andCIntypeNotLike(String value) {
            addCriterion("c_intype not like", value, "cIntype");
            return (Criteria) this;
        }

        public Criteria andCIntypeIn(List<String> values) {
            addCriterion("c_intype in", values, "cIntype");
            return (Criteria) this;
        }

        public Criteria andCIntypeNotIn(List<String> values) {
            addCriterion("c_intype not in", values, "cIntype");
            return (Criteria) this;
        }

        public Criteria andCIntypeBetween(String value1, String value2) {
            addCriterion("c_intype between", value1, value2, "cIntype");
            return (Criteria) this;
        }

        public Criteria andCIntypeNotBetween(String value1, String value2) {
            addCriterion("c_intype not between", value1, value2, "cIntype");
            return (Criteria) this;
        }

        public Criteria andCInbitIsNull() {
            addCriterion("c_inbit is null");
            return (Criteria) this;
        }

        public Criteria andCInbitIsNotNull() {
            addCriterion("c_inbit is not null");
            return (Criteria) this;
        }

        public Criteria andCInbitEqualTo(Integer value) {
            addCriterion("c_inbit =", value, "cInbit");
            return (Criteria) this;
        }

        public Criteria andCInbitNotEqualTo(Integer value) {
            addCriterion("c_inbit <>", value, "cInbit");
            return (Criteria) this;
        }

        public Criteria andCInbitGreaterThan(Integer value) {
            addCriterion("c_inbit >", value, "cInbit");
            return (Criteria) this;
        }

        public Criteria andCInbitGreaterThanOrEqualTo(Integer value) {
            addCriterion("c_inbit >=", value, "cInbit");
            return (Criteria) this;
        }

        public Criteria andCInbitLessThan(Integer value) {
            addCriterion("c_inbit <", value, "cInbit");
            return (Criteria) this;
        }

        public Criteria andCInbitLessThanOrEqualTo(Integer value) {
            addCriterion("c_inbit <=", value, "cInbit");
            return (Criteria) this;
        }

        public Criteria andCInbitIn(List<Integer> values) {
            addCriterion("c_inbit in", values, "cInbit");
            return (Criteria) this;
        }

        public Criteria andCInbitNotIn(List<Integer> values) {
            addCriterion("c_inbit not in", values, "cInbit");
            return (Criteria) this;
        }

        public Criteria andCInbitBetween(Integer value1, Integer value2) {
            addCriterion("c_inbit between", value1, value2, "cInbit");
            return (Criteria) this;
        }

        public Criteria andCInbitNotBetween(Integer value1, Integer value2) {
            addCriterion("c_inbit not between", value1, value2, "cInbit");
            return (Criteria) this;
        }

        public Criteria andFDevIsNull() {
            addCriterion("f_dev is null");
            return (Criteria) this;
        }

        public Criteria andFDevIsNotNull() {
            addCriterion("f_dev is not null");
            return (Criteria) this;
        }

        public Criteria andFDevEqualTo(String value) {
            addCriterion("f_dev =", value, "fDev");
            return (Criteria) this;
        }

        public Criteria andFDevNotEqualTo(String value) {
            addCriterion("f_dev <>", value, "fDev");
            return (Criteria) this;
        }

        public Criteria andFDevGreaterThan(String value) {
            addCriterion("f_dev >", value, "fDev");
            return (Criteria) this;
        }

        public Criteria andFDevGreaterThanOrEqualTo(String value) {
            addCriterion("f_dev >=", value, "fDev");
            return (Criteria) this;
        }

        public Criteria andFDevLessThan(String value) {
            addCriterion("f_dev <", value, "fDev");
            return (Criteria) this;
        }

        public Criteria andFDevLessThanOrEqualTo(String value) {
            addCriterion("f_dev <=", value, "fDev");
            return (Criteria) this;
        }

        public Criteria andFDevLike(String value) {
            addCriterion("f_dev like", value, "fDev");
            return (Criteria) this;
        }

        public Criteria andFDevNotLike(String value) {
            addCriterion("f_dev not like", value, "fDev");
            return (Criteria) this;
        }

        public Criteria andFDevIn(List<String> values) {
            addCriterion("f_dev in", values, "fDev");
            return (Criteria) this;
        }

        public Criteria andFDevNotIn(List<String> values) {
            addCriterion("f_dev not in", values, "fDev");
            return (Criteria) this;
        }

        public Criteria andFDevBetween(String value1, String value2) {
            addCriterion("f_dev between", value1, value2, "fDev");
            return (Criteria) this;
        }

        public Criteria andFDevNotBetween(String value1, String value2) {
            addCriterion("f_dev not between", value1, value2, "fDev");
            return (Criteria) this;
        }

        public Criteria andFDevidIsNull() {
            addCriterion("f_devid is null");
            return (Criteria) this;
        }

        public Criteria andFDevidIsNotNull() {
            addCriterion("f_devid is not null");
            return (Criteria) this;
        }

        public Criteria andFDevidEqualTo(Integer value) {
            addCriterion("f_devid =", value, "fDevid");
            return (Criteria) this;
        }

        public Criteria andFDevidNotEqualTo(Integer value) {
            addCriterion("f_devid <>", value, "fDevid");
            return (Criteria) this;
        }

        public Criteria andFDevidGreaterThan(Integer value) {
            addCriterion("f_devid >", value, "fDevid");
            return (Criteria) this;
        }

        public Criteria andFDevidGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_devid >=", value, "fDevid");
            return (Criteria) this;
        }

        public Criteria andFDevidLessThan(Integer value) {
            addCriterion("f_devid <", value, "fDevid");
            return (Criteria) this;
        }

        public Criteria andFDevidLessThanOrEqualTo(Integer value) {
            addCriterion("f_devid <=", value, "fDevid");
            return (Criteria) this;
        }

        public Criteria andFDevidIn(List<Integer> values) {
            addCriterion("f_devid in", values, "fDevid");
            return (Criteria) this;
        }

        public Criteria andFDevidNotIn(List<Integer> values) {
            addCriterion("f_devid not in", values, "fDevid");
            return (Criteria) this;
        }

        public Criteria andFDevidBetween(Integer value1, Integer value2) {
            addCriterion("f_devid between", value1, value2, "fDevid");
            return (Criteria) this;
        }

        public Criteria andFDevidNotBetween(Integer value1, Integer value2) {
            addCriterion("f_devid not between", value1, value2, "fDevid");
            return (Criteria) this;
        }

        public Criteria andFInaddrIsNull() {
            addCriterion("f_inaddr is null");
            return (Criteria) this;
        }

        public Criteria andFInaddrIsNotNull() {
            addCriterion("f_inaddr is not null");
            return (Criteria) this;
        }

        public Criteria andFInaddrEqualTo(String value) {
            addCriterion("f_inaddr =", value, "fInaddr");
            return (Criteria) this;
        }

        public Criteria andFInaddrNotEqualTo(String value) {
            addCriterion("f_inaddr <>", value, "fInaddr");
            return (Criteria) this;
        }

        public Criteria andFInaddrGreaterThan(String value) {
            addCriterion("f_inaddr >", value, "fInaddr");
            return (Criteria) this;
        }

        public Criteria andFInaddrGreaterThanOrEqualTo(String value) {
            addCriterion("f_inaddr >=", value, "fInaddr");
            return (Criteria) this;
        }

        public Criteria andFInaddrLessThan(String value) {
            addCriterion("f_inaddr <", value, "fInaddr");
            return (Criteria) this;
        }

        public Criteria andFInaddrLessThanOrEqualTo(String value) {
            addCriterion("f_inaddr <=", value, "fInaddr");
            return (Criteria) this;
        }

        public Criteria andFInaddrLike(String value) {
            addCriterion("f_inaddr like", value, "fInaddr");
            return (Criteria) this;
        }

        public Criteria andFInaddrNotLike(String value) {
            addCriterion("f_inaddr not like", value, "fInaddr");
            return (Criteria) this;
        }

        public Criteria andFInaddrIn(List<String> values) {
            addCriterion("f_inaddr in", values, "fInaddr");
            return (Criteria) this;
        }

        public Criteria andFInaddrNotIn(List<String> values) {
            addCriterion("f_inaddr not in", values, "fInaddr");
            return (Criteria) this;
        }

        public Criteria andFInaddrBetween(String value1, String value2) {
            addCriterion("f_inaddr between", value1, value2, "fInaddr");
            return (Criteria) this;
        }

        public Criteria andFInaddrNotBetween(String value1, String value2) {
            addCriterion("f_inaddr not between", value1, value2, "fInaddr");
            return (Criteria) this;
        }

        public Criteria andFIntypeIsNull() {
            addCriterion("f_intype is null");
            return (Criteria) this;
        }

        public Criteria andFIntypeIsNotNull() {
            addCriterion("f_intype is not null");
            return (Criteria) this;
        }

        public Criteria andFIntypeEqualTo(String value) {
            addCriterion("f_intype =", value, "fIntype");
            return (Criteria) this;
        }

        public Criteria andFIntypeNotEqualTo(String value) {
            addCriterion("f_intype <>", value, "fIntype");
            return (Criteria) this;
        }

        public Criteria andFIntypeGreaterThan(String value) {
            addCriterion("f_intype >", value, "fIntype");
            return (Criteria) this;
        }

        public Criteria andFIntypeGreaterThanOrEqualTo(String value) {
            addCriterion("f_intype >=", value, "fIntype");
            return (Criteria) this;
        }

        public Criteria andFIntypeLessThan(String value) {
            addCriterion("f_intype <", value, "fIntype");
            return (Criteria) this;
        }

        public Criteria andFIntypeLessThanOrEqualTo(String value) {
            addCriterion("f_intype <=", value, "fIntype");
            return (Criteria) this;
        }

        public Criteria andFIntypeLike(String value) {
            addCriterion("f_intype like", value, "fIntype");
            return (Criteria) this;
        }

        public Criteria andFIntypeNotLike(String value) {
            addCriterion("f_intype not like", value, "fIntype");
            return (Criteria) this;
        }

        public Criteria andFIntypeIn(List<String> values) {
            addCriterion("f_intype in", values, "fIntype");
            return (Criteria) this;
        }

        public Criteria andFIntypeNotIn(List<String> values) {
            addCriterion("f_intype not in", values, "fIntype");
            return (Criteria) this;
        }

        public Criteria andFIntypeBetween(String value1, String value2) {
            addCriterion("f_intype between", value1, value2, "fIntype");
            return (Criteria) this;
        }

        public Criteria andFIntypeNotBetween(String value1, String value2) {
            addCriterion("f_intype not between", value1, value2, "fIntype");
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