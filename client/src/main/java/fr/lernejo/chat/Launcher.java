package fr.lernejo.chat;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@SpringBootApplication
public class Launcher {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Launcher.class);
        RabbitTemplate rabbitTemplate = context.getBean(RabbitTemplate.class);

        Scanner scanner = new Scanner(System.in);
        String userMessage;
        do {
            System.out.println("Imput a message, we will sent it for you (q for quit).");
            userMessage = scanner.nextLine();
            if(!userMessage.equals("q")) {
                rabbitTemplate.convertAndSend("", "chat_messages", userMessage);
                System.out.print("Message sent. ");
            }
        } while (!userMessage.equals("q"));
        System.out.println("Bye.");
    }
}
