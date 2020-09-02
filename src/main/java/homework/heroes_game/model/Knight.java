package homework.heroes_game.model;

import java.util.Random;

public class Knight extends Hero {
    private static Random random = new Random(System.currentTimeMillis());

    public Knight() {
        super(getRandomKnightName(), random.nextInt(11)+2, random.nextInt(11)+2, new HumanFightStrategy());
    }

    private static String getRandomKnightName() {
        String[] names = {"Костя", "Джон Сина", "Василий Федорович"};
        return names[random.nextInt(names.length)];
    }
}
