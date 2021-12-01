package tw.tcnr03.m0601;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class M0601 extends AppCompatActivity {

    private Button b001;
    private Button b002;
    private Button b003;
    private TextView c001;
    private TextView s001;
    private TextView f000;
    private String u_select;
    private String ans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0601);
        setupViewComponent();
    }
private void setupViewComponent(){
        b001=(Button)findViewById(R.id.m0601_b001);
        b002=(Button)findViewById(R.id.m0601_b002);
        b003=(Button)findViewById(R.id.m0601_b003);
        c001=(TextView)findViewById(R.id.m0601_c001);
        s001=(TextView)findViewById(R.id.m0601_s001);
        f000=(TextView)findViewById(R.id.m0601_f000);
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
            case R.id.m0601_b001:
                u_select=getString(R.string.m0601_s001)+getString(R.string.m0601_b001);
                switch (iComp){
                    case 1:
                        c001.setText(R.string.m0601_b001);
                        ans=getString(R.string.m0601_f000)+getString(R.string.m0601_f003);
                        break;
                    case 2:
                        c001.setText(R.string.m0601_b002);
                        ans=getString(R.string.m0601_f000)+getString(R.string.m0601_f002);
                        break;
                    case 3:
                        c001.setText(R.string.m0601_b003);
                        ans=getString(R.string.m0601_f000)+getString(R.string.m0601_f001);
                        break;
                }
                break;

//-------------------------------------------------------
            case R.id.m0601_b002:
                u_select=getString(R.string.m0601_s001)+getString(R.string.m0601_b002);
                switch (iComp){
                    case 1:
                        c001.setText(R.string.m0601_b001);
                        ans=getString(R.string.m0601_f000)+getString(R.string.m0601_f001);
                        break;
                    case 2:
                        c001.setText(R.string.m0601_b002);
                        ans=getString(R.string.m0601_f000)+getString(R.string.m0601_f003);
                        break;
                    case 3:
                        c001.setText(R.string.m0601_b003);
                        ans=getString(R.string.m0601_f000)+getString(R.string.m0601_f002);
                        break;
                }
                break;

//-------------------------------------------------------
            case R.id.m0601_b003:
                u_select=getString(R.string.m0601_s001)+getString(R.string.m0601_b003);
                switch (iComp){
                    case 1:
                        c001.setText(R.string.m0601_b001);
                        ans=getString(R.string.m0601_f000)+getString(R.string.m0601_f002);
                        break;
                    case 2:
                        c001.setText(R.string.m0601_b002);
                        ans=getString(R.string.m0601_f000)+getString(R.string.m0601_f001);
                        break;
                    case 3:
                        c001.setText(R.string.m0601_b003);
                        ans=getString(R.string.m0601_f000)+getString(R.string.m0601_f003);
                        break;
                }
                break;
        }
        s001.setText(u_select);
        f000.setText(ans);
        }
    };
}