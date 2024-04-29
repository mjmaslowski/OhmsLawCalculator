package Net.AndroidBootCamp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class ResistorColorCode extends AppCompatActivity {

    String strFirstBand;
    String strSecondBand;
    int intMultiplierBand;
    String strTolerance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resistor_color_code);

        final Spinner firstBand = (Spinner) findViewById(R.id.txtFirstBand);
        final Spinner secondBand = (Spinner) findViewById(R.id.txtSecondBand);
        final Spinner thirdBand = (Spinner) findViewById(R.id.txtThirdBand);
        final Spinner fourthBand = (Spinner) findViewById(R.id.txtFourthBand);


        Button calculate = (Button) findViewById(R.id.btnResiatorCalculate);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final TextView result = (TextView) findViewById(R.id.txtResult);
                strFirstBand = String.valueOf(firstBand.getSelectedItemPosition());
                strSecondBand = String.valueOf(secondBand.getSelectedItemPosition());
                intMultiplierBand = thirdBand.getSelectedItemPosition();
                strTolerance = fourthBand.getSelectedItem().toString();
                String tolerance = strTolerance.substring(strTolerance.indexOf("("));
                String resistorValue = new String();

                if (intMultiplierBand == 0)
                {
                    resistorValue = "0." + strFirstBand + strSecondBand + " " + tolerance;
                }
                else if (intMultiplierBand == 1)
                {
                    resistorValue = strFirstBand + "." + strSecondBand + " " + tolerance;
                }
                else if (intMultiplierBand == 2)
                {
                    resistorValue = strFirstBand + strSecondBand + " " + tolerance;
                }
                else if (intMultiplierBand > 2)
                {
                    StringBuilder zeros = new StringBuilder();
                    for (int i = 0; i < (intMultiplierBand - 2); i++)
                    {
                        zeros.append("0");
                    }
                    resistorValue = strFirstBand + strSecondBand + zeros.toString() +  " " + tolerance;
                }

                result.setText(resistorValue);

            }
        });



    }
}