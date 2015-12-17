package week6;


import java.util.ArrayList;
import java.util.List;

public class StringRedactor {

    public final static String[] dividedIntoParts(String command){
        List<String> listForCommand = new ArrayList<String>();
        int positionInList = 0;
        if (command == null || command.equals("" )) {
            while (!command.equals("")){
               String part = takeFirstPart(command);
                if (part.startsWith("-") || part.startsWith(" -")) {
                    listForCommand.add(positionInList-1 , part);
                }else {
                    listForCommand.add(part);}
                positionInList++;
            }
            return rewriteListInMasString(listForCommand);
        }throw new NullPointerException();

    }

    protected final static String[] rewriteListInMasString(List<String> list){
        String[] res = new String[list.size()];
        for (int i = 0; i < res.length ; i++) {
            res[i] = list.get(i);
        }return res;
    }

    protected final static String takeFirstPart(String command){
        int finish = command.indexOf(" ");
        return command.substring(0, finish);
    }

    protected final static String takeSecondPart(String command){
        int start = command.indexOf(" ");
        return command.substring(start) ;
    }

    protected final static String takePref(String command) {
        int start = command.indexOf("-");
        return command.substring(start);
    }
}
