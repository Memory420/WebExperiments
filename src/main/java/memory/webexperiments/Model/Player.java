package memory.webexperiments.Model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Player {
    private final String name;
    private final int hoursPlayed;
    private final int likeCount;

    @JsonCreator
    public Player(
            @JsonProperty("name") String name,
            @JsonProperty("hours_played") int hoursPlayed,
            @JsonProperty("like_count") int likeCount) {
        this.name = name;
        this.hoursPlayed = hoursPlayed;
        this.likeCount = likeCount;
    }
}
