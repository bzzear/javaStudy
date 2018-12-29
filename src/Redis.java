import redis.clients.jedis.Jedis;

import java.util.List;

public class Redis {

    static int a;
    static int b;
    static char c;
    static {
        a = 1;
        b = 3;
        c = 'A';
    }
    static Integer i5 = 127;

    public static void main(String[] args) {
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("192.168.11.7", 16379);
        System.out.println("连接成功");
        System.out.println("服务正在运行: "+jedis.ping());
        //存储数据到列表中
        jedis.lpush("site-list", "Runoob");
        jedis.lpush("site-list", "Google");
        jedis.lpush("site-list", "Taobao");
        // 获取存储的数据并输出
        List<String> list = jedis.lrange("site-list", 0 ,2);
        for(int i=0; i<list.size(); i++) {
            System.out.println("列表项为: "+list.get(i));
        }
        System.out.println(c);
        System.out.println(i5);
    }

}
