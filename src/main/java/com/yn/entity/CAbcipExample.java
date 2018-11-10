package com.yn.entity;

import java.util.ArrayList;
import java.util.List;

public class CAbcipExample extends Base{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CAbcipExample() {
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

        public Criteria andWeightIsNull() {
            addCriterion("weight is null");
            return (Criteria) this;
        }

        public Criteria andWeightIsNotNull() {
            addCriterion("weight is not null");
            return (Criteria) this;
        }

        public Criteria andWeightEqualTo(Integer value) {
            addCriterion("weight =", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotEqualTo(Integer value) {
            addCriterion("weight <>", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThan(Integer value) {
            addCriterion("weight >", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThanOrEqualTo(Integer value) {
            addCriterion("weight >=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThan(Integer value) {
            addCriterion("weight <", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThanOrEqualTo(Integer value) {
            addCriterion("weight <=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightIn(List<Integer> values) {
            addCriterion("weight in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotIn(List<Integer> values) {
            addCriterion("weight not in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightBetween(Integer value1, Integer value2) {
            addCriterion("weight between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotBetween(Integer value1, Integer value2) {
            addCriterion("weight not between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andMainIpIsNull() {
            addCriterion("main_ip is null");
            return (Criteria) this;
        }

        public Criteria andMainIpIsNotNull() {
            addCriterion("main_ip is not null");
            return (Criteria) this;
        }

        public Criteria andMainIpEqualTo(String value) {
            addCriterion("main_ip =", value, "mainIp");
            return (Criteria) this;
        }

        public Criteria andMainIpNotEqualTo(String value) {
            addCriterion("main_ip <>", value, "mainIp");
            return (Criteria) this;
        }

        public Criteria andMainIpGreaterThan(String value) {
            addCriterion("main_ip >", value, "mainIp");
            return (Criteria) this;
        }

        public Criteria andMainIpGreaterThanOrEqualTo(String value) {
            addCriterion("main_ip >=", value, "mainIp");
            return (Criteria) this;
        }

        public Criteria andMainIpLessThan(String value) {
            addCriterion("main_ip <", value, "mainIp");
            return (Criteria) this;
        }

        public Criteria andMainIpLessThanOrEqualTo(String value) {
            addCriterion("main_ip <=", value, "mainIp");
            return (Criteria) this;
        }

        public Criteria andMainIpLike(String value) {
            addCriterion("main_ip like", value, "mainIp");
            return (Criteria) this;
        }

        public Criteria andMainIpNotLike(String value) {
            addCriterion("main_ip not like", value, "mainIp");
            return (Criteria) this;
        }

        public Criteria andMainIpIn(List<String> values) {
            addCriterion("main_ip in", values, "mainIp");
            return (Criteria) this;
        }

        public Criteria andMainIpNotIn(List<String> values) {
            addCriterion("main_ip not in", values, "mainIp");
            return (Criteria) this;
        }

        public Criteria andMainIpBetween(String value1, String value2) {
            addCriterion("main_ip between", value1, value2, "mainIp");
            return (Criteria) this;
        }

        public Criteria andMainIpNotBetween(String value1, String value2) {
            addCriterion("main_ip not between", value1, value2, "mainIp");
            return (Criteria) this;
        }

        public Criteria andBackIpIsNull() {
            addCriterion("back_ip is null");
            return (Criteria) this;
        }

        public Criteria andBackIpIsNotNull() {
            addCriterion("back_ip is not null");
            return (Criteria) this;
        }

        public Criteria andBackIpEqualTo(String value) {
            addCriterion("back_ip =", value, "backIp");
            return (Criteria) this;
        }

        public Criteria andBackIpNotEqualTo(String value) {
            addCriterion("back_ip <>", value, "backIp");
            return (Criteria) this;
        }

        public Criteria andBackIpGreaterThan(String value) {
            addCriterion("back_ip >", value, "backIp");
            return (Criteria) this;
        }

        public Criteria andBackIpGreaterThanOrEqualTo(String value) {
            addCriterion("back_ip >=", value, "backIp");
            return (Criteria) this;
        }

        public Criteria andBackIpLessThan(String value) {
            addCriterion("back_ip <", value, "backIp");
            return (Criteria) this;
        }

        public Criteria andBackIpLessThanOrEqualTo(String value) {
            addCriterion("back_ip <=", value, "backIp");
            return (Criteria) this;
        }

        public Criteria andBackIpLike(String value) {
            addCriterion("back_ip like", value, "backIp");
            return (Criteria) this;
        }

        public Criteria andBackIpNotLike(String value) {
            addCriterion("back_ip not like", value, "backIp");
            return (Criteria) this;
        }

        public Criteria andBackIpIn(List<String> values) {
            addCriterion("back_ip in", values, "backIp");
            return (Criteria) this;
        }

        public Criteria andBackIpNotIn(List<String> values) {
            addCriterion("back_ip not in", values, "backIp");
            return (Criteria) this;
        }

        public Criteria andBackIpBetween(String value1, String value2) {
            addCriterion("back_ip between", value1, value2, "backIp");
            return (Criteria) this;
        }

        public Criteria andBackIpNotBetween(String value1, String value2) {
            addCriterion("back_ip not between", value1, value2, "backIp");
            return (Criteria) this;
        }

        public Criteria andPortIsNull() {
            addCriterion("port is null");
            return (Criteria) this;
        }

        public Criteria andPortIsNotNull() {
            addCriterion("port is not null");
            return (Criteria) this;
        }

        public Criteria andPortEqualTo(Integer value) {
            addCriterion("port =", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortNotEqualTo(Integer value) {
            addCriterion("port <>", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortGreaterThan(Integer value) {
            addCriterion("port >", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortGreaterThanOrEqualTo(Integer value) {
            addCriterion("port >=", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortLessThan(Integer value) {
            addCriterion("port <", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortLessThanOrEqualTo(Integer value) {
            addCriterion("port <=", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortIn(List<Integer> values) {
            addCriterion("port in", values, "port");
            return (Criteria) this;
        }

        public Criteria andPortNotIn(List<Integer> values) {
            addCriterion("port not in", values, "port");
            return (Criteria) this;
        }

        public Criteria andPortBetween(Integer value1, Integer value2) {
            addCriterion("port between", value1, value2, "port");
            return (Criteria) this;
        }

        public Criteria andPortNotBetween(Integer value1, Integer value2) {
            addCriterion("port not between", value1, value2, "port");
            return (Criteria) this;
        }

        public Criteria andClctIntervalIsNull() {
            addCriterion("clct_interval is null");
            return (Criteria) this;
        }

        public Criteria andClctIntervalIsNotNull() {
            addCriterion("clct_interval is not null");
            return (Criteria) this;
        }

        public Criteria andClctIntervalEqualTo(Integer value) {
            addCriterion("clct_interval =", value, "clctInterval");
            return (Criteria) this;
        }

        public Criteria andClctIntervalNotEqualTo(Integer value) {
            addCriterion("clct_interval <>", value, "clctInterval");
            return (Criteria) this;
        }

        public Criteria andClctIntervalGreaterThan(Integer value) {
            addCriterion("clct_interval >", value, "clctInterval");
            return (Criteria) this;
        }

        public Criteria andClctIntervalGreaterThanOrEqualTo(Integer value) {
            addCriterion("clct_interval >=", value, "clctInterval");
            return (Criteria) this;
        }

        public Criteria andClctIntervalLessThan(Integer value) {
            addCriterion("clct_interval <", value, "clctInterval");
            return (Criteria) this;
        }

        public Criteria andClctIntervalLessThanOrEqualTo(Integer value) {
            addCriterion("clct_interval <=", value, "clctInterval");
            return (Criteria) this;
        }

        public Criteria andClctIntervalIn(List<Integer> values) {
            addCriterion("clct_interval in", values, "clctInterval");
            return (Criteria) this;
        }

        public Criteria andClctIntervalNotIn(List<Integer> values) {
            addCriterion("clct_interval not in", values, "clctInterval");
            return (Criteria) this;
        }

        public Criteria andClctIntervalBetween(Integer value1, Integer value2) {
            addCriterion("clct_interval between", value1, value2, "clctInterval");
            return (Criteria) this;
        }

        public Criteria andClctIntervalNotBetween(Integer value1, Integer value2) {
            addCriterion("clct_interval not between", value1, value2, "clctInterval");
            return (Criteria) this;
        }

        public Criteria andClctTimeoutIsNull() {
            addCriterion("clct_timeout is null");
            return (Criteria) this;
        }

        public Criteria andClctTimeoutIsNotNull() {
            addCriterion("clct_timeout is not null");
            return (Criteria) this;
        }

        public Criteria andClctTimeoutEqualTo(Integer value) {
            addCriterion("clct_timeout =", value, "clctTimeout");
            return (Criteria) this;
        }

        public Criteria andClctTimeoutNotEqualTo(Integer value) {
            addCriterion("clct_timeout <>", value, "clctTimeout");
            return (Criteria) this;
        }

        public Criteria andClctTimeoutGreaterThan(Integer value) {
            addCriterion("clct_timeout >", value, "clctTimeout");
            return (Criteria) this;
        }

        public Criteria andClctTimeoutGreaterThanOrEqualTo(Integer value) {
            addCriterion("clct_timeout >=", value, "clctTimeout");
            return (Criteria) this;
        }

        public Criteria andClctTimeoutLessThan(Integer value) {
            addCriterion("clct_timeout <", value, "clctTimeout");
            return (Criteria) this;
        }

        public Criteria andClctTimeoutLessThanOrEqualTo(Integer value) {
            addCriterion("clct_timeout <=", value, "clctTimeout");
            return (Criteria) this;
        }

        public Criteria andClctTimeoutIn(List<Integer> values) {
            addCriterion("clct_timeout in", values, "clctTimeout");
            return (Criteria) this;
        }

        public Criteria andClctTimeoutNotIn(List<Integer> values) {
            addCriterion("clct_timeout not in", values, "clctTimeout");
            return (Criteria) this;
        }

        public Criteria andClctTimeoutBetween(Integer value1, Integer value2) {
            addCriterion("clct_timeout between", value1, value2, "clctTimeout");
            return (Criteria) this;
        }

        public Criteria andClctTimeoutNotBetween(Integer value1, Integer value2) {
            addCriterion("clct_timeout not between", value1, value2, "clctTimeout");
            return (Criteria) this;
        }

        public Criteria andCmdTimeoutIsNull() {
            addCriterion("cmd_timeout is null");
            return (Criteria) this;
        }

        public Criteria andCmdTimeoutIsNotNull() {
            addCriterion("cmd_timeout is not null");
            return (Criteria) this;
        }

        public Criteria andCmdTimeoutEqualTo(Integer value) {
            addCriterion("cmd_timeout =", value, "cmdTimeout");
            return (Criteria) this;
        }

        public Criteria andCmdTimeoutNotEqualTo(Integer value) {
            addCriterion("cmd_timeout <>", value, "cmdTimeout");
            return (Criteria) this;
        }

        public Criteria andCmdTimeoutGreaterThan(Integer value) {
            addCriterion("cmd_timeout >", value, "cmdTimeout");
            return (Criteria) this;
        }

        public Criteria andCmdTimeoutGreaterThanOrEqualTo(Integer value) {
            addCriterion("cmd_timeout >=", value, "cmdTimeout");
            return (Criteria) this;
        }

        public Criteria andCmdTimeoutLessThan(Integer value) {
            addCriterion("cmd_timeout <", value, "cmdTimeout");
            return (Criteria) this;
        }

        public Criteria andCmdTimeoutLessThanOrEqualTo(Integer value) {
            addCriterion("cmd_timeout <=", value, "cmdTimeout");
            return (Criteria) this;
        }

        public Criteria andCmdTimeoutIn(List<Integer> values) {
            addCriterion("cmd_timeout in", values, "cmdTimeout");
            return (Criteria) this;
        }

        public Criteria andCmdTimeoutNotIn(List<Integer> values) {
            addCriterion("cmd_timeout not in", values, "cmdTimeout");
            return (Criteria) this;
        }

        public Criteria andCmdTimeoutBetween(Integer value1, Integer value2) {
            addCriterion("cmd_timeout between", value1, value2, "cmdTimeout");
            return (Criteria) this;
        }

        public Criteria andCmdTimeoutNotBetween(Integer value1, Integer value2) {
            addCriterion("cmd_timeout not between", value1, value2, "cmdTimeout");
            return (Criteria) this;
        }

        public Criteria andPackageLenIsNull() {
            addCriterion("package_len is null");
            return (Criteria) this;
        }

        public Criteria andPackageLenIsNotNull() {
            addCriterion("package_len is not null");
            return (Criteria) this;
        }

        public Criteria andPackageLenEqualTo(Integer value) {
            addCriterion("package_len =", value, "packageLen");
            return (Criteria) this;
        }

        public Criteria andPackageLenNotEqualTo(Integer value) {
            addCriterion("package_len <>", value, "packageLen");
            return (Criteria) this;
        }

        public Criteria andPackageLenGreaterThan(Integer value) {
            addCriterion("package_len >", value, "packageLen");
            return (Criteria) this;
        }

        public Criteria andPackageLenGreaterThanOrEqualTo(Integer value) {
            addCriterion("package_len >=", value, "packageLen");
            return (Criteria) this;
        }

        public Criteria andPackageLenLessThan(Integer value) {
            addCriterion("package_len <", value, "packageLen");
            return (Criteria) this;
        }

        public Criteria andPackageLenLessThanOrEqualTo(Integer value) {
            addCriterion("package_len <=", value, "packageLen");
            return (Criteria) this;
        }

        public Criteria andPackageLenIn(List<Integer> values) {
            addCriterion("package_len in", values, "packageLen");
            return (Criteria) this;
        }

        public Criteria andPackageLenNotIn(List<Integer> values) {
            addCriterion("package_len not in", values, "packageLen");
            return (Criteria) this;
        }

        public Criteria andPackageLenBetween(Integer value1, Integer value2) {
            addCriterion("package_len between", value1, value2, "packageLen");
            return (Criteria) this;
        }

        public Criteria andPackageLenNotBetween(Integer value1, Integer value2) {
            addCriterion("package_len not between", value1, value2, "packageLen");
            return (Criteria) this;
        }

        public Criteria andRouteIsNull() {
            addCriterion("route is null");
            return (Criteria) this;
        }

        public Criteria andRouteIsNotNull() {
            addCriterion("route is not null");
            return (Criteria) this;
        }

        public Criteria andRouteEqualTo(String value) {
            addCriterion("route =", value, "route");
            return (Criteria) this;
        }

        public Criteria andRouteNotEqualTo(String value) {
            addCriterion("route <>", value, "route");
            return (Criteria) this;
        }

        public Criteria andRouteGreaterThan(String value) {
            addCriterion("route >", value, "route");
            return (Criteria) this;
        }

        public Criteria andRouteGreaterThanOrEqualTo(String value) {
            addCriterion("route >=", value, "route");
            return (Criteria) this;
        }

        public Criteria andRouteLessThan(String value) {
            addCriterion("route <", value, "route");
            return (Criteria) this;
        }

        public Criteria andRouteLessThanOrEqualTo(String value) {
            addCriterion("route <=", value, "route");
            return (Criteria) this;
        }

        public Criteria andRouteLike(String value) {
            addCriterion("route like", value, "route");
            return (Criteria) this;
        }

        public Criteria andRouteNotLike(String value) {
            addCriterion("route not like", value, "route");
            return (Criteria) this;
        }

        public Criteria andRouteIn(List<String> values) {
            addCriterion("route in", values, "route");
            return (Criteria) this;
        }

        public Criteria andRouteNotIn(List<String> values) {
            addCriterion("route not in", values, "route");
            return (Criteria) this;
        }

        public Criteria andRouteBetween(String value1, String value2) {
            addCriterion("route between", value1, value2, "route");
            return (Criteria) this;
        }

        public Criteria andRouteNotBetween(String value1, String value2) {
            addCriterion("route not between", value1, value2, "route");
            return (Criteria) this;
        }

        public Criteria andCmdCacheSizeIsNull() {
            addCriterion("cmd_cache_size is null");
            return (Criteria) this;
        }

        public Criteria andCmdCacheSizeIsNotNull() {
            addCriterion("cmd_cache_size is not null");
            return (Criteria) this;
        }

        public Criteria andCmdCacheSizeEqualTo(Integer value) {
            addCriterion("cmd_cache_size =", value, "cmdCacheSize");
            return (Criteria) this;
        }

        public Criteria andCmdCacheSizeNotEqualTo(Integer value) {
            addCriterion("cmd_cache_size <>", value, "cmdCacheSize");
            return (Criteria) this;
        }

        public Criteria andCmdCacheSizeGreaterThan(Integer value) {
            addCriterion("cmd_cache_size >", value, "cmdCacheSize");
            return (Criteria) this;
        }

        public Criteria andCmdCacheSizeGreaterThanOrEqualTo(Integer value) {
            addCriterion("cmd_cache_size >=", value, "cmdCacheSize");
            return (Criteria) this;
        }

        public Criteria andCmdCacheSizeLessThan(Integer value) {
            addCriterion("cmd_cache_size <", value, "cmdCacheSize");
            return (Criteria) this;
        }

        public Criteria andCmdCacheSizeLessThanOrEqualTo(Integer value) {
            addCriterion("cmd_cache_size <=", value, "cmdCacheSize");
            return (Criteria) this;
        }

        public Criteria andCmdCacheSizeIn(List<Integer> values) {
            addCriterion("cmd_cache_size in", values, "cmdCacheSize");
            return (Criteria) this;
        }

        public Criteria andCmdCacheSizeNotIn(List<Integer> values) {
            addCriterion("cmd_cache_size not in", values, "cmdCacheSize");
            return (Criteria) this;
        }

        public Criteria andCmdCacheSizeBetween(Integer value1, Integer value2) {
            addCriterion("cmd_cache_size between", value1, value2, "cmdCacheSize");
            return (Criteria) this;
        }

        public Criteria andCmdCacheSizeNotBetween(Integer value1, Integer value2) {
            addCriterion("cmd_cache_size not between", value1, value2, "cmdCacheSize");
            return (Criteria) this;
        }

        public Criteria andActiveIsNull() {
            addCriterion("active is null");
            return (Criteria) this;
        }

        public Criteria andActiveIsNotNull() {
            addCriterion("active is not null");
            return (Criteria) this;
        }

        public Criteria andActiveEqualTo(Integer value) {
            addCriterion("active =", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveNotEqualTo(Integer value) {
            addCriterion("active <>", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveGreaterThan(Integer value) {
            addCriterion("active >", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveGreaterThanOrEqualTo(Integer value) {
            addCriterion("active >=", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveLessThan(Integer value) {
            addCriterion("active <", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveLessThanOrEqualTo(Integer value) {
            addCriterion("active <=", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveIn(List<Integer> values) {
            addCriterion("active in", values, "active");
            return (Criteria) this;
        }

        public Criteria andActiveNotIn(List<Integer> values) {
            addCriterion("active not in", values, "active");
            return (Criteria) this;
        }

        public Criteria andActiveBetween(Integer value1, Integer value2) {
            addCriterion("active between", value1, value2, "active");
            return (Criteria) this;
        }

        public Criteria andActiveNotBetween(Integer value1, Integer value2) {
            addCriterion("active not between", value1, value2, "active");
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