package tw.tcnr03.m0607;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class M0607 extends AppCompatActivity {

    private Button btn01;
    private Button btn02;
    private Button btn03;
    private Button btn04;
    private Button btn05;
    private Button btn06;
    private Button btn07;
    private Intent intent=new Intent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0607);
        setupViewComponent();
    }
    private void setupViewComponent(){
        btn01=(Button)findViewById(R.id.m0607_b001);
        btn02=(Button)findViewById(R.id.m0607_b002);
        btn03 =(Button)findViewById(R.id.m0607_b003);
        btn04=(Button)findViewById(R.id.m0607_b004);
        btn05=(Button)findViewById(R.id.m0607_b005);
        btn06=(Button)findViewById(R.id.m0607_b006);
        btn07=(Button)findViewById(R.id.m0607_b007);
        btn01.setOnClickListener(btnON);
        btn02.setOnClickListener(btnON);
        btn03.setOnClickListener(btnON);
        btn04.setOnClickListener(btnON);
        btn05.setOnClickListener(btnON);
        btn06.setOnClickListener(btnON);
        btn07.setOnClickListener(btnON);
    }

    private View.OnClickListener btnON=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.m0607_b001:
                    intent.putExtra("class_title",getString(R.string.m0000_b0500));
                    intent.setClass(M0607.this, M0500.class);
                break;
                case  R.id.m0607_b002:
                    intent.putExtra("class_title", getString(R.string.m0000_b0501));
                    intent.setClass(M0607.this, M0501.class);
               break;
                case  R.id.m0607_b003:
                    intent.putExtra("class_title", getString(R.string.m0000_b0502));
                    intent.setClass(M0607.this, M0502.class);
                    break;
                case  R.id.m0607_b004:
                    intent.putExtra("class_title", getString(R.string.m0000_b0504));
                    intent.setClass(M0607.this, M0504.class);
                    break;
                case  R.id.m0607_b005:
                    intent.putExtra("class_title", getString(R.string.m0000_b0505));
                    intent.setClass(M0607.this, M0505.class);
                    break;
                case  R.id.m0607_b006:
                    intent.putExtra("class_title", getString(R.string.m0000_b0604));
                    intent.setClass(M0607.this, M0604.class);
                    break;
                case  R.id.m0607_b007:
                    intent.putExtra("class_title", getString(R.string.m0000_b0606));
                    intent.setClass(M0607.this, M0606.class);
                    break;

            }
            startActivity(intent);
        }
    };
}