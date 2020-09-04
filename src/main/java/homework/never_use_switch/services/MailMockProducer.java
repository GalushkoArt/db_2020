package homework.never_use_switch.services;

import com.github.javafaker.Faker;
import heroes.RandomUtil;
import homework.never_use_switch.controllers.email_controllers.MailDistributor;
import homework.never_use_switch.controllers.email_controllers.BasicMailDistributor;
import homework.never_use_switch.models.MailInfo;
import lombok.SneakyThrows;
import org.fluttercode.datafactory.impl.DataFactory;

/**
 * @author Evgeny Borisov
 */
public class MailMockProducer {

    private MailDistributor mailDistributor = new BasicMailDistributor();
    private Faker faker = new Faker();
    private DataFactory dataFactory = new DataFactory();


    @SneakyThrows
    public void sendMailsForever()  {
        while (true) {
            int mailType = RandomUtil.getIntBetween(0, 6) + 1;
            MailInfo mailInfo = MailInfo.builder()
                    .email(dataFactory.getEmailAddress())
                    .mailType(mailType)
                    .text(faker.chuckNorris().fact()).build();
            mailDistributor.sendMailInfo(mailInfo);
            Thread.sleep(1000);
        }
    }

    public static void main(String[] args) {
        new MailMockProducer().sendMailsForever();
    }
}






