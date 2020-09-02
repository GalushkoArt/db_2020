package homework.heroes_game.model;

import java.util.Random;

public class Knight extends Hero {

    public Knight(String name) {
        super(name, new Random().nextInt(11)+2, new Random().nextInt(11)+2, new HumanFightStrategy());
    }
}
