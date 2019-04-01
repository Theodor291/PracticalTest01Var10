package ro.pub.cs.system.eim.practicaltest01var10;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.Menu;
import android.view.MenuItem;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PracticalTest01Var10MainActivity extends AppCompatActivity {


    private EditText allTermEditText = null;
    private EditText nextTermEditText = null;
    private Button computeButton = null;
    private Button addButton = null;

    private final static int SECONDARY_ACTIVITY_REQUEST_CODE = 1;


    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {


        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.compute_button:
                    String allterm = allTermEditText.getText().toString();
                    Intent intent = new Intent(getApplicationContext(), PracticalTest01Var10SecondaryActivity.class);
                    intent.putExtra("Terms", allterm);
                    startActivityForResult(intent, SECONDARY_ACTIVITY_REQUEST_CODE);
                    break;
                case R.id.add_button:
                    String newterm = nextTermEditText.getText().toString();
                    String allterms = allTermEditText.getText().toString();
                    if (newterm!= null) {

                        allterms = allterms + "+" + newterm;
                    }
                    allTermEditText.setText(allterms);
                    break;

            }
        }
    }




    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var10_main);

        allTermEditText = (EditText)findViewById(R.id.next_term_edit_text);
        nextTermEditText = (EditText)findViewById(R.id.all_terms_edit_text);
        allTermEditText.setText(String.valueOf(0));
        nextTermEditText.setText(String.valueOf(0));

        addButton = (Button)findViewById(R.id.add_button);
        computeButton = (Button)findViewById(R.id.compute_button);

        computeButton = (Button)findViewById(R.id.compute_button);
        computeButton.setOnClickListener(buttonClickListener);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == SECONDARY_ACTIVITY_REQUEST_CODE) {
            Toast.makeText(this, "The activity returned with result " + resultCode, Toast.LENGTH_LONG).show();
        }
    }




}
