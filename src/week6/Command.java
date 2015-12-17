package week6;

public interface Command {
    Object commandAction(String command) throws PrefNoFoundEeption;
}
