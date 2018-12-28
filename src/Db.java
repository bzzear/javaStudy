import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Db {
    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://192.168.11.7:13306/fz_textbook";
    private static String user = "root";
    private static String pwd = "123456";
    private static Connection conn = null;
    private static Statement stmt = null;

    //构造方法
    public static void  Db(){
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url, user, pwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void statement() {
        if (conn ==null) {
            Db();
        }
        try {
            stmt = (Statement) conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static ResultSet resultSet(String sql) {
        ResultSet rs = null;
        if (stmt == null) {
            statement();
        }
        try {
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    private static List<HashMap<String, String>> result(String sql) {
        ResultSet rs = Db.resultSet(sql);
        List<HashMap<String, String>> result = new ArrayList<HashMap<String, String>>();
        try {
            ResultSetMetaData md = rs.getMetaData();
            int cc = md.getColumnCount();
            while (rs.next()) {
                HashMap<String, String> columnMap = new HashMap<String, String>();
                for (int i = 1; i <= cc; i++) {
                    columnMap.put(md.getColumnName(i), rs.getString(i));
                }
                result.add(columnMap);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static synchronized void close() {
        try {
            if (stmt != null) {
                stmt.close();
                stmt = null;
            }
            if (conn != null) {
                conn.close();
                conn = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            if (conn == null) {
                Db();
            }
            System.out.println(conn);
            stmt = conn.createStatement();
            ResultSet rs = ((Statement) stmt).executeQuery("select * from t_textbook");
            while(rs.next()){
                // 通过字段检索
                int id  = rs.getInt("id");
                String name = rs.getString("fullName");
                String url = rs.getString("PicOriginUrl");

                // 输出数据
                System.out.print("ID: " + id);
                System.out.print(", 站点名称: " + name);
                System.out.print(", 站点 URL: " + url);
                System.out.print("\n");
            }
            // 完成后关闭
            rs.close();
            stmt.close();
            conn.close();



        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
