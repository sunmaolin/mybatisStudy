package dao.cascadeMapper;

import pojo.cascadePojo.FemaleHealthForm;

/**
 * 女性体检表操作接口
 */
public interface FemaleHealthFormMapper {

    /**
     * 根据雇员id查找其体检表
     * @param empId 雇员id
     * @return
     */
    FemaleHealthForm getFemaleHealthFormByEmpId(long empId);

}
