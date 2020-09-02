package homework.heroes_game.model;

import java.util.Random;

public class Hobbit extends Hero {
    private static Random random = new Random(System.currentTimeMillis());

    public Hobbit() {
        super(getRandomHobbitName(), 3, 0, new HobbitFightStrategy());
    }

    private static String getRandomHobbitName() {
        String[] names = {"Фродо", "Бильбо Бэггенс"};
        return names[random.nextInt(names.length)];
    }
}
