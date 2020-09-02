package homework.heroes_game.model;

import java.util.Random;

public class HeroFactory {
    private HeroFactory() {}
    private static final Random random = new Random(System.currentTimeMillis());

    public static Hero createHero() {
        Hero[] heroes = getHeroes();

        return heroes[random.nextInt(heroes.length)];
    }

    private static Hero[] getHeroes() {
        return new Hero[]{new Hobbit("Фродо"),
                new Hobbit("Бильбо Бэггенс"),
                new Elf("Малфурион Ярость Бури"),
                new King("Ричард"),
                new Knight("Костя"),
                new Knight("Джон Сина")};
    }
}
