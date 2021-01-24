package myEnum;

import java.util.Arrays;

/**
 * 学习枚举类
 */
public class EnumStudy {
    public static void main(String[] args) {
        testOrdinal();
        testCompareTo();
        testNameOrToString();
        testValueOf();
        testValuesAndValueOf();
    }

    /**
     * 测试枚举类的ordinal方法，该方法主要是获取枚举变量声明的顺序下标
     * 下标从0开始
     */
    public static void testOrdinal(){
        Week monday = Week.MONDAY;
        //输出1
        System.out.println(monday.ordinal());
    }

    /**
     * 测试枚举类的compareTo方法，比较大小是根据其ordinal比较的
     */
    public static void testCompareTo(){
        Week monday = Week.MONDAY;
        Week tuesday = Week.TUESDAY;
        System.out.println(monday.compareTo(tuesday));
    }

    /**
     * 测试枚举类的name()与toString()方法
     * 输出变量的字符串形式
     */
    public static void testNameOrToString(){
        Week monday = Week.MONDAY;
        System.out.println(monday.toString());
        System.out.println(monday.name());
    }

    /**
     * 测试枚举类的valueOf方法
     * 根据枚举类的class对象与枚举类的名称获取该枚举对象
     */
    public static void testValueOf(){
        Week monday = Week.valueOf(Week.class,"MONDAY");
        System.out.println(monday);
    }

    /**
     * 测试枚举类的values()与valueOf()方法
     * 这俩个方法是编译器自动生成的，上面的那个valueOf是自带的，参数不同
     */
    public static void testValuesAndValueOf(){
        //获取所有的枚举
        Week[] days = Week.values();
        System.out.println(Arrays.toString(days));
        //根据name获取枚举
        Week monday = Week.valueOf("MONDAY");
        System.out.println(monday);

        //需要注意的是，向上转型没有这俩个方法，因为这是编译器自动生成的
        //原先的enum类没有这俩个方法
        Enum upEnum = Week.MONDAY;
        //upEnum.values();报错

        //BUT 但是，我们可用通过class类获取
        Class upEnumClass = upEnum.getDeclaringClass();
        //判断是否枚举类
        if(upEnumClass.isEnum()){
            //获取所有枚举类
            Week[] weeks = (Week[]) upEnumClass.getEnumConstants();
            System.out.println(Arrays.toString(weeks));
        }
    }
}

/**
 * 日期枚举类
 */
enum Week{
    //周一，周二，周三，周四，周五，周六，周日
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
}
