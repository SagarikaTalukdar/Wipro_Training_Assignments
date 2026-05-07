package SDET_Day12;

import java.io.*;

class Student implements Serializable {
    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

public class Serialization {
    public static void main(String[] args) {
        try {
            Student s1 = new Student(101, "Gourav");

            // Serialization
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("student.txt"));
            oos.writeObject(s1);
            oos.close();

            // De-serialization
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("student.txt"));
            Student s2 = (Student) ois.readObject();
            ois.close();

            System.out.println(s2.id + " " + s2.name);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}