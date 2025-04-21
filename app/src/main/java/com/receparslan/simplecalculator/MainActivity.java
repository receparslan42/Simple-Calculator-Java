package com.receparslan.simplecalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.receparslan.simplecalculator.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    // Calculator Views
    EditText firstNumberEditText;
    EditText secondNumberEditText;
    TextView resultTextView;

    // Calculator Values
    double firstNumberValue;
    double secondNumberValue;
    double resultValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater()); // Inflate the layout using ViewBinding
        setContentView(binding.getRoot()); // Set the content view
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Inflate the layout using ViewBinding
        firstNumberEditText = binding.firstNumberEditText;
        secondNumberEditText = binding.secondNumberEditText;
        resultTextView = binding.resultTextView;

        // Set the default value of the result
        resultTextView.setText(getString(R.string.result, (double) 0));
    }

    // Calculate the sum of the two numbers
    public void sum(View view) {
        setNumbers();
        resultValue = firstNumberValue + secondNumberValue;
        resultTextView.setText(getString(R.string.result, resultValue));
    }

    // Calculate the subtraction of the two numbers
    public void subtraction(View view) {
        setNumbers();
        resultValue = firstNumberValue - secondNumberValue;
        resultTextView.setText(getString(R.string.result, resultValue));
    }

    // Calculate the multiplication of the two numbers
    public void multiplication(View view) {
        setNumbers();
        resultValue = firstNumberValue * secondNumberValue;
        resultTextView.setText(getString(R.string.result, resultValue));
    }

    // Calculate the division of the two numbers
    public void division(View view) {
        setNumbers();
        resultValue = firstNumberValue / secondNumberValue;
        resultTextView.setText(getString(R.string.result, resultValue));
    }

    // Check numbers and set
    public void setNumbers() {
        String firstNumber = firstNumberEditText.getText().toString();
        String secondNumber = secondNumberEditText.getText().toString();

        firstNumberValue = Double.parseDouble(firstNumber.isEmpty() ? "0" : firstNumber);
        secondNumberValue = Double.parseDouble(secondNumber.isEmpty() ? "0" : secondNumber);
    }
}