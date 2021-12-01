package tw.tcnr03.m0602;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class M0602 extends AppCompatActivity {


    private TextView s001;
    private TextView f000;
    private String u_select;
    private String ans;
    private ImageButton b001;
    private ImageButton b002;
    private ImageButton b003;
    private ImageView c001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0602);
        setupViewComponent();
    }
private void setupViewComponent(){
        b001=(ImageButton) findViewById(R.id.m0602_b001);
        b002=(ImageButton) findViewById(R.id.m0602_b002);
        b003=(ImageButton)findViewById(R.id.m0602_b003);
        c001=(ImageView)findViewById(R.id.m0602_c001);
        s001=(TextView)findViewById(R.id.m0602_s001);
        f000=(TextView)findViewById(R.id.m0602_f000);
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
            case R.id.m0602_b001:
                u_select=getString(R.string.m0602_s001)+getString(R.string.m0602_b001);
                switch (iComp){
                    case 1:
                        c001.setImageResource(R.drawable.scissors);
                        ans=getString(R.string.m0602_f000)+getString(R.string.m0602_f003);
                        f000.setTextColor(Color.YELLOW);
                        break;
                    case 2:
                        c001.setImageResource(R.drawable.stone);
                        ans=getString(R.string.m0602_f000)+getString(R.string.m0602_f002);
                        f000.setTextColor(Color.RED);
                        break;
                    case 3:
                        c001.setImageResource(R.drawable.net);
                        ans=getString(R.string.m0602_f000)+getString(R.string.m0602_f001);
                        f000.setTextColor(Color.GREEN);
                        break;
                }
                break;

//-------------------------------------------------------
            case R.id.m0602_b002:
                u_select=getString(R.string.m0602_s001)+getString(R.string.m0602_b002);
                switch (iComp){
                    case 1:
                        c001.setImageResource(R.drawable.stone);
                        ans=getString(R.string.m0602_f000)+getString(R.string.m0602_f003);
                        f000.setTextColor(Color.YELLOW);
                        break;
                    case 2:
                        c001.setImageResource(R.drawable.net);
                        ans=getString(R.string.m0602_f000)+getString(R.string.m0602_f002);
                        f000.setTextColor(Color.RED);
                        break;
                    case 3:
                        c001.setImageResource(R.drawable.scissors);
                        ans=getString(R.string.m0602_f000)+getString(R.string.m0602_f001);
                        f000.setTextColor(Color.GREEN);
                        break;
                }
                break;

//-------------------------------------------------------
            case R.id.m0602_b003:
                u_select=getString(R.string.m0602_s001)+getString(R.string.m0602_b003);
                switch (iComp){
                    case 1:
                        c001.setImageResource(R.drawable.net);
                        ans=getString(R.string.m0602_f000)+getString(R.string.m0602_f003);
                        f000.setTextColor(Color.YELLOW);
                        break;
                    case 2:
                        c001.setImageResource(R.drawable.scissors);
                        ans=getString(R.string.m0602_f000)+getString(R.string.m0602_f002);
                        f000.setTextColor(Color.RED);
                        break;
                    case 3:
                        c001.setImageResource(R.drawable.stone);
                        ans=getString(R.string.m0602_f000)+getString(R.string.m0602_f001);
                        f000.setTextColor(Color.GREEN);
                        break;
                }
                break;
        }
        s001.setText(u_select);
        f000.setText(ans);
        }
    };
}