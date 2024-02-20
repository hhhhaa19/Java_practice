import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王金涛
 * Date: 2024-01-27
 * Time: 21:03
 */
public class JDBC {
    /**
     * 通过source
     * @param args
     * @throws SQLException
     */
    public static void main(String[] args) throws SQLException {
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource) dataSource).setUrl("jdbc:mysql://127.0.0.1:3306/bit?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource) dataSource).setUser("root");
        ((MysqlDataSource) dataSource).setPassword("WJT164673!");
        Connection connection = dataSource.getConnection();

        String sql= "insert into student1 values (NULL,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,"Benjamin");
        int n=statement.executeUpdate();
        System.out.println(n);

        sql= "select * from student1";
        statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while(resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            System.out.println(id+name);
        }
        resultSet.close();
        statement.close();
        connection.close();
    }

}
