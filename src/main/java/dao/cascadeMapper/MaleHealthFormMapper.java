package dao.cascadeMapper;

import pojo.cascadePojo.MaleHealthForm;

/**
 * 男性体检表操作接口
 */
public interface MaleHealthFormMapper {

    /**
     * 通过雇员id获取该男性雇员体检表
     * @param empId 雇员id
     * @return
     */
    MaleHealthForm getMaleHealthFormByEmpId(long empId);
}
