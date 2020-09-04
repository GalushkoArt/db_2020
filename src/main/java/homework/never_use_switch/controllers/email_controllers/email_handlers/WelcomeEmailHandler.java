package homework.never_use_switch.controllers.email_controllers.email_handlers;

import homework.never_use_switch.models.MailInfo;

public class WelcomeEmailHandler implements EmailHandler {
    @Override
    public int getType() {
        return 1;
    }

    @Override
    public void handle(MailInfo mailInfo) {
        System.out.println("WELCOME " + mailInfo.getText() + " was sent to" + mailInfo.getEmail());
    }
}
