package com.example.helloworld;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.*;
import android.os.Bundle;
import android.text.InputType;
import android.util.TypedValue;
import android.widget.LinearLayout;
import android.widget.*;

public class MainActivity extends Activity {

	LinearLayout layout;
	TextView label;
	EditText firstNumber;
	EditText secondNumber;
	Button calculateButton;
	TextView result;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		firstNumber = new EditText(this);
		secondNumber = new EditText(this);
		calculateButton = new Button(this);
		result = new TextView(this);
		result.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
		
		
		firstNumber.setInputType(InputType.TYPE_CLASS_NUMBER);
		secondNumber.setInputType(InputType.TYPE_CLASS_NUMBER);
		layout = new LinearLayout(this);
		label = new TextView(this);
		label.setText("Simple Hello World");
		layout.addView(label);
		
		result.setText("0");
		calculateButton.setText("Press to Add two number");
		
		calculateButton.setOnClickListener(addNumbers);
		
		layout.setOrientation(LinearLayout.VERTICAL);
		layout.addView(firstNumber);
		layout.addView(secondNumber);
		layout.addView(calculateButton);
		firstNumber.setGravity(Gravity.CENTER_HORIZONTAL);
		secondNumber.setGravity(Gravity.CENTER_HORIZONTAL);

		result.setGravity(Gravity.CENTER_HORIZONTAL);
		layout.setGravity(Gravity.CENTER_HORIZONTAL);
		
		layout.addView(result);
		setContentView(layout);
		
		firstNumber.setLayoutParams(new LinearLayout.LayoutParams(200,50));
		secondNumber.setLayoutParams(new LinearLayout.LayoutParams(200,50));
		calculateButton.setLayoutParams(new LinearLayout.LayoutParams(200,50));
		result.setLayoutParams(new LinearLayout.LayoutParams(200,80));
	}

	private  OnClickListener addNumbers = new OnClickListener(){

				@Override
				public void onClick(View v) {
					Double resultString = Double.parseDouble(firstNumber.getText().toString())+
							Double.parseDouble(secondNumber.getText().toString());
					result.setText(String.valueOf(resultString));	
				}
	};
/*
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}*/
}
