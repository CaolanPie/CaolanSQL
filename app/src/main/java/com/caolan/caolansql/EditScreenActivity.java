package com.caolan.caolansql;

import android.app.Activity;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;

/*
 * Change Log
 * 27-Dec-13 Tony	inserted our code to save a row when the save button is pressed
 * 					Also the Save and cancel button now return you to the main screen
 */

public class EditScreenActivity extends Activity  {

	private Button mSaveButton;
	private Button mCancelButton;
	private EditText mNameBox;
	private EditText mAddressBox;
// The below line used to read "private EditText mDateBox;"
	private DatePicker mDateBox;
    private EditText mNumberBox;
	private static final int DATE_PICKER_DIALOG = 0;
	private DetailsDbFunctions mDbHelper;
	SimpleDateFormat myDateFormat = new SimpleDateFormat("yyyy-MM-dd");

	
	
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
					super.onCreate(savedInstanceState);
	
// -- Caolan what does the next line do?
//		It calls the screen to show the "edit screen" with the fields filled in?
// it sets the context of the phone to this screen where by bringing it to the front
// and bringing focus on it
		setContentView(R.layout.editscreen);
// The next line can be used to set opacity, but we aren't using at the moment
//		findViewById(R.id.background1).setAlpha( (float) 0.5);
		mDbHelper = new DetailsDbFunctions(this);
		mDbHelper.open();
		
		// My Buttons
//-- Caolan what does the next line do?
//		this is where you define that the "save button" actually saves
		// FindViewByID finds the internal number/name for our buttonSave and stores it in nSaveButton
		mSaveButton = (Button) findViewById(R.id.ButtonSave);
		mCancelButton = (Button) findViewById(R.id.ButtonCancel);
		mNameBox = (EditText) findViewById (R.id.idNameBox);
		mAddressBox = (EditText) findViewById (R.id.idAddressBox);
		mDateBox = (DatePicker) findViewById (R.id.datePicker1);
		mNumberBox = (EditText) findViewById (R.id.idNumberBox);
		
//-- Caolan what does the next line do?
//		this detects when the button itself is pressed
		// this calls a routine which will setup the detection of the buttons
		registerButtonsListenersAndSetDefaultText();
					
	}
	
	// This routine we will create all our listensrs for our screen
	private void registerButtonsListenersAndSetDefaultText() {
		// TODO Auto-generated method stub


//-- Caolan what does the next line do?
//		this is to detect when the save button specifically is pressed
		// this sets up a trigger which will tell us when the button is press and when it is it calls our onClick
		mSaveButton.setOnClickListener(
			new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					String myDateString = myDateFormat.format(new Date(mDateBox.getYear(),
																mDateBox.getMonth(),
																mDateBox.getDayOfMonth()));
		// this is called when our button is actually pressed
					Toast.makeText(EditScreenActivity.this,
						"Clicked Save button Name = "+mNameBox.getText().toString() +
						" Address="+mAddressBox.getText().toString() +
						" Date="+myDateString +
						" Telephone Number="+mNumberBox.getText().toString(),
						Toast.LENGTH_SHORT).show();

		// This line actually calls our createDetailRow which then 
		//		inserts the new row in our databse
					mDbHelper.createDetailRow(
							mNameBox.getText().toString(),
							mAddressBox.getText().toString(),
							myDateString,
							mNumberBox.getText().toString());
					Toast.makeText(EditScreenActivity.this,
							"Details saved.",
							Toast.LENGTH_SHORT).show();
					finish(); // now exit this screen
//						showDialog(DATE_PICKER_DIALOG);
				} // end of setClick(view...
			} // end of new View...
		); // this is the end of setOnClickListener
		
		mCancelButton.setOnClickListener(
			new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Toast.makeText(EditScreenActivity.this, "we clicked the cancel button", Toast.LENGTH_SHORT).show();
					finish(); // now exit this screen
				}
			}
		);


/*
		// -- Caolan Your forgot these also
		mConfirmButton.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View view) {
        		saveState(); 
        		setResult(RESULT_OK);
        	    Toast.makeText(ReminderEditActivity.this, getString(R.string.task_saved_message), Toast.LENGTH_SHORT).show();
        	    finish(); 
        	}
          
        });

		mTimeButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
			showDialog(TIME_PICKER_DIALOG);
			}
			
			
		});
		
		updateDateButtonText();
	
		updateTimeButtonText();
*/
	}

	
	
	
	
	private void saveDetails() {
/*		String title = mTitleText.getText().toString();
		String body = mBodyText.getText().toString();
		
		SimpleDateFormat dateTimeFormat = new
			SimpleDateFormat(DATE_TIME_FORMAT);
		String reminderDateTime =
		
					dateTimeFormat.format(mCalendar.getTime());
		
		long id = mDbHelper.createReminder(title, body, reminderDateTime);
*/
	}

}