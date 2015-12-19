package week6;

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class Characters {
    StringRedactor stringRedactor = new StringRedactor();

    public class RightScope implements Symbol {
        private String information = "> takes the standard output of the command on the left, and redirects it to the file on the right.";


        @Override
        public void makeSymbolAcction(String out, String in) {
            FileReader inputStream = null;
            FileWriter outputStream = null;

            try {
                inputStream = new FileReader(out);
                outputStream = new FileWriter(in);
                outputStream.flush();
                int info;
                while ((info = inputStream.read()) != -1) {
                    outputStream.write(info);
                }
            } catch (IOException ex) {
                System.err.println("Exeption in > ");
            } finally {
                try {
                    inputStream.close();
                    outputStream.close();
                } catch (IOException io) {
                    System.err.println("Exeption in >,finally ");
                }
            }
        }

        public void setInformation(String information) {
            this.information = information;
        }
    }

    public class DoubleRightScope implements Symbol {
        private String information = ">> takes the standard output of the command on the left and appends (adds) it to the file on the right.";

        @Override
        public void makeSymbolAcction(String out, String in) {
            FileReader inputStream = null;
            FileWriter outputStream = null;

            try {
                inputStream = new FileReader(out);
                outputStream = new FileWriter(in);
                int info;
                while ((info = inputStream.read()) != -1) {
                    outputStream.write(info);
                }
            } catch (IOException ex) {
                System.err.println("Exeption in >> ");
            } finally {
                try {
                    inputStream.close();
                    outputStream.close();
                } catch (IOException io) {
                    System.err.println("Exeption in >>,finally ");
                }

            }
        }

        public String getInformation() {
            return information;
        }
    }

    public class LeftScoupe implements Symbol {
        private String information = "< takes the standard input from the file on the right and inputs it into the program on the left.";

        @Override
        public void makeSymbolAcction(String adress, String CURRENT_PATH) {
            Path dir = FileSystems.getDefault().getPath(CURRENT_PATH + adress, "access.CURRENT_PATH");
            File read = dir.toFile();
            String text = read.toString();
            System.out.println(text);
        }
    }

    public class Pipe implements Symbol {
        private String information = "pipe - takes the standard output of the command on the left, and pipes it as standard input to the command on the right. ";

        @Override
        public void makeSymbolAcction(String out, String in) {
            FileReader inputStream = null;
            FileWriter outputStream = null;
            PipedOutputStream pipedOutputStream = null;
            PipedInputStream pipedInputStream = null;

            try {
                inputStream = new FileReader(out);
                outputStream = new FileWriter(in);
                int info;
                while ((info = inputStream.read()) != -1) {
                    pipedOutputStream.write(info);
                }
                pipedInputStream.connect(pipedOutputStream);

            } catch (IOException ex) {
                System.out.println("Exeption IO in pipestream");
            } finally {

                try {
                    inputStream.close();
                    outputStream.close();
                } catch (IOException io) {
                    System.err.println("Exeption in pipe,finally ");
                }
            }
        }
    }
}
