package homework.heroes_game.services;

import homework.heroes_game.model.*;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class HeroFactory {
    private HeroFactory() {}
    private static final Random random = new Random(System.currentTimeMillis());

    public static Hero createHero() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Set<Class<? extends Hero>> classesSet = new Reflections("homework/heroes_game/model/").getSubTypesOf(Hero.class);
        List<Class<? extends Hero>> heroesList = new ArrayList<>(classesSet);
        int pick = random.nextInt(heroesList.size());
        return heroesList.get(pick).getDeclaredConstructor().newInstance();
    }

}
