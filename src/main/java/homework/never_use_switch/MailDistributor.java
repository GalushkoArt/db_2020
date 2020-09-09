package homework.never_use_switch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

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











