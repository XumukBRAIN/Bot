public class Sender {

    Accountant accountant;

    public Sender(Accountant accountant) {
        this.accountant = accountant;
    }

    public String report (String text){
        String response;
        if(text.equals("/start")){
            response = "Привет, нажми /get или Отчет";
        }else if(text.equals("/get") || text.equals("Отчет")){
            response = accountant.getRandQuote();
        }else {
            response = "Неверная команда";
        }
        return response;
    }

}
