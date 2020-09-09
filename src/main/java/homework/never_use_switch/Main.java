package homework.never_use_switch;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        MailMockProducer producer = new AnnotationConfigApplicationContext(MailConfiguration.class)
                .getBean(MailMockProducer.class);
        producer.sendMailsForever();
    }
}
