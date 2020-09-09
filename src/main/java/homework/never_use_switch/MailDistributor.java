package homework.never_use_switch;

import lombok.SneakyThrows;
import org.reflections.Reflections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Evgeny Borisov
 */
@Component
public class MailDistributor {
    @Autowired
    private Map<String, MailSender> mailSenderMap;

    public void sendMailInfo(MailInfo mailInfo) {
        String mailType = "mailSender" + mailInfo.getMailType();
        MailSender mailSender = mailSenderMap.get(mailType);
        if (mailSender != null) {
            mailSender.sendMail(mailInfo);
        } else {
            mailSenderMap.get("mailSender0").sendMail(mailInfo);
        }
    }
}











