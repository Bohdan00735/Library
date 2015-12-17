package week6;


import java.util.Scanner;

public class Distributor extends Commands {
    private Commands commands = new Commands();
    int controlerForCommandMas;
    private StringRedactor stringRedactor = new StringRedactor();
    private Commands.CommandPWD pwd = new CommandPWD();

    public void startIdentifity(){
        Scanner scanner = new Scanner(System.in);
        String request = scanner.next();
        String[] CommandsInMas = stringRedactor.dividedIntoParts(request);
    }

    private void identifyCommand(String[] masCommands) throws PrefNoFoundEeption {
        if (masCommands[controlerForCommandMas].equals("pwd")){
            controlerForCommandMas++;
            pwd.commandAction(masCommands[controlerForCommandMas - 1]);
        }else if (masCommands[controlerForCommandMas].startsWith("cd")){
        controlerForCommandMas++;

        }else if (masCommands[controlerForCommandMas].startsWith("ls"));
        controlerForCommandMas++;
        Commands.CommandLS ls = new CommandLS();
        ls.commandAction(masCommands[controlerForCommandMas - 1]);
    }
}
