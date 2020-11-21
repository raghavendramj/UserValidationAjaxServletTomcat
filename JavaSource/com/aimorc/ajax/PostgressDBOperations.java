package com.aimorc.ajax;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PostgressDBOperations {


    public List<Account> fetchAccounts() {

        List<Account> accounts = new ArrayList<>();
        String sqlQuery = "select * from accounts";

        // variables
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        // Step 1: Loading or registering MySQL JDBC driver class
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException cnfex) {
            System.out.println("Problem in loading MySQL JDBC driver");
            cnfex.printStackTrace();
        }

        // Step 2: Opening database connection
        try {

            // Step 2.A: Create and get connection using DriverManager
            connection = DriverManager.getConnection(
                    DbContract.HOST + DbContract.DB_NAME,
                    DbContract.USERNAME,
                    DbContract.PASSWORD);

            // Step 2.B: Creating JDBC Statement
            statement = connection.createStatement();

            // Step 2.C: Executing SQL & retrieve data into ResultSet
            resultSet = statement.executeQuery(sqlQuery);


            while (resultSet.next()){
                int user_id = resultSet.getInt("user_id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String email = resultSet.getString("email");
                Date created_on = resultSet.getDate("created_on");
                Date last_login = resultSet.getDate("last_login");
                Account account = new Account(user_id, username, password, email, created_on, last_login);
                accounts.add(account);
            }

        } catch (SQLException sqlex) {
            sqlex.printStackTrace();
        } finally {

            // Step 3: Closing database connection
            try {
                if (null != connection) {

                    // cleanup resources, once after processing
                    statement.close();

                    // and then finally close connection
                    connection.close();
                    resultSet.close();
                }
            } catch (SQLException sqlex) {
                sqlex.printStackTrace();
            }
        }

        return accounts;


    }
}
