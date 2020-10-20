package example.zhongxiong.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {

    private EditText et_search;
    private PersonBean bean;
    private ArrayAdapter<String> arrayAdapter;
    private List<String> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        data = new ArrayList<>();

        ListView mListView = findViewById(R.id.lv_lib);
        et_search = findViewById(R.id.et_search);
        Button bt_search = findViewById(R.id.bt_search);

        arrayAdapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, data);
        mListView.setAdapter(arrayAdapter);
        bt_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = et_search.getText().toString().trim();
                bean = MyApplication.getIntence().queryName(name);
                if (bean == null) {
                    Toast.makeText(SearchActivity.this, "没有找到该书籍", Toast.LENGTH_SHORT).show();
                    return;
                }
                data.add(bean.getName());
                arrayAdapter.notifyDataSetChanged();
            }
        });

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(SearchActivity.this, ContentActivity.class);
                intent.putExtra("data", data.get(i));
                startActivity(intent);
            }
        });

    }
}