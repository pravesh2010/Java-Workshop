package com.mphasis.assignment.serialization;

import java.io.*;
import java.util.Random;

/*
 *  implementing Externalization and override implemented methos
 */
public class ExternalizationExample implements Externalizable {
    private int bookId;
    private String isbn;
    private String title;
    private String publisher;
    private String author;

    public ExternalizationExample() {

    }

    public ExternalizationExample(int bookId, String isbn, String title, String publisher, String author) {
        this.bookId = bookId;
        this.isbn = isbn;
        this.title = title;
        this.publisher = publisher;
        this.author = author;
    }



    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(getBookId());
        out.writeObject(getIsbn());
        out.writeObject(getTitle());
        out.writeObject(getPublisher());
        out.writeObject(getAuthor());
    }
    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        setBookId(in.readInt());
        setIsbn(in.readObject().toString());
        setTitle(in.readObject().toString());
        setPublisher(in.readObject().toString());
        setAuthor(in.readObject().toString());
    }

    @Override
    public String toString() {
        return "Book [bookId=" + bookId + ", isbn="
                + isbn + ", title=" + title + ", publisher="
                + publisher + ", author=" + author + "]";
    }

    public static final String FILE_PATH ="D://Java//Serialization Path//library.sz";

    public static void main(String[] args) throws Exception{

        Random rand = new Random();

        ExternalizationExample b1 = new ExternalizationExample(rand.nextInt(100),
                "123-456-789", "Graph Theory", "PHI", "ND");
        FileOutputStream fileOut =
                new FileOutputStream(FILE_PATH);
        ObjectOutputStream objOut =
                new ObjectOutputStream(fileOut);
        b1.writeExternal(objOut);

        objOut.flush();
        fileOut.close();

        FileInputStream fileIn =
                new FileInputStream(FILE_PATH);
        ObjectInputStream objIn =
                new ObjectInputStream(fileIn);
        ExternalizationExample b2 = new ExternalizationExample();
        b2.readExternal(objIn);
        objIn.close();

        System.out.println(b2);
    }


}


