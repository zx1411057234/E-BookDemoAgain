package example.zhongxiong.myapplication;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by : xiaoyehai
 * Create date : 2019/9/11 20:39
 * description : 数据库操作类
 */
public class DataBaseDao {

    private final MyDbHelper mDbHelper;


    public DataBaseDao(Context context) {
        //实例化数据库管理类
        mDbHelper = new MyDbHelper(context);
    }

    /**
     * 插入
     *
     * @param list
     */
    public void insert(List<PersonBean> list) {
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        if (db.isOpen()) {
            for (int i = 0; i < list.size(); i++) {
                db.execSQL("insert into person(name) values(" + "'" + list.get(i).getName() + "'" + ")");
            }
            db.close();
        }
    }

    /**
     * 更新
     *
     * @param id
     * @param personBean
     */
    public void update(int id, PersonBean personBean) {
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        if (db.isOpen()) {
            db.execSQL("update person set name=? where _id=?", new Object[]{personBean.getName(), id});
            db.close();
        }
    }

    /**
     * 根据id删除
     */
    public void delete(int id) {
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        if (db.isOpen()) {
            db.execSQL("delete from person where _id=?", new Object[]{id});
            db.close();
        }
    }

    /**
     * 删除所有
     */
    public void deleteAll() {
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        if (db.isOpen()) {
            db.execSQL("delete from person");
            //设置id从1开始（sqlite默认id从1开始），若没有这一句，id将会延续删除之前的id
            db.execSQL("update sqlite_sequence  set seq=0 where name='person'");
            db.close();
        }
    }


    /**
     * 查询所有
     */
    public List<PersonBean> queryAll() {
        List<PersonBean> list = new ArrayList<>();
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        if (db.isOpen()) {
            Cursor cursor = db.rawQuery("select * from person", null);
            while (cursor.moveToNext()) {
                //int id = cursor.getInt(0);
                int _id = cursor.getInt(cursor.getColumnIndex("_id"));
                String name = cursor.getString(cursor.getColumnIndex("name"));
                PersonBean personBean = new PersonBean(_id, name);
                list.add(personBean);
            }
            cursor.close();
            db.close();
        }
        return list;
    }

    /**
     * 根据id查询
     */
    public List<PersonBean> query(int id) {
        List<PersonBean> list = new ArrayList<>();
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        if (db.isOpen()) {
            Cursor cursor = db.rawQuery("select * from person where _id=?", new String[]{id + ""});
            while (cursor.moveToNext()) {
                //int id = cursor.getInt(0);
                int _id = cursor.getInt(cursor.getColumnIndex("_id"));
                String name = cursor.getString(cursor.getColumnIndex("name"));
                PersonBean dataBean = new PersonBean(_id, name);
                list.add(dataBean);
            }
            cursor.close();
            db.close();
        }
        return list;
    }

    /**
     * 根据name查询
     */
    public PersonBean queryName(String name) {
        List<PersonBean> list = new ArrayList<>();
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        if (db.isOpen()) {
            Cursor cursor = db.rawQuery("select * from person where name=?", new String[]{name + ""});
            while (cursor.moveToNext()) {
                //int id = cursor.getInt(0);
                String n = cursor.getString(cursor.getColumnIndex("name"));
                String c = cursor.getString(cursor.getColumnIndex("content"));
                PersonBean dataBean = new PersonBean(c,n);
                return dataBean;
            }
            cursor.close();
            db.close();
        }
        return null;
    }

    /**
     * 根据type查询
     */
    public List<PersonBean> queryType(int type) {
        List<PersonBean> list = new ArrayList<>();
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        if (db.isOpen()) {
            Cursor cursor = db.rawQuery("select * from person where type=?", new String[]{type + ""});
            while (cursor.moveToNext()) {
                //int id = cursor.getInt(0);
                int i = cursor.getInt(cursor.getColumnIndex("type"));
                String name = cursor.getString(cursor.getColumnIndex("name"));
                PersonBean dataBean = new PersonBean(i, name);
                list.add(dataBean);
            }
            cursor.close();
            db.close();
        }
        return list;
    }
}


