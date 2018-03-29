package ro.pub.cs.systems.eim.practicaltest01;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PracticalTest01Var02SecondaryActivity extends AppCompatActivity {

    private TextView textView;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch(view.getId()) {
                case R.id.cancel:
                    setResult(RESULT_CANCELED, null);
                    break;
                case R.id.ok:
                    setResult(RESULT_OK, null);
                    break;
            }

            finish();
        }
    }

    private Button cancel, ok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var02_secondary);

        Intent intent = getIntent();

        textView = findViewById(R.id.result);
        if (intent != null) {
            String text = intent.getStringExtra("MY_TEXT");
            textView.setText(text);
        }

        cancel = findViewById(R.id.cancel);
        ok = findViewById(R.id.ok);

        cancel.setOnClickListener(buttonClickListener);
        ok.setOnClickListener(buttonClickListener);
    }
}
