package dao;

import model.*;

import java.util.List;

public interface JiaoCai {

    int getAdmin(String account, String password);

    Yhmodel getYh(int id);

    List<Shumodel>getShu(String name);

    List<Shumodel>getShu2();

    Shumodel byShu(int id);

    List<GouwuModel> byGouwu(int id);

    void  GaiShuliang(int id,int shuliang);

    int byDd(int id);

    void AddgGouwu(int id,int j_id,int d_id);

    void dd(int zje, String date,int admin,int dd);

    void  Cjdd(int id);

    void deGoods(int id);

    void XiugaiYh(Yhmodel yhmodel);

    List<Ddmodel> ChakanDd(int id);

    List<Shumodel> Chakangwc(int id,int dd);

    void Shouhuo(int y_id,int d_id,int zhuang);

    List<Ddmodel> ChakanDdadmin();

    void Shoucang(int id,int j_id);

    List<Soucang>byshoocang(int y_id);

    int byShouchang(int y_id,int j_id);

    void sShoucang(int y_id,int j_id);

    List<Yhmodel> getallYh();

    void yhCz(int y_id);

    void deYh(int y_id);

}
