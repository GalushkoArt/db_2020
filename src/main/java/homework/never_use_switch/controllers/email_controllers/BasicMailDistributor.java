package homework.never_use_switch.controllers.email_controllers;

import homework.never_use_switch.controllers.email_controllers.email_handlers.EmailHandler;
import homework.never_use_switch.models.MailInfo;

/**
 * @author Evgeny Borisov
 */
public class BasicMailDistributor implements MailDistributor {
    private MailTypeConfiguration configuration = new MainMailTypeConfiguration();

    @Override
    public void sendMailInfo(MailInfo mailInfo) throws UnsupportedOperationException {
        EmailHandler handler = configuration.getMailTypeToHandlerMap().get(mailInfo.getMailType());
        if (handler != null) {
            handler.handle(mailInfo);
        } else {
            throw new UnsupportedOperationException("Wrong email type");
        }
    }
}
