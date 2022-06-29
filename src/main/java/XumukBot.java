import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;


public class XumukBot extends TelegramLongPollingBot {

    Accountant accountant;
    Sender sender;

    public XumukBot(Accountant accountant, Sender sender) {
        this.accountant = accountant;
        this.sender = sender;
    }


    @Override
    public String getBotUsername() {
        return "xumBrain_bot";
    }

    @Override
    public String getBotToken() {
        return "5506223585:AAExGzPvSYlAqSyinP3-GA1nKKpMaf2c-rA";
    }

    @Override
    public void onUpdateReceived(Update update) {
        try{
            if(update.hasMessage() && update.getMessage().hasText())
            {
                //Извлекаем из объекта сообщение пользователя
                Message inMess = update.getMessage();

                //Достаем из inMess id чата пользователя
                String chatId = inMess.getChatId().toString();

                //Получаем текст сообщения пользователя, отправляем в написанный нами обработчик
                String response = sender.report(inMess.getText());

                //Создаем объект класса SendMessage - наш будущий ответ пользователю
                SendMessage outMess = new SendMessage();

                outMess.setReplyMarkup(initKeyBoard());

                //Добавляем в наше сообщение id чата а также наш ответ
                outMess.setChatId(chatId);
                outMess.setText(response);

                //Отправка в чат
                execute(outMess);
            }
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

   //public String report (String text){
   //    String response;
   //    if(text.equals("/start")){
   //        response = "Привет, нажми get";
   //    }else if(text.equals("/get") || text.equals("Отчет")){
   //        response = accountant.getRandQuote();
   //    }else {
   //        response = "Неверная команда";
   //    }
   //    return response;
   //}


    ReplyKeyboard initKeyBoard(){
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        ArrayList<KeyboardRow> keyboardRows = new ArrayList<>();

        KeyboardRow keyboardRow = new KeyboardRow();
        keyboardRows.add(keyboardRow);

        keyboardRow.add(new KeyboardButton("Отчет"));
        keyboardRow.add(new KeyboardButton("/start"));

        replyKeyboardMarkup.setKeyboard(keyboardRows);
        return replyKeyboardMarkup;
    }


}
