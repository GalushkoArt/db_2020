package homework.heroes_game.services;

import homework.heroes_game.model.*;

import java.util.Random;

public class HeroFactory {
    private HeroFactory() {}
    private static final Random random = new Random(System.currentTimeMillis());

    public static Hero createHero() {
        int pick = random.nextInt(4);
        if (pick == 0) {
            return new Elf("Малфурион Ярость Бури");
        } else if (pick == 1) {
            return new King("Ричард");
        } else if (pick == 2) {
            return new Knight(getRandomKnightName());
        } else {
            return new Hobbit(getRandomHobbitName());
        }
    }

    private static String getRandomHobbitName() {
        String[] names = {"Фродо", "Бильбо Бэггенс"};
        return names[random.nextInt(names.length)];
    }

    private static String getRandomKnightName() {
        String[] names = {"Костя", "Джон Сина", "Василий Федорович"};
        return names[random.nextInt(names.length)];
    }
}
