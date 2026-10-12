
package school;

import java.sql.*;

public class SchoolDB {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/";
        String user = "root";
        String password = "whenI143u";

        try {
            Connection con = DriverManager.getConnection(
                url, user, password
            );

            Statement st = con.createStatement();

            st.executeUpdate(
                "CREATE DATABASE IF NOT EXISTS school"
            );

            st.executeUpdate("USE school");

            st.executeUpdate(
                "CREATE TABLE IF NOT EXISTS student (" +
                "id INT PRIMARY KEY, " +
                "name VARCHAR(50), " +
                "city VARCHAR(50))"
            );

            st.executeUpdate(
                "INSERT IGNORE INTO student VALUES " +
                "(1, 'Anu', 'Bangalore'), " +
                "(2, 'Rahul', 'Mysore'), " +
                "(3, 'Priya', 'Kochi')"
            );

            ResultSet rs = st.executeQuery(
                "SELECT * FROM student"
            );

            System.out.println("ID\tName\tCity");
            System.out.println("-------------------------");

            while (rs.next()) {
                System.out.println(
                    rs.getInt("id") + "\t" +
                    rs.getString("name") + "\t" +
                    rs.getString("city")
                );
            }

            rs.close();
            st.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

