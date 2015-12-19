package week6;


import java.util.Scanner;

public class Distributor extends Commands {
    private Commands commands = new Commands();
    int controlerForCommandMas;
    private StringRedactor stringRedactor = new StringRedactor();
    private Commands.CommandPWD pwd = new CommandPWD();

    public void startIdentifity() throws PrefNoFoundEeption, CommandNotFoundExeption {
        Scanner scanner = new Scanner(System.in);
        String request = scanner.next();
        if (!request.equals(null)){
        String[] CommandsInMas = stringRedactor.dividedIntoParts(request);
        identifyCommand(CommandsInMas);
        }else{
            System.err.println("Take command");
        }
    }

    private String identifyCommand(String[] masCommands) throws PrefNoFoundEeption, CommandNotFoundExeption {
        if (!masCommands[controlerForCommandMas].equals(null)) {

            if (masCommands[controlerForCommandMas].equals("pwd")) {
                controlerForCommandMas++;
                return pwd.commandAction(masCommands[controlerForCommandMas - 1]) + identifyCommand(masCommands);


            } else if (masCommands[controlerForCommandMas].startsWith("cd")) {
                controlerForCommandMas++;
                CommandCD commandCD = new CommandCD();
                return commandCD.commandAction(masCommands[controlerForCommandMas - 1]) + identifyCommand(masCommands);


            } else if (masCommands[controlerForCommandMas].startsWith("ls")) {
                controlerForCommandMas++;
                Commands.CommandLS ls = new CommandLS();
                return ls.commandAction(masCommands[controlerForCommandMas - 1]) + identifyCommand(masCommands);

            }else if (masCommands[controlerForCommandMas].startsWith("cp")){
                controlerForCommandMas++;
                Commands.CommandCP cp = new CommandCP();
                return cp.commandAction(masCommands[controlerForCommandMas - 1]) + identifyCommand(masCommands);

            }else if (masCommands[controlerForCommandMas].startsWith("mv")){
                controlerForCommandMas++;
                Commands.CommandMV mv = new CommandMV();
                return mv.commandAction(masCommands[controlerForCommandMas - 1]) + identifyCommand(masCommands);

            }else if (masCommands[controlerForCommandMas].startsWith("cp")){
                controlerForCommandMas++;
                Commands.CommandRM rm = new CommandRM();
                return rm.commandAction(masCommands[controlerForCommandMas - 1]) + identifyCommand(masCommands);

            }else if (masCommands[controlerForCommandMas].startsWith("cp")){
                controlerForCommandMas++;
                Commands.CommandTOUCH touch = new CommandTOUCH();
                return touch.commandAction(masCommands[controlerForCommandMas - 1]) + identifyCommand(masCommands);

            }else if (masCommands[controlerForCommandMas].startsWith("cp")){
                controlerForCommandMas++;
                Commands.CommandMKDIR mkdir = new CommandMKDIR();
                return mkdir.commandAction(masCommands[controlerForCommandMas - 1]) + identifyCommand(masCommands);

            }else if (masCommands[controlerForCommandMas].startsWith("cp")){
                controlerForCommandMas++;
                Commands.CommandHEAD head = new CommandHEAD();
                return head.commandAction(masCommands[controlerForCommandMas - 1]) + identifyCommand(masCommands);

            }else if (masCommands[controlerForCommandMas].startsWith("cp")){
                controlerForCommandMas++;
                Commands.CommandTAIL tail = new CommandTAIL();
                return tail.commandAction(masCommands[controlerForCommandMas - 1]) + identifyCommand(masCommands);
            }else if (masCommands[controlerForCommandMas].startsWith("cp")) {
                controlerForCommandMas++;
                processingCommandCAT(masCommands);
            }throw  new CommandNotFoundExeption();
        }
        return " ";
    }

    private void processingCommandCAT(String[] commandsInArr)throws PrefNoFoundEeption {
        CommandCAT cat = new CommandCAT();
        String command = "";

        try {
            if (commandsInArr[controlerForCommandMas + 1].equals(">") || commandsInArr[controlerForCommandMas + 1].equals("|")) {
                command += commandsInArr[controlerForCommandMas] + commandsInArr[controlerForCommandMas + 1] + commandsInArr[controlerForCommandMas + 2];
                controlerForCommandMas += 3;
                if (commandsInArr[controlerForCommandMas + 1].equals(">") || commandsInArr[controlerForCommandMas + 1].equals("|")) {
                    command += commandsInArr[controlerForCommandMas + 1];
                    if (!commandsInArr[controlerForCommandMas + 1].equals(null) && !commandsInArr[controlerForCommandMas + 1].equals(">") && commandsInArr[controlerForCommandMas + 1].equals("|")) {
                        command += commandsInArr[controlerForCommandMas + 2];
                        controlerForCommandMas++;
                    }
                    controlerForCommandMas++;
                    if (commandsInArr[controlerForCommandMas + 2].equals(">") || commandsInArr[controlerForCommandMas + 2].equals("|")) {
                        command += commandsInArr[controlerForCommandMas + 1] + commandsInArr[controlerForCommandMas + 2];
                    }
                }

            }
            cat.commandAction(command);
        }catch (NullPointerException n ){}
    }
}
