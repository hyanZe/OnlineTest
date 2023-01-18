package top.jayczee.backend.util;

import com.github.yitter.contract.IdGeneratorOptions;
import com.github.yitter.idgen.YitIdHelper;
import lombok.extern.slf4j.Slf4j;

/**
 * 雪花ID生成器 利用雪花漂移算法
 */
@Slf4j
public class SnowFlaskIdUtil {
    //雪花漂移ID生成器
    private static final short WORKER_ID = 0;
    private static final IdGeneratorOptions options;

    //Java类中的static静态代码块会自动运行
    static {
        options = new IdGeneratorOptions(WORKER_ID);
    }

    public static long getId() {
        long id = YitIdHelper.nextId();
        log.info("生成雪花漂移ID【{}】", id);
        return id;
    }
}
