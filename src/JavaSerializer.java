import java.io.*;

public class JavaSerializer {
    public static void main(String[] args) {
        User user = new User();
        user.setUserName("testUser");
        user.setPassWord("testPass");
        writeToFile(user);
        System.out.println("Wrote file");
        System.out.println("Reading file");
        User loadedUser = readFromFile();
        System.out.println(loadedUser);
    }

    private static User readFromFile() {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("User.obj"));
            Object o = objectInputStream.readObject();
            return (User) o;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void writeToFile(Serializable s){
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("User.obj"));
            objectOutputStream.writeObject(s);
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
