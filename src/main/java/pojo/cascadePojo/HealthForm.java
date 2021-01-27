package pojo.cascadePojo;

/**
 * 体检表父类
 */
public abstract class HealthForm {
    /**
     * 编号
     */
    private Long id;
    /**
     * 雇员编号
     */
    private Long empId;
    /**
     * 心
     */
    private String heart;
    /**
     * 肝
     */
    private String liver;
    /**
     * 脾
     */
    private String spleen;
    /**
     * 肺
     */
    private String lung;
    /**
     * 肾
     */
    private String kidney;
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

    public String getHeart() {
        return heart;
    }

    public void setHeart(String heart) {
        this.heart = heart;
    }

    public String getLiver() {
        return liver;
    }

    public void setLiver(String liver) {
        this.liver = liver;
    }

    public String getSpleen() {
        return spleen;
    }

    public void setSpleen(String spleen) {
        this.spleen = spleen;
    }

    public String getLung() {
        return lung;
    }

    public void setLung(String lung) {
        this.lung = lung;
    }

    public String getKidney() {
        return kidney;
    }

    public void setKidney(String kidney) {
        this.kidney = kidney;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
