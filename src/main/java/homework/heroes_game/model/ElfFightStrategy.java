package homework.heroes_game.model;

import homework.heroes_game.model.fight_strategy.FightStrategy;

public class ElfFightStrategy implements FightStrategy {
    @Override
    public void kick(Hero attacker, Hero attacked) {
        if (attacker.power > attacked.power) {
            attacked.hp = 0;
            System.out.printf("Эльф %s уничтожает %s!!1!\n", attacker.name, attacked.name);
        } else {
            attacked.power--;
            System.out.printf("Эльф %s отнимает 1 силу у %s\n", attacker.name, attacked.name);
        }
    }
}
