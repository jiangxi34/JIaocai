package dao;

import db.DBConnection;
import model.GouwuModel;
import model.Shumodel;
import model.Yhmodel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JiaoCaiImpl implements JiaoCai{

    @Override
    public int getAdmin(String account, String password) {
        try {
            int admin = 0;
            DBConnection db = new DBConnection();
            Connection con = db.getConnection();
            PreparedStatement pst = con.prepareStatement("select y_id from yh where y_name=? && mm=?");
            pst.setString(1, account);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                admin = (rs.getInt("y_id"));
                rs.close();
                pst.close();
                con.close();
                return admin;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Yhmodel getYh(int id) {
        try {
            DBConnection db = new DBConnection();
            Connection con = db.getConnection();
            PreparedStatement pst = con.prepareStatement("SELECT * FROM yh where y_id = ?");
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            Yhmodel yhmodel = new Yhmodel();
            if (rs.next()) {
               yhmodel.setId(rs.getInt("y_id"));
               yhmodel.setName(rs.getString("y_name"));
               yhmodel.setMm(rs.getString("mm"));
               yhmodel.setSjh(rs.getString("sjh"));
               yhmodel.setSex(rs.getInt("sex"));
               yhmodel.setSh(rs.getString("sh"));
               yhmodel.setZhye(rs.getInt("zhye"));
            }
            pst.close();
            con.close();
            return yhmodel;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Shumodel> getShu() {
        try {
            DBConnection db = new DBConnection();
            Connection con = db.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM  jiaocai ");
            //获取数据库连接
            //执行查询
            //处理结果集
            List<Shumodel> shumodels = new ArrayList<Shumodel>();
            while (rs.next()) {
                //将行数据加入通讯录封装类
                Shumodel shumodel = new Shumodel();
                shumodel.setId(rs.getInt("j_id"));
                shumodel.setJ_name(rs.getString("j_name"));
                shumodel.setLb(rs.getString("lb"));
                shumodel.setJs(rs.getString("js"));
                shumodel.setTp(rs.getString("tp"));
                shumodel.setJg(rs.getInt("jg"));
                shumodels.add(shumodel); //将对象加入列表
            }
            // 关闭连接，释放资源
            rs.close();
            st.close();
            con.close();
            return shumodels;  //返回全部通讯录

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Shumodel byShu(int id) {

        try {
            DBConnection db = new DBConnection();
            Connection con = db.getConnection();
            PreparedStatement pst = con.prepareStatement("SELECT * FROM  jiaocai where j_id = ? ");
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            List<Shumodel> shumodels = new ArrayList<Shumodel>();
            if (rs.next()) {
                Shumodel shumodel = new Shumodel();
                shumodel.setId(rs.getInt("j_id"));
                shumodel.setJ_name(rs.getString("j_name"));
                shumodel.setLb(rs.getString("lb"));
                shumodel.setJs(rs.getString("js"));
                shumodel.setTp(rs.getString("tp"));
                shumodel.setJg(rs.getInt("jg"));
                pst.close();
                con.close();
                return shumodel;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public List<GouwuModel> byGouwu(int id) {
        try {
            DBConnection db = new DBConnection();
            Connection con = db.getConnection();
            PreparedStatement pst = con.prepareStatement("SELECT * FROM jiaocai JOIN gwc on jiaocai.j_id=gwc.j_id where gwc.y_id = ?");
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            List<GouwuModel> gouwuModels = new ArrayList<GouwuModel>();
            while (rs.next()) {
                GouwuModel gouwuModel = new GouwuModel();
                gouwuModel.setId(rs.getInt("j_id"));
                gouwuModel.setJ_name(rs.getString("j_name"));
                gouwuModel.setLb(rs.getString("lb"));
                gouwuModel.setJs(rs.getString("js"));
                gouwuModel.setTp(rs.getString("tp"));
                gouwuModel.setJg(rs.getInt("jg"));
                gouwuModel.setG_id(rs.getInt("g_id"));
                gouwuModel.setY_id(rs.getInt("y_id"));
                gouwuModel.setD_id(rs.getInt("d_id"));
                gouwuModel.setSl(rs.getInt("sl"));
                gouwuModels.add(gouwuModel);
            }
            pst.close();
            con.close();
            return  gouwuModels;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void GaiShuliang(int id, int shuliang) {
        try {
            // 获取连接
            DBConnection db = new DBConnection();
            Connection con = db.getConnection();
            // 执行SQL语句
            PreparedStatement pst = con.prepareStatement("UPDATE gwc set sl=? WHERE g_id =?");
            pst.setInt(1,shuliang);
            pst.setInt(2,id);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public int byDd(int id) {
        try {
            DBConnection db = new DBConnection();
            Connection con = db.getConnection();
            PreparedStatement pst = con.prepareStatement("SELECT d_id FROM dd where y_id= ? and zt =0");
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            int d_id = 0;
            if (rs.next()) {
                d_id = rs.getInt("d_id");
            }
            pst.close();
            con.close();
            return d_id;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    @Override
    public void AddgGouwu(int id, int j_id, int d_id) {
        try {
            // 获取连接
            DBConnection db = new DBConnection();
            Connection con = db.getConnection();
            // 执行SQL语句
            PreparedStatement pst = con.prepareStatement("insert into gwc(y_id ,j_id,d_id,sl) values(?,?,?,?)");
            pst.setInt(1,id);
            pst.setInt(2,j_id);
            pst.setInt(3,d_id);
            pst.setInt(4,1);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
