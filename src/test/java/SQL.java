import java.sql.*;

public class SQL {

    public static void main(String[] args) throws SQLException {

        String url="jdbc:mysql://localhost:3306/qadbtest";
        String username="root";
        String password="Nsp@sql22";
        Connection conn=DriverManager.getConnection(url,username,password);
        Statement s=conn.createStatement();
        ResultSet rs=s.executeQuery("select * from Credentials where scenario='zerobalancecard'");
        rs.next();
        System.out.println(rs.getString(2));
    }
}
