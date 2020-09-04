package homework.never_use_switch.controllers.email_controllers;

import com.google.common.collect.ImmutableMap;
import homework.never_use_switch.controllers.email_controllers.email_handlers.*;

import java.util.Map;

public class MainMailTypeConfiguration implements MailTypeConfiguration {
    @Override
    public Map<Integer, EmailHandler> getMailTypeToHandlerMap() {
        return ImmutableMap.<Integer, EmailHandler> builder()
                .put(1, new WelcomeEmailHandler())
                .put(2, new DebtEmailHandler())
                .put(3, new HappyBirthdayEmailHandler())
                .put(4, new NewYearEmailHandler())
                .put(5, new SaleEmailHandler())
                .build();
    }
}
