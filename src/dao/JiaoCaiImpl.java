package dao;

import db.DBConnection;
import model.*;

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
               yhmodel.setSex(rs.getString("sex"));
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
    public List<Shumodel> getShu(String name) {
        try {

            DBConnection db = new DBConnection();
            Connection con = db.getConnection();
            Statement st = con.createStatement();
            //获取数据库连接
            //执行查询
            //处理结果集
            PreparedStatement pst = con.prepareStatement("SELECT * FROM  jiaocai where j_name like ? or lb = ?");
            pst.setString(1, "%"+name+"%");
            pst.setString(2, name);
            ResultSet rs = pst.executeQuery();
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
    public List<Shumodel> getShu2() {
            try {

                DBConnection db = new DBConnection();
                Connection con = db.getConnection();
                Statement st = con.createStatement();
                //获取数据库连接
                //执行查询
                //处理结果集
                PreparedStatement pst = con.prepareStatement("SELECT * FROM  jiaocai");
                ResultSet rs = pst.executeQuery();
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
            PreparedStatement pst = con.prepareStatement("SELECT * FROM jiaocai JOIN gwc on jiaocai.j_id=gwc.j_id JOIN dd on dd.d_id=gwc.d_id where gwc.y_id = ? AND dd.zt=0");
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

    @Override
    public void dd(int zje, String date, int admin ,int d_id) {
        try {
            // 获取连接
            DBConnection db = new DBConnection();
            Connection con = db.getConnection();
            // 执行SQL语句
            PreparedStatement pst = con.prepareStatement("UPDATE dd set zje=?,zt=?,sj=? WHERE y_id =? and d_id=?");
            pst.setInt(1,zje);
            pst.setInt(2,1);
            pst.setString(3,date);
            pst.setInt(4,admin);
            pst.setInt(5,d_id);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void Cjdd(int id) {

        try {
            // 获取连接
            DBConnection db = new DBConnection();
            Connection con = db.getConnection();
            // 执行SQL语句
            PreparedStatement pst = con.prepareStatement("insert into dd(y_id,zje,zt) values(?,?,?)");
            pst.setInt(1,id);
            pst.setInt(2,0);
            pst.setInt(3,0);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deGoods(int id) {
        try {
            DBConnection db = new DBConnection();
            Connection con = db.getConnection();
            PreparedStatement pst = con.prepareStatement("delete from gwc where g_id=? ");
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void XiugaiYh(Yhmodel yhmodel) {
        try {
            // 获取连接
            DBConnection db = new DBConnection();
            Connection con = db.getConnection();
            // 执行SQL语句
            PreparedStatement pst = con.prepareStatement("UPDATE yh set y_name=?,mm=?,sex=?,sh=?,sjh=?,zhye=? WHERE y_id =?");
            pst.setString(1,yhmodel.getName());
            pst.setString(2,yhmodel.getMm());
            pst.setString(3,yhmodel.getSex());
            pst.setString(4,yhmodel.getSh());
            pst.setString(5,yhmodel.getSjh());
            pst.setInt(6,yhmodel.getZhye());
            pst.setInt(7,yhmodel.getId());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Ddmodel> ChakanDd(int id) {
        try {
            DBConnection db = new DBConnection();
            Connection con = db.getConnection();
            PreparedStatement pst = con.prepareStatement("SELECT * FROM dd  where y_id=? and zt!=0");
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            List<Ddmodel> ddmodels = new ArrayList<Ddmodel>();
            while (rs.next()) {
                Ddmodel ddmodel = new Ddmodel();
                ddmodel.setD_id(rs.getInt("d_id"));
                ddmodel.setY_id(rs.getInt("y_id"));
                ddmodel.setDate(rs.getString("sj"));
                ddmodel.setZje(rs.getInt("zje"));
                ddmodel.setZt(rs.getInt("zt"));
                ddmodels.add(ddmodel);
            }
            pst.close();
            con.close();
            return  ddmodels;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Shumodel> Chakangwc(int id, int dd) {
        try {
            DBConnection db = new DBConnection();
            Connection con = db.getConnection();
            Statement st = con.createStatement();

            PreparedStatement pst = con.prepareStatement("SELECT sl,j_name,jg FROM gwc JOIN jiaocai on gwc.j_id=jiaocai.j_id where gwc.d_id= ? and gwc.y_id=?");
            pst.setInt(1, dd);
            pst.setInt(2, id);
            ResultSet rs = pst.executeQuery();
            List<Shumodel> shumodels = new ArrayList<Shumodel>();
            while (rs.next()) {
                //将行数据加入通讯录封装类
                Shumodel shumodel = new Shumodel();
                shumodel.setId(rs.getInt("sl"));
                shumodel.setJ_name(rs.getString("j_name"));
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
    public void Shouhuo(int y_id,int d_id,int zhuang) {

        try {
            // 获取连接
            DBConnection db = new DBConnection();
            Connection con = db.getConnection();
            // 执行SQL语句
            PreparedStatement pst = con.prepareStatement("UPDATE dd set zt=? WHERE y_id =? and d_id=?");
            pst.setInt(1,zhuang);
            pst.setInt(2,y_id);
            pst.setInt(3,d_id);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public List<Ddmodel> ChakanDdadmin() {
        try {
            DBConnection db = new DBConnection();
            Connection con = db.getConnection();
            PreparedStatement pst = con.prepareStatement("SELECT * FROM dd  where zt=1");
            ResultSet rs = pst.executeQuery();
            List<Ddmodel> ddmodels = new ArrayList<Ddmodel>();
            while (rs.next()) {
                Ddmodel ddmodel = new Ddmodel();
                ddmodel.setD_id(rs.getInt("d_id"));
                ddmodel.setY_id(rs.getInt("y_id"));
                ddmodel.setDate(rs.getString("sj"));
                ddmodel.setZje(rs.getInt("zje"));
                ddmodel.setZt(rs.getInt("zt"));
                ddmodels.add(ddmodel);
            }
            pst.close();
            con.close();
            return  ddmodels;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void Shoucang(int id, int j_id) {
        try {
            // 获取连接
            DBConnection db = new DBConnection();
            Connection con = db.getConnection();
            // 执行SQL语句
            PreparedStatement pst = con.prepareStatement("insert into sc(y_id,j_id) values(?,?)");
            pst.setInt(1,id);
            pst.setInt(2,j_id);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Soucang> byshoocang(int y_id) {
        try {
            DBConnection db = new DBConnection();
            Connection con = db.getConnection();
            PreparedStatement pst = con.prepareStatement("SELECT * FROM sc  where y_id=?");
            pst.setInt(1,y_id);
            ResultSet rs = pst.executeQuery();
            List<Soucang> soucangs = new ArrayList<Soucang>();
            while (rs.next()) {
               Soucang soucang=new Soucang();
                soucang.setS_id(rs.getInt("s_id"));
                soucang.setY_id(rs.getInt("y_id"));
                soucang.setJ_id(rs.getInt("j_id"));
               soucangs.add(soucang);
            }
            pst.close();
            con.close();
            return soucangs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int byShouchang(int y_id, int j_id) {
        try {
            DBConnection db = new DBConnection();
            Connection con = db.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from sc where y_id=? and j_id = ?");
            pst.setInt(1, y_id);
            pst.setInt(2, j_id);
            ResultSet rs = pst.executeQuery();
            if (rs.next())
            {
                pst.close();
                con.close();
                return 1;
            }
            pst.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void sShoucang(int y_id, int j_id) {
        try {
            DBConnection db = new DBConnection();
            Connection con = db.getConnection();
            PreparedStatement pst = con.prepareStatement("delete from sc where y_id=? and j_id = ?");
            pst.setInt(1, y_id);
            pst.setInt(2, j_id);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Yhmodel> getallYh() {
        try {
            DBConnection db = new DBConnection();
            Connection con = db.getConnection();
            PreparedStatement pst = con.prepareStatement("SELECT * FROM yh ");
            ResultSet rs = pst.executeQuery();
            List<Yhmodel> yhmodels = new ArrayList<Yhmodel>();
            while (rs.next()) {
                Yhmodel yhmodel=new Yhmodel();
                yhmodel.setId(rs.getInt("y_id"));
                yhmodel.setName(rs.getString("y_name"));
                yhmodel.setMm(rs.getString("mm"));
                yhmodel.setSjh(rs.getString("sjh"));
                yhmodel.setSex(rs.getString("sex"));
                yhmodel.setSh(rs.getString("sh"));
                yhmodel.setZhye(rs.getInt("zhye"));
                yhmodels.add(yhmodel);
            }
            pst.close();
            con.close();
            return yhmodels;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void yhCz(int y_id) {
        try {
            // 获取连接
            DBConnection db = new DBConnection();
            Connection con = db.getConnection();
            // 执行SQL语句
            PreparedStatement pst = con.prepareStatement("UPDATE yh set mm=? WHERE y_id =?");
            pst.setString(1,"123456");
            pst.setInt(2,y_id);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deYh(int y_id) {
        try {
            DBConnection db = new DBConnection();
            Connection con = db.getConnection();
            PreparedStatement pst = con.prepareStatement("delete from yh where y_id=?");
            pst.setInt(1, y_id);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
