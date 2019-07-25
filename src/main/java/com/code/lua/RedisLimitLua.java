package com.code.lua;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tianwei
 * @since 2019-07-25 12:37
 */
public class RedisLimitLua {
    /**
     * 固定时间窗口<br/>
     * key: key <br/>
     * ARGV1:限制频率 <br/>
     * ARGV2:限制时间段 <br/>
     */
    private final static String FIXED_TIME_WINDOW_SCRIPT = "local key = \"rate.limit:\" .. KEYS[1]\n"
            + "local limit = tonumber(ARGV[1])\n" + "local expire_time = ARGV[2]\n" + "\n"
            + "local is_exists = redis.call(\"EXISTS\", key)\n" + "if is_exists == 1 then\n"
            + "    if redis.call(\"INCR\", key) > limit then\n" + "        return 0\n" + "    else\n"
            + "        return 1\n" + "    end\n" + "else\n" + "    redis.call(\"SET\", key, 1)\n"
            + "    redis.call(\"EXPIRE\", key, expire_time)\n" + "    return 1\n" + "end";

    /**
     * 令牌桶<br/>
     */
    private final static String TOKEN_BUCKET_SCRIPT = "--- 获取令牌\n" + "--- 返回码\n" + "--- 0 没有令牌桶配置\n"
            + "--- -1 表示取令牌失败，也就是桶里没有令牌\n" + "--- 1 表示取令牌成功\n" + "--- @param key 令牌（资源）的唯一标识\n"
            + "--- @param permits 请求令牌数量\n" + "--- @param curr_mill_second 当前毫秒数\n" + "--- @param context 使用令牌的应用标识\n"
            + "local function acquire(key, permits, curr_mill_second, context)\n"
            + "local rate_limit_info = redis.pcall(\"HMGET\", key, \"last_mill_second\", \"curr_permits\", \"max_permits\", \"rate\", \"apps\")\n"
            + "local last_mill_second = rate_limit_info[1]\n" + "local curr_permits = tonumber(rate_limit_info[2])\n"
            + "local max_permits = tonumber(rate_limit_info[3])\n" + "local rate = rate_limit_info[4]\n"
            + "local apps = rate_limit_info[5]\n" + " \n" + "--- 标识没有配置令牌桶\n"
            + "if type(apps) == 'boolean' or apps == nil or not contains(apps, context) then\n" + "return 0\n" + "end\n"
            + "local local_curr_permits = max_permits;\n" + " \n" + "--- 令牌桶刚刚创建，上一次获取令牌的毫秒数为空\n"
            + "--- 根据和上一次向桶里添加令牌的时间和当前时间差，触发式往桶里添加令牌\n" + "--- 并且更新上一次向桶里添加令牌的时间\n"
            + "--- 如果向桶里添加的令牌数不足一个，则不更新上一次向桶里添加令牌的时间\n"
            + "if (type(last_mill_second) ~= 'boolean' and last_mill_second ~= false and last_mill_second ~= nil) then\n"
            + "local reverse_permits = math.floor(((curr_mill_second - last_mill_second) / 1000) * rate)\n"
            + "local expect_curr_permits = reverse_permits + curr_permits;\n"
            + "local_curr_permits = math.min(expect_curr_permits, max_permits);\n" + " \n"
            + "--- 大于0表示不是第一次获取令牌，也没有向桶里添加令牌\n" + "if (reverse_permits > 0) then\n"
            + "redis.pcall(\"HSET\", key, \"last_mill_second\", curr_mill_second)\n" + "end\n" + "else\n"
            + "redis.pcall(\"HSET\", key, \"last_mill_second\", curr_mill_second)\n" + "end\n" + " \n" + " \n"
            + "local result = -1\n" + "if (local_curr_permits - permits >= 0) then\n" + "result = 1\n"
            + "redis.pcall(\"HSET\", key, \"curr_permits\", local_curr_permits - permits)\n" + "else\n"
            + "redis.pcall(\"HSET\", key, \"curr_permits\", local_curr_permits)\n" + "end\n" + " \n" + "return result\n"
            + "end";

    /**
     * 分布式限流 固定时间窗口
     *
     * @throws InterruptedException
     */
    public void fixedTimeWindow() throws InterruptedException {
        // 上传脚本
        // String scriptLoad = jimClient.scriptLoad(script);
        // System.out.println(scriptLoad);
        String scriptLoad = "e77f1e26cf6ed3672ad3c41b3161da1d3d4b64c4";
        List<String> keys = new ArrayList<>();
        keys.add("tianwei_key1");// key名称
        List<String> args = new ArrayList<>();
        args.add("1");// 不超过1
        // args.add("10");// 100秒

        // 调用脚本
        // Object evalsha = jimClient.evalsha(scriptLoad, keys, args, false);
        // System.out.println(evalsha);
        // for (int i = 0; i < 100; i++) {
        // Thread.sleep(1000);
        // evalsha = jimClient.evalsha(scriptLoad, keys, args, false);
        // System.out.println(evalsha);
        // }
    }


    /**
     * 分布式限流 令牌桶
     *
     */
    public void tokenBucket() {

    }

    /**
     * 扣减库存
     * 
     * @throws InterruptedException
     */
    public void incrbyStock() throws InterruptedException {
        StringBuilder script = new StringBuilder();
        script.append("if (redis.call('exists', KEYS[1]) == 1) then");
        script.append("    local stock = tonumber(redis.call('get', KEYS[1]));");
        script.append("    local num = tonumber(ARGV[1]);");
        script.append("    if (stock == -1) then");
        script.append("        return -1;");
        script.append("    end;");
        script.append("    if (stock >= num) then");
        script.append("        return redis.call('incrby', KEYS[1], 0 - num);");
        script.append("    end;");
        script.append("    return -2;");
        script.append("end;");
        script.append("return -3;");
        // String scriptLoad = jimClient.scriptLoad(script.toString());
        // System.out.println(scriptLoad);

        // 初始化库存
        // jimClient.incrBy("tianwei_store", 10);
        // System.out.println("当前库存" + jimClient.get("tianwei_store"));
        // 扣库存
        List<String> keys = new ArrayList<>();
        keys.add("tianwei_store");// key名称
        List<String> args = new ArrayList<>();
        args.add("2");// 不超过1
        // args.add("10");// 100秒
        for (int i = 0; i < 100; i++) {
            Thread.sleep(1000);
            // Object evalsha = jimClient.evalsha(scriptLoad, keys, args, false);
            // System.out.println(evalsha);
        }
    }
}
