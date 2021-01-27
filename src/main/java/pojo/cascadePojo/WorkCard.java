package pojo.cascadePojo;

/**
 * 工牌表
 */
public class WorkCard {
    /**
     * 编号
     */
    private Long id;
    /**
     * 雇员编号
     */
    private Long empId;
    /**
     * 姓名
     */
    private String realName;
    /**
     * 部门
     */
    private String department;
    /**
     * 手机
     */
    private String mobile;
    /**
     * 职位
     */
    private String position;
    /**
     * 备注
     */
    private String note;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
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
}
