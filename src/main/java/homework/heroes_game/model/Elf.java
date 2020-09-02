package homework.heroes_game.model;

import java.util.Random;

public class Elf extends Hero {
    private static Random random = new Random(System.currentTimeMillis());

    public Elf() {
        super(getRandomElfName(), 10, 10, new ElfFightStrategy());
    }

    private static String getRandomElfName() {
        String[] names = {"Малфурион Ярость Бури", "Кенариус"};
        return names[random.nextInt(names.length)];
    }
}
