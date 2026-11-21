
package com.ems.util;

import java.sql.Connection;
import java.sql.SQLException;

public class DBConnectionTest {

    public static void main(String[] args) {

        try (Connection con = DBConnection.getConnection()){
            if (con != null) {
                System.out.println("Database Connected Successfully!");
            }

        } catch (SQLException e) {

            System.out.println("Database Connection Failed!");
            e.printStackTrace();

        }
    }
}
