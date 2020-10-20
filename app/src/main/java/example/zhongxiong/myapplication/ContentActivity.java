package example.zhongxiong.myapplication;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ContentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        TextView tv_content = findViewById(R.id.tv_content);
        String data = getIntent().getStringExtra("data");
        PersonBean bean = MyApplication.getIntence().queryName(data);
        tv_content.setText(bean.getContent());
    }
}