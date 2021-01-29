package dao;

import org.apache.ibatis.annotations.Param;
import pojo.Role;

import java.util.List;

/**
 * 动态sql测试
 */
public interface DynamicSqlMapperTest {

    /**
     * 测试动态sql的if
     * @param roleName
     * @return
     */
    Role testIf(String roleName);

    /**
     * 测试动态sql的choose when otherwise  相当于case when
     * @param roleId
     * @param roleName
     * @return
     */
    Role testChooseWhenOtherwise(@Param("roleId") int roleId, @Param("roleName") String roleName);

    /**
     * 测试动态sql的trim
     * @param roleId
     * @param roleName
     * @return
     */
    Role testTrim(@Param("roleId") int roleId,@Param("roleName") String roleName);

    /**
     * 测试动态sql的where
     * @param roleId
     * @param roleName
     * @return
     */
    Role testWhere(@Param("roleId") int roleId,@Param("roleName") String roleName);

    /**
     * 测试动态sql的set
     * @param roleSex
     * @param roleName
     * @return
     */
    int testSet(@Param("roleSex") int roleSex,@Param("roleName") String roleName);

    /**
     * 测试动态sql的foreach
     * 传递list参数,MyBatis 会自动将它包装在一个 Map 中,用名称在作为键。List 实例将会以“list” 作为键,而数组实例将会以“array”作为键
     * 所以在使用时  #{list} 或者 #{array}
     * 也可以封装在map中   或者使用@Param参数
     * @param roleIds
     * @return
     */
    List<Role> testForeach(@Param("roleIds") List<Integer> roleIds);

    /**
     * 测试动态sql的bind
     * @param roleName
     * @param note
     * @return
     */
    Role testBind(@Param("roleName") String roleName,@Param("note") String note);
}
