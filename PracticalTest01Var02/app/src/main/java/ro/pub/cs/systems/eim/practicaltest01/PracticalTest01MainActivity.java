package ro.pub.cs.systems.eim.practicaltest01;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PracticalTest01MainActivity extends AppCompatActivity {

    public static final String SAVED_TEXT = "SAVED_TEXT";

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            int x, y, z;
            switch (view.getId()) {
                case R.id.plus:
                    x = Integer.parseInt(operator1.getText().toString());
                    y = Integer.parseInt(operator2.getText().toString());
                    z = x + y;
                    suma.setText(x + " + " + y + " = " + z);
                    break;
                case R.id.minus:
                    x = Integer.parseInt(operator1.getText().toString());
                    y = Integer.parseInt(operator2.getText().toString());
                    z = x - y;
                    suma.setText(x + " - " + y + " = " + z);
                    break;
                case R.id.activ2:
                    Intent intent = new Intent(getApplicationContext(), PracticalTest01Var02SecondaryActivity.class);
                    String text = suma.getText().toString();
                    intent.putExtra("MY_TEXT", text);
                    startActivityForResult(intent, 1);
                    break;

            }
        }
    }

    private TextView suma;
    private EditText operator1, operator2;
    private Button plus, minus, activity2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_main);

        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        operator1 = findViewById(R.id.operator1);
        operator2 = findViewById(R.id.operator2);
        activity2 = findViewById(R.id.activ2);
        suma = findViewById(R.id.suma);

        if (savedInstanceState != null) {
            suma.setText(savedInstanceState.getString(SAVED_TEXT));
        }

        plus.setOnClickListener(buttonClickListener);
        minus.setOnClickListener(buttonClickListener);
        activity2.setOnClickListener(buttonClickListener);

    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putString(SAVED_TEXT, suma.getText().toString());
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            Toast.makeText(this, "The activity returned with result " + resultCode, Toast.LENGTH_LONG).show();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
