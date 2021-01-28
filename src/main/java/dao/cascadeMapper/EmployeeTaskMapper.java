package dao.cascadeMapper;

import pojo.cascadePojo.EmployeeTask;

import java.util.List;

/**
 * 雇员任务操作接口
 */
public interface EmployeeTaskMapper {

    /**
     * 通过雇员编号查询雇员任务
     * @param empId
     * @return
     */
    List<EmployeeTask> getEmployeeTaskByEmpId(long empId);

}
