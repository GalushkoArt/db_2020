package homework.never_use_switch.controllers.email_controllers;

import homework.never_use_switch.controllers.email_controllers.email_handlers.EmailHandler;

import java.util.Map;

public interface MailTypeConfiguration {
    Map<Integer, EmailHandler> getMailTypeToHandlerMap();
}
