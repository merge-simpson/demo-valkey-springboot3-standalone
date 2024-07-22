package example.demo.layered.entity;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;
import org.springframework.data.redis.core.index.Indexed;

import java.time.Instant;

@RedisHash("email-otp")
public class EmailOtp {
    @Id
    @Getter
    private String email;
    @Indexed // findBy + Otp를 사용할 수 있게 함. (inverse 된 OTP:KEY 저장)
    public String otp;
    public Instant createdAt;
    @TimeToLive
    public Integer ttl;
}
