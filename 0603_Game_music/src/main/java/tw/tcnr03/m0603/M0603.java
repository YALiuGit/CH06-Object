package tw.tcnr03.m0603;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class M0603 extends AppCompatActivity {


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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0603);
        setupViewComponent();
    }
private void setupViewComponent(){
        b001=(ImageButton) findViewById(R.id.m0603_b001);
//    startmusic = MediaPlayer.create(getApplication(), R.raw.guess);
//    startmusic.start();

        b002=(ImageButton) findViewById(R.id.m0603_b002);
        b003=(ImageButton)findViewById(R.id.m0603_b003);
        c001=(ImageView)findViewById(R.id.m0603_c001);
        s001=(TextView)findViewById(R.id.m0603_s001);
        f000=(TextView)findViewById(R.id.m0603_f000);
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



    private View.OnClickListener b001ON=new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        int iComp = (int) (Math.random() * 3 + 1);
// 1 - scissors, 2 - stone, 3 - net.
        switch (v.getId()){
            case R.id.m0603_b001:
                u_select=getString(R.string.m0603_s001)+getString(R.string.m0603_b001);
                switch (iComp){
                    case 1:
                        c001.setImageResource(R.drawable.scissors);
//                        ans=getString(R.string.m0603_f000)+getString(R.string.m0603_f003);
//                        f000.setTextColor(Color.YELLOW);
                        music(2);
                        break;
                    case 2:
                        c001.setImageResource(R.drawable.stone);
//                        ans=getString(R.string.m0603_f000)+getString(R.string.m0603_f002);
//                        f000.setTextColor(Color.RED);
                        music(3);
                        break;
                    case 3:
                        c001.setImageResource(R.drawable.net);
//                        ans=getString(R.string.m0603_f000)+getString(R.string.m0603_f001);
//                        f000.setTextColor(Color.GREEN);
                        music(1);
                        break;
                }
                break;

//-------------------------------------------------------
            case R.id.m0603_b002:
                u_select=getString(R.string.m0603_s001)+getString(R.string.m0603_b002);
                switch (iComp){
                    case 1:
                        c001.setImageResource(R.drawable.stone);
//                        ans=getString(R.string.m0603_f000)+getString(R.string.m0603_f003);
//                        f000.setTextColor(Color.YELLOW);
                        music(2);
                        break;
                    case 2:
                        c001.setImageResource(R.drawable.net);
//                        ans=getString(R.string.m0603_f000)+getString(R.string.m0603_f002);
//                        f000.setTextColor(Color.RED);
                        music(3);
                        break;
                    case 3:
                        c001.setImageResource(R.drawable.scissors);
//                        ans=getString(R.string.m0603_f000)+getString(R.string.m0603_f001);
//                        f000.setTextColor(Color.GREEN);
                        music(1);
                        break;
                }
                break;

//-------------------------------------------------------
            case R.id.m0603_b003:
                u_select=getString(R.string.m0603_s001)+getString(R.string.m0603_b003);
                switch (iComp){
                    case 1:
                        c001.setImageResource(R.drawable.net);
//                        ans=getString(R.string.m0603_f000)+getString(R.string.m0603_f003);
//                        f000.setTextColor(Color.YELLOW);
                        music(2);
                        break;
                    case 2:
                        c001.setImageResource(R.drawable.scissors);
//                        ans=getString(R.string.m0603_f000)+getString(R.string.m0603_f002);
//                        f000.setTextColor(Color.RED);
                        music(3);
                        break;
                    case 3:
                        c001.setImageResource(R.drawable.stone);
//                        ans=getString(R.string.m0603_f000)+getString(R.string.m0603_f001);
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

    private void music(int i) { //自定義方法
        if(startmusic.isPlaying()) startmusic.stop();
       if(win.isPlaying())  win.pause();
        if(draw.isPlaying()) draw.pause();
        if (lose.isPlaying())  lose.pause();

        switch (i){
            case 1:
                win.start();
                ans=getString(R.string.m0603_f000)+getString(R.string.m0603_f001);
                f000.setTextColor(Color.GREEN);
                break;
            case 2:
                draw.start();
                ans=getString(R.string.m0603_f000)+getString(R.string.m0603_f003);
                f000.setTextColor(Color.YELLOW);
                break;
            case 3:
                lose.start();
                ans=getString(R.string.m0603_f000)+getString(R.string.m0603_f002);
                f000.setTextColor(Color.RED);
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