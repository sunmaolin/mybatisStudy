package myEnum;

/**
 * 枚举类进阶用法
 */
public class EnumStudyAdvanced {
    public static void main(String[] args) {
        //Sex 枚举类
        //abstractEnum 定义抽象方法枚举类
        //还有 EnumMap与EnumSet集合 专为枚举设计，暂不写了
    }
}

/**
 * 定义性别枚举类
 */
enum Sex{
    MALE("男性"),
    FEMALE("女性");

    //中文描述
    private String desc;

    /**
     * 构造器为私有的，可以不写，默认
     * @param desc
     */
    private Sex(String desc){
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Sex{" +
                "desc='" + desc + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Sex[] sexes = Sex.values();
        for (Sex sex : sexes){
            System.out.println("name:"+sex.name()+",desc:"+sex.getDesc());
        }
    }

}

enum AbstractEnum {

    FIRST{
        @Override
        String getInfo() {
            return "first";
        }
    },
    SECOND{
        @Override
        String getInfo() {
            return "second";
        }
    };

    /**
     * 定义抽象方法
     * @return
     */
    abstract String getInfo();

    public static void main(String[] args) {
        //体现了java的多态，但是其仍然不能当作引用传递
        System.out.println(AbstractEnum.FIRST.getInfo());
        System.out.println(AbstractEnum.SECOND.getInfo());
    }
}
