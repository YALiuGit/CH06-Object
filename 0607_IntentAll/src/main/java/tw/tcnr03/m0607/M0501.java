package tw.tcnr03.m0607;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class M0501 extends AppCompatActivity {

    private Spinner s001;
    private EditText e001;
    private Button b001;
    private TextView ans01;
    private String sSex;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0501);
        setupViewComponent();
    }

    private void setupViewComponent() {
        Intent intent = new Intent();
        intent=this.getIntent();
        String mode_title = intent.getStringExtra("class_title");
        this.setTitle(mode_title);
        s001 = (Spinner) findViewById(R.id.m0501_s001);
        e001 = (EditText) findViewById(R.id.m0501_e001);
        b001 = (Button) findViewById(R.id.m0501_b001);
        ans01 = (TextView) findViewById(R.id.m0501_f000);

// 使用系統格式 字體無法改變
//  ArrayAdapter<CharSequence> adapterSexList=
//          ArrayAdapter.createFromResource(
//                  this,
//                  R.array.m0501_a001,
//                  R.layout.support_simple_spinner_dropdown_item);
//        s001.setAdapter(adapterSexList);
//---------------------------------------
        // 使用自訂義格式 字體可以改變

        // 設定 spinner item 選項------------
        ArrayAdapter<CharSequence> adapterSexList=
                ArrayAdapter.createFromResource(
                        this,
                        R.array.m0501_a001,
                        R.layout.spinner_item);
        //總是使用this(虛位),陣列來源,顯示下選項
        s001.setAdapter(adapterSexList);

//---------------------------------------
        // 準備 Listener a001Lis 需再設定 Listener
        s001.setOnItemSelectedListener(spnSexItemSelLis);
        // 準備 Listener btnb001 需再設定 Listener
        b001.setOnClickListener(b001ON);

    }
    // =========================================================================

    private AdapterView.OnItemSelectedListener spnSexItemSelLis = new AdapterView.OnItemSelectedListener() {

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//            ((TextView) parent.getChildAt(0)).setTextColor(Color.BLUE);
//            ((TextView) parent.getChildAt(0)).setTextSize(24);
            sSex = parent.getSelectedItem().toString();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };
    // =======================================================================
    private Button.OnClickListener b001ON = new Button.OnClickListener() {

        @Override
        public void onClick(View v) {
            String strSug = getString(R.string.m0501_f000);
//-----------------------------------------------------------------------------------
// 檢查 年齡是否有輸入
            if (e001.getText().toString().trim().length() != 0) {
                int iAge = Integer.parseInt(e001.getText().toString());
                //-----------------------------------------------------------------------------------
                if (sSex.equals(getString(R.string.m0501_chk01)))
                    if (iAge < 28)
                        strSug += getString(R.string.m0501_f001);
                    else if (iAge > 33)
                        strSug += getString(R.string.m0501_f003);
                    else {
                        strSug += getString(R.string.m0501_f002);
                    }
                    //檢查女生年齡
                else if (iAge < 25)
                    strSug += getString(R.string.m0501_f001);
                else if (iAge > 30)
                    strSug += getString(R.string.m0501_f003);
                else {
                    strSug += getString(R.string.m0501_f002);
                }
                ans01.setText(strSug);
//-------------------------------------------------------
            } else {
                strSug = getString(R.string.nospace);//else { //年齡輸入空白
            }
            ans01.setText(strSug); //請勿輸入空白
        }
    };
}
