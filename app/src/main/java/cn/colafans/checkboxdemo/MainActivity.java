package cn.colafans.checkboxdemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
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
    private Button btnSubmit, btnCheckMovie, btnUncheckMovie, btnCheckMusic, btnUncheckMusic;
    private List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initListeners();
        list = new ArrayList<String>();
    }

    private void initListeners() {
        cbMovie.setOnCheckedChangeListener(this);
        cbMusic.setOnCheckedChangeListener(this);
        btnSubmit.setOnClickListener(this);
        btnCheckMovie.setOnClickListener(this);
        btnCheckMusic.setOnClickListener(this);
        btnUncheckMovie.setOnClickListener(this);
        btnUncheckMusic.setOnClickListener(this);
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
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if (textView.getText().toString().startsWith("w")) {
            textView.setText("");
        }
        if (b) {
            list.add(compoundButton.getText().toString());
            textView.setText(textView.getText().toString() + " " + compoundButton.getText() + " has been checked \n");
        } else {
            list.remove(compoundButton.getText().toString());
            textView.setText(textView.getText().toString() + " " + compoundButton.getText() + " has been unchecked \n");
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_submit:
                textView.setText("what is in list:" + list.toString());
                break;
            case R.id.btn_movie_check:
                Log.i("lancelot","111111");
                cbMovie.setChecked(true);
                break;
            case R.id.btn_movie_uncheck:
                Log.i("lancelot","22222");
                cbMovie.setChecked(false);
                break;
            case R.id.btn_music_check:
                cbMusic.setChecked(true);
                break;
            case R.id.btn_music_uncheck:
                cbMusic.setChecked(false);
                break;
            default:
                //nothing todo
        }
    }
}
