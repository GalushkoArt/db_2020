package homework.never_use_switch.controllers.email_controllers.email_handlers;

import homework.never_use_switch.models.MailInfo;

public class DebtEmailHandler implements EmailHandler {
    @Override
    public void handle(MailInfo mailInfo) {
        System.out.println("Debt email " + mailInfo.getText() + " was sent to" + mailInfo.getEmail());
    }

    @Override
    public int getType() {
        return 2;
    }
}
