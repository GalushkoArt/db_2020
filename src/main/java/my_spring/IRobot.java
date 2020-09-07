package my_spring;

/**
 * @author Evgeny Borisov
 */
public class IRobot {

    @InjectInstance
    private Speaker speaker;
    @InjectInstance
    private Cleaner cleaner;

    public void cleanRoom() {
        speaker.speak("Я начал уборку");
        cleaner.clean();
        speaker.speak("Я закончил уборку");
    }
}
