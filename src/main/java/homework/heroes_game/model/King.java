package homework.heroes_game.model;

import java.util.Random;

public class King extends Hero {
    private static Random random = new Random(System.currentTimeMillis());

    public King() {
        super(getRandomKingName(), random.nextInt(11)+5, random.nextInt(11)+5, new HumanFightStrategy());
    }

    @Override
    public void kick(Hero hero) {
        System.out.print("Великолепный ");
        super.kick(hero);
    }

    private static String getRandomKingName() {
        String[] names = {"Ричард", "Филип"};
        return names[random.nextInt(names.length)];
    }
}
