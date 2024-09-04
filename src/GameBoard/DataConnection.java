package GameBoard;

import java.sql.*;

public class DataConnection {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/chessDB",
                    "robes",
                    "eXampLe123_"
            );
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM score_board");

            while (resultSet.next()) {
                System.out.print(resultSet.getString("user_name"));
                System.out.print(": ");
                System.out.println(resultSet.getString("high_score"));
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
}
