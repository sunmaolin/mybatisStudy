package pojo.cascadePojo;

import myEnum.SexEnum;

import java.util.Date;
import java.util.List;

/**
 * 雇员父类
 */
public class Employee {
    /**
     * 编号
     */
    private Long id;
    /**
     * 真实姓名
     */
    private String realName;
    /**
     * 性别
     */
    private SexEnum sexEnum;
    /**
     * 生日
     */
    private Date birthday;
    /**
     * 电话
     */
    private String mobile;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 职位
     */
    private String position;
    /**
     * 备注
     */
    private String note;
    /**
     * 工牌 一对一级联
     */
    private WorkCard workCard;
    /**
     * 雇员任务  一对多的关系
     */
    private List<EmployeeTask> employeeTaskList = null;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public SexEnum getSexEnum() {
        return sexEnum;
    }

    public void setSexEnum(SexEnum sexEnum) {
        this.sexEnum = sexEnum;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public WorkCard getWorkCard() {
        return workCard;
    }

    public void setWorkCard(WorkCard workCard) {
        this.workCard = workCard;
    }

    public List<EmployeeTask> getEmployeeTaskList() {
        return employeeTaskList;
    }

    public void setEmployeeTaskList(List<EmployeeTask> employeeTaskList) {
        this.employeeTaskList = employeeTaskList;
    }
}
