package my_spring;

/**
 * @author Evgeny Borisov
 */
public class Main {
    public static void main(String[] args) {
        Context context = new Context();
        IRobot iRobot = context.getInstance(IRobot.class);
        iRobot.cleanRoom();
    }
}
