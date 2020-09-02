package homework.heroes_game;

import homework.heroes_game.controller.GameManager;
import homework.heroes_game.model.Hero;
import homework.heroes_game.services.HeroFactory;

import java.lang.reflect.InvocationTargetException;

public class HeroesMain {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Hero hero1 = HeroFactory.createHero();
        Hero hero2 = HeroFactory.createHero();
        GameManager manager = new GameManager();
        manager.fight(hero1, hero2);
    }
}
