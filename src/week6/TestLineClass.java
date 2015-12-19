package week6;


public class TestLineClass {
    public static void main(String[] args) {
        Distributor distributor = new Distributor();
        try {
            distributor.startIdentifity();
        }catch ( CommandNotFoundExeption exeption){
            System.out.println("Command not found");
        }
    }


}
