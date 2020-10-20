package example.zhongxiong.myapplication;

import android.app.Application;
import android.content.Context;

/**
 * Created by zhongxiong on 2020/10/20.
 * Description：
 */
public class MyApplication extends Application {
    public static DataBaseDao mDataBaseDao;

    public static  Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = MyApplication.this;
        mDataBaseDao = new DataBaseDao(this);
    }

    public static DataBaseDao getIntence(){
        if (mDataBaseDao == null) {
            synchronized (DataBaseDao.class) {
                if (mDataBaseDao == null) {
                    mDataBaseDao = new DataBaseDao(context);
                }
            }
        }
        return mDataBaseDao;
    }
}
