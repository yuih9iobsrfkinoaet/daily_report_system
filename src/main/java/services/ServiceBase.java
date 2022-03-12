package services;

import javax.persistence.EntityManager;

import utils.DBUtil;

//DB接続に関するクラス
public class ServiceBase {
    //EntityManagerインスタンス
    protected EntityManager em = DBUtil.createEntityManager();

    //EntityManagerのクローズ
    public void close() {
        if(em.isOpen()) {
            em.close();
        }
    }
}
