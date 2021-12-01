package tw.tcnr03.m0607;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class M0606 extends AppCompatActivity {


    private TextView s001;
    private TextView f000;
    private String u_select;
    private String ans;
    private ImageButton b001;
    private ImageButton b002;
    private ImageButton b003;
    private ImageView c001;
    private MediaPlayer startmusic;
    private MediaPlayer win;
    private MediaPlayer lose;
    private MediaPlayer draw;
    private MediaPlayer endmusic;

    private View.OnClickListener b001ON = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int iComp = (int) (Math.random() * 3 + 1);
// 1 - scissors, 2 - stone, 3 - net.
            switch (v.getId()) {
                case R.id.m0606_b001:
                    u_select = getString(R.string.m0606_s001) + getString(R.string.m0606_b001);
                    u_setalpha();
                    b001.getBackground().setAlpha(255);
                    switch (iComp) {
                        case 1:
                            c001.setImageResource(R.drawable.scissors);
//                        ans=getString(R.string.m0606_f000)+getString(R.string.m0606_f003);
//                        f000.setTextColor(Color.YELLOW);
                            music(2);
                            break;
                        case 2:
                            c001.setImageResource(R.drawable.stone);
//                        ans=getString(R.string.m0606_f000)+getString(R.string.m0606_f002);
//                        f000.setTextColor(Color.RED);
                            music(3);
                            break;
                        case 3:
                            c001.setImageResource(R.drawable.net);
//                        ans=getString(R.string.m0606_f000)+getString(R.string.m0606_f001);
//                        f000.setTextColor(Color.GREEN);
                            music(1);
                            break;
                    }
                    break;

//-------------------------------------------------------
                case R.id.m0606_b002:
                    u_select = getString(R.string.m0606_s001) + getString(R.string.m0606_b002);
                    u_setalpha();
                    b002.getBackground().setAlpha(255);
                    switch (iComp) {
                        case 1:
                            c001.setImageResource(R.drawable.stone);
//                        ans=getString(R.string.m0606_f000)+getString(R.string.m0606_f003);
//                        f000.setTextColor(Color.YELLOW);
                            music(2);
                            break;
                        case 2:
                            c001.setImageResource(R.drawable.net);
//                        ans=getString(R.string.m0606_f000)+getString(R.string.m0606_f002);
//                        f000.setTextColor(Color.RED);
                            music(3);
                            break;
                        case 3:
                            c001.setImageResource(R.drawable.scissors);
//                        ans=getString(R.string.m0606_f000)+getString(R.string.m0606_f001);
//                        f000.setTextColor(Color.GREEN);
                            music(1);
                            break;
                    }
                    break;

//-------------------------------------------------------
                case R.id.m0606_b003:
                    u_select = getString(R.string.m0606_s001) + getString(R.string.m0606_b003);
                    u_setalpha();
                    b003.getBackground().setAlpha(255);
                    switch (iComp) {
                        case 1:
                            c001.setImageResource(R.drawable.net);
//                        ans=getString(R.string.m0606_f000)+getString(R.string.m0606_f003);
//                        f000.setTextColor(Color.YELLOW);
                            music(2);
                            break;
                        case 2:
                            c001.setImageResource(R.drawable.scissors);
//                        ans=getString(R.string.m0606_f000)+getString(R.string.m0606_f002);
//                        f000.setTextColor(Color.RED);
                            music(3);
                            break;
                        case 3:
                            c001.setImageResource(R.drawable.stone);
//                        ans=getString(R.string.m0606_f000)+getString(R.string.m0606_f001);
//                        f000.setTextColor(Color.GREEN);
                            music(1);
                            break;
                    }
                    break;
            }
            s001.setText(u_select);
            f000.setText(ans);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0606);
        setupViewComponent();
    }

    private void setupViewComponent() {
        Intent intent = new Intent();
        intent=this.getIntent();
        String mode_title = intent.getStringExtra("class_title");
        this.setTitle(mode_title);
        b001 = (ImageButton) findViewById(R.id.m0606_b001);
//    startmusic = MediaPlayer.create(getApplication(), R.raw.guess);
//    startmusic.start();

        b002 = (ImageButton) findViewById(R.id.m0606_b002);
        b003 = (ImageButton) findViewById(R.id.m0606_b003);
        c001 = (ImageView) findViewById(R.id.m0606_c001);
        s001 = (TextView) findViewById(R.id.m0606_s001);
        f000 = (TextView) findViewById(R.id.m0606_f000);
        startmusic = MediaPlayer.create(getApplication(), R.raw.guess);
        startmusic.start();
        endmusic = MediaPlayer.create(getApplication(), R.raw.goodnight);
        win = MediaPlayer.create(getApplication(), R.raw.vctory);
        draw = MediaPlayer.create(getApplication(), R.raw.haha);
        lose = MediaPlayer.create(getApplication(), R.raw.lose);
        b001.setOnClickListener(b001ON);
        b002.setOnClickListener(b001ON);
        b003.setOnClickListener(b001ON);
    }

    private void u_setalpha() {
//        imageButton 背景為灰色且為全透明
//        setBackgroundColor(Color.XXX)為新方法，講義為舊方法。
        b001.setBackgroundColor(Color.GRAY);
        b001.getBackground().setAlpha(0); //0-255
        b002.setBackgroundColor(Color.GRAY);
        b002.getBackground().setAlpha(0);
        b003.setBackgroundColor(Color.GRAY);
        b003.getBackground().setAlpha(0);
    }

    private void music(int i) { //自定義方法
        if (startmusic.isPlaying()) startmusic.stop();
        if (win.isPlaying()) win.pause();
        if (draw.isPlaying()) draw.pause();
        if (lose.isPlaying()) lose.pause();

        switch (i) {
            case 1:
                win.start();
                ans = getString(R.string.m0606_f000) + getString(R.string.m0606_f001);
                f000.setTextColor(Color.GREEN);
                Toast.makeText(getApplicationContext(), R.string.m0606_f001,
                        Toast.LENGTH_LONG).show(); // 贏
                break;
            case 2:
                draw.start();
                ans = getString(R.string.m0606_f000) + getString(R.string.m0606_f003);
                f000.setTextColor(Color.YELLOW);
                Toast.makeText(getApplicationContext(), R.string.m0606_f003,
                        Toast.LENGTH_LONG).show(); // 平手
                break;
            case 3:
                lose.start();
                ans = getString(R.string.m0606_f000) + getString(R.string.m0606_f002);
                f000.setTextColor(Color.RED);
                Toast.makeText(getApplicationContext(), R.string.m0606_f002,
                        Toast.LENGTH_LONG).show(); // 贏
                break;
            case 4:
                endmusic.start();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        this.finish();
    }

    @Override
    protected void onStop() {
        super.onStop();
        music(4);
    }
}