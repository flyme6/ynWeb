package com.yn.entity;

import java.util.ArrayList;
import java.util.List;

public class CIec104Example extends Base {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CIec104Example() {
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

        public Criteria andSInitIsNull() {
            addCriterion("s_init is null");
            return (Criteria) this;
        }

        public Criteria andSInitIsNotNull() {
            addCriterion("s_init is not null");
            return (Criteria) this;
        }

        public Criteria andSInitEqualTo(Integer value) {
            addCriterion("s_init =", value, "sInit");
            return (Criteria) this;
        }

        public Criteria andSInitNotEqualTo(Integer value) {
            addCriterion("s_init <>", value, "sInit");
            return (Criteria) this;
        }

        public Criteria andSInitGreaterThan(Integer value) {
            addCriterion("s_init >", value, "sInit");
            return (Criteria) this;
        }

        public Criteria andSInitGreaterThanOrEqualTo(Integer value) {
            addCriterion("s_init >=", value, "sInit");
            return (Criteria) this;
        }

        public Criteria andSInitLessThan(Integer value) {
            addCriterion("s_init <", value, "sInit");
            return (Criteria) this;
        }

        public Criteria andSInitLessThanOrEqualTo(Integer value) {
            addCriterion("s_init <=", value, "sInit");
            return (Criteria) this;
        }

        public Criteria andSInitIn(List<Integer> values) {
            addCriterion("s_init in", values, "sInit");
            return (Criteria) this;
        }

        public Criteria andSInitNotIn(List<Integer> values) {
            addCriterion("s_init not in", values, "sInit");
            return (Criteria) this;
        }

        public Criteria andSInitBetween(Integer value1, Integer value2) {
            addCriterion("s_init between", value1, value2, "sInit");
            return (Criteria) this;
        }

        public Criteria andSInitNotBetween(Integer value1, Integer value2) {
            addCriterion("s_init not between", value1, value2, "sInit");
            return (Criteria) this;
        }

        public Criteria andRInitIsNull() {
            addCriterion("r_init is null");
            return (Criteria) this;
        }

        public Criteria andRInitIsNotNull() {
            addCriterion("r_init is not null");
            return (Criteria) this;
        }

        public Criteria andRInitEqualTo(Integer value) {
            addCriterion("r_init =", value, "rInit");
            return (Criteria) this;
        }

        public Criteria andRInitNotEqualTo(Integer value) {
            addCriterion("r_init <>", value, "rInit");
            return (Criteria) this;
        }

        public Criteria andRInitGreaterThan(Integer value) {
            addCriterion("r_init >", value, "rInit");
            return (Criteria) this;
        }

        public Criteria andRInitGreaterThanOrEqualTo(Integer value) {
            addCriterion("r_init >=", value, "rInit");
            return (Criteria) this;
        }

        public Criteria andRInitLessThan(Integer value) {
            addCriterion("r_init <", value, "rInit");
            return (Criteria) this;
        }

        public Criteria andRInitLessThanOrEqualTo(Integer value) {
            addCriterion("r_init <=", value, "rInit");
            return (Criteria) this;
        }

        public Criteria andRInitIn(List<Integer> values) {
            addCriterion("r_init in", values, "rInit");
            return (Criteria) this;
        }

        public Criteria andRInitNotIn(List<Integer> values) {
            addCriterion("r_init not in", values, "rInit");
            return (Criteria) this;
        }

        public Criteria andRInitBetween(Integer value1, Integer value2) {
            addCriterion("r_init between", value1, value2, "rInit");
            return (Criteria) this;
        }

        public Criteria andRInitNotBetween(Integer value1, Integer value2) {
            addCriterion("r_init not between", value1, value2, "rInit");
            return (Criteria) this;
        }

        public Criteria andRCacheSizeIsNull() {
            addCriterion("r_cache_size is null");
            return (Criteria) this;
        }

        public Criteria andRCacheSizeIsNotNull() {
            addCriterion("r_cache_size is not null");
            return (Criteria) this;
        }

        public Criteria andRCacheSizeEqualTo(Integer value) {
            addCriterion("r_cache_size =", value, "rCacheSize");
            return (Criteria) this;
        }

        public Criteria andRCacheSizeNotEqualTo(Integer value) {
            addCriterion("r_cache_size <>", value, "rCacheSize");
            return (Criteria) this;
        }

        public Criteria andRCacheSizeGreaterThan(Integer value) {
            addCriterion("r_cache_size >", value, "rCacheSize");
            return (Criteria) this;
        }

        public Criteria andRCacheSizeGreaterThanOrEqualTo(Integer value) {
            addCriterion("r_cache_size >=", value, "rCacheSize");
            return (Criteria) this;
        }

        public Criteria andRCacheSizeLessThan(Integer value) {
            addCriterion("r_cache_size <", value, "rCacheSize");
            return (Criteria) this;
        }

        public Criteria andRCacheSizeLessThanOrEqualTo(Integer value) {
            addCriterion("r_cache_size <=", value, "rCacheSize");
            return (Criteria) this;
        }

        public Criteria andRCacheSizeIn(List<Integer> values) {
            addCriterion("r_cache_size in", values, "rCacheSize");
            return (Criteria) this;
        }

        public Criteria andRCacheSizeNotIn(List<Integer> values) {
            addCriterion("r_cache_size not in", values, "rCacheSize");
            return (Criteria) this;
        }

        public Criteria andRCacheSizeBetween(Integer value1, Integer value2) {
            addCriterion("r_cache_size between", value1, value2, "rCacheSize");
            return (Criteria) this;
        }

        public Criteria andRCacheSizeNotBetween(Integer value1, Integer value2) {
            addCriterion("r_cache_size not between", value1, value2, "rCacheSize");
            return (Criteria) this;
        }

        public Criteria andSCacheSizeIsNull() {
            addCriterion("s_cache_size is null");
            return (Criteria) this;
        }

        public Criteria andSCacheSizeIsNotNull() {
            addCriterion("s_cache_size is not null");
            return (Criteria) this;
        }

        public Criteria andSCacheSizeEqualTo(Integer value) {
            addCriterion("s_cache_size =", value, "sCacheSize");
            return (Criteria) this;
        }

        public Criteria andSCacheSizeNotEqualTo(Integer value) {
            addCriterion("s_cache_size <>", value, "sCacheSize");
            return (Criteria) this;
        }

        public Criteria andSCacheSizeGreaterThan(Integer value) {
            addCriterion("s_cache_size >", value, "sCacheSize");
            return (Criteria) this;
        }

        public Criteria andSCacheSizeGreaterThanOrEqualTo(Integer value) {
            addCriterion("s_cache_size >=", value, "sCacheSize");
            return (Criteria) this;
        }

        public Criteria andSCacheSizeLessThan(Integer value) {
            addCriterion("s_cache_size <", value, "sCacheSize");
            return (Criteria) this;
        }

        public Criteria andSCacheSizeLessThanOrEqualTo(Integer value) {
            addCriterion("s_cache_size <=", value, "sCacheSize");
            return (Criteria) this;
        }

        public Criteria andSCacheSizeIn(List<Integer> values) {
            addCriterion("s_cache_size in", values, "sCacheSize");
            return (Criteria) this;
        }

        public Criteria andSCacheSizeNotIn(List<Integer> values) {
            addCriterion("s_cache_size not in", values, "sCacheSize");
            return (Criteria) this;
        }

        public Criteria andSCacheSizeBetween(Integer value1, Integer value2) {
            addCriterion("s_cache_size between", value1, value2, "sCacheSize");
            return (Criteria) this;
        }

        public Criteria andSCacheSizeNotBetween(Integer value1, Integer value2) {
            addCriterion("s_cache_size not between", value1, value2, "sCacheSize");
            return (Criteria) this;
        }

        public Criteria andPubAddrSizeIsNull() {
            addCriterion("pub_addr_size is null");
            return (Criteria) this;
        }

        public Criteria andPubAddrSizeIsNotNull() {
            addCriterion("pub_addr_size is not null");
            return (Criteria) this;
        }

        public Criteria andPubAddrSizeEqualTo(Integer value) {
            addCriterion("pub_addr_size =", value, "pubAddrSize");
            return (Criteria) this;
        }

        public Criteria andPubAddrSizeNotEqualTo(Integer value) {
            addCriterion("pub_addr_size <>", value, "pubAddrSize");
            return (Criteria) this;
        }

        public Criteria andPubAddrSizeGreaterThan(Integer value) {
            addCriterion("pub_addr_size >", value, "pubAddrSize");
            return (Criteria) this;
        }

        public Criteria andPubAddrSizeGreaterThanOrEqualTo(Integer value) {
            addCriterion("pub_addr_size >=", value, "pubAddrSize");
            return (Criteria) this;
        }

        public Criteria andPubAddrSizeLessThan(Integer value) {
            addCriterion("pub_addr_size <", value, "pubAddrSize");
            return (Criteria) this;
        }

        public Criteria andPubAddrSizeLessThanOrEqualTo(Integer value) {
            addCriterion("pub_addr_size <=", value, "pubAddrSize");
            return (Criteria) this;
        }

        public Criteria andPubAddrSizeIn(List<Integer> values) {
            addCriterion("pub_addr_size in", values, "pubAddrSize");
            return (Criteria) this;
        }

        public Criteria andPubAddrSizeNotIn(List<Integer> values) {
            addCriterion("pub_addr_size not in", values, "pubAddrSize");
            return (Criteria) this;
        }

        public Criteria andPubAddrSizeBetween(Integer value1, Integer value2) {
            addCriterion("pub_addr_size between", value1, value2, "pubAddrSize");
            return (Criteria) this;
        }

        public Criteria andPubAddrSizeNotBetween(Integer value1, Integer value2) {
            addCriterion("pub_addr_size not between", value1, value2, "pubAddrSize");
            return (Criteria) this;
        }

        public Criteria andReasonSizeIsNull() {
            addCriterion("reason_size is null");
            return (Criteria) this;
        }

        public Criteria andReasonSizeIsNotNull() {
            addCriterion("reason_size is not null");
            return (Criteria) this;
        }

        public Criteria andReasonSizeEqualTo(Integer value) {
            addCriterion("reason_size =", value, "reasonSize");
            return (Criteria) this;
        }

        public Criteria andReasonSizeNotEqualTo(Integer value) {
            addCriterion("reason_size <>", value, "reasonSize");
            return (Criteria) this;
        }

        public Criteria andReasonSizeGreaterThan(Integer value) {
            addCriterion("reason_size >", value, "reasonSize");
            return (Criteria) this;
        }

        public Criteria andReasonSizeGreaterThanOrEqualTo(Integer value) {
            addCriterion("reason_size >=", value, "reasonSize");
            return (Criteria) this;
        }

        public Criteria andReasonSizeLessThan(Integer value) {
            addCriterion("reason_size <", value, "reasonSize");
            return (Criteria) this;
        }

        public Criteria andReasonSizeLessThanOrEqualTo(Integer value) {
            addCriterion("reason_size <=", value, "reasonSize");
            return (Criteria) this;
        }

        public Criteria andReasonSizeIn(List<Integer> values) {
            addCriterion("reason_size in", values, "reasonSize");
            return (Criteria) this;
        }

        public Criteria andReasonSizeNotIn(List<Integer> values) {
            addCriterion("reason_size not in", values, "reasonSize");
            return (Criteria) this;
        }

        public Criteria andReasonSizeBetween(Integer value1, Integer value2) {
            addCriterion("reason_size between", value1, value2, "reasonSize");
            return (Criteria) this;
        }

        public Criteria andReasonSizeNotBetween(Integer value1, Integer value2) {
            addCriterion("reason_size not between", value1, value2, "reasonSize");
            return (Criteria) this;
        }

        public Criteria andInfoAddrSizeIsNull() {
            addCriterion("info_addr_size is null");
            return (Criteria) this;
        }

        public Criteria andInfoAddrSizeIsNotNull() {
            addCriterion("info_addr_size is not null");
            return (Criteria) this;
        }

        public Criteria andInfoAddrSizeEqualTo(Integer value) {
            addCriterion("info_addr_size =", value, "infoAddrSize");
            return (Criteria) this;
        }

        public Criteria andInfoAddrSizeNotEqualTo(Integer value) {
            addCriterion("info_addr_size <>", value, "infoAddrSize");
            return (Criteria) this;
        }

        public Criteria andInfoAddrSizeGreaterThan(Integer value) {
            addCriterion("info_addr_size >", value, "infoAddrSize");
            return (Criteria) this;
        }

        public Criteria andInfoAddrSizeGreaterThanOrEqualTo(Integer value) {
            addCriterion("info_addr_size >=", value, "infoAddrSize");
            return (Criteria) this;
        }

        public Criteria andInfoAddrSizeLessThan(Integer value) {
            addCriterion("info_addr_size <", value, "infoAddrSize");
            return (Criteria) this;
        }

        public Criteria andInfoAddrSizeLessThanOrEqualTo(Integer value) {
            addCriterion("info_addr_size <=", value, "infoAddrSize");
            return (Criteria) this;
        }

        public Criteria andInfoAddrSizeIn(List<Integer> values) {
            addCriterion("info_addr_size in", values, "infoAddrSize");
            return (Criteria) this;
        }

        public Criteria andInfoAddrSizeNotIn(List<Integer> values) {
            addCriterion("info_addr_size not in", values, "infoAddrSize");
            return (Criteria) this;
        }

        public Criteria andInfoAddrSizeBetween(Integer value1, Integer value2) {
            addCriterion("info_addr_size between", value1, value2, "infoAddrSize");
            return (Criteria) this;
        }

        public Criteria andInfoAddrSizeNotBetween(Integer value1, Integer value2) {
            addCriterion("info_addr_size not between", value1, value2, "infoAddrSize");
            return (Criteria) this;
        }

        public Criteria andTimer0IsNull() {
            addCriterion("timer0 is null");
            return (Criteria) this;
        }

        public Criteria andTimer0IsNotNull() {
            addCriterion("timer0 is not null");
            return (Criteria) this;
        }

        public Criteria andTimer0EqualTo(Integer value) {
            addCriterion("timer0 =", value, "timer0");
            return (Criteria) this;
        }

        public Criteria andTimer0NotEqualTo(Integer value) {
            addCriterion("timer0 <>", value, "timer0");
            return (Criteria) this;
        }

        public Criteria andTimer0GreaterThan(Integer value) {
            addCriterion("timer0 >", value, "timer0");
            return (Criteria) this;
        }

        public Criteria andTimer0GreaterThanOrEqualTo(Integer value) {
            addCriterion("timer0 >=", value, "timer0");
            return (Criteria) this;
        }

        public Criteria andTimer0LessThan(Integer value) {
            addCriterion("timer0 <", value, "timer0");
            return (Criteria) this;
        }

        public Criteria andTimer0LessThanOrEqualTo(Integer value) {
            addCriterion("timer0 <=", value, "timer0");
            return (Criteria) this;
        }

        public Criteria andTimer0In(List<Integer> values) {
            addCriterion("timer0 in", values, "timer0");
            return (Criteria) this;
        }

        public Criteria andTimer0NotIn(List<Integer> values) {
            addCriterion("timer0 not in", values, "timer0");
            return (Criteria) this;
        }

        public Criteria andTimer0Between(Integer value1, Integer value2) {
            addCriterion("timer0 between", value1, value2, "timer0");
            return (Criteria) this;
        }

        public Criteria andTimer0NotBetween(Integer value1, Integer value2) {
            addCriterion("timer0 not between", value1, value2, "timer0");
            return (Criteria) this;
        }

        public Criteria andTimer1IsNull() {
            addCriterion("timer1 is null");
            return (Criteria) this;
        }

        public Criteria andTimer1IsNotNull() {
            addCriterion("timer1 is not null");
            return (Criteria) this;
        }

        public Criteria andTimer1EqualTo(Integer value) {
            addCriterion("timer1 =", value, "timer1");
            return (Criteria) this;
        }

        public Criteria andTimer1NotEqualTo(Integer value) {
            addCriterion("timer1 <>", value, "timer1");
            return (Criteria) this;
        }

        public Criteria andTimer1GreaterThan(Integer value) {
            addCriterion("timer1 >", value, "timer1");
            return (Criteria) this;
        }

        public Criteria andTimer1GreaterThanOrEqualTo(Integer value) {
            addCriterion("timer1 >=", value, "timer1");
            return (Criteria) this;
        }

        public Criteria andTimer1LessThan(Integer value) {
            addCriterion("timer1 <", value, "timer1");
            return (Criteria) this;
        }

        public Criteria andTimer1LessThanOrEqualTo(Integer value) {
            addCriterion("timer1 <=", value, "timer1");
            return (Criteria) this;
        }

        public Criteria andTimer1In(List<Integer> values) {
            addCriterion("timer1 in", values, "timer1");
            return (Criteria) this;
        }

        public Criteria andTimer1NotIn(List<Integer> values) {
            addCriterion("timer1 not in", values, "timer1");
            return (Criteria) this;
        }

        public Criteria andTimer1Between(Integer value1, Integer value2) {
            addCriterion("timer1 between", value1, value2, "timer1");
            return (Criteria) this;
        }

        public Criteria andTimer1NotBetween(Integer value1, Integer value2) {
            addCriterion("timer1 not between", value1, value2, "timer1");
            return (Criteria) this;
        }

        public Criteria andTimer2IsNull() {
            addCriterion("timer2 is null");
            return (Criteria) this;
        }

        public Criteria andTimer2IsNotNull() {
            addCriterion("timer2 is not null");
            return (Criteria) this;
        }

        public Criteria andTimer2EqualTo(Integer value) {
            addCriterion("timer2 =", value, "timer2");
            return (Criteria) this;
        }

        public Criteria andTimer2NotEqualTo(Integer value) {
            addCriterion("timer2 <>", value, "timer2");
            return (Criteria) this;
        }

        public Criteria andTimer2GreaterThan(Integer value) {
            addCriterion("timer2 >", value, "timer2");
            return (Criteria) this;
        }

        public Criteria andTimer2GreaterThanOrEqualTo(Integer value) {
            addCriterion("timer2 >=", value, "timer2");
            return (Criteria) this;
        }

        public Criteria andTimer2LessThan(Integer value) {
            addCriterion("timer2 <", value, "timer2");
            return (Criteria) this;
        }

        public Criteria andTimer2LessThanOrEqualTo(Integer value) {
            addCriterion("timer2 <=", value, "timer2");
            return (Criteria) this;
        }

        public Criteria andTimer2In(List<Integer> values) {
            addCriterion("timer2 in", values, "timer2");
            return (Criteria) this;
        }

        public Criteria andTimer2NotIn(List<Integer> values) {
            addCriterion("timer2 not in", values, "timer2");
            return (Criteria) this;
        }

        public Criteria andTimer2Between(Integer value1, Integer value2) {
            addCriterion("timer2 between", value1, value2, "timer2");
            return (Criteria) this;
        }

        public Criteria andTimer2NotBetween(Integer value1, Integer value2) {
            addCriterion("timer2 not between", value1, value2, "timer2");
            return (Criteria) this;
        }

        public Criteria andTimer3IsNull() {
            addCriterion("timer3 is null");
            return (Criteria) this;
        }

        public Criteria andTimer3IsNotNull() {
            addCriterion("timer3 is not null");
            return (Criteria) this;
        }

        public Criteria andTimer3EqualTo(Integer value) {
            addCriterion("timer3 =", value, "timer3");
            return (Criteria) this;
        }

        public Criteria andTimer3NotEqualTo(Integer value) {
            addCriterion("timer3 <>", value, "timer3");
            return (Criteria) this;
        }

        public Criteria andTimer3GreaterThan(Integer value) {
            addCriterion("timer3 >", value, "timer3");
            return (Criteria) this;
        }

        public Criteria andTimer3GreaterThanOrEqualTo(Integer value) {
            addCriterion("timer3 >=", value, "timer3");
            return (Criteria) this;
        }

        public Criteria andTimer3LessThan(Integer value) {
            addCriterion("timer3 <", value, "timer3");
            return (Criteria) this;
        }

        public Criteria andTimer3LessThanOrEqualTo(Integer value) {
            addCriterion("timer3 <=", value, "timer3");
            return (Criteria) this;
        }

        public Criteria andTimer3In(List<Integer> values) {
            addCriterion("timer3 in", values, "timer3");
            return (Criteria) this;
        }

        public Criteria andTimer3NotIn(List<Integer> values) {
            addCriterion("timer3 not in", values, "timer3");
            return (Criteria) this;
        }

        public Criteria andTimer3Between(Integer value1, Integer value2) {
            addCriterion("timer3 between", value1, value2, "timer3");
            return (Criteria) this;
        }

        public Criteria andTimer3NotBetween(Integer value1, Integer value2) {
            addCriterion("timer3 not between", value1, value2, "timer3");
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