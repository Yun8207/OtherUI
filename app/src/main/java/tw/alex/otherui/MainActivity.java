package tw.alex.otherui;

import android.app.DatePickerDialog;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;
import android.widget.ViewFlipper;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private CheckBox opt1;
    private RadioGroup years;
    private ToggleButton tbtn;
    private TextView newdate;
    private ViewFlipper vf;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        opt1 = findViewById(R.id.opt1);
        tbtn = findViewById(R.id.tbtn);
        newdate = findViewById(R.id.newdate);
        vf = findViewById(R.id.vf);

        View v0 = vf.getChildAt(0);
        View v1 = vf.getChildAt(1);
        View v2 = vf.getChildAt(2);
        View v3 = vf.getChildAt(3);
        FlipperOnClick listener = new FlipperOnClick();
        v0.setOnClickListener(listener);
        v1.setOnClickListener(listener);
        v2.setOnClickListener(listener);
        v3.setOnClickListener(listener);



        opt1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Toast.makeText(MainActivity.this, "OK", Toast.LENGTH_SHORT)
                            .show();
                }
            }
        });

        years = findViewById(R.id.years);

        years.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.year1:
                        Toast.makeText(MainActivity.this, "20-", Toast.LENGTH_SHORT)
                                .show();
                        break;
                    case R.id.year2:
                        Toast.makeText(MainActivity.this, "20-40", Toast.LENGTH_SHORT)
                                .show();
                        break;
                    case R.id.year3:
                        Toast.makeText(MainActivity.this, "40-60", Toast.LENGTH_SHORT)
                                .show();
                        break;
                    case R.id.year4:
                        Toast.makeText(MainActivity.this, "60+", Toast.LENGTH_SHORT)
                                .show();
                        break;

                }
            }
        });

        tbtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(MainActivity.this, isChecked?"ON":"OFF", Toast.LENGTH_SHORT).show();
            }
        });


    }

    private class FlipperOnClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            int index = vf.indexOfChild(v) ;
            vf.showNext();
            Toast.makeText(MainActivity.this, "" +index, Toast.LENGTH_SHORT).show();

        }
    }



    public void chDate(View view) {
        Calendar cal = Calendar.getInstance();
        int yy = cal.get(Calendar.YEAR);
        int mm = cal.get(Calendar.MONTH);
        int dd = cal.get(Calendar.DAY_OF_MONTH);
        //TimePickerDialog
        new DatePickerDialog(this, android.app.AlertDialog.THEME_TRADITIONAL, new DatePickerDialog.OnDateSetListener(){
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                newdate.setText(year + "-" + (month+1) + "-" + dayOfMonth);

            }
        }, yy,mm,dd).show();


    }
}
//https://github.com/ceryle/SegmentedButton   for reference