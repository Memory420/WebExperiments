package memory.webexperiments.Temporary;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import memory.webexperiments.Model.Player;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class JsonUtils {
    public static void main(String[] args) {
        List<Player> players = new ArrayList<>(List.of(
                new Player("CrimsonFox", 345, 23),
                new Player("GoldenEagle", 289, 45),
                new Player("ShadowPanther", 312, 67),
                new Player("StormRider", 278, 12),
                new Player("BlazeFalcon", 400, 55),
                new Player("NightOwl", 150, 32),
                new Player("FrostWolf", 220, 41),
                new Player("IronBear", 310, 29),
                new Player("SwiftTiger", 280, 66),
                new Player("MistyDragon", 360, 78),
                new Player("ThunderBolt", 420, 85),
                new Player("RavenClaw", 190, 33),
                new Player("SilentArrow", 265, 17),
                new Player("DarkKnight", 380, 48),
                new Player("RapidViper", 240, 56),
                new Player("SlyCheetah", 310, 74),
                new Player("MightyRhino", 430, 62),
                new Player("LoneWolf", 200, 35),
                new Player("WildStallion", 275, 50),
                new Player("StealthLynx", 310, 39),
                new Player("BraveHawk", 325, 44),
                new Player("FireSerpent", 290, 60),
                new Player("QuickCobra", 260, 28),
                new Player("ViciousPanther", 340, 72),
                new Player("FeralFalcon", 210, 19),
                new Player("MysticShark", 375, 81),
                new Player("SavageBear", 410, 65),
                new Player("IronFist", 225, 34),
                new Player("StoneGolem", 295, 27),
                new Player("ElectricEel", 330, 53),
                new Player("DarkRaven", 310, 38),
                new Player("SolarFlare", 280, 46),
                new Player("MoonShadow", 340, 50),
                new Player("NebulaStar", 360, 58),
                new Player("CosmicTiger", 390, 79),
                new Player("GalacticWolf", 300, 55),
                new Player("LunarPhoenix", 410, 87),
                new Player("StellarDragon", 370, 64),
                new Player("MeteorStrike", 285, 42),
                new Player("CometTail", 320, 69),
                new Player("NovaBlast", 400, 73),
                new Player("CelestialFox", 350, 59),
                new Player("AuroraBorealis", 265, 31),
                new Player("TempestStorm", 380, 77),
                new Player("EclipseNight", 300, 48),
                new Player("RadiantLion", 335, 50),
                new Player("GlacialBear", 275, 37),
                new Player("InfernoHawk", 420, 90),
                new Player("SapphireShark", 290, 44),
                new Player("EmeraldCobra", 310, 52),
                new Player("CrimsonViper", 360, 64),
                new Player("ObsidianPanther", 395, 71),
                new Player("TitaniumWolf", 300, 66),
                new Player("QuantumFalcon", 330, 75),
                new Player("VortexDragon", 410, 80),
                new Player("CycloneRider", 280, 53),
                new Player("BlizzardTiger", 350, 45),
                new Player("HurricaneEagle", 365, 68),
                new Player("TornadoHawk", 305, 57),
                new Player("LightningStreak", 400, 77),
                new Player("ThunderClap", 375, 66),
                new Player("TempestFury", 315, 59),
                new Player("RagingBull", 320, 43),
                new Player("SavageLion", 330, 52),
                new Player("FuriousBear", 340, 62),
                new Player("WildEagle", 280, 49),
                new Player("CobaltPanther", 310, 41),
                new Player("VibrantFox", 295, 37),
                new Player("ElectricTiger", 360, 71),
                new Player("CrimsonClaw", 385, 74),
                new Player("GoldenPuma", 320, 65),
                new Player("MysticLynx", 305, 58),
                new Player("StealthRaven", 330, 50),
                new Player("RapidHawk", 290, 63),
                new Player("FrostFalcon", 310, 45),
                new Player("StormFang", 360, 67),
                new Player("ShadowStalker", 375, 72),
                new Player("NightHowl", 290, 41),
                new Player("LunarWolf", 315, 55),
                new Player("SolarLion", 340, 60),
                new Player("NovaEagle", 370, 68),
                new Player("CosmicBear", 355, 64),
                new Player("GalacticPanther", 395, 70),
                new Player("CelestialHawk", 330, 53),
                new Player("EternalDragon", 410, 80),
                new Player("PhantomFox", 300, 47),
                new Player("MirageTiger", 340, 59),
                new Player("SpectralWolf", 320, 52),
                new Player("ObsidianEagle", 360, 66),
                new Player("CrimsonKnight", 375, 73),
                new Player("GoldenDragon", 395, 82),
                new Player("MysticPhoenix", 410, 85),
                new Player("BlazingFalcon", 330, 55),
                new Player("ThunderWolf", 365, 68),
                new Player("ShadowStrike", 310, 49),
                new Player("RapidLion", 320, 53),
                new Player("FierceEagle", 340, 60),
                new Player("SavageCobra", 290, 44),
                new Player("WildViper", 310, 50),
                new Player("StealthDragon", 360, 67),
                new Player("MightyHawk", 380, 74),
                new Player("IronPanther", 325, 57),
                new Player("StormLion", 350, 61),
                new Player("BlazeWolf", 370, 69),
                new Player("FrostEagle", 315, 48),
                new Player("NightPanther", 335, 56),
                new Player("RapidBear", 360, 70),
                new Player("SwiftDragon", 385, 75),
                new Player("SilentTiger", 300, 42),
                new Player("DarkFalcon", 330, 55),
                new Player("ThunderEagle", 370, 68),
                new Player("MysticBear", 340, 60),
                new Player("ShadowWolf", 355, 66),
                new Player("BlazingLion", 390, 73),
                new Player("CrimsonDragon", 400, 78),
                new Player("GoldenWolf", 315, 54),
                new Player("RapidPhoenix", 370, 69),
                new Player("FierceTiger", 345, 63),
                new Player("StealthBear", 360, 65),
                new Player("MightyDragon", 380, 80)
        ));
        makeJsonFromPlayers(players);
    }
    static public List<Player> getPlayersFromJson(String jsonName, boolean printLog) {
        List<Player> players = new ArrayList<>();

        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);

        try (InputStream inputStream = JsonUtils.class.getClassLoader().getResourceAsStream("playerdata.json")) {
            if (inputStream == null) {
                System.err.println("Файл data.json не найден в ресурсах!");
                return new ArrayList<>();
            }

            players = objectMapper.readValue(inputStream, new TypeReference<List<Player>>() {});

            if (printLog) {
                System.out.println("Импортирование игроков:");
                players.forEach(player -> System.out.println(
                        "Name: " + player.getName() +
                                ", Hours Player: " + player.getHoursPlayed() +
                                ", Like Count: " + player.getLikeCount()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return players;
    }
    static public List<Player> getPlayersFromJson(String jsonName) {
        return getPlayersFromJson(jsonName, false);
    }

    static public void makeJsonFromPlayers(List<Player> players, boolean printLog) {
        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        try {
            objectMapper.writeValue(new File("playerdata.json"), players);
            if (printLog) {
                System.out.println("Данные о игроках записаны в data.json");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static public void makeJsonFromPlayers(List<Player> players) {
        makeJsonFromPlayers(players, false);
    }
}
