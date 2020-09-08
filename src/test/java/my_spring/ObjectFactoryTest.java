package my_spring;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.HashMap;

/**
 * @author Evgeny Borisov
 */
public class ObjectFactoryTest {

    @Before
    public void setupFactory() {
        Config config = new JavaConfig(new HashMap<>(), "my_spring");
        ObjectFactory.getInstance().setupFactory(config);
    }

    @Test
    public void singletonAnnotationTest() {
        Object obj1 = ObjectFactory.getInstance().createObject(SingletonClass.class);
        Object obj2 = ObjectFactory.getInstance().createObject(SingletonClass.class);
        Assert.assertEquals(obj1, obj2);
    }


    @Test(expected = IllegalArgumentException.class)
    public void injectRandomIntForIncorrectValuesIsFailing() {
        ObjectFactory.getInstance().createObject(Developer.class);
    }

    @Test
    public void injectRandomIntIsWorking() {
        Soldier soldier = ObjectFactory.getInstance().createObject(Soldier.class);
        Assert.assertTrue(soldier.getPower() < 15 && soldier.getPower() > 7);
    }

    @Test
    public void objectWasCreatedFromConfiguredClass() {
        Config config = Mockito.mock(Config.class);
        Mockito.when(config.getImpl(SuperHero.class)).then(invocation -> Batman.class);
        Mockito.when(config.getPackageToScan()).thenReturn("my_spring");

        ObjectFactory.getInstance().setConfig(config);
        SuperHero superHero = ObjectFactory.getInstance().createObject(SuperHero.class);
        Assert.assertEquals(Batman.class, superHero.getClass());
    }
}























