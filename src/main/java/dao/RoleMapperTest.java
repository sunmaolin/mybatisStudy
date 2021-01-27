package dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import pojo.Role;

import java.util.List;
import java.util.Map;

/**
 * 测试映射器接口
 */
public interface RoleMapperTest {

    /**
     * 通过map传递参数 {roleName:孙茂林,roleId:1}
     * @param parameter
     * @return
     */
    Role parameterMapTest(Map<String,Object> parameter);

    /**
     * 通过注解参数的形式传递参数
     * @param name
     * @param id
     * @return
     */
    Role parameterAnnotationTest(@Param("roleName") String name,@Param("roleId")String id);

    /**
     * 通过javaBean的形式传递参数
     * @param role
     * @return
     */
    Role parameterBeanTest(Role role);

    /**
     * 混合使用传递参数
     * @param role
     * @param limitMap 分页map  {start:1,end:10}
     * @return
     */
    Role parameterMixTest(@Param("role")Role role,@Param("limitMap")Map<String,Integer> limitMap);

    /**
     * 测试mybatis自带rowBounds分页查询,用于小数据量
     * 因为mybatis执行sql查询后从结果集中进行筛选,大数据量性能并不佳
     * @param rowBounds mybatis自带分页查询 默认是0开始 最大条数为Integer的最大数
     * @return
     */
    List<Role> rowBoundsTest(RowBounds rowBounds);

    /**
     * 测试主键回填
     * @param role
     * @return
     */
    int generateKeyTest(Role role);

    /**
     * 测试插入自定义主键,在最大主键+3插入
     * @param role
     * @return
     */
    int customizeKeyTest(Role role);

    /**
     * 测试定义变量sql
     * @param roleId
     * @return
     */
    Role variableSqlTest(int roleId);

}
