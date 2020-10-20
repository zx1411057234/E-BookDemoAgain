package example.zhongxiong.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void library(View view) {
        List<PersonBean> list = MyApplication.getIntence().queryAll(); //查询全部
        Intent intent = new Intent(MainActivity.this, LibraryActivity.class);
        intent.putExtra("list", (Serializable) list);
        startActivity(intent);
    }

    public void classification(View view) {
        List<PersonBean> list1 = MyApplication.getIntence().queryType(1); //查询全部
        List<PersonBean> list2 = MyApplication.getIntence().queryType(2); //查询全部
        Intent intent = new Intent(MainActivity.this, ClassificationActivity.class);
        intent.putExtra("list1", (Serializable) list1);
        intent.putExtra("list2", (Serializable) list2);
        startActivity(intent);
    }

    public void search(View view) {
        Intent intent = new Intent(MainActivity.this, SearchActivity.class);
        startActivity(intent);
    }
}