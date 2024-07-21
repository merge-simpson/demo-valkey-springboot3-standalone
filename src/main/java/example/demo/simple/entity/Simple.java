package example.demo.simple.entity;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;

@RedisHash("simple")
public class Simple {
    @Id
    @Getter
    private String id;

    public String name;
    public Integer age;
    @TimeToLive
    public Integer ttl;
}
