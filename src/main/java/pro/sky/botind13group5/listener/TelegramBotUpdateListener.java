package pro.sky.botind13group5.listener;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import pro.sky.botind13group5.services.UserRequestsService;

import java.util.List;

@Component
public class TelegramBotUpdateListener implements UpdatesListener {

    private final UserRequestsService userRequestsService;
    private final Logger logger = LoggerFactory.getLogger(TelegramBotUpdateListener.class);
    private final TelegramBot telegramBot;

    public TelegramBotUpdateListener(UserRequestsService userRequestsService, TelegramBot telegramBot) {
        this.userRequestsService = userRequestsService;
        this.telegramBot = telegramBot;
    }

    @PostConstruct
    public void init() {
        telegramBot.setUpdatesListener(this);
    }


    @Override
    public int process(List<Update> updates) {
        try {

            updates.forEach(update -> {
                logger.info("Handles update: {}", update);

//                if (userRequestsService.checkReport(update)) {
//                    return;
//                }
//
//                if (userRequestsService.checkVolunteer(update)) {
//                    return;
//                }
//
//                if (userRequestsService.checkAdopter(update)) {
//                    return;
//                }
//
//                if (userRequestsService.checkUserInGuestCat(update)) {
//                    return;
//                }
//
//                if (userRequestsService.checkUserInGuestDog(update)) {
//                    return;
//                }
//
//                if (update.message() == null) {
//                    userRequestsService.createButtonClick(update);
//
//                } else {
                    userRequestsService.sendMessageStart(update);
//                }
            });
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return UpdatesListener.CONFIRMED_UPDATES_ALL;
    }
}
