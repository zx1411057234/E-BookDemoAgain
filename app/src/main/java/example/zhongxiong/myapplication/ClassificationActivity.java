package example.zhongxiong.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ClassificationActivity extends AppCompatActivity {

    private List<String> data1;
    private List<String> data2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classification);

        data1 = new ArrayList<>();
        data2 = new ArrayList<>();
        List<PersonBean> list1 = (List<PersonBean>) getIntent().getSerializableExtra("list1");
        List<PersonBean> list2 = (List<PersonBean>) getIntent().getSerializableExtra("list2");
        ListView mListView1 = findViewById(R.id.lv_lib1);
        ListView mListView2 = findViewById(R.id.lv_lib2);
        for (PersonBean p : list1) {
            data1.add(p.getName());
        }
        for (PersonBean p : list2) {
            data2.add(p.getName());
        }
        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, data1);
        mListView1.setAdapter(arrayAdapter1);

        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, data2);
        mListView2.setAdapter(arrayAdapter2);


        mListView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ClassificationActivity.this, ContentActivity.class);
                intent.putExtra("data", data1.get(i));
                startActivity(intent);
            }
        });


        mListView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ClassificationActivity.this, ContentActivity.class);
                intent.putExtra("data", data2.get(i));
                startActivity(intent);
            }
        });
    }
}