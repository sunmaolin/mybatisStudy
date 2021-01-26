package dao;

import org.apache.ibatis.annotations.Param;
import pojo.Role;

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

}
