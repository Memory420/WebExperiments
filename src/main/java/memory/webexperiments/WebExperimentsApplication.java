package memory.webexperiments;

import memory.webexperiments.Model.Player;
import memory.webexperiments.Service.RedisZSetService;
import memory.webexperiments.Temporary.JsonUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.*;

import static memory.webexperiments.Service.RedisZSetService.printZSet;

@SpringBootApplication
public class WebExperimentsApplication {
    static String playTime = "players:ranking:playtime";
    static String likeCount = "players:ranking:likecount";
    static String playerData = "playerdata.json";

    public static void main(String[] args) {
        SpringApplication.run(WebExperimentsApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(RedisZSetService redisZSetService) {
        return args -> {
            List<Player> players = JsonUtils.getPlayersFromJson(playerData);

            redisZSetService.flushAll();

            for (Player player : players) {
                redisZSetService.zsetAdd(playTime, player.getName(), player.getHoursPlayed());
                redisZSetService.zsetAdd(likeCount, player.getName(), player.getLikeCount());
            }

            printZSet(playTime, redisZSetService, -1);

            printZSet(likeCount, redisZSetService, -1);
        };
    }
}
