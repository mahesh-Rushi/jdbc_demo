import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CreateDatabase {
    public static void main(String[] args) throws Exception {

        // 1. Register MySQL Driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 2. Get connection (WITHOUT database)
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "root");

        // 3. Create Statement
        Statement st = con.createStatement();




        // 4. Create Database
        String createDB = "CREATE DATABASE IF NOT EXISTS payal_salunke";
        st.executeUpdate(createDB);
        System.out.println("Database created successfully...");

        // 5. Select database (IMPORTANT)
        st.executeUpdate("USE payal_salunke");

        // 6. Create Table
        String createTable = "CREATE TABLE IF NOT EXISTS emp (" + "id INT PRIMARY KEY," + "name VARCHAR(50)," + "age INT" + ")";

        st.executeUpdate(createTable);
        System.out.println("Table created successfully...");




        // insert data

        String insert="INSERT INTO emp(id,name,age)values(103,'yash',23)";
        st.executeUpdate(insert);
        System.out.println("data inserted.....");


// show data

        ResultSet rs= st.executeQuery("select * from emp");
        while(rs.next()) {
            System.out.println(rs.getInt("id") + " " + rs.getString("name") + " " + rs.getInt("age"));

        }

//        // 7. Close connection
        st.close();
        con.close();
    }
}
