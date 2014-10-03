package ua.kbb.com.springscalc;

import android.app.Activity;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class About extends Activity implements OnClickListener {

	Button button1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about);
	
		TextView appVersion = (TextView) findViewById(R.id.txtAppVersion);
		button1 = (Button) findViewById(R.id.button1);
		button1.setOnClickListener(this);
		//Выводим версию приложения.
		try {
			String versionApp = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
			appVersion.setText(versionApp);
		} catch (NameNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void onClick(View v) {
		switch (v.getId())
		{
			case R.id.button1:
				finish();
				break;
		}
		
	}
}
