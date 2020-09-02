package homework.heroes_game.model;

import homework.heroes_game.model.fight_strategy.FightStrategy;

public abstract class Hero implements Fighter {
    protected String name;
    protected int hp;
    protected int power;
    private final FightStrategy fightStrategy;

    public Hero(String name, int hp, int power, FightStrategy fightStrategy) {
        this.name = name;
        this.hp = hp;
        this.power = power;
        this.fightStrategy = fightStrategy;
    }

    @Override
    public void kick(Hero hero) {
        fightStrategy.kick(this, hero);
    }

    public boolean isAlive() {
        return hp > 0;
    }
}
