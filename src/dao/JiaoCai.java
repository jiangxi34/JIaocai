package dao;

import model.GouwuModel;
import model.Shumodel;
import model.Yhmodel;

import java.util.List;

public interface JiaoCai {

    int getAdmin(String account, String password);

    Yhmodel getYh(int id);

    List<Shumodel>getShu();

    Shumodel byShu(int id);

    List<GouwuModel> byGouwu(int id);

    void  GaiShuliang(int id,int shuliang);

    int byDd(int id);

    void AddgGouwu(int id,int j_id,int d_id);

}
