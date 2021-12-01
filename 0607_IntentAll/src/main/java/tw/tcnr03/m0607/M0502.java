package tw.tcnr03.m0607;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class M0502 extends AppCompatActivity {

    private Button b001;
    private TextView ans01;
    private String sSex;
    private RadioGroup rb01;
    private RadioGroup rb02;
    private RadioButton rb021;
    private RadioButton rb022;
    private RadioButton rb023;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0502);

        setupViewComponent();
    }

    private void setupViewComponent() {
        Intent intent = new Intent();
        intent=this.getIntent();
        String mode_title = intent.getStringExtra("class_title");
        this.setTitle(mode_title);
        b001 = (Button) findViewById(R.id.m0502_b001);
        ans01 = (TextView) findViewById(R.id.m0502_f000);
        rb01 = (RadioGroup) findViewById(R.id.m0502_r001);
        rb02 = (RadioGroup) findViewById(R.id.m0502_r002);
        rb021 = (RadioButton) findViewById(R.id.m0502_r002a);
        rb022 = (RadioButton) findViewById(R.id.m0502_r002b);
        rb023 = (RadioButton) findViewById(R.id.m0502_r002c);
        b001.setOnClickListener(b001ON);
        rb01.setOnCheckedChangeListener(rb01ON);
    }


    private RadioGroup.OnCheckedChangeListener rb01ON = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int c) {
            switch (c) {
                case R.id.m0502_r001a:
                    rb021.setText(R.string.m0502_r002aa);
                    rb022.setText(R.string.m0502_r002ab);
                    rb023.setText(R.string.m0502_r002ac);
                    break;
                case R.id.m0502_r001b:
                    rb021.setText(R.string.m0502_r002ba);
                    rb022.setText(R.string.m0502_r002bb);
                    rb023.setText(R.string.m0502_r002bc);
                    break;

            }
        }
    };
    //     =======================================================================
    private Button.OnClickListener b001ON = new Button.OnClickListener() {

        @Override
        public void onClick(View v) {
            String strSug = getString(R.string.m0502_f000);
            int ichsex = rb01.getCheckedRadioButtonId();
            switch (ichsex) {
                case R.id.m0502_r001a: //選男
                    switch (rb02.getCheckedRadioButtonId()) {
                        case R.id.m0502_r002a:
                            strSug += getString(R.string.m0502_f001);
                            break;
                        case R.id.m0502_r002b:
                            strSug += getString(R.string.m0502_f002);
                            break;
                        default:
                            strSug +=getString(R.string.m0502_f003) ;
                    }
                            break;
                case R.id.m0502_r001b: //選女
                    switch (rb02.getCheckedRadioButtonId()) {
                        case R.id.m0502_r002a:
                            strSug += getString(R.string.m0502_f004);
                            break;
                        case R.id.m0502_r002b:
                            strSug += getString(R.string.m0502_f005);
                            break;
                        default:
                            strSug += getString(R.string.m0502_f006);
                    }
                    break;
            }
            ans01.setText(strSug); //請勿輸入空白
        }
    };
}