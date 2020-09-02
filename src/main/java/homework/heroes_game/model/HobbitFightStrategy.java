package homework.heroes_game.model;

import homework.heroes_game.model.fight_strategy.FightStrategy;

public class HobbitFightStrategy implements FightStrategy {
    @Override
    public void kick(Hero attacker, Hero attacked) {
        System.out.printf("Хоббит %s просто плачет((((\n", attacker.name);
    }
}
