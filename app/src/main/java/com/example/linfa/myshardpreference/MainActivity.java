package com.example.linfa.myshardpreference;
/**
 * @date 2018/4/6
 * @author skylinelin
 */

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText mKey, mValue;
    private Button mSave,mRead;

    private EditText mrKey;
    private TextView mrValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {

        mKey = findViewById(R.id.et_key);
        mValue = findViewById(R.id.et_value);
        mSave = findViewById(R.id.bt_save);

        mrKey = findViewById(R.id.et_rkey);
        mrValue = findViewById(R.id.et_rvalue);
        mRead = findViewById(R.id.bt_read);

        mSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //保存数据
                String key = mKey.getText().toString().trim();
                String value = mValue.getText().toString().trim();

                SharedPreferences sharedPreferences = MainActivity.this.getSharedPreferences("skylinelin", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString(key, value);
                //异步存储
                editor.apply();
            }
        });


        mRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //读取相应key的value
                String key = mrKey.getText().toString().trim();
                SharedPreferences sharedPreferences = MainActivity.this.getSharedPreferences("skylinelin", MODE_PRIVATE);
                String value = sharedPreferences.getString(key, "没有内容");

                mrValue.setText(value);
            }
        });
    }
}
