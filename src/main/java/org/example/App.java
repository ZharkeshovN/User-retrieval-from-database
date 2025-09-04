package org.example;

import java.sql.*;
import java.util.Scanner;

public class App 
{
    private static Connection connect() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://db:5432/usersdb", "app", "app");
    }

    public static void main(String[] args) {
        System.out.println("User Lookup, type 'exit' to quit");
        try (Scanner in = new Scanner(System.in); Connection conn = connect()) {
            final String sql = "SELECT id, firstName, lastName, email, role FROM users WHERE lower(firstName)=lower(?) AND lower(lastname)=lower(?)";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                while (true) {
                    System.out.print("Enter the firstName: ");
                    String firstName = in.nextLine().trim();
                    System.out.print("Enter the lastName: ");
                    String lastName = in.nextLine().trim();
                    if ((firstName).equalsIgnoreCase("exit") || (lastName).equalsIgnoreCase("exit") ) break;
                    if (firstName.isBlank() || lastName.isBlank()){
                        System.out.println("Fields must not be empty!");
                        continue;
                    }

                    ps.setString(1, firstName);
                    ps.setString(2, lastName);
                    try (ResultSet rs = ps.executeQuery()) {
                        if (rs.next()) {
                            System.out.printf(
                                    "\nID: %d%nFirst Name: %s%nLast Name: %s%nEmail: %s%nRole: %s%n%n",
                                    rs.getLong("id"),
                                    rs.getString("firstName"),
                                    rs.getString("lastName"),
                                    rs.getString("email"),
                                    rs.getString("role"));
                        } else {
                            System.out.println("No user found.\n");
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
        System.out.println("Bye.");
    }
}
