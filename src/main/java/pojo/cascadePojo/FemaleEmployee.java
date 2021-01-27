package pojo.cascadePojo;

/**
 * 女雇员
 */
public class FemaleEmployee extends Employee{

    /**
     * 女性体检表
     */
    private FemaleHealthForm femaleHealthForm = null;

    public FemaleHealthForm getFemaleHealthForm() {
        return femaleHealthForm;
    }

    public void setFemaleHealthForm(FemaleHealthForm femaleHealthForm) {
        this.femaleHealthForm = femaleHealthForm;
    }
}
