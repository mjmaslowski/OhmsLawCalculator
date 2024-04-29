package Net.AndroidBootCamp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String[ ] menu={"Ohm's Law Calculator", "Watt's Law Calculator", "Resistor Color Code"};
        setListAdapter(new ArrayAdapter<String>(this, R.layout.activity_main, R.id.menu, menu));

    }

    protected void onListItemClick(ListView l, View v, int position, long id) {

        switch (position) {
            case 0:
                startActivity(new Intent(MainActivity.this, OhmsLaw.class));
                break;
            case 1:
                startActivity(new Intent(MainActivity.this, WattsLaw.class));
                break;
            case 2:
                startActivity(new Intent(MainActivity.this, ResistorColorCode.class));
                break;
        }
    }

}