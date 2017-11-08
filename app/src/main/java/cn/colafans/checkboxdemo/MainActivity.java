package cn.colafans.checkboxdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {

    private CheckBox cbMovie, cbMusic;
    private TextView textView;
    private Button btnSubmit, btnCheckMovie, btnUncheckMovie, btnPerformMovie,
            btnCheckMusic, btnUncheckMusic, btnPerformMusic;
    private List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initListeners();
        list = new ArrayList<>();
    }

    private void initListeners() {
        cbMovie.setOnCheckedChangeListener(this);
        cbMusic.setOnCheckedChangeListener(this);
        btnSubmit.setOnClickListener(this);
        btnCheckMovie.setOnClickListener(this);
        btnCheckMusic.setOnClickListener(this);
        btnUncheckMovie.setOnClickListener(this);
        btnUncheckMusic.setOnClickListener(this);
        btnPerformMovie.setOnClickListener(this);
        btnPerformMusic.setOnClickListener(this);
    }

    private void initViews() {
        cbMovie = findViewById(R.id.cb_movie);
        cbMusic = findViewById(R.id.cb_music);
        textView = findViewById(R.id.tv);
        btnSubmit = findViewById(R.id.btn_submit);
        btnCheckMovie = findViewById(R.id.btn_movie_check);
        btnCheckMusic = findViewById(R.id.btn_music_check);
        btnUncheckMovie = findViewById(R.id.btn_movie_uncheck);
        btnUncheckMusic = findViewById(R.id.btn_music_uncheck);
        btnPerformMovie = findViewById(R.id.btn_movie_perform);
        btnPerformMusic = findViewById(R.id.btn_music_perform);
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
        if (textView.getText().toString().startsWith("w")) {
            textView.setText(""); //不用管这个
        }
        if (isChecked) {
            //这里是checkbox 被选中的时候会执行的代码
            list.add(compoundButton.getText().toString());
            textView.setText(getString(R.string.checked, textView.getText().toString(), compoundButton.getText()));
        } else {
            //这里是checkbox 被取消选中的时候会执行的代码
            list.remove(compoundButton.getText().toString());
            textView.setText(getString(R.string.unchecked, textView.getText().toString(), compoundButton.getText()));
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_submit:
                //点击button，把list中的内容打出来
                //textView.setText(getString(R.string.wil) + list.toString());
                textView.setText(getString(R.string.wil, list.toString()));
                break;
            //下面setChecked(isChecked),performClick()     可以主动设置CheckBox的选中状态，这里以点击button为例
            //同时也会走onCheckedChanged这个回调
            case R.id.btn_movie_check:
                cbMovie.setChecked(true);
                break;
            case R.id.btn_movie_uncheck:
                cbMovie.setChecked(false);
                break;
            case R.id.btn_movie_perform:
                cbMovie.performClick();
                break;
            case R.id.btn_music_check:
                cbMusic.setChecked(true);
                break;
            case R.id.btn_music_uncheck:
                cbMusic.setChecked(false);
                break;
            case R.id.btn_music_perform:
                cbMusic.performClick();
                break;
            default:
                //nothing todo
        }
    }
}
