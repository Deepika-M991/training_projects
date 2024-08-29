import java.sql.Connection;
import  java.sql.DriverManager;
import  java.sql.SQLException;

public class jdbc {

    public static void main(String[] args) throws ClassNotFoundException {

        String databaseURL=("jdbc:mysql://localhost:3306/company");
        String user="root";
        String password="Qwerty@2024";
        Connection con=null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(databaseURL, user, password);
            if(con!=null){
                System.out.println("connection established successfully");

            }
        }catch(SQLException ex){
            System.out.println("Connection error occurred");
            ex.printStackTrace();
        }



    }
}
