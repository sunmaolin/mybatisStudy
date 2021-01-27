package pojo.cascadePojo;

/**
 * 男雇员
 */
public class MaleEmployee extends Employee {
    /**
     * 男性体检表
     */
    private MaleHealthForm maleHealthForm = null;

    public MaleHealthForm getMaleHealthForm() {
        return maleHealthForm;
    }

    public void setMaleHealthForm(MaleHealthForm maleHealthForm) {
        this.maleHealthForm = maleHealthForm;
    }
}
