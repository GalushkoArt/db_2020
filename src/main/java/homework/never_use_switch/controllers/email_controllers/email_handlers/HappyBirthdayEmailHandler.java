package homework.never_use_switch.controllers.email_controllers.email_handlers;

import homework.never_use_switch.models.MailInfo;

public class HappyBirthdayEmailHandler implements EmailHandler {
    @Override
    public void handle(MailInfo mailInfo) {
        System.out.println("Happy birthday " + mailInfo.getText() + " was sent to" + mailInfo.getEmail());
    }
}
