package week6;


import java.io.File;
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

    public class CommandCP implements Command {
        private String information = "cp - copies contents from first and insert it in second";
        Path dir = FileSystems.getDefault().getPath("CURRENT_PATH", "access.CURRENT_PATH");

        @Override
        public Object commandAction(String command) throws PrefNoFoundEeption {
            String adress = stringRedactor.takeSecondPart(command);
            String from = stringRedactor.takeFirstPart(adress);
            String to = stringRedactor.takeSecondPart(adress);
            File add = null;

            try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
                for (Path file : stream) {
                    if (file.getFileName().equals(from)){
                        add = file.toFile();
                    }else if (file.getFileName().equals(to)){
                        file = add.toPath();
                    }
                }
            } catch (IOException | DirectoryIteratorException x) {
                System.err.println("Exeption in ls -al ");
            }return "cp make good job";
        }

        public String getInformation() {
            return information;
        }
    }
}
