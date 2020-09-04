package homework.never_use_switch.controllers.email_controllers;

import homework.never_use_switch.models.MailInfo;

public interface MailDistributor {
    void sendMailInfo(MailInfo mailInfo) throws UnsupportedOperationException;
}
