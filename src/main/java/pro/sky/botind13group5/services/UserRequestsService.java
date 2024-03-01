package pro.sky.botind13group5.services;

import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import org.springframework.stereotype.Component;
import pro.sky.botind13group5.model.User;
@Component
public class UserRequestsService {
    public void sendMessageStart(Update update) {

        Message message = update.message();
        Long chatId = message.from().id();
        String text = message.text();
        String firstName = update.message().from().firstName();
        String userName = update.message().from().username();
        long telegramId = update.message().from().id();

        if ("/start".equals(text)) {

//            User user = userService.findUserByTelegramId(telegramId);
        }
    }
}
