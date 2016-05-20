package divyanshu.aclaglid.in.aclagliddemos;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

/**
 * Created by divyanshu on 29/04/16.
 */
public class TimePickerExample extends Activity{

    Button pick;
    TimePicker time;
    DatePicker date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timepicker_layout);

        time = (TimePicker)findViewById(R.id.timePicker1);
        pick = (Button)findViewById(R.id.button1);

        date = (DatePicker)findViewById(R.id.datePicker1) ;


        time.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {

                Toast.makeText(TimePickerExample.this,"Time is "+hourOfDay +" : "+minute,Toast.LENGTH_SHORT).show();
            }
        });

        pick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(TimePickerExample.this,"Time is "+time.getCurrentHour() +" : "+time.getCurrentMinute(),Toast.LENGTH_SHORT).show();

                Toast.makeText(TimePickerExample.this,"DATE is "+date.getDayOfMonth() +" : "+date.getMonth()+1+" : "+date.getYear(),Toast.LENGTH_SHORT).show();

            }
        });

    }
}
