package homework.heroes_game.model;

import java.util.Random;

public class King extends Hero {

    public King(String name) {
        super(name, new Random().nextInt(11)+5, new Random().nextInt(11)+5, new HumanFightStrategy());
    }

    @Override
    public void kick(Hero hero) {
        System.out.print("Великолепный ");
        super.kick(hero);
    }
}
