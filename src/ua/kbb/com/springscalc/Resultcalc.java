package ua.kbb.com.springscalc;

import ua.kbb.com.springscalc.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Resultcalc extends MenuActivity implements OnClickListener{
	
	Button btnBackResult;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.resultcalc);
		
		btnBackResult = (Button)findViewById(R.id.btnBackResult);
		btnBackResult.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btnBackResult:
			finish();
			break;
		}
	}
}
