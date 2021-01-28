package dao.cascadeMapper;

import pojo.cascadePojo.Employee;

/**
 * 雇员操作接口
 */
public interface EmployeeMapper {

    /**
     * 通过雇员id获取雇员
     * @param id 雇员id
     * @return
     */
    Employee getEmployee(long id);

}
