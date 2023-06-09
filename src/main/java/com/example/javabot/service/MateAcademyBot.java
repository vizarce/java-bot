package com.example.javabot.service;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;
@Component
public class MateAcademyBot extends TelegramLongPollingBot {

    @Override
    public String getBotUsername() {
        return "recipe_by_zhvit_bot";
    }

    @Override
    public String getBotToken() {
        return "5943041712:AAHT4SqWzVsk3H2YE5lbdg-GlFcmR6yzfHI";
    }


    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        System.out.println("Message received: " + message.getText());
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText("Hello User! I successfully received your message: '" + message.getText() + "'");
        sendMessage.setChatId(String.valueOf(message.getChatId()));

        String input = message.getText();

        StringBuilder sb = new StringBuilder();
        String welcome = sb.append("Hello dear User! \nWelcome to the Recipe Bot!")
                .append("\n\nYou can pass here the meal of the day \nand get appropriate recipes")
                .append("\n\n.......Possible options are:......\n").toString();
//                .append("--- Breakfast ---\n")
//                .append("--- Lunch ---\n")
//                .append("--- Dinner ---\n")
//                .append("--- Supper ---\n")
//                .toString();
        if (input.equalsIgnoreCase("/start")) {
            sendMessage.enableMarkdown(true);
            ReplyKeyboardMarkup replyKeyboardMarkup = getMenuKeyboard();
            sendMessage.setReplyMarkup(replyKeyboardMarkup);
            sendMessage.setText(welcome);
        }

        if ((input.replaceAll("[ .]", "").replaceAll("[ !]", "")).equalsIgnoreCase("hello")
                || (input.replaceAll("[ .]", "").replaceAll("[ !]", "")).equalsIgnoreCase("hi")) {
            sendMessage.setText("Hello dear User! \nWelcome to the Recipe Bot!");
        }
        String breakfastMenu = sb.append(".......Breakfast Menu!......\n")
                .append("1. Blueberry-Banana-Nut Smoothie\n")
                .append("2. Classic Omelet and Greens\n")
                .append("3. Curry-Avocado Crispy Egg Toast")
                .toString();
        sb.delete(0, sb.length());

        String lunchMenu = sb.append(".......Lunch Menu!......\n")
                .append("1. Crispy Chicken Grab and Go Salad\n")
                .append("2. Ranch Carrot Sticks\n")
                .append("3. Assorted Cold Sandwiches and Wraps")
                .toString();
        sb.delete(0, sb.length());

        String dinnerMenu = sb.append(".......Dinner Menu!......\n")
                .append("1. Creamy Lemon Chicken Pasta\n")
                .append("2. Turkey Tacos\n")
                .append("3. Vegetarian Lasagna")
                .toString();
        sb.delete(0, sb.length());
        String supperMenu = sb.append(".......Supper Menu!......\n")
                .append("1. Pan Roasted Green Beans\n")
                .append("2. Chicken Pot Pie\n")
                .append("3. Smoked Dry Rub Chicken Wings")
                .toString();
        sb.delete(0, sb.length());

        if (input.equalsIgnoreCase("breakfast")) {
            sendMessage.setText(breakfastMenu);
        } else if (input.equalsIgnoreCase("lunch")) {
            sendMessage.setText(lunchMenu);
        } else if (input.equalsIgnoreCase("dinner")) {
            sendMessage.setText(dinnerMenu);
        } else if (input.equalsIgnoreCase("supper")) {
            sendMessage.setText(supperMenu);
        } //else {
            //sendMessage.setText("Incorrect Input! Try once more.");
        //}
        sendMessage.setChatId(String.valueOf(message.getChatId()));
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private ReplyKeyboardMarkup getMenuKeyboard() {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        List<KeyboardRow> keyboardRows = new ArrayList<>();

        KeyboardRow keyboardRow = new KeyboardRow();
        keyboardRow.add("Breakfast");
        keyboardRow.add("Lunch");
        KeyboardRow keyboardSecondRow = new KeyboardRow();
        keyboardSecondRow.add("Dinner");
        keyboardSecondRow.add("Supper");

        keyboardRows.add(keyboardRow);
        keyboardRows.add(keyboardSecondRow);

        replyKeyboardMarkup.setKeyboard(keyboardRows);

        return replyKeyboardMarkup;
    }
}




























//        System.out.println("Message received: " + update.getMessage().getText());
//        System.out.println("update.getMyChatMember(): " + update.getMyChatMember());
//        System.out.println("update.getMessage().getMessageId(): " + update.getMessage().getMessageId());
//        System.out.println("update.getMessage().getForwardSenderName(): " + update.getMessage().getForwardSenderName());
//        System.out.println("update.getMessage().getForwardFrom(): " + update.getMessage().getForwardFrom());
//        System.out.println("update.getMessage().getAuthorSignature(): " + update.getMessage().getAuthorSignature());
//        System.out.println("update.getMessage().getChatId(): " + update.getMessage().getChatId());
//        System.out.println("update.getMessage().getReplyToMessage(): " + update.getMessage().getReplyToMessage());
//        System.out.println("update.getMessage().getChat(): " + update.getMessage().getChat());
//        System.out.println("update.getMessage().getDate(): " + update.getMessage().getDate());
//        System.out.println("update.getInlineQuery(): " + update.getInlineQuery());
//        System.out.println("update.getUpdateId(): " + update.getUpdateId());
//        System.out.println("update.getChatJoinRequest(): " + update.getChatJoinRequest());
//        System.out.println("update.getChatMember(): " + update.getChatMember());
//        System.out.println("update.getChannelPost(): " + update.getChannelPost());
//        int dId = update.getMessage().getDate();
//        SendMessage sm = new SendMessage();
//        String input = update.getMessage().getText()
//                .replaceAll("[ .]", "")
//                .replaceAll("[ !]", "")
//                .replaceAll("[ ?]", "");
//        if (update.getMessage().getText().equalsIgnoreCase("how are you?")) {
//            sm.setText("Thanks a lot! I'm pretty good. What about you?");
//            sm.setChatId(String.valueOf(update.getMessage().getChatId()));
//            try {
//                execute(sm);
//            } catch (TelegramApiException e) {
//                e.printStackTrace();
//            }
//            dId = update.getMessage().getDate();
//        }
//        //int dId = update.getMessage().getDate();
//        SendMessage sms = new SendMessage();
//        //update.setUpdateId(update.getUpdateId());
//        if (update.getMessage().getText().equalsIgnoreCase("fine")
//                || update.getMessage().getText().equalsIgnoreCase("well")
//                && update.getMessage().getDate() == dId) {
//            sms.setText("Glad to hear!");
//            sms.setChatId(String.valueOf(update.getMessage().getChatId()));
//            try {
//                execute(sms);
//            } catch (TelegramApiException e) {
//                e.printStackTrace();
//            }
//        } else if (update.getMessage().getText().equalsIgnoreCase("bad")
//                || update.getMessage().getText().equalsIgnoreCase("badly")
//                && update.getMessage().getDate() == dId) {
//            sms.setText("So sorry for this!");
//            sms.setChatId(String.valueOf(update.getMessage().getChatId()));
//            try {
//                execute(sms);
//            } catch (TelegramApiException e) {
//                e.printStackTrace();
//            }
//        }

