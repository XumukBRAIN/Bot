import java.util.ArrayList;

public class Accountant {

    private final ArrayList<String> list;

    Accountant()
    {
        list = new ArrayList<>();
        list.add("1. 1 \n" +
                 "2. dd.mm.yy \n" +
                 "3. 2 hours \n" +
                 "4. create app ");

        list.add("1. 2 \n" +
                 "2. dd.mm.yy \n" +
                 "3. 2 hours \n" +
                 "4. create app ");

        list.add("1. 3 \n" +
                 "2. dd.mm.yy \n" +
                 "3. 2 hours \n" +
                 "4. create app ");
    }

    String getRandQuote(){

        int random = (int)(Math.random()*list.size());

        return list.get(random);
    }

}
