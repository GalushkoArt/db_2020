package homework.heroes_game.model;

public class Hobbit extends Hero {

    public Hobbit(String name) {
        super(name, 3, 0, new HobbitFightStrategy());
    }
}
