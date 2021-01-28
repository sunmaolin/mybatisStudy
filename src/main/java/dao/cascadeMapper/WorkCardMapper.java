package dao.cascadeMapper;

import pojo.cascadePojo.WorkCard;

/**
 * 工牌操作接口
 */
public interface WorkCardMapper {

    /**
     * 通过雇员id获取其工牌
     * @param empId 雇员id
     * @return
     */
    WorkCard getWorkCardByEmpId(long empId);

}
