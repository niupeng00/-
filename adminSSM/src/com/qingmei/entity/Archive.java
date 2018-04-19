package com.qingmei.entity;

import java.io.Serializable;
import java.util.Date;

public class Archive implements Serializable {
    private Integer id;

    private String archiveNo;

    private String status;

    private String fullName;

    private String pinYin;

    private String sex;

    private Date birthday;

    private String nation;

    private String nativePlace;

    private String citizenNo;

    private String mobile;

    private String siteTree;

    private String address;

    private String postCode;

    private String email;

    private String qq;

    private String weixin;

    private String education;

    private String major;

    private String school;

    private String graduateTime;

    private String certificate;

    private Integer liveCity1;

    private Integer liveCity2;

    private Integer liveCity3;

    private String photoUrl;

    private String citizenPhotoUrl;

    private String educationPhotoUrl;

    private String note;

    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getArchiveNo() {
        return archiveNo;
    }

    public void setArchiveNo(String archiveNo) {
        this.archiveNo = archiveNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPinYin() {
        return pinYin;
    }

    public void setPinYin(String pinYin) {
        this.pinYin = pinYin;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public String getCitizenNo() {
        return citizenNo;
    }

    public void setCitizenNo(String citizenNo) {
        this.citizenNo = citizenNo;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getSiteTree() {
        return siteTree;
    }

    public void setSiteTree(String siteTree) {
        this.siteTree = siteTree;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getWeixin() {
        return weixin;
    }

    public void setWeixin(String weixin) {
        this.weixin = weixin;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getGraduateTime() {
        return graduateTime;
    }

    public void setGraduateTime(String graduateTime) {
        this.graduateTime = graduateTime;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public Integer getLiveCity1() {
        return liveCity1;
    }

    public void setLiveCity1(Integer liveCity1) {
        this.liveCity1 = liveCity1;
    }

    public Integer getLiveCity2() {
        return liveCity2;
    }

    public void setLiveCity2(Integer liveCity2) {
        this.liveCity2 = liveCity2;
    }

    public Integer getLiveCity3() {
        return liveCity3;
    }

    public void setLiveCity3(Integer liveCity3) {
        this.liveCity3 = liveCity3;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getCitizenPhotoUrl() {
        return citizenPhotoUrl;
    }

    public void setCitizenPhotoUrl(String citizenPhotoUrl) {
        this.citizenPhotoUrl = citizenPhotoUrl;
    }

    public String getEducationPhotoUrl() {
        return educationPhotoUrl;
    }

    public void setEducationPhotoUrl(String educationPhotoUrl) {
        this.educationPhotoUrl = educationPhotoUrl;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Archive other = (Archive) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getArchiveNo() == null ? other.getArchiveNo() == null : this.getArchiveNo().equals(other.getArchiveNo()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getFullName() == null ? other.getFullName() == null : this.getFullName().equals(other.getFullName()))
            && (this.getPinYin() == null ? other.getPinYin() == null : this.getPinYin().equals(other.getPinYin()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getBirthday() == null ? other.getBirthday() == null : this.getBirthday().equals(other.getBirthday()))
            && (this.getNation() == null ? other.getNation() == null : this.getNation().equals(other.getNation()))
            && (this.getNativePlace() == null ? other.getNativePlace() == null : this.getNativePlace().equals(other.getNativePlace()))
            && (this.getCitizenNo() == null ? other.getCitizenNo() == null : this.getCitizenNo().equals(other.getCitizenNo()))
            && (this.getMobile() == null ? other.getMobile() == null : this.getMobile().equals(other.getMobile()))
            && (this.getSiteTree() == null ? other.getSiteTree() == null : this.getSiteTree().equals(other.getSiteTree()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getPostCode() == null ? other.getPostCode() == null : this.getPostCode().equals(other.getPostCode()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getQq() == null ? other.getQq() == null : this.getQq().equals(other.getQq()))
            && (this.getWeixin() == null ? other.getWeixin() == null : this.getWeixin().equals(other.getWeixin()))
            && (this.getEducation() == null ? other.getEducation() == null : this.getEducation().equals(other.getEducation()))
            && (this.getMajor() == null ? other.getMajor() == null : this.getMajor().equals(other.getMajor()))
            && (this.getSchool() == null ? other.getSchool() == null : this.getSchool().equals(other.getSchool()))
            && (this.getGraduateTime() == null ? other.getGraduateTime() == null : this.getGraduateTime().equals(other.getGraduateTime()))
            && (this.getCertificate() == null ? other.getCertificate() == null : this.getCertificate().equals(other.getCertificate()))
            && (this.getLiveCity1() == null ? other.getLiveCity1() == null : this.getLiveCity1().equals(other.getLiveCity1()))
            && (this.getLiveCity2() == null ? other.getLiveCity2() == null : this.getLiveCity2().equals(other.getLiveCity2()))
            && (this.getLiveCity3() == null ? other.getLiveCity3() == null : this.getLiveCity3().equals(other.getLiveCity3()))
            && (this.getPhotoUrl() == null ? other.getPhotoUrl() == null : this.getPhotoUrl().equals(other.getPhotoUrl()))
            && (this.getCitizenPhotoUrl() == null ? other.getCitizenPhotoUrl() == null : this.getCitizenPhotoUrl().equals(other.getCitizenPhotoUrl()))
            && (this.getEducationPhotoUrl() == null ? other.getEducationPhotoUrl() == null : this.getEducationPhotoUrl().equals(other.getEducationPhotoUrl()))
            && (this.getNote() == null ? other.getNote() == null : this.getNote().equals(other.getNote()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getArchiveNo() == null) ? 0 : getArchiveNo().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getFullName() == null) ? 0 : getFullName().hashCode());
        result = prime * result + ((getPinYin() == null) ? 0 : getPinYin().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getBirthday() == null) ? 0 : getBirthday().hashCode());
        result = prime * result + ((getNation() == null) ? 0 : getNation().hashCode());
        result = prime * result + ((getNativePlace() == null) ? 0 : getNativePlace().hashCode());
        result = prime * result + ((getCitizenNo() == null) ? 0 : getCitizenNo().hashCode());
        result = prime * result + ((getMobile() == null) ? 0 : getMobile().hashCode());
        result = prime * result + ((getSiteTree() == null) ? 0 : getSiteTree().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getPostCode() == null) ? 0 : getPostCode().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getQq() == null) ? 0 : getQq().hashCode());
        result = prime * result + ((getWeixin() == null) ? 0 : getWeixin().hashCode());
        result = prime * result + ((getEducation() == null) ? 0 : getEducation().hashCode());
        result = prime * result + ((getMajor() == null) ? 0 : getMajor().hashCode());
        result = prime * result + ((getSchool() == null) ? 0 : getSchool().hashCode());
        result = prime * result + ((getGraduateTime() == null) ? 0 : getGraduateTime().hashCode());
        result = prime * result + ((getCertificate() == null) ? 0 : getCertificate().hashCode());
        result = prime * result + ((getLiveCity1() == null) ? 0 : getLiveCity1().hashCode());
        result = prime * result + ((getLiveCity2() == null) ? 0 : getLiveCity2().hashCode());
        result = prime * result + ((getLiveCity3() == null) ? 0 : getLiveCity3().hashCode());
        result = prime * result + ((getPhotoUrl() == null) ? 0 : getPhotoUrl().hashCode());
        result = prime * result + ((getCitizenPhotoUrl() == null) ? 0 : getCitizenPhotoUrl().hashCode());
        result = prime * result + ((getEducationPhotoUrl() == null) ? 0 : getEducationPhotoUrl().hashCode());
        result = prime * result + ((getNote() == null) ? 0 : getNote().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        return result;
    }
}