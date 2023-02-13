package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 会员信息对象 viprole
 *
 * @author ruoyi
 * @date 2023-02-13
 */
public class Viprole extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 部门 */
    @Excel(name = "部门")
    private String department;

    /** 职务 */
    @Excel(name = "职务")
    private String position;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 性别 */
    @Excel(name = "性别")
    private String genders;

    /** 民族 */
    @Excel(name = "民族")
    private String nationality;

    /** 政治面貌 */
    @Excel(name = "政治面貌")
    private String politicalBread;

    /** 出生日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "出生日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date dateOfBirth;

    /** 手机号 */
    @Excel(name = "手机号")
    private String phonenumber;

    /** 住址 */
    @Excel(name = "住址")
    private String address;

    /** 工作单位 */
    @Excel(name = "工作单位")
    private String employer;

    /** 微信号 */
    @Excel(name = "微信号")
    private String wechatId;

    /** 入会时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "入会时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date membershipTime;

    /** 入会介绍人 */
    @Excel(name = "入会介绍人")
    private String introducer;

    /** 特长 */
    @Excel(name = "特长")
    private String expertise;

    /** 会员状态 */
    @Excel(name = "会员状态")
    private String status;

    /** 离会时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "离会时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date departureTime;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setDepartment(String department)
    {
        this.department = department;
    }

    public String getDepartment()
    {
        return department;
    }
    public void setPosition(String position)
    {
        this.position = position;
    }

    public String getPosition()
    {
        return position;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public void setGenders(String genders)
    {
        this.genders = genders;
    }

    public String getGenders()
    {
        return genders;
    }
    public void setNationality(String nationality)
    {
        this.nationality = nationality;
    }

    public String getNationality()
    {
        return nationality;
    }
    public void setPoliticalBread(String politicalBread)
    {
        this.politicalBread = politicalBread;
    }

    public String getPoliticalBread()
    {
        return politicalBread;
    }
    public void setDateOfBirth(Date dateOfBirth)
    {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getDateOfBirth()
    {
        return dateOfBirth;
    }
    public void setPhonenumber(String phonenumber)
    {
        this.phonenumber = phonenumber;
    }

    public String getPhonenumber()
    {
        return phonenumber;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getAddress()
    {
        return address;
    }
    public void setEmployer(String employer)
    {
        this.employer = employer;
    }

    public String getEmployer()
    {
        return employer;
    }
    public void setWechatId(String wechatId)
    {
        this.wechatId = wechatId;
    }

    public String getWechatId()
    {
        return wechatId;
    }
    public void setMembershipTime(Date membershipTime)
    {
        this.membershipTime = membershipTime;
    }

    public Date getMembershipTime()
    {
        return membershipTime;
    }
    public void setIntroducer(String introducer)
    {
        this.introducer = introducer;
    }

    public String getIntroducer()
    {
        return introducer;
    }
    public void setExpertise(String expertise)
    {
        this.expertise = expertise;
    }

    public String getExpertise()
    {
        return expertise;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }
    public void setDepartureTime(Date departureTime)
    {
        this.departureTime = departureTime;
    }

    public Date getDepartureTime()
    {
        return departureTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("department", getDepartment())
                .append("position", getPosition())
                .append("name", getName())
                .append("genders", getGenders())
                .append("nationality", getNationality())
                .append("politicalBread", getPoliticalBread())
                .append("dateOfBirth", getDateOfBirth())
                .append("phonenumber", getPhonenumber())
                .append("address", getAddress())
                .append("employer", getEmployer())
                .append("wechatId", getWechatId())
                .append("membershipTime", getMembershipTime())
                .append("introducer", getIntroducer())
                .append("expertise", getExpertise())
                .append("status", getStatus())
                .append("departureTime", getDepartureTime())
                .append("remark", getRemark())
                .toString();
    }
}
