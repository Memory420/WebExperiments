package memory.webexperiments;

import memory.webexperiments.Service.RedisService;
import memory.webexperiments.Service.RedisZSetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.ZSetOperations;

import java.util.Set;

import static memory.webexperiments.Service.RedisService.*;

@SpringBootApplication
public class WebExperimentsApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebExperimentsApplication.class, args);
    }
    @Bean
    public CommandLineRunner commandLineRunner(RedisService redisService, RedisZSetService redisZSetService) {
        return args -> {
            redisZSetService.flushAll();
            redisZSetService.zsetAdd("players:ranking:playtime", "Scotium", 126);
            redisZSetService.zsetAdd("players:ranking:playtime", "prostuzhen", 176);
            redisZSetService.zsetAdd("players:ranking:playtime", "or_mem", 143);
            redisZSetService.zsetAdd("players:ranking:playtime", "IvanNovr", 189);
            printZSet("players:ranking:playtime", redisZSetService, 2);
        };
    }
    static void printZSet(String setName, RedisZSetService service, int reach){
        Set<ZSetOperations.TypedTuple<Object>> set = service.zsetTopWithScores(setName,
                0, reach - 1);
        set.forEach(i -> System.out.println(i.getValue() + " - "
                + i.getScore()));
    }
}
