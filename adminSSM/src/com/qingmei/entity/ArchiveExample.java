package com.qingmei.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ArchiveExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ArchiveExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andArchiveNoIsNull() {
            addCriterion("archive_no is null");
            return (Criteria) this;
        }

        public Criteria andArchiveNoIsNotNull() {
            addCriterion("archive_no is not null");
            return (Criteria) this;
        }

        public Criteria andArchiveNoEqualTo(String value) {
            addCriterion("archive_no =", value, "archiveNo");
            return (Criteria) this;
        }

        public Criteria andArchiveNoNotEqualTo(String value) {
            addCriterion("archive_no <>", value, "archiveNo");
            return (Criteria) this;
        }

        public Criteria andArchiveNoGreaterThan(String value) {
            addCriterion("archive_no >", value, "archiveNo");
            return (Criteria) this;
        }

        public Criteria andArchiveNoGreaterThanOrEqualTo(String value) {
            addCriterion("archive_no >=", value, "archiveNo");
            return (Criteria) this;
        }

        public Criteria andArchiveNoLessThan(String value) {
            addCriterion("archive_no <", value, "archiveNo");
            return (Criteria) this;
        }

        public Criteria andArchiveNoLessThanOrEqualTo(String value) {
            addCriterion("archive_no <=", value, "archiveNo");
            return (Criteria) this;
        }

        public Criteria andArchiveNoLike(String value) {
            addCriterion("archive_no like", value, "archiveNo");
            return (Criteria) this;
        }

        public Criteria andArchiveNoNotLike(String value) {
            addCriterion("archive_no not like", value, "archiveNo");
            return (Criteria) this;
        }

        public Criteria andArchiveNoIn(List<String> values) {
            addCriterion("archive_no in", values, "archiveNo");
            return (Criteria) this;
        }

        public Criteria andArchiveNoNotIn(List<String> values) {
            addCriterion("archive_no not in", values, "archiveNo");
            return (Criteria) this;
        }

        public Criteria andArchiveNoBetween(String value1, String value2) {
            addCriterion("archive_no between", value1, value2, "archiveNo");
            return (Criteria) this;
        }

        public Criteria andArchiveNoNotBetween(String value1, String value2) {
            addCriterion("archive_no not between", value1, value2, "archiveNo");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andFullNameIsNull() {
            addCriterion("full_name is null");
            return (Criteria) this;
        }

        public Criteria andFullNameIsNotNull() {
            addCriterion("full_name is not null");
            return (Criteria) this;
        }

        public Criteria andFullNameEqualTo(String value) {
            addCriterion("full_name =", value, "fullName");
            return (Criteria) this;
        }

        public Criteria andFullNameNotEqualTo(String value) {
            addCriterion("full_name <>", value, "fullName");
            return (Criteria) this;
        }

        public Criteria andFullNameGreaterThan(String value) {
            addCriterion("full_name >", value, "fullName");
            return (Criteria) this;
        }

        public Criteria andFullNameGreaterThanOrEqualTo(String value) {
            addCriterion("full_name >=", value, "fullName");
            return (Criteria) this;
        }

        public Criteria andFullNameLessThan(String value) {
            addCriterion("full_name <", value, "fullName");
            return (Criteria) this;
        }

        public Criteria andFullNameLessThanOrEqualTo(String value) {
            addCriterion("full_name <=", value, "fullName");
            return (Criteria) this;
        }

        public Criteria andFullNameLike(String value) {
            addCriterion("full_name like", value, "fullName");
            return (Criteria) this;
        }

        public Criteria andFullNameNotLike(String value) {
            addCriterion("full_name not like", value, "fullName");
            return (Criteria) this;
        }

        public Criteria andFullNameIn(List<String> values) {
            addCriterion("full_name in", values, "fullName");
            return (Criteria) this;
        }

        public Criteria andFullNameNotIn(List<String> values) {
            addCriterion("full_name not in", values, "fullName");
            return (Criteria) this;
        }

        public Criteria andFullNameBetween(String value1, String value2) {
            addCriterion("full_name between", value1, value2, "fullName");
            return (Criteria) this;
        }

        public Criteria andFullNameNotBetween(String value1, String value2) {
            addCriterion("full_name not between", value1, value2, "fullName");
            return (Criteria) this;
        }

        public Criteria andPinYinIsNull() {
            addCriterion("pin_yin is null");
            return (Criteria) this;
        }

        public Criteria andPinYinIsNotNull() {
            addCriterion("pin_yin is not null");
            return (Criteria) this;
        }

        public Criteria andPinYinEqualTo(String value) {
            addCriterion("pin_yin =", value, "pinYin");
            return (Criteria) this;
        }

        public Criteria andPinYinNotEqualTo(String value) {
            addCriterion("pin_yin <>", value, "pinYin");
            return (Criteria) this;
        }

        public Criteria andPinYinGreaterThan(String value) {
            addCriterion("pin_yin >", value, "pinYin");
            return (Criteria) this;
        }

        public Criteria andPinYinGreaterThanOrEqualTo(String value) {
            addCriterion("pin_yin >=", value, "pinYin");
            return (Criteria) this;
        }

        public Criteria andPinYinLessThan(String value) {
            addCriterion("pin_yin <", value, "pinYin");
            return (Criteria) this;
        }

        public Criteria andPinYinLessThanOrEqualTo(String value) {
            addCriterion("pin_yin <=", value, "pinYin");
            return (Criteria) this;
        }

        public Criteria andPinYinLike(String value) {
            addCriterion("pin_yin like", value, "pinYin");
            return (Criteria) this;
        }

        public Criteria andPinYinNotLike(String value) {
            addCriterion("pin_yin not like", value, "pinYin");
            return (Criteria) this;
        }

        public Criteria andPinYinIn(List<String> values) {
            addCriterion("pin_yin in", values, "pinYin");
            return (Criteria) this;
        }

        public Criteria andPinYinNotIn(List<String> values) {
            addCriterion("pin_yin not in", values, "pinYin");
            return (Criteria) this;
        }

        public Criteria andPinYinBetween(String value1, String value2) {
            addCriterion("pin_yin between", value1, value2, "pinYin");
            return (Criteria) this;
        }

        public Criteria andPinYinNotBetween(String value1, String value2) {
            addCriterion("pin_yin not between", value1, value2, "pinYin");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(String value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(String value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(String value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(String value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(String value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(String value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLike(String value) {
            addCriterion("sex like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotLike(String value) {
            addCriterion("sex not like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<String> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<String> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(String value1, String value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(String value1, String value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNull() {
            addCriterion("birthday is null");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNotNull() {
            addCriterion("birthday is not null");
            return (Criteria) this;
        }

        public Criteria andBirthdayEqualTo(Date value) {
            addCriterionForJDBCDate("birthday =", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotEqualTo(Date value) {
            addCriterionForJDBCDate("birthday <>", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThan(Date value) {
            addCriterionForJDBCDate("birthday >", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("birthday >=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThan(Date value) {
            addCriterionForJDBCDate("birthday <", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("birthday <=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayIn(List<Date> values) {
            addCriterionForJDBCDate("birthday in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotIn(List<Date> values) {
            addCriterionForJDBCDate("birthday not in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("birthday between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("birthday not between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andNationIsNull() {
            addCriterion("nation is null");
            return (Criteria) this;
        }

        public Criteria andNationIsNotNull() {
            addCriterion("nation is not null");
            return (Criteria) this;
        }

        public Criteria andNationEqualTo(String value) {
            addCriterion("nation =", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotEqualTo(String value) {
            addCriterion("nation <>", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationGreaterThan(String value) {
            addCriterion("nation >", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationGreaterThanOrEqualTo(String value) {
            addCriterion("nation >=", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationLessThan(String value) {
            addCriterion("nation <", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationLessThanOrEqualTo(String value) {
            addCriterion("nation <=", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationLike(String value) {
            addCriterion("nation like", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotLike(String value) {
            addCriterion("nation not like", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationIn(List<String> values) {
            addCriterion("nation in", values, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotIn(List<String> values) {
            addCriterion("nation not in", values, "nation");
            return (Criteria) this;
        }

        public Criteria andNationBetween(String value1, String value2) {
            addCriterion("nation between", value1, value2, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotBetween(String value1, String value2) {
            addCriterion("nation not between", value1, value2, "nation");
            return (Criteria) this;
        }

        public Criteria andNativePlaceIsNull() {
            addCriterion("native_place is null");
            return (Criteria) this;
        }

        public Criteria andNativePlaceIsNotNull() {
            addCriterion("native_place is not null");
            return (Criteria) this;
        }

        public Criteria andNativePlaceEqualTo(String value) {
            addCriterion("native_place =", value, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceNotEqualTo(String value) {
            addCriterion("native_place <>", value, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceGreaterThan(String value) {
            addCriterion("native_place >", value, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceGreaterThanOrEqualTo(String value) {
            addCriterion("native_place >=", value, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceLessThan(String value) {
            addCriterion("native_place <", value, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceLessThanOrEqualTo(String value) {
            addCriterion("native_place <=", value, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceLike(String value) {
            addCriterion("native_place like", value, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceNotLike(String value) {
            addCriterion("native_place not like", value, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceIn(List<String> values) {
            addCriterion("native_place in", values, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceNotIn(List<String> values) {
            addCriterion("native_place not in", values, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceBetween(String value1, String value2) {
            addCriterion("native_place between", value1, value2, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceNotBetween(String value1, String value2) {
            addCriterion("native_place not between", value1, value2, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andCitizenNoIsNull() {
            addCriterion("citizen_no is null");
            return (Criteria) this;
        }

        public Criteria andCitizenNoIsNotNull() {
            addCriterion("citizen_no is not null");
            return (Criteria) this;
        }

        public Criteria andCitizenNoEqualTo(String value) {
            addCriterion("citizen_no =", value, "citizenNo");
            return (Criteria) this;
        }

        public Criteria andCitizenNoNotEqualTo(String value) {
            addCriterion("citizen_no <>", value, "citizenNo");
            return (Criteria) this;
        }

        public Criteria andCitizenNoGreaterThan(String value) {
            addCriterion("citizen_no >", value, "citizenNo");
            return (Criteria) this;
        }

        public Criteria andCitizenNoGreaterThanOrEqualTo(String value) {
            addCriterion("citizen_no >=", value, "citizenNo");
            return (Criteria) this;
        }

        public Criteria andCitizenNoLessThan(String value) {
            addCriterion("citizen_no <", value, "citizenNo");
            return (Criteria) this;
        }

        public Criteria andCitizenNoLessThanOrEqualTo(String value) {
            addCriterion("citizen_no <=", value, "citizenNo");
            return (Criteria) this;
        }

        public Criteria andCitizenNoLike(String value) {
            addCriterion("citizen_no like", value, "citizenNo");
            return (Criteria) this;
        }

        public Criteria andCitizenNoNotLike(String value) {
            addCriterion("citizen_no not like", value, "citizenNo");
            return (Criteria) this;
        }

        public Criteria andCitizenNoIn(List<String> values) {
            addCriterion("citizen_no in", values, "citizenNo");
            return (Criteria) this;
        }

        public Criteria andCitizenNoNotIn(List<String> values) {
            addCriterion("citizen_no not in", values, "citizenNo");
            return (Criteria) this;
        }

        public Criteria andCitizenNoBetween(String value1, String value2) {
            addCriterion("citizen_no between", value1, value2, "citizenNo");
            return (Criteria) this;
        }

        public Criteria andCitizenNoNotBetween(String value1, String value2) {
            addCriterion("citizen_no not between", value1, value2, "citizenNo");
            return (Criteria) this;
        }

        public Criteria andMobileIsNull() {
            addCriterion("mobile is null");
            return (Criteria) this;
        }

        public Criteria andMobileIsNotNull() {
            addCriterion("mobile is not null");
            return (Criteria) this;
        }

        public Criteria andMobileEqualTo(String value) {
            addCriterion("mobile =", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotEqualTo(String value) {
            addCriterion("mobile <>", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThan(String value) {
            addCriterion("mobile >", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThanOrEqualTo(String value) {
            addCriterion("mobile >=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThan(String value) {
            addCriterion("mobile <", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThanOrEqualTo(String value) {
            addCriterion("mobile <=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLike(String value) {
            addCriterion("mobile like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotLike(String value) {
            addCriterion("mobile not like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileIn(List<String> values) {
            addCriterion("mobile in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotIn(List<String> values) {
            addCriterion("mobile not in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileBetween(String value1, String value2) {
            addCriterion("mobile between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotBetween(String value1, String value2) {
            addCriterion("mobile not between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andSiteTreeIsNull() {
            addCriterion("site_tree is null");
            return (Criteria) this;
        }

        public Criteria andSiteTreeIsNotNull() {
            addCriterion("site_tree is not null");
            return (Criteria) this;
        }

        public Criteria andSiteTreeEqualTo(String value) {
            addCriterion("site_tree =", value, "siteTree");
            return (Criteria) this;
        }

        public Criteria andSiteTreeNotEqualTo(String value) {
            addCriterion("site_tree <>", value, "siteTree");
            return (Criteria) this;
        }

        public Criteria andSiteTreeGreaterThan(String value) {
            addCriterion("site_tree >", value, "siteTree");
            return (Criteria) this;
        }

        public Criteria andSiteTreeGreaterThanOrEqualTo(String value) {
            addCriterion("site_tree >=", value, "siteTree");
            return (Criteria) this;
        }

        public Criteria andSiteTreeLessThan(String value) {
            addCriterion("site_tree <", value, "siteTree");
            return (Criteria) this;
        }

        public Criteria andSiteTreeLessThanOrEqualTo(String value) {
            addCriterion("site_tree <=", value, "siteTree");
            return (Criteria) this;
        }

        public Criteria andSiteTreeLike(String value) {
            addCriterion("site_tree like", value, "siteTree");
            return (Criteria) this;
        }

        public Criteria andSiteTreeNotLike(String value) {
            addCriterion("site_tree not like", value, "siteTree");
            return (Criteria) this;
        }

        public Criteria andSiteTreeIn(List<String> values) {
            addCriterion("site_tree in", values, "siteTree");
            return (Criteria) this;
        }

        public Criteria andSiteTreeNotIn(List<String> values) {
            addCriterion("site_tree not in", values, "siteTree");
            return (Criteria) this;
        }

        public Criteria andSiteTreeBetween(String value1, String value2) {
            addCriterion("site_tree between", value1, value2, "siteTree");
            return (Criteria) this;
        }

        public Criteria andSiteTreeNotBetween(String value1, String value2) {
            addCriterion("site_tree not between", value1, value2, "siteTree");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andPostCodeIsNull() {
            addCriterion("post_code is null");
            return (Criteria) this;
        }

        public Criteria andPostCodeIsNotNull() {
            addCriterion("post_code is not null");
            return (Criteria) this;
        }

        public Criteria andPostCodeEqualTo(String value) {
            addCriterion("post_code =", value, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeNotEqualTo(String value) {
            addCriterion("post_code <>", value, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeGreaterThan(String value) {
            addCriterion("post_code >", value, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeGreaterThanOrEqualTo(String value) {
            addCriterion("post_code >=", value, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeLessThan(String value) {
            addCriterion("post_code <", value, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeLessThanOrEqualTo(String value) {
            addCriterion("post_code <=", value, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeLike(String value) {
            addCriterion("post_code like", value, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeNotLike(String value) {
            addCriterion("post_code not like", value, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeIn(List<String> values) {
            addCriterion("post_code in", values, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeNotIn(List<String> values) {
            addCriterion("post_code not in", values, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeBetween(String value1, String value2) {
            addCriterion("post_code between", value1, value2, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeNotBetween(String value1, String value2) {
            addCriterion("post_code not between", value1, value2, "postCode");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andQqIsNull() {
            addCriterion("qq is null");
            return (Criteria) this;
        }

        public Criteria andQqIsNotNull() {
            addCriterion("qq is not null");
            return (Criteria) this;
        }

        public Criteria andQqEqualTo(String value) {
            addCriterion("qq =", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotEqualTo(String value) {
            addCriterion("qq <>", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqGreaterThan(String value) {
            addCriterion("qq >", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqGreaterThanOrEqualTo(String value) {
            addCriterion("qq >=", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqLessThan(String value) {
            addCriterion("qq <", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqLessThanOrEqualTo(String value) {
            addCriterion("qq <=", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqLike(String value) {
            addCriterion("qq like", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotLike(String value) {
            addCriterion("qq not like", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqIn(List<String> values) {
            addCriterion("qq in", values, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotIn(List<String> values) {
            addCriterion("qq not in", values, "qq");
            return (Criteria) this;
        }

        public Criteria andQqBetween(String value1, String value2) {
            addCriterion("qq between", value1, value2, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotBetween(String value1, String value2) {
            addCriterion("qq not between", value1, value2, "qq");
            return (Criteria) this;
        }

        public Criteria andWeixinIsNull() {
            addCriterion("weixin is null");
            return (Criteria) this;
        }

        public Criteria andWeixinIsNotNull() {
            addCriterion("weixin is not null");
            return (Criteria) this;
        }

        public Criteria andWeixinEqualTo(String value) {
            addCriterion("weixin =", value, "weixin");
            return (Criteria) this;
        }

        public Criteria andWeixinNotEqualTo(String value) {
            addCriterion("weixin <>", value, "weixin");
            return (Criteria) this;
        }

        public Criteria andWeixinGreaterThan(String value) {
            addCriterion("weixin >", value, "weixin");
            return (Criteria) this;
        }

        public Criteria andWeixinGreaterThanOrEqualTo(String value) {
            addCriterion("weixin >=", value, "weixin");
            return (Criteria) this;
        }

        public Criteria andWeixinLessThan(String value) {
            addCriterion("weixin <", value, "weixin");
            return (Criteria) this;
        }

        public Criteria andWeixinLessThanOrEqualTo(String value) {
            addCriterion("weixin <=", value, "weixin");
            return (Criteria) this;
        }

        public Criteria andWeixinLike(String value) {
            addCriterion("weixin like", value, "weixin");
            return (Criteria) this;
        }

        public Criteria andWeixinNotLike(String value) {
            addCriterion("weixin not like", value, "weixin");
            return (Criteria) this;
        }

        public Criteria andWeixinIn(List<String> values) {
            addCriterion("weixin in", values, "weixin");
            return (Criteria) this;
        }

        public Criteria andWeixinNotIn(List<String> values) {
            addCriterion("weixin not in", values, "weixin");
            return (Criteria) this;
        }

        public Criteria andWeixinBetween(String value1, String value2) {
            addCriterion("weixin between", value1, value2, "weixin");
            return (Criteria) this;
        }

        public Criteria andWeixinNotBetween(String value1, String value2) {
            addCriterion("weixin not between", value1, value2, "weixin");
            return (Criteria) this;
        }

        public Criteria andEducationIsNull() {
            addCriterion("education is null");
            return (Criteria) this;
        }

        public Criteria andEducationIsNotNull() {
            addCriterion("education is not null");
            return (Criteria) this;
        }

        public Criteria andEducationEqualTo(String value) {
            addCriterion("education =", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationNotEqualTo(String value) {
            addCriterion("education <>", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationGreaterThan(String value) {
            addCriterion("education >", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationGreaterThanOrEqualTo(String value) {
            addCriterion("education >=", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationLessThan(String value) {
            addCriterion("education <", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationLessThanOrEqualTo(String value) {
            addCriterion("education <=", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationLike(String value) {
            addCriterion("education like", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationNotLike(String value) {
            addCriterion("education not like", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationIn(List<String> values) {
            addCriterion("education in", values, "education");
            return (Criteria) this;
        }

        public Criteria andEducationNotIn(List<String> values) {
            addCriterion("education not in", values, "education");
            return (Criteria) this;
        }

        public Criteria andEducationBetween(String value1, String value2) {
            addCriterion("education between", value1, value2, "education");
            return (Criteria) this;
        }

        public Criteria andEducationNotBetween(String value1, String value2) {
            addCriterion("education not between", value1, value2, "education");
            return (Criteria) this;
        }

        public Criteria andMajorIsNull() {
            addCriterion("major is null");
            return (Criteria) this;
        }

        public Criteria andMajorIsNotNull() {
            addCriterion("major is not null");
            return (Criteria) this;
        }

        public Criteria andMajorEqualTo(String value) {
            addCriterion("major =", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorNotEqualTo(String value) {
            addCriterion("major <>", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorGreaterThan(String value) {
            addCriterion("major >", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorGreaterThanOrEqualTo(String value) {
            addCriterion("major >=", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorLessThan(String value) {
            addCriterion("major <", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorLessThanOrEqualTo(String value) {
            addCriterion("major <=", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorLike(String value) {
            addCriterion("major like", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorNotLike(String value) {
            addCriterion("major not like", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorIn(List<String> values) {
            addCriterion("major in", values, "major");
            return (Criteria) this;
        }

        public Criteria andMajorNotIn(List<String> values) {
            addCriterion("major not in", values, "major");
            return (Criteria) this;
        }

        public Criteria andMajorBetween(String value1, String value2) {
            addCriterion("major between", value1, value2, "major");
            return (Criteria) this;
        }

        public Criteria andMajorNotBetween(String value1, String value2) {
            addCriterion("major not between", value1, value2, "major");
            return (Criteria) this;
        }

        public Criteria andSchoolIsNull() {
            addCriterion("school is null");
            return (Criteria) this;
        }

        public Criteria andSchoolIsNotNull() {
            addCriterion("school is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolEqualTo(String value) {
            addCriterion("school =", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolNotEqualTo(String value) {
            addCriterion("school <>", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolGreaterThan(String value) {
            addCriterion("school >", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolGreaterThanOrEqualTo(String value) {
            addCriterion("school >=", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolLessThan(String value) {
            addCriterion("school <", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolLessThanOrEqualTo(String value) {
            addCriterion("school <=", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolLike(String value) {
            addCriterion("school like", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolNotLike(String value) {
            addCriterion("school not like", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolIn(List<String> values) {
            addCriterion("school in", values, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolNotIn(List<String> values) {
            addCriterion("school not in", values, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolBetween(String value1, String value2) {
            addCriterion("school between", value1, value2, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolNotBetween(String value1, String value2) {
            addCriterion("school not between", value1, value2, "school");
            return (Criteria) this;
        }

        public Criteria andGraduateTimeIsNull() {
            addCriterion("graduate_time is null");
            return (Criteria) this;
        }

        public Criteria andGraduateTimeIsNotNull() {
            addCriterion("graduate_time is not null");
            return (Criteria) this;
        }

        public Criteria andGraduateTimeEqualTo(String value) {
            addCriterion("graduate_time =", value, "graduateTime");
            return (Criteria) this;
        }

        public Criteria andGraduateTimeNotEqualTo(String value) {
            addCriterion("graduate_time <>", value, "graduateTime");
            return (Criteria) this;
        }

        public Criteria andGraduateTimeGreaterThan(String value) {
            addCriterion("graduate_time >", value, "graduateTime");
            return (Criteria) this;
        }

        public Criteria andGraduateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("graduate_time >=", value, "graduateTime");
            return (Criteria) this;
        }

        public Criteria andGraduateTimeLessThan(String value) {
            addCriterion("graduate_time <", value, "graduateTime");
            return (Criteria) this;
        }

        public Criteria andGraduateTimeLessThanOrEqualTo(String value) {
            addCriterion("graduate_time <=", value, "graduateTime");
            return (Criteria) this;
        }

        public Criteria andGraduateTimeLike(String value) {
            addCriterion("graduate_time like", value, "graduateTime");
            return (Criteria) this;
        }

        public Criteria andGraduateTimeNotLike(String value) {
            addCriterion("graduate_time not like", value, "graduateTime");
            return (Criteria) this;
        }

        public Criteria andGraduateTimeIn(List<String> values) {
            addCriterion("graduate_time in", values, "graduateTime");
            return (Criteria) this;
        }

        public Criteria andGraduateTimeNotIn(List<String> values) {
            addCriterion("graduate_time not in", values, "graduateTime");
            return (Criteria) this;
        }

        public Criteria andGraduateTimeBetween(String value1, String value2) {
            addCriterion("graduate_time between", value1, value2, "graduateTime");
            return (Criteria) this;
        }

        public Criteria andGraduateTimeNotBetween(String value1, String value2) {
            addCriterion("graduate_time not between", value1, value2, "graduateTime");
            return (Criteria) this;
        }

        public Criteria andCertificateIsNull() {
            addCriterion("certificate is null");
            return (Criteria) this;
        }

        public Criteria andCertificateIsNotNull() {
            addCriterion("certificate is not null");
            return (Criteria) this;
        }

        public Criteria andCertificateEqualTo(String value) {
            addCriterion("certificate =", value, "certificate");
            return (Criteria) this;
        }

        public Criteria andCertificateNotEqualTo(String value) {
            addCriterion("certificate <>", value, "certificate");
            return (Criteria) this;
        }

        public Criteria andCertificateGreaterThan(String value) {
            addCriterion("certificate >", value, "certificate");
            return (Criteria) this;
        }

        public Criteria andCertificateGreaterThanOrEqualTo(String value) {
            addCriterion("certificate >=", value, "certificate");
            return (Criteria) this;
        }

        public Criteria andCertificateLessThan(String value) {
            addCriterion("certificate <", value, "certificate");
            return (Criteria) this;
        }

        public Criteria andCertificateLessThanOrEqualTo(String value) {
            addCriterion("certificate <=", value, "certificate");
            return (Criteria) this;
        }

        public Criteria andCertificateLike(String value) {
            addCriterion("certificate like", value, "certificate");
            return (Criteria) this;
        }

        public Criteria andCertificateNotLike(String value) {
            addCriterion("certificate not like", value, "certificate");
            return (Criteria) this;
        }

        public Criteria andCertificateIn(List<String> values) {
            addCriterion("certificate in", values, "certificate");
            return (Criteria) this;
        }

        public Criteria andCertificateNotIn(List<String> values) {
            addCriterion("certificate not in", values, "certificate");
            return (Criteria) this;
        }

        public Criteria andCertificateBetween(String value1, String value2) {
            addCriterion("certificate between", value1, value2, "certificate");
            return (Criteria) this;
        }

        public Criteria andCertificateNotBetween(String value1, String value2) {
            addCriterion("certificate not between", value1, value2, "certificate");
            return (Criteria) this;
        }

        public Criteria andLiveCity1IsNull() {
            addCriterion("live_city1 is null");
            return (Criteria) this;
        }

        public Criteria andLiveCity1IsNotNull() {
            addCriterion("live_city1 is not null");
            return (Criteria) this;
        }

        public Criteria andLiveCity1EqualTo(Integer value) {
            addCriterion("live_city1 =", value, "liveCity1");
            return (Criteria) this;
        }

        public Criteria andLiveCity1NotEqualTo(Integer value) {
            addCriterion("live_city1 <>", value, "liveCity1");
            return (Criteria) this;
        }

        public Criteria andLiveCity1GreaterThan(Integer value) {
            addCriterion("live_city1 >", value, "liveCity1");
            return (Criteria) this;
        }

        public Criteria andLiveCity1GreaterThanOrEqualTo(Integer value) {
            addCriterion("live_city1 >=", value, "liveCity1");
            return (Criteria) this;
        }

        public Criteria andLiveCity1LessThan(Integer value) {
            addCriterion("live_city1 <", value, "liveCity1");
            return (Criteria) this;
        }

        public Criteria andLiveCity1LessThanOrEqualTo(Integer value) {
            addCriterion("live_city1 <=", value, "liveCity1");
            return (Criteria) this;
        }

        public Criteria andLiveCity1In(List<Integer> values) {
            addCriterion("live_city1 in", values, "liveCity1");
            return (Criteria) this;
        }

        public Criteria andLiveCity1NotIn(List<Integer> values) {
            addCriterion("live_city1 not in", values, "liveCity1");
            return (Criteria) this;
        }

        public Criteria andLiveCity1Between(Integer value1, Integer value2) {
            addCriterion("live_city1 between", value1, value2, "liveCity1");
            return (Criteria) this;
        }

        public Criteria andLiveCity1NotBetween(Integer value1, Integer value2) {
            addCriterion("live_city1 not between", value1, value2, "liveCity1");
            return (Criteria) this;
        }

        public Criteria andLiveCity2IsNull() {
            addCriterion("live_city2 is null");
            return (Criteria) this;
        }

        public Criteria andLiveCity2IsNotNull() {
            addCriterion("live_city2 is not null");
            return (Criteria) this;
        }

        public Criteria andLiveCity2EqualTo(Integer value) {
            addCriterion("live_city2 =", value, "liveCity2");
            return (Criteria) this;
        }

        public Criteria andLiveCity2NotEqualTo(Integer value) {
            addCriterion("live_city2 <>", value, "liveCity2");
            return (Criteria) this;
        }

        public Criteria andLiveCity2GreaterThan(Integer value) {
            addCriterion("live_city2 >", value, "liveCity2");
            return (Criteria) this;
        }

        public Criteria andLiveCity2GreaterThanOrEqualTo(Integer value) {
            addCriterion("live_city2 >=", value, "liveCity2");
            return (Criteria) this;
        }

        public Criteria andLiveCity2LessThan(Integer value) {
            addCriterion("live_city2 <", value, "liveCity2");
            return (Criteria) this;
        }

        public Criteria andLiveCity2LessThanOrEqualTo(Integer value) {
            addCriterion("live_city2 <=", value, "liveCity2");
            return (Criteria) this;
        }

        public Criteria andLiveCity2In(List<Integer> values) {
            addCriterion("live_city2 in", values, "liveCity2");
            return (Criteria) this;
        }

        public Criteria andLiveCity2NotIn(List<Integer> values) {
            addCriterion("live_city2 not in", values, "liveCity2");
            return (Criteria) this;
        }

        public Criteria andLiveCity2Between(Integer value1, Integer value2) {
            addCriterion("live_city2 between", value1, value2, "liveCity2");
            return (Criteria) this;
        }

        public Criteria andLiveCity2NotBetween(Integer value1, Integer value2) {
            addCriterion("live_city2 not between", value1, value2, "liveCity2");
            return (Criteria) this;
        }

        public Criteria andLiveCity3IsNull() {
            addCriterion("live_city3 is null");
            return (Criteria) this;
        }

        public Criteria andLiveCity3IsNotNull() {
            addCriterion("live_city3 is not null");
            return (Criteria) this;
        }

        public Criteria andLiveCity3EqualTo(Integer value) {
            addCriterion("live_city3 =", value, "liveCity3");
            return (Criteria) this;
        }

        public Criteria andLiveCity3NotEqualTo(Integer value) {
            addCriterion("live_city3 <>", value, "liveCity3");
            return (Criteria) this;
        }

        public Criteria andLiveCity3GreaterThan(Integer value) {
            addCriterion("live_city3 >", value, "liveCity3");
            return (Criteria) this;
        }

        public Criteria andLiveCity3GreaterThanOrEqualTo(Integer value) {
            addCriterion("live_city3 >=", value, "liveCity3");
            return (Criteria) this;
        }

        public Criteria andLiveCity3LessThan(Integer value) {
            addCriterion("live_city3 <", value, "liveCity3");
            return (Criteria) this;
        }

        public Criteria andLiveCity3LessThanOrEqualTo(Integer value) {
            addCriterion("live_city3 <=", value, "liveCity3");
            return (Criteria) this;
        }

        public Criteria andLiveCity3In(List<Integer> values) {
            addCriterion("live_city3 in", values, "liveCity3");
            return (Criteria) this;
        }

        public Criteria andLiveCity3NotIn(List<Integer> values) {
            addCriterion("live_city3 not in", values, "liveCity3");
            return (Criteria) this;
        }

        public Criteria andLiveCity3Between(Integer value1, Integer value2) {
            addCriterion("live_city3 between", value1, value2, "liveCity3");
            return (Criteria) this;
        }

        public Criteria andLiveCity3NotBetween(Integer value1, Integer value2) {
            addCriterion("live_city3 not between", value1, value2, "liveCity3");
            return (Criteria) this;
        }

        public Criteria andPhotoUrlIsNull() {
            addCriterion("photo_url is null");
            return (Criteria) this;
        }

        public Criteria andPhotoUrlIsNotNull() {
            addCriterion("photo_url is not null");
            return (Criteria) this;
        }

        public Criteria andPhotoUrlEqualTo(String value) {
            addCriterion("photo_url =", value, "photoUrl");
            return (Criteria) this;
        }

        public Criteria andPhotoUrlNotEqualTo(String value) {
            addCriterion("photo_url <>", value, "photoUrl");
            return (Criteria) this;
        }

        public Criteria andPhotoUrlGreaterThan(String value) {
            addCriterion("photo_url >", value, "photoUrl");
            return (Criteria) this;
        }

        public Criteria andPhotoUrlGreaterThanOrEqualTo(String value) {
            addCriterion("photo_url >=", value, "photoUrl");
            return (Criteria) this;
        }

        public Criteria andPhotoUrlLessThan(String value) {
            addCriterion("photo_url <", value, "photoUrl");
            return (Criteria) this;
        }

        public Criteria andPhotoUrlLessThanOrEqualTo(String value) {
            addCriterion("photo_url <=", value, "photoUrl");
            return (Criteria) this;
        }

        public Criteria andPhotoUrlLike(String value) {
            addCriterion("photo_url like", value, "photoUrl");
            return (Criteria) this;
        }

        public Criteria andPhotoUrlNotLike(String value) {
            addCriterion("photo_url not like", value, "photoUrl");
            return (Criteria) this;
        }

        public Criteria andPhotoUrlIn(List<String> values) {
            addCriterion("photo_url in", values, "photoUrl");
            return (Criteria) this;
        }

        public Criteria andPhotoUrlNotIn(List<String> values) {
            addCriterion("photo_url not in", values, "photoUrl");
            return (Criteria) this;
        }

        public Criteria andPhotoUrlBetween(String value1, String value2) {
            addCriterion("photo_url between", value1, value2, "photoUrl");
            return (Criteria) this;
        }

        public Criteria andPhotoUrlNotBetween(String value1, String value2) {
            addCriterion("photo_url not between", value1, value2, "photoUrl");
            return (Criteria) this;
        }

        public Criteria andCitizenPhotoUrlIsNull() {
            addCriterion("citizen_photo_url is null");
            return (Criteria) this;
        }

        public Criteria andCitizenPhotoUrlIsNotNull() {
            addCriterion("citizen_photo_url is not null");
            return (Criteria) this;
        }

        public Criteria andCitizenPhotoUrlEqualTo(String value) {
            addCriterion("citizen_photo_url =", value, "citizenPhotoUrl");
            return (Criteria) this;
        }

        public Criteria andCitizenPhotoUrlNotEqualTo(String value) {
            addCriterion("citizen_photo_url <>", value, "citizenPhotoUrl");
            return (Criteria) this;
        }

        public Criteria andCitizenPhotoUrlGreaterThan(String value) {
            addCriterion("citizen_photo_url >", value, "citizenPhotoUrl");
            return (Criteria) this;
        }

        public Criteria andCitizenPhotoUrlGreaterThanOrEqualTo(String value) {
            addCriterion("citizen_photo_url >=", value, "citizenPhotoUrl");
            return (Criteria) this;
        }

        public Criteria andCitizenPhotoUrlLessThan(String value) {
            addCriterion("citizen_photo_url <", value, "citizenPhotoUrl");
            return (Criteria) this;
        }

        public Criteria andCitizenPhotoUrlLessThanOrEqualTo(String value) {
            addCriterion("citizen_photo_url <=", value, "citizenPhotoUrl");
            return (Criteria) this;
        }

        public Criteria andCitizenPhotoUrlLike(String value) {
            addCriterion("citizen_photo_url like", value, "citizenPhotoUrl");
            return (Criteria) this;
        }

        public Criteria andCitizenPhotoUrlNotLike(String value) {
            addCriterion("citizen_photo_url not like", value, "citizenPhotoUrl");
            return (Criteria) this;
        }

        public Criteria andCitizenPhotoUrlIn(List<String> values) {
            addCriterion("citizen_photo_url in", values, "citizenPhotoUrl");
            return (Criteria) this;
        }

        public Criteria andCitizenPhotoUrlNotIn(List<String> values) {
            addCriterion("citizen_photo_url not in", values, "citizenPhotoUrl");
            return (Criteria) this;
        }

        public Criteria andCitizenPhotoUrlBetween(String value1, String value2) {
            addCriterion("citizen_photo_url between", value1, value2, "citizenPhotoUrl");
            return (Criteria) this;
        }

        public Criteria andCitizenPhotoUrlNotBetween(String value1, String value2) {
            addCriterion("citizen_photo_url not between", value1, value2, "citizenPhotoUrl");
            return (Criteria) this;
        }

        public Criteria andEducationPhotoUrlIsNull() {
            addCriterion("education_photo_url is null");
            return (Criteria) this;
        }

        public Criteria andEducationPhotoUrlIsNotNull() {
            addCriterion("education_photo_url is not null");
            return (Criteria) this;
        }

        public Criteria andEducationPhotoUrlEqualTo(String value) {
            addCriterion("education_photo_url =", value, "educationPhotoUrl");
            return (Criteria) this;
        }

        public Criteria andEducationPhotoUrlNotEqualTo(String value) {
            addCriterion("education_photo_url <>", value, "educationPhotoUrl");
            return (Criteria) this;
        }

        public Criteria andEducationPhotoUrlGreaterThan(String value) {
            addCriterion("education_photo_url >", value, "educationPhotoUrl");
            return (Criteria) this;
        }

        public Criteria andEducationPhotoUrlGreaterThanOrEqualTo(String value) {
            addCriterion("education_photo_url >=", value, "educationPhotoUrl");
            return (Criteria) this;
        }

        public Criteria andEducationPhotoUrlLessThan(String value) {
            addCriterion("education_photo_url <", value, "educationPhotoUrl");
            return (Criteria) this;
        }

        public Criteria andEducationPhotoUrlLessThanOrEqualTo(String value) {
            addCriterion("education_photo_url <=", value, "educationPhotoUrl");
            return (Criteria) this;
        }

        public Criteria andEducationPhotoUrlLike(String value) {
            addCriterion("education_photo_url like", value, "educationPhotoUrl");
            return (Criteria) this;
        }

        public Criteria andEducationPhotoUrlNotLike(String value) {
            addCriterion("education_photo_url not like", value, "educationPhotoUrl");
            return (Criteria) this;
        }

        public Criteria andEducationPhotoUrlIn(List<String> values) {
            addCriterion("education_photo_url in", values, "educationPhotoUrl");
            return (Criteria) this;
        }

        public Criteria andEducationPhotoUrlNotIn(List<String> values) {
            addCriterion("education_photo_url not in", values, "educationPhotoUrl");
            return (Criteria) this;
        }

        public Criteria andEducationPhotoUrlBetween(String value1, String value2) {
            addCriterion("education_photo_url between", value1, value2, "educationPhotoUrl");
            return (Criteria) this;
        }

        public Criteria andEducationPhotoUrlNotBetween(String value1, String value2) {
            addCriterion("education_photo_url not between", value1, value2, "educationPhotoUrl");
            return (Criteria) this;
        }

        public Criteria andNoteIsNull() {
            addCriterion("note is null");
            return (Criteria) this;
        }

        public Criteria andNoteIsNotNull() {
            addCriterion("note is not null");
            return (Criteria) this;
        }

        public Criteria andNoteEqualTo(String value) {
            addCriterion("note =", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotEqualTo(String value) {
            addCriterion("note <>", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThan(String value) {
            addCriterion("note >", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThanOrEqualTo(String value) {
            addCriterion("note >=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThan(String value) {
            addCriterion("note <", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThanOrEqualTo(String value) {
            addCriterion("note <=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLike(String value) {
            addCriterion("note like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotLike(String value) {
            addCriterion("note not like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteIn(List<String> values) {
            addCriterion("note in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotIn(List<String> values) {
            addCriterion("note not in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteBetween(String value1, String value2) {
            addCriterion("note between", value1, value2, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotBetween(String value1, String value2) {
            addCriterion("note not between", value1, value2, "note");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }

        public Criteria andArchiveNoLikeInsensitive(String value) {
            addCriterion("upper(archive_no) like", value.toUpperCase(), "archiveNo");
            return this;
        }

        public Criteria andStatusLikeInsensitive(String value) {
            addCriterion("upper(status) like", value.toUpperCase(), "status");
            return this;
        }

        public Criteria andFullNameLikeInsensitive(String value) {
            addCriterion("upper(full_name) like", value.toUpperCase(), "fullName");
            return this;
        }

        public Criteria andPinYinLikeInsensitive(String value) {
            addCriterion("upper(pin_yin) like", value.toUpperCase(), "pinYin");
            return this;
        }

        public Criteria andSexLikeInsensitive(String value) {
            addCriterion("upper(sex) like", value.toUpperCase(), "sex");
            return this;
        }

        public Criteria andNationLikeInsensitive(String value) {
            addCriterion("upper(nation) like", value.toUpperCase(), "nation");
            return this;
        }

        public Criteria andNativePlaceLikeInsensitive(String value) {
            addCriterion("upper(native_place) like", value.toUpperCase(), "nativePlace");
            return this;
        }

        public Criteria andCitizenNoLikeInsensitive(String value) {
            addCriterion("upper(citizen_no) like", value.toUpperCase(), "citizenNo");
            return this;
        }

        public Criteria andMobileLikeInsensitive(String value) {
            addCriterion("upper(mobile) like", value.toUpperCase(), "mobile");
            return this;
        }

        public Criteria andSiteTreeLikeInsensitive(String value) {
            addCriterion("upper(site_tree) like", value.toUpperCase(), "siteTree");
            return this;
        }

        public Criteria andAddressLikeInsensitive(String value) {
            addCriterion("upper(address) like", value.toUpperCase(), "address");
            return this;
        }

        public Criteria andPostCodeLikeInsensitive(String value) {
            addCriterion("upper(post_code) like", value.toUpperCase(), "postCode");
            return this;
        }

        public Criteria andEmailLikeInsensitive(String value) {
            addCriterion("upper(email) like", value.toUpperCase(), "email");
            return this;
        }

        public Criteria andQqLikeInsensitive(String value) {
            addCriterion("upper(qq) like", value.toUpperCase(), "qq");
            return this;
        }

        public Criteria andWeixinLikeInsensitive(String value) {
            addCriterion("upper(weixin) like", value.toUpperCase(), "weixin");
            return this;
        }

        public Criteria andEducationLikeInsensitive(String value) {
            addCriterion("upper(education) like", value.toUpperCase(), "education");
            return this;
        }

        public Criteria andMajorLikeInsensitive(String value) {
            addCriterion("upper(major) like", value.toUpperCase(), "major");
            return this;
        }

        public Criteria andSchoolLikeInsensitive(String value) {
            addCriterion("upper(school) like", value.toUpperCase(), "school");
            return this;
        }

        public Criteria andGraduateTimeLikeInsensitive(String value) {
            addCriterion("upper(graduate_time) like", value.toUpperCase(), "graduateTime");
            return this;
        }

        public Criteria andCertificateLikeInsensitive(String value) {
            addCriterion("upper(certificate) like", value.toUpperCase(), "certificate");
            return this;
        }

        public Criteria andPhotoUrlLikeInsensitive(String value) {
            addCriterion("upper(photo_url) like", value.toUpperCase(), "photoUrl");
            return this;
        }

        public Criteria andCitizenPhotoUrlLikeInsensitive(String value) {
            addCriterion("upper(citizen_photo_url) like", value.toUpperCase(), "citizenPhotoUrl");
            return this;
        }

        public Criteria andEducationPhotoUrlLikeInsensitive(String value) {
            addCriterion("upper(education_photo_url) like", value.toUpperCase(), "educationPhotoUrl");
            return this;
        }

        public Criteria andNoteLikeInsensitive(String value) {
            addCriterion("upper(note) like", value.toUpperCase(), "note");
            return this;
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