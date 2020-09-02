package homework.heroes_game.model;

public class Elf extends Hero {
    public Elf(String name) {
        super(name, 10, 10, new ElfFightStrategy());
    }
}
