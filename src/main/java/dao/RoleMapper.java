package dao;

import org.apache.ibatis.annotations.Select;
import pojo.Role;

import java.util.List;

/**
 * 操作role实体接口
 */
public interface RoleMapper {

    /**
     * 通过id获取Role对象
     * @param roleId
     * @return
     */
    Role getRoleByXml(int roleId);

    /**
     * 通过注解sql获取role对象
     * @param roleId
     * @return
     */
    @Select("select * from role where role_id = #{roleId}")
    Role getRoleByAnnotation(int roleId);

    /**
     * 插入一个对象
     * @param role
     * @return
     */
    int insertRole(Role role);

    /**
     * 删除一个对象
     * @param roleId
     * @return
     */
    int deleteRole(int roleId);

    /**
     * 更改一个对象
     * @param role
     * @return
     */
    int updateRole(Role role);

    /**
     * 查找所有的role
     * @param roleName
     * @return
     */
    List<Role> findRoles(String roleName);

    /**
     * 根据id获取姓名
     * @param roleId
     * @return
     */
    String getRoleName(int roleId);

    /**
     * 通过mybatis自带的枚举类（EnumOrdinalTypeHandler）转换器测试获取性别并转换为汉字
     * @param roleId
     * @return
     */
    Role getSexByEnumOrdinal(int roleId);
}
