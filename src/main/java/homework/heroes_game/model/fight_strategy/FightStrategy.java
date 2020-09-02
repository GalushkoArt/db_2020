package homework.heroes_game.model.fight_strategy;

import homework.heroes_game.model.Hero;

public interface FightStrategy {
    void kick(Hero attacker, Hero attacked);
}
