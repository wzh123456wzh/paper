package com.wzh.paper.util;

import com.wzh.paper.entity.User;
import redis.clients.jedis.Jedis;
import sun.misc.BASE64Encoder;

import java.util.Random;

public class CurrentUserUtil {

    public static String getToken(User user){
        String nickname = user.getNickname();
        int i = new Random().nextInt(1000);
        String str = nickname + CalendarUtil.getDate() + i;
        BASE64Encoder be = new BASE64Encoder();
        String token = be.encode(str.getBytes());
        return token;
    }
}
