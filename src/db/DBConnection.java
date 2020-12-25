package db;

import java.sql.*;

public class DBConnection {

    /**
     * 获取数据库连接
     * @throws SQLException
     */
    public Connection getConnection() throws SQLException {
        //注册驱动类
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //获取连接
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jiaocai?seUnicode=true&characterEncoding=UTF-8&allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=Asia/Shanghai&&"
                + "user=root&password=111111");
        return con;
        //执行查询
    }

    public static void main(String[] args) throws SQLException {
        DBConnection db = new DBConnection();
        Connection con = db.getConnection();
        Statement st = con.createStatement();
        ResultSet re = st.executeQuery("select * from fsxx");
        while(re.next()) {
            String name = re.getString("f_name");
            System.out.println("姓名："+name);
        }
        re.close();
        st.close();
        con.close();
    }
}
