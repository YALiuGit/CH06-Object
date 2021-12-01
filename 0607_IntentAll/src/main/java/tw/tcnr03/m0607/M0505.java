package tw.tcnr03.m0607;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class M0505 extends AppCompatActivity {

    private AutoCompleteTextView e001;
    private Button b001;
    private Button b002;
    private ArrayAdapter<String> adapAutoCompText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0505);
        setupViewComponent();
    }
    private void setupViewComponent(){
        Intent intent = new Intent();
        intent=this.getIntent();
        String mode_title = intent.getStringExtra("class_title");
        this.setTitle(mode_title);
        e001=(AutoCompleteTextView)findViewById(R.id.m0505_a001);
        b001=(Button)findViewById(R.id.m0505_b001);
        b002=(Button)findViewById(R.id.m0505_b002);
        /*adapAutoCompText = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line);
         */
        adapAutoCompText = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line);
        e001.setAdapter(adapAutoCompText);
        b001.setOnClickListener(b001ON);
        b002.setOnClickListener(b001ON);
    }
    private View.OnClickListener b001ON = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.m0505_b001:
                    String s = e001.getText().toString();
                    adapAutoCompText.add(s);
                    e001.setText("");
                    break;
            }
            switch (v.getId()){
                case R.id.m0505_b002:
                    adapAutoCompText.clear();
                    e001.setText("");
                    break;
            }
        }
    };
}