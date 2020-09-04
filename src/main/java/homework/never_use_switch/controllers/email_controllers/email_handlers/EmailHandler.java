package homework.never_use_switch.controllers.email_controllers.email_handlers;

import homework.never_use_switch.models.MailInfo;

public interface EmailHandler {
    void handle(MailInfo mailInfo);
    int getType();
}
