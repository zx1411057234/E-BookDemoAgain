package example.zhongxiong.myapplication;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

/**
 * Created by zhongxiong on 2020/10/20.
 * Description：
 */
class MyAdapter extends ArrayAdapter {
    public MyAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }
}
