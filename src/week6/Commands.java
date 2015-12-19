package week6;


import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.*;

public class Commands extends StringRedactor {
    private static final String HOME_DIR_PATH = "/c/Users/Bogdan/IdeaProjects/OOP/src/week6";
    private String CURRENT_PATH = HOME_DIR_PATH;
    StringRedactor stringRedactor = new StringRedactor();


    public class CommandPWD implements Command {

        private String information = " pwd - take path where you now";

        @Override
        public Object commandAction(String oldPath) throws PrefNoFoundEeption {
            return CURRENT_PATH;
        }

        public String getInformation() {
            return information;
        }
    }

    public class CommandCD implements Command {
        private String information = "cd - change directory";

        @Override
        public Object commandAction(String command) throws PrefNoFoundEeption {
            return CURRENT_PATH = stringRedactor.takePref(command);
        }

        public String getInformation() {
            return information;
        }
    }

    public class CommandLS implements Command {
        private final String prefAL = "al";
        private String information = "ls - take files and directories in current directory";
        private String pref;
        Path dir = FileSystems.getDefault().getPath("CURRENT_PATH", "access.CURRENT_PATH");

        @Override
        public Object commandAction(String commandls) throws PrefNoFoundEeption {
            pref = StringRedactor.takePref(commandls);

            try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
                for (Path file : stream) {
                    if (pref.equals(prefAL)) {
                        System.out.println(file.getFileName() + file.getFileSystem().toString());
                    } else {
                        System.out.println(file.getFileName());
                    }
                }
            } catch (IOException | DirectoryIteratorException x) {
                System.err.println("Exeption in ls -al ");
            }
            return "ls make good job";
        }

        public String getInformation() {
            return information;
        }
    }

    public class CommandCP extends Characters implements Command {
        private String information = "cp - copies contents from first and insert it in second";

        @Override
        public Object commandAction(String command) throws PrefNoFoundEeption {
            String adress = stringRedactor.takeSecondPart(command);
            String from = stringRedactor.takeFirstPart(adress);
            String to = stringRedactor.takeSecondPart(adress);
            Characters.DoubleRightScope doubleRightScope = new Characters.DoubleRightScope();
            doubleRightScope.makeSymbolAcction(from , to);
            return "cp make good job";
        }

        public String getInformation() {
            return information;
        }
    }

    public class CommandMV implements Command {
        private String information = "mv - moves files";


        @Override
        public Object commandAction(String command) throws PrefNoFoundEeption {
            String adress = stringRedactor.takeSecondPart(command);
            String from = stringRedactor.takeFirstPart(adress);
            String to = stringRedactor.takeSecondPart(adress);
            FileReader inputStream = null;
            FileWriter outputStream = null;

            try {
                inputStream = new FileReader(from);
                outputStream = new FileWriter(to);
                int info;
                while ((info = inputStream.read()) != -1) {
                    outputStream.write(info);
                }
                inputStream = null;
            } catch (IOException ex) {
                System.err.println("Exeption in mv ");
            } finally {
                try {
                    inputStream.close();
                    outputStream.close();
                } catch (IOException io) {
                    System.err.println("Exeption in mv,finally ");
                }

            }
            return "mv make good job";
        }

        public String getInformation() {
            return information;
        }
    }

    public class CommandRM implements Command {
        private String information = "rm - deletes files and directories";

        @Override
        public Object commandAction(String command) throws PrefNoFoundEeption {
            String adress = stringRedactor.takeSecondPart(command);
            FileReader inputStream = null;

            try {
                inputStream = new FileReader(adress);
                inputStream = null;
            } catch (IOException ex) {
                System.err.println("Exeption in rm ");
            } finally {
                try {
                    inputStream.close();
                } catch (IOException io) {
                    System.err.println("Exeption in rm,finally ");
                }

            }
            return "rm make good job";
        }

        public String getInformation() {
            return information;
        }
    }

    public class CommandTOUCH implements Command {
        private String information = "touch - add new file";

        @Override
        public Object commandAction(String command) throws PrefNoFoundEeption {
            String adress = stringRedactor.takeSecondPart(command);
            FileWriter outputStream = null;

            try {
                File file = new File(adress);
                outputStream = new FileWriter(file);
            } catch (IOException ex) {
                System.err.println("Exeption in touch ");
            } finally {
                try {
                    outputStream.close();
                } catch (IOException io) {
                    System.err.println("Exeption in touch,finally ");
                }

            }
            return "touch add new file " + adress;
        }

        public String getInformation() {
            return information;
        }
    }

    public class CommandMKDIR implements Command {
        private String information = "mkdir - add new directory";
        Path dir = FileSystems.getDefault().getPath("CURRENT_PATH", "access.CURRENT_PATH");


        @Override
        public Object commandAction(String command) throws PrefNoFoundEeption {
            String adress = stringRedactor.takeSecondPart(command);

                File file = new File(CURRENT_PATH + adress);
                file.mkdirs();
            return "touch add new file " + adress;
        }

        public String getInformation() {
            return information;
        }
    }

    public class CommandHEAD implements Command{
        private String information = "head - show ten first files ";

        @Override
        public Object commandAction(String command) throws PrefNoFoundEeption {
            String adress = stringRedactor.takeSecondPart(command);
            Path dir = FileSystems.getDefault().getPath(CURRENT_PATH + adress, "access.CURRENT_PATH");
            File read = dir.toFile();
            String text = read.toString();
            String[] textInMas = stringRedactor.dividedIntoParts(text);
            for (int i = 0; i < 9; i++) {
                System.out.println(textInMas[i]);
            }
            return "head command end with work";

        }

        public String getInformation() {
            return information;
        }
    }

    public class CommandTAIL implements Command{
        private String information = "head - show ten first files ";

        @Override
        public Object commandAction(String command) throws PrefNoFoundEeption {
            String adress = stringRedactor.takeSecondPart(command);
            Path dir = FileSystems.getDefault().getPath(CURRENT_PATH + adress, "access.CURRENT_PATH");
            File read = dir.toFile();
            String text = read.toString();
            String[] textInMas = stringRedactor.dividedIntoParts(text);
            for (int i = textInMas.length; i <= textInMas.length - 10; i--) {
                System.out.println(textInMas[i]);
            }
            return "head command end with work";
        }

        public String getInformation() {
            return information;
        }
    }

    public class CommandCAT extends Characters implements Command{
        private String information = " cat command outputs the contents of a file to the terminal.";


        @Override
        public Object commandAction(String command)  throws PrefNoFoundEeption  {
            Characters.Pipe pipe = new Characters.Pipe();
            LeftScoupe leftScoupe = new LeftScoupe();
            RightScope rightScope = new RightScope();
            DoubleRightScope doubleRightScope = new DoubleRightScope();
            String commandForAcction = stringRedactor.takeSecondPart(command);
            String[] arr = stringRedactor.dividedIntoParts(commandForAcction);

            if (arr[2].equals("|") && arr[2].equals(">") && arr[2].equals(">>")){

            }

            return "cat finish work";
        }

        public String getInformation() {
            return information;
        }
    }

    public class CommandHELP implements Command{
        private String information = "help - print information about command in this console";
        CommandLS commandLS = new CommandLS();
        CommandPWD commandPWD = new CommandPWD();
        CommandTAIL commandTAIL = new CommandTAIL();
        CommandHEAD commandHEAD = new CommandHEAD();
        CommandCAT commandCAT = new CommandCAT();
        CommandCD commandCD = new CommandCD();
        CommandCP commandCP = new CommandCP();
        CommandMKDIR commandMKDIR = new CommandMKDIR();
        CommandTOUCH commandTOUCH = new CommandTOUCH();
        CommandMV commandMV = new CommandMV();
        CommandRM commandRM = new CommandRM();

        @Override
        public Object commandAction(String command) throws PrefNoFoundEeption {
            System.out.println( information+commandCAT.getInformation() + commandCD.getInformation() + commandCP.getInformation() + commandHEAD.getInformation() + commandLS.getInformation() +
                    commandMKDIR.getInformation() + commandMV.getInformation() + commandPWD.getInformation() + commandRM.getInformation() + commandTAIL.getInformation() + commandTOUCH.getInformation() );

            return " help help you ";
        }
    }
}
