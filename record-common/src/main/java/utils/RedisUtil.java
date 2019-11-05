package utils;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class RedisUtil {


    /**
     * 限流，是否允许操作
     *
     * @param uniqueCode - 唯一码（如订单号，userPin）
     * @param actionKey  - 动作类型（要限制的操作的编码）
     * @param period     - 时间段（多长时间内允许操作，单位为秒）
     * @param maxCount   - 最多操作的次数（该时间段内最多允许操作多少次）
     * @return
     */
    /*
    public boolean isActionAllowed(String uniqueCode, String actionKey, int period, int maxCount) throws UnsupportedEncodingException {
        String key = String.format("hist:%s:%s", actionKey, uniqueCode);
        PipelineClient pipe = jimClient.pipelineClient();
        long nowNanoTs = System.nanoTime();

        pipe.zAdd(key.getBytes(DEFAULT_CHARSET), nowNanoTs, (nowNanoTs + "").getBytes(DEFAULT_CHARSET));
        pipe.zRemRangeByScore(key.getBytes(DEFAULT_CHARSET), 0, nowNanoTs - period * 1000000000L);
        pipe.zCard(key.getBytes());
        pipe.expire(key.getBytes(), period + 1, TimeUnit.SECONDS);

        List<Object> results = pipe.flushAndReturnAll();

        log.info("pipe.flushAndReturnAll: key - {}, maxCount - {}, results - {}", key, maxCount, JSON.toJSONString(results));

        pipe.close();

        int count = Integer.parseInt(results.get(2).toString());

        return count <= maxCount;
    }
    */

}
