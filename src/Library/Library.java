package Library;

public class Library {
    Book[] books = new Book[100];
    Reader[] readers = new Reader[10];
    Reader[] blackList = new Reader[10];
    int controlBook = 0;
    int controlReaders = 0;
    int controlBlackList = 0;
    private int pinLibrarian = 5271;


    public void addBook(String name, String avtor, int year) {
        if (controlBook >= books.length) {
            Book[] books = new Book[this.books.length + 1];
            for (int i = 0; i < this.books.length; i++) {
                for (int j = 0; j < books.length; j++) {
                    books[j] = this.books[i];
                }
                books = this.books;
            }
        }
        Book book = new Book(name, avtor, year);
        books[controlBook] = book;
        controlBook++;
    }


    public int[] createAndAddReader(String name, String surname, int pin) {
        Reader reader = new Reader(name, surname, pin);
        if (controlReaders >= this.readers.length) {
            Reader[] readers = new Reader[this.readers.length + 1];
            for (int i = 0; i < this.readers.length; i++) {
                for (int j = 0; j < readers.length; j++) {
                    readers[j] = this.readers[i];
                }
                readers = this.readers;
            }
        }
        readers[controlReaders] = reader;
        controlReaders++;
        return reader.id;
    }


    public void seeAllReaders(int pin) {
        if (pin != this.pinLibrarian) {
            System.err.println("You do not have access");
        } else {
            System.out.println("Hello Librarian.  ");
            for (int i = 0; i < controlReaders ; i++) {

                System.out.println(readers[i].name +" " + readers[i].surname);

            }

        }
    }

    public void seeFreeBooks() {
        for (int i = 0; i < controlBook; i++) {
            if (books[i].status.equals(true)) {
                System.out.println(books[i].avtor + " " + books[i].name + " " + books[i].year);
            }
        }
    }


    public void addToBlackList(int pin, int[] id) {
        if (pin != this.pinLibrarian) {
            System.err.println("You do not have access");
        } else {
            Reader reader = findReader(id);
            if (reader == null) {
                System.err.println("sorry, can`t find reader");
            } else {
                blackList[controlBlackList] = reader;
            }
        }
    }

    private Reader findReader(int[] id) {
        int control = 0;
        for (int i = 0; i < controlReaders; i++) {
            for (int j = 0; j < id.length; j++) {
                for (int k = 0; k < readers[i].id.length; k++) {
                    if (readers[i].id[k] == id[j]) {
                        control++;
                    }
                    if (control == 4) {
                        return readers[i];
                    }
                }
            }
            control = 0;
        }
        return null;
    }

    public Book findBook(String name, String avtor) {
        for (int i = 0; i < controlBook; i++) {
            if (books[i].name.equals(name)) {
                if (books[i].avtor.equals(avtor)) {
                    return books[i];
                }
            }
        }
        return null;
    }


    public void takeABok(String name, String avtor, int[] id, int pin) {
        Reader reader = findReader(id);
        int maxOfBooksForRader = 2;
        if (pin == reader.pin) {
            if (reader.controllerBooks >= maxOfBooksForRader) {
                System.err.println("You can`t take more books");
            } else {
                if (reader.status.equals(false)) {
                    System.err.println("You in black list");
                } else {
                    Book book = findBook(name, avtor);
                    if (book != null) {
                        if (book.status.equals(true)) {
                            reader.books[reader.controllerBooks] = book;
                            book.status = false;
                            reader.controllerBooks++;

                        } else {
                            System.err.println("on that time we haven`t this book, sorry");
                        }
                    }else{
                        System.out.println("we haven`t this book");
                    }
                }
            }

        } else {
            System.err.println("invalid password");
        }
    }


    public void seeBooksOnReders(int pin) {
        if (pinLibrarian == pin) {
            for (int i = 0; i < controlBook; i++) {
                if (books[i].status.equals(false)) {
                    System.out.println(books[i].name);
                }
            }

        } else {
            System.err.println("you do not have access");
        }
    }

    public void seeMyBooks(int[] id, int pin) {
        Reader reader = findReader(id);
        if (reader == null) {
            System.err.println("incorrect id");
        } else {
            if (pin == reader.pin || pin == pinLibrarian) {
                for (int i = 0; i < reader.controllerBooks; i++) {
                    System.out.println(reader.books[i]);
                }
            } else {
                System.err.println("invalid password");
            }
        }
    }

    public void seeBooksOfAvtur(String avtor) {
        for (int i = 0; i < controlBook; i++) {
            if (books[i].avtor.equals(avtor)) {
                System.out.println(books[i].name + books[i].avtor);
            }

        }
    }

    public void seeNewBooks() {
        for (int i = 0; i < controlBook; i++) {
            if (books[i].year >= 2013) {
                System.out.println(books[i].name +" "+ books[i].avtor +" "+ books[i].year);
            }

        }
    }


}
