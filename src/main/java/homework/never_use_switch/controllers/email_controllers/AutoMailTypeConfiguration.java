package homework.never_use_switch.controllers.email_controllers;

import homework.never_use_switch.controllers.email_controllers.email_handlers.EmailHandler;
import lombok.SneakyThrows;
import org.reflections.Reflections;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AutoMailTypeConfiguration implements MailTypeConfiguration {
    Reflections scanner = new Reflections("homework/never_use_switch/controllers/email_controllers/");
    List<Class<? extends EmailHandler>> classes;

    public AutoMailTypeConfiguration() {
        classes = new ArrayList<>(scanner.getSubTypesOf(EmailHandler.class));
    }

    @SneakyThrows
    private static EmailHandler apply(Class<? extends EmailHandler> e) {
        return e.getDeclaredConstructor().newInstance();
    }

    @Override
    public Map<Integer, EmailHandler> getMailTypeToHandlerMap() {
        return classes.stream().map(AutoMailTypeConfiguration::apply).collect(Collectors.toMap(EmailHandler::getType, e->e));
    }
}
