package Net.AndroidBootCamp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class WattsLaw extends AppCompatActivity {
    float decVolts;
    float decWatts;
    float decAmps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watts_law);


        final EditText volts = (EditText) findViewById(R.id.txtWattsVoltage);
        final EditText watts = (EditText) findViewById(R.id.txtWattsPower);
        final EditText amps = (EditText) findViewById(R.id.txtWattsCurrent);

        Button btnCalculate = (Button) findViewById(R.id.btnWattsCalculate);
        Button btnClear = (Button) findViewById(R.id.btnWattsClear);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                amps.setBackgroundColor(Color.TRANSPARENT);
                watts.setBackgroundColor(Color.TRANSPARENT);
                volts.setBackgroundColor(Color.TRANSPARENT);


                try{
                    decVolts = Float.parseFloat((volts.getText().toString()));
                }
                catch (Exception e)
                {
                    decVolts = 0;
                }
                try{
                    decWatts = Float.parseFloat((watts.getText().toString()));
                }
                catch (Exception e)
                {
                    decWatts = 0;
                }
                try{
                    decAmps = Float.parseFloat((amps.getText().toString()));
                }
                catch (Exception e)
                {
                    decAmps = 0;
                }


                if (decVolts == 0  && decWatts != 0 && decAmps != 0)
                {
                    decVolts = decWatts / decAmps;

                    volts.setText(String.valueOf(decVolts));
                    volts.setBackgroundColor(Color.GREEN);
                }
                else if (decWatts == 0 && decVolts != 0 && decAmps != 0)
                {
                    decWatts = decVolts * decAmps;
                    watts.setText((String.valueOf(decWatts)));
                    watts.setBackgroundColor(Color.GREEN);

                }
                else if (decAmps == 0 && decVolts != 0 && decWatts != 0)
                {
                    decAmps = decWatts / decVolts;

                    amps.setText(String.valueOf(decAmps));
                    amps.setBackgroundColor(Color.GREEN);

                }
                else
                {
                    Toast.makeText(WattsLaw.this, "Exactly 2 values must be entered to properly calculate",
                            Toast.LENGTH_LONG).show();

                }
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                volts.setText("");
                watts.setText("");
                amps.setText("");
                amps.setBackgroundColor(Color.TRANSPARENT);
                watts.setBackgroundColor(Color.TRANSPARENT);
                volts.setBackgroundColor(Color.TRANSPARENT);


            }
        });

    }
}