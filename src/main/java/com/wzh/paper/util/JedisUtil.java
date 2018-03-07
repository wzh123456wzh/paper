package com.wzh.paper.util;

import com.wzh.paper.entity.TokenData;
import redis.clients.jedis.Jedis;

import java.util.Map;

public class JedisUtil {

    public static Jedis jedis;

    static {
        jedis = new Jedis("120.78.205.73");
        jedis.auth("123456");
    }

    public static void setTokenData(String token, TokenData tokenData){
        jedis.hset(token, "nickname", tokenData.getNickname());
        jedis.hset(token, "roleId", tokenData.getRoleIds());
        jedis.hset(token, "userId", tokenData.getUserId());
        jedis.expire(token, 60 * 30);
    }


}
