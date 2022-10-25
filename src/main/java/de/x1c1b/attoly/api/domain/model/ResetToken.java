package de.x1c1b.attoly.api.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash(value = "ResetToken", timeToLive = 300)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ResetToken {

    @Id
    private String token;
    private String principal;
}
