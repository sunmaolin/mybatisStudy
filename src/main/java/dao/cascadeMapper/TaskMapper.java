package dao.cascadeMapper;

import pojo.cascadePojo.Task;

/**
 * 任务操作接口
 */
public interface TaskMapper {

    /**
     * 获取任务
     * @param id 任务id
     * @return
     */
    Task getTask(long id);
}
