package presencial.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BD {
    private static final String DRIVER="org.h2.Driver";
    private static final String URL="jdbc:h2:~/clase18";
    private static final String USER="sa";
    private static final String PASS="";
    private static final String SQL_CREATE_TABLE_DOMICILIOS="drop table if exists domicilios;" +
            "create table domicilios(" +
            "id int auto_increment primary key, " +
            "calle varchar(100) not null, " +
            "numero int not null, " +
            "localidad varchar(100) not null, " +
            "provincia varchar(100) not null)";

    private static final String SQL_CREATE_TABLE_PACIENTES="drop table if exists pacientes;" +
            "create table pacientes(" +
            "id int auto_increment primary key, " +
            "apellido varchar(100) not null, " +
            "nombre varchar(100) not null, " +
            "dni int not null, " +
            "fecha date not null, " +
            "domicilio_id int not null)";
    public static Connection getConnection() throws Exception{
        Class.forName(DRIVER);
        return DriverManager.getConnection(URL,USER,PASS);
    }
    public static void crearTablas() throws Exception{
        Connection connection=getConnection();
        Statement statement=connection.createStatement();
        statement.execute(SQL_CREATE_TABLE_DOMICILIOS);
        statement.execute(SQL_CREATE_TABLE_PACIENTES);
    }
}
