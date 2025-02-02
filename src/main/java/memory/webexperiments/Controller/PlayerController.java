package memory.webexperiments.Controller;

import memory.webexperiments.Model.Player;
import memory.webexperiments.Service.RedisZSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RequestMapping("/api/players")
@RestController
public class PlayerController {

    @Autowired
    private RedisZSetService redisZSetService;

    private static final String PLAYTIME_KEY = "players:ranking:playtime";
    private static final String LIKECOUNT_KEY = "players:ranking:likecount";


    @GetMapping("/getbyhours")
    public ResponseEntity<List<Player>> getPlayersByHours(
            @RequestParam(defaultValue = "0") int offset,
            @RequestParam(defaultValue = "20") int limit) {
        if (offset < 0 || limit <= 0 || limit > 100) { // ограничим лимит, например, 100
            return ResponseEntity.badRequest().build();
        }
        Set<ZSetOperations.TypedTuple<Object>> hoursAndName = redisZSetService.zsetTopWithScores(
                PLAYTIME_KEY, offset, offset + limit - 1);

        List<Player> dtos = new ArrayList<>();

        if (hoursAndName != null) {
            for (ZSetOperations.TypedTuple<Object> tuple : hoursAndName) {
                String name = tuple.getValue() != null ? tuple.getValue().toString() : "Unknown";
                int hoursPlayed = tuple.getScore() != null ? tuple.getScore().intValue() : 0;

                Double likeScore = redisZSetService.zsetScore(LIKECOUNT_KEY, name);
                int likeCount = likeScore != null ? likeScore.intValue() : 0;

                dtos.add(new Player(name, hoursPlayed, likeCount));
            }
        }
        return ResponseEntity.ok(dtos);
    }
}
