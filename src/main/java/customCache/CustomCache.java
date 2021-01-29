package customCache;

import org.apache.ibatis.cache.Cache;

import java.util.concurrent.locks.ReadWriteLock;

/**
 * 自定义缓存  我觉的用处不大  知道有这个东西  需要用到时在看
 *
 * 可定义一个redis缓存等之类的    自定义缓存需要实现cache接口
 *
 */
public class CustomCache implements Cache {
    /**
     * 获取缓存id
     * @return
     */
    public String getId() {
        return null;
    }

    /**
     * 添加缓存
     * @param o key
     * @param o1 value
     */
    public void putObject(Object o, Object o1) {

    }

    /**
     * 获取缓存
     * @param o key
     * @return
     */
    public Object getObject(Object o) {
        return null;
    }

    /**
     * 删除缓存
     * @param o key
     * @return
     */
    public Object removeObject(Object o) {
        return null;
    }

    /**
     * 清空缓存
     */
    public void clear() {

    }

    /**
     * 获取缓存数量
     * @return
     */
    public int getSize() {
        return 0;
    }

    /**
     * 获取读写锁 多线程使用
     * @return
     */
    public ReadWriteLock getReadWriteLock() {
        return null;
    }
}
