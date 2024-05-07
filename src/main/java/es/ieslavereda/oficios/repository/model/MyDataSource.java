package es.ieslavereda.oficios.repository.model;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class MyDataSource {
    @Bean(name = "mysqlDataSource")
    public static DataSource getMySQLDataSource(){
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL("jdbc:mysql://localhost:3306/java");
        dataSource.setUser("jsantamariap");
        dataSource.setPassword("1111");
        return dataSource;
    }
}
