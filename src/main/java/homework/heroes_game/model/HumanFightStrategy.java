package homework.heroes_game.model;

import homework.heroes_game.model.fight_strategy.FightStrategy;

public class HumanFightStrategy implements FightStrategy {
    @Override
    public void kick(Hero attacker, Hero attacked) {
        int damage = (int) Math.round(attacker.power * Math.random());
        attacked.hp -= damage;
        System.out.printf("%s наносит удар по %s на %d урона\n", attacker.name, attacked.name, damage);
    }
}
