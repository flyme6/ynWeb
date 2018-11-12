package com.yn.entity;

import java.util.ArrayList;
import java.util.List;

public class ComExample extends Base{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ComExample() {
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

        public Criteria andPortNumberIsNull() {
            addCriterion("port_number is null");
            return (Criteria) this;
        }

        public Criteria andPortNumberIsNotNull() {
            addCriterion("port_number is not null");
            return (Criteria) this;
        }

        public Criteria andPortNumberEqualTo(Integer value) {
            addCriterion("port_number =", value, "portNumber");
            return (Criteria) this;
        }

        public Criteria andPortNumberNotEqualTo(Integer value) {
            addCriterion("port_number <>", value, "portNumber");
            return (Criteria) this;
        }

        public Criteria andPortNumberGreaterThan(Integer value) {
            addCriterion("port_number >", value, "portNumber");
            return (Criteria) this;
        }

        public Criteria andPortNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("port_number >=", value, "portNumber");
            return (Criteria) this;
        }

        public Criteria andPortNumberLessThan(Integer value) {
            addCriterion("port_number <", value, "portNumber");
            return (Criteria) this;
        }

        public Criteria andPortNumberLessThanOrEqualTo(Integer value) {
            addCriterion("port_number <=", value, "portNumber");
            return (Criteria) this;
        }

        public Criteria andPortNumberIn(List<Integer> values) {
            addCriterion("port_number in", values, "portNumber");
            return (Criteria) this;
        }

        public Criteria andPortNumberNotIn(List<Integer> values) {
            addCriterion("port_number not in", values, "portNumber");
            return (Criteria) this;
        }

        public Criteria andPortNumberBetween(Integer value1, Integer value2) {
            addCriterion("port_number between", value1, value2, "portNumber");
            return (Criteria) this;
        }

        public Criteria andPortNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("port_number not between", value1, value2, "portNumber");
            return (Criteria) this;
        }

        public Criteria andSendDelayIsNull() {
            addCriterion("send_delay is null");
            return (Criteria) this;
        }

        public Criteria andSendDelayIsNotNull() {
            addCriterion("send_delay is not null");
            return (Criteria) this;
        }

        public Criteria andSendDelayEqualTo(Integer value) {
            addCriterion("send_delay =", value, "sendDelay");
            return (Criteria) this;
        }

        public Criteria andSendDelayNotEqualTo(Integer value) {
            addCriterion("send_delay <>", value, "sendDelay");
            return (Criteria) this;
        }

        public Criteria andSendDelayGreaterThan(Integer value) {
            addCriterion("send_delay >", value, "sendDelay");
            return (Criteria) this;
        }

        public Criteria andSendDelayGreaterThanOrEqualTo(Integer value) {
            addCriterion("send_delay >=", value, "sendDelay");
            return (Criteria) this;
        }

        public Criteria andSendDelayLessThan(Integer value) {
            addCriterion("send_delay <", value, "sendDelay");
            return (Criteria) this;
        }

        public Criteria andSendDelayLessThanOrEqualTo(Integer value) {
            addCriterion("send_delay <=", value, "sendDelay");
            return (Criteria) this;
        }

        public Criteria andSendDelayIn(List<Integer> values) {
            addCriterion("send_delay in", values, "sendDelay");
            return (Criteria) this;
        }

        public Criteria andSendDelayNotIn(List<Integer> values) {
            addCriterion("send_delay not in", values, "sendDelay");
            return (Criteria) this;
        }

        public Criteria andSendDelayBetween(Integer value1, Integer value2) {
            addCriterion("send_delay between", value1, value2, "sendDelay");
            return (Criteria) this;
        }

        public Criteria andSendDelayNotBetween(Integer value1, Integer value2) {
            addCriterion("send_delay not between", value1, value2, "sendDelay");
            return (Criteria) this;
        }

        public Criteria andRecvTimeoutIsNull() {
            addCriterion("recv_timeout is null");
            return (Criteria) this;
        }

        public Criteria andRecvTimeoutIsNotNull() {
            addCriterion("recv_timeout is not null");
            return (Criteria) this;
        }

        public Criteria andRecvTimeoutEqualTo(Integer value) {
            addCriterion("recv_timeout =", value, "recvTimeout");
            return (Criteria) this;
        }

        public Criteria andRecvTimeoutNotEqualTo(Integer value) {
            addCriterion("recv_timeout <>", value, "recvTimeout");
            return (Criteria) this;
        }

        public Criteria andRecvTimeoutGreaterThan(Integer value) {
            addCriterion("recv_timeout >", value, "recvTimeout");
            return (Criteria) this;
        }

        public Criteria andRecvTimeoutGreaterThanOrEqualTo(Integer value) {
            addCriterion("recv_timeout >=", value, "recvTimeout");
            return (Criteria) this;
        }

        public Criteria andRecvTimeoutLessThan(Integer value) {
            addCriterion("recv_timeout <", value, "recvTimeout");
            return (Criteria) this;
        }

        public Criteria andRecvTimeoutLessThanOrEqualTo(Integer value) {
            addCriterion("recv_timeout <=", value, "recvTimeout");
            return (Criteria) this;
        }

        public Criteria andRecvTimeoutIn(List<Integer> values) {
            addCriterion("recv_timeout in", values, "recvTimeout");
            return (Criteria) this;
        }

        public Criteria andRecvTimeoutNotIn(List<Integer> values) {
            addCriterion("recv_timeout not in", values, "recvTimeout");
            return (Criteria) this;
        }

        public Criteria andRecvTimeoutBetween(Integer value1, Integer value2) {
            addCriterion("recv_timeout between", value1, value2, "recvTimeout");
            return (Criteria) this;
        }

        public Criteria andRecvTimeoutNotBetween(Integer value1, Integer value2) {
            addCriterion("recv_timeout not between", value1, value2, "recvTimeout");
            return (Criteria) this;
        }

        public Criteria andBaudRateIsNull() {
            addCriterion("baud_rate is null");
            return (Criteria) this;
        }

        public Criteria andBaudRateIsNotNull() {
            addCriterion("baud_rate is not null");
            return (Criteria) this;
        }

        public Criteria andBaudRateEqualTo(Integer value) {
            addCriterion("baud_rate =", value, "baudRate");
            return (Criteria) this;
        }

        public Criteria andBaudRateNotEqualTo(Integer value) {
            addCriterion("baud_rate <>", value, "baudRate");
            return (Criteria) this;
        }

        public Criteria andBaudRateGreaterThan(Integer value) {
            addCriterion("baud_rate >", value, "baudRate");
            return (Criteria) this;
        }

        public Criteria andBaudRateGreaterThanOrEqualTo(Integer value) {
            addCriterion("baud_rate >=", value, "baudRate");
            return (Criteria) this;
        }

        public Criteria andBaudRateLessThan(Integer value) {
            addCriterion("baud_rate <", value, "baudRate");
            return (Criteria) this;
        }

        public Criteria andBaudRateLessThanOrEqualTo(Integer value) {
            addCriterion("baud_rate <=", value, "baudRate");
            return (Criteria) this;
        }

        public Criteria andBaudRateIn(List<Integer> values) {
            addCriterion("baud_rate in", values, "baudRate");
            return (Criteria) this;
        }

        public Criteria andBaudRateNotIn(List<Integer> values) {
            addCriterion("baud_rate not in", values, "baudRate");
            return (Criteria) this;
        }

        public Criteria andBaudRateBetween(Integer value1, Integer value2) {
            addCriterion("baud_rate between", value1, value2, "baudRate");
            return (Criteria) this;
        }

        public Criteria andBaudRateNotBetween(Integer value1, Integer value2) {
            addCriterion("baud_rate not between", value1, value2, "baudRate");
            return (Criteria) this;
        }

        public Criteria andParityIsNull() {
            addCriterion("parity is null");
            return (Criteria) this;
        }

        public Criteria andParityIsNotNull() {
            addCriterion("parity is not null");
            return (Criteria) this;
        }

        public Criteria andParityEqualTo(String value) {
            addCriterion("parity =", value, "parity");
            return (Criteria) this;
        }

        public Criteria andParityNotEqualTo(String value) {
            addCriterion("parity <>", value, "parity");
            return (Criteria) this;
        }

        public Criteria andParityGreaterThan(String value) {
            addCriterion("parity >", value, "parity");
            return (Criteria) this;
        }

        public Criteria andParityGreaterThanOrEqualTo(String value) {
            addCriterion("parity >=", value, "parity");
            return (Criteria) this;
        }

        public Criteria andParityLessThan(String value) {
            addCriterion("parity <", value, "parity");
            return (Criteria) this;
        }

        public Criteria andParityLessThanOrEqualTo(String value) {
            addCriterion("parity <=", value, "parity");
            return (Criteria) this;
        }

        public Criteria andParityLike(String value) {
            addCriterion("parity like", value, "parity");
            return (Criteria) this;
        }

        public Criteria andParityNotLike(String value) {
            addCriterion("parity not like", value, "parity");
            return (Criteria) this;
        }

        public Criteria andParityIn(List<String> values) {
            addCriterion("parity in", values, "parity");
            return (Criteria) this;
        }

        public Criteria andParityNotIn(List<String> values) {
            addCriterion("parity not in", values, "parity");
            return (Criteria) this;
        }

        public Criteria andParityBetween(String value1, String value2) {
            addCriterion("parity between", value1, value2, "parity");
            return (Criteria) this;
        }

        public Criteria andParityNotBetween(String value1, String value2) {
            addCriterion("parity not between", value1, value2, "parity");
            return (Criteria) this;
        }

        public Criteria andDataBitsIsNull() {
            addCriterion("data_bits is null");
            return (Criteria) this;
        }

        public Criteria andDataBitsIsNotNull() {
            addCriterion("data_bits is not null");
            return (Criteria) this;
        }

        public Criteria andDataBitsEqualTo(Integer value) {
            addCriterion("data_bits =", value, "dataBits");
            return (Criteria) this;
        }

        public Criteria andDataBitsNotEqualTo(Integer value) {
            addCriterion("data_bits <>", value, "dataBits");
            return (Criteria) this;
        }

        public Criteria andDataBitsGreaterThan(Integer value) {
            addCriterion("data_bits >", value, "dataBits");
            return (Criteria) this;
        }

        public Criteria andDataBitsGreaterThanOrEqualTo(Integer value) {
            addCriterion("data_bits >=", value, "dataBits");
            return (Criteria) this;
        }

        public Criteria andDataBitsLessThan(Integer value) {
            addCriterion("data_bits <", value, "dataBits");
            return (Criteria) this;
        }

        public Criteria andDataBitsLessThanOrEqualTo(Integer value) {
            addCriterion("data_bits <=", value, "dataBits");
            return (Criteria) this;
        }

        public Criteria andDataBitsIn(List<Integer> values) {
            addCriterion("data_bits in", values, "dataBits");
            return (Criteria) this;
        }

        public Criteria andDataBitsNotIn(List<Integer> values) {
            addCriterion("data_bits not in", values, "dataBits");
            return (Criteria) this;
        }

        public Criteria andDataBitsBetween(Integer value1, Integer value2) {
            addCriterion("data_bits between", value1, value2, "dataBits");
            return (Criteria) this;
        }

        public Criteria andDataBitsNotBetween(Integer value1, Integer value2) {
            addCriterion("data_bits not between", value1, value2, "dataBits");
            return (Criteria) this;
        }

        public Criteria andStopBitsIsNull() {
            addCriterion("stop_bits is null");
            return (Criteria) this;
        }

        public Criteria andStopBitsIsNotNull() {
            addCriterion("stop_bits is not null");
            return (Criteria) this;
        }

        public Criteria andStopBitsEqualTo(Double value) {
            addCriterion("stop_bits =", value, "stopBits");
            return (Criteria) this;
        }

        public Criteria andStopBitsNotEqualTo(Double value) {
            addCriterion("stop_bits <>", value, "stopBits");
            return (Criteria) this;
        }

        public Criteria andStopBitsGreaterThan(Double value) {
            addCriterion("stop_bits >", value, "stopBits");
            return (Criteria) this;
        }

        public Criteria andStopBitsGreaterThanOrEqualTo(Double value) {
            addCriterion("stop_bits >=", value, "stopBits");
            return (Criteria) this;
        }

        public Criteria andStopBitsLessThan(Double value) {
            addCriterion("stop_bits <", value, "stopBits");
            return (Criteria) this;
        }

        public Criteria andStopBitsLessThanOrEqualTo(Double value) {
            addCriterion("stop_bits <=", value, "stopBits");
            return (Criteria) this;
        }

        public Criteria andStopBitsIn(List<Double> values) {
            addCriterion("stop_bits in", values, "stopBits");
            return (Criteria) this;
        }

        public Criteria andStopBitsNotIn(List<Double> values) {
            addCriterion("stop_bits not in", values, "stopBits");
            return (Criteria) this;
        }

        public Criteria andStopBitsBetween(Double value1, Double value2) {
            addCriterion("stop_bits between", value1, value2, "stopBits");
            return (Criteria) this;
        }

        public Criteria andStopBitsNotBetween(Double value1, Double value2) {
            addCriterion("stop_bits not between", value1, value2, "stopBits");
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