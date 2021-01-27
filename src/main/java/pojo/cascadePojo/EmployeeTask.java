package pojo.cascadePojo;

/**
 * 雇员任务表
 */
public class EmployeeTask {
    /**
     * 编号
     */
    private Long id;
    /**
     * 雇员编号
     */
    private Long empId;
    /**
     * 任务
     */
    private Task task = null;
    /**
     * 任务标题
     */
    private String taskName;
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

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
