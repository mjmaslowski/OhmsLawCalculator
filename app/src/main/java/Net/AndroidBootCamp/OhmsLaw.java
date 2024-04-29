package Net.AndroidBootCamp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.Toast;

public class OhmsLaw extends AppCompatActivity {
    float decVolts;
    float decOhms;
    float decAmps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ohms_law);


        final EditText volts = (EditText) findViewById(R.id.txtOhmsVoltage);
        final EditText ohms = (EditText) findViewById(R.id.txtOhmsResistance);
        final EditText amps = (EditText) findViewById(R.id.txtOhmsCurrent);

        Button btnCalculate = (Button) findViewById(R.id.btnOhmCalculate);
        Button btnClear = (Button) findViewById(R.id.btnOhmsClear);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                amps.setBackgroundColor(Color.TRANSPARENT);
                ohms.setBackgroundColor(Color.TRANSPARENT);
                volts.setBackgroundColor(Color.TRANSPARENT);


                try{
                    decVolts = Float.parseFloat((volts.getText().toString()));
                }
                catch (Exception e)
                {
                    decVolts = 0;
                }
                try{
                    decOhms = Float.parseFloat((ohms.getText().toString()));
                }
                catch (Exception e)
                {
                    decOhms = 0;
                }
                try{
                    decAmps = Float.parseFloat((amps.getText().toString()));
                }
                catch (Exception e)
                {
                    decAmps = 0;
                }


                if (decVolts == 0  && decOhms != 0 && decAmps != 0)
                {
                    decVolts = decAmps * decOhms;

                    volts.setText(String.valueOf(decVolts));
                    volts.setBackgroundColor(Color.GREEN);
                }
                else if (decOhms == 0 && decVolts != 0 && decAmps != 0)
                {
                    decOhms = decVolts / decAmps;
                    ohms.setText((String.valueOf(decOhms)));
                    ohms.setBackgroundColor(Color.GREEN);

                }
                else if (decAmps == 0 && decVolts != 0 && decOhms != 0)
                {
                    decAmps = decVolts / decOhms;

                    amps.setText(String.valueOf(decAmps));
                    amps.setBackgroundColor(Color.GREEN);

                }
                else
                {
                    Toast.makeText(OhmsLaw.this, "Exactly 2 values must be entered to properly calculate",
                            Toast.LENGTH_LONG).show();

                }
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                volts.setText("");
                ohms.setText("");
                amps.setText("");
                amps.setBackgroundColor(Color.TRANSPARENT);
                ohms.setBackgroundColor(Color.TRANSPARENT);
                volts.setBackgroundColor(Color.TRANSPARENT);


            }
        });

    }
}