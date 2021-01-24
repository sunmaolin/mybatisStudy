package myEnum;

/**
 * 性别的枚举类
 */
public enum SexEnum {
    //男性
    MALE(1,"男"),
    //女性
    FEMALE(0,"女");

    //代表的数字
    private int id;
    //代表的描述
    private String desc;

    SexEnum(int id,String desc){
        this.id = id;
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * 根据id获取枚举的方法
     * @param id
     * @return
     */
    public SexEnum getSexById(int id){
        for (SexEnum sex : SexEnum.values()){
            if(sex.getId() == id){
                return sex;
            }
        }
        return null;
    }
}
