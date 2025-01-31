package memory.webexperiments.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class RedisZSetService {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public Boolean zsetAdd(String name, Object key, double value) {
        return redisTemplate.opsForZSet().add(name, key, value);
    }

    public Long zsetRemove(String name, Object key) {
        return redisTemplate.opsForZSet().remove(name, key);
    }

    public Set<Object> zsetTop(String name, int start, int end) {
        return redisTemplate.opsForZSet().reverseRange(name, start, end);
    }

    public Set<ZSetOperations.TypedTuple<Object>> zsetTopWithScores(String name, int start, int end) {
        return redisTemplate.opsForZSet().reverseRangeWithScores(name, start, end);
    }

    public Object zsetMin(String name) {
        return redisTemplate.opsForZSet().range(name, 0, 0).stream().findFirst().orElse(null);
    }

    public Object zsetMax(String name) {
        return redisTemplate.opsForZSet().reverseRange(name, 0, 0).stream().findFirst().orElse(null);
    }

    public Long zsetRank(String name, Object key) {
        return redisTemplate.opsForZSet().rank(name, key);
    }

    public Long zsetSize(String name) {
        return redisTemplate.opsForZSet().size(name);
    }

    public Set<Object> zsetRangeByScore(String name, double minScore, double maxScore) {
        return redisTemplate.opsForZSet().rangeByScore(name, minScore, maxScore);
    }
    public void flushAll() {
        redisTemplate.getConnectionFactory().getConnection().flushAll();
    }
}
