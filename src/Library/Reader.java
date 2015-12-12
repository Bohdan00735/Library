package Library;

class Reader {
    String name;
    String surname;
    Book[] books = new Book[3];
    int[] id;
    int pin;
    Boolean status;
    int controllerBooks = 0;

    Reader(String name, String surname, int code) {
        this.name = name;
        this.surname = surname;
        this.pin = code;
        id = new int[4];
        String id = " ";
        status = true;
        for (int i = 0; i < this.id.length; i++) {
            int random = (int) (Math.random() * 10);
            this.id[i] = random;
            String add = Integer.toString(this.id[i]);
            id += add;
        }
        System.out.println("Your id =" + id + "remember it");

    }
}
