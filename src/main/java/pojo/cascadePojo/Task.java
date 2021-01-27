package pojo.cascadePojo;

/**
 * 任务表
 */
public class Task {
    /**
     * 编号
     */
    private Long id;
    /**
     * 任务标题
     */
    private String title;
    /**
     * 任务内容
     */
    private String context;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
