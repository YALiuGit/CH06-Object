package tw.tcnr03.m0604;

import static android.view.Gravity.CENTER;
import static android.view.Gravity.END;
import static android.view.Gravity.TOP;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class M0604 extends AppCompatActivity {

    private Button btn01;
    private Button btn02;
    private Button btn03;
    private Button btn04;
    private Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0604);
        setupViewComponent();
    }
private void setupViewComponent(){
        btn01=(Button)findViewById(R.id.m0604_b001);
        btn02=(Button)findViewById(R.id.m0604_b002);
        btn03=(Button)findViewById(R.id.m0604_b003);
        btn04=(Button)findViewById(R.id.m0604_b004);
        btn01.setOnClickListener(btnON);
        btn02.setOnClickListener(btnON);
        btn03.setOnClickListener(btnON);
        btn04.setOnClickListener(btnON);
}

    View.OnClickListener btnON=new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.m0604_b001:
                Toast.makeText(getApplicationContext(), getText(R.string.m0604_t001), Toast.LENGTH_LONG).show();
                break;
            case R.id.m0604_b002:
                toast=null;
                toast=Toast.makeText(getApplicationContext(), getString(R.string.m0604_b002), Toast.LENGTH_LONG);
                toast.setGravity(CENTER, 0, 0);
                toast.show();
                break;
            case R.id.m0604_b003:
                toast=Toast.makeText(getApplicationContext(), getString(R.string.m0604_t001), Toast.LENGTH_LONG);
                toast.setGravity(TOP|Gravity.END, 0, 0);
                LinearLayout toastView = (LinearLayout) toast.getView();
                ImageView img01 = new ImageView(getApplicationContext());
                img01.setImageResource(R.drawable.ico1);
                toastView.addView(img01, 0);
                toast.show();
                break;
            case  R.id.m0604_b004:
                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.custom, (ViewGroup) findViewById(R.id.llToast));

                ImageView image = (ImageView) layout.findViewById(R.id.tvImageToast);
                TextView title = (TextView) layout.findViewById(R.id.tvTitleToast);
                TextView text = (TextView) layout.findViewById(R.id.tvTextToast);

                image.setImageResource(R.drawable.ico1);
                title.setText(getString(R.string.m0604_t001).toString());
                text.setText(getString(R.string.m0604_test).toString());
//-----------------------------------
                toast = new Toast(getApplicationContext());
                toast.setGravity(Gravity.START | Gravity.TOP, 20, 40);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.setView(layout);
                toast.show();

                break;
        }
    }
};
}