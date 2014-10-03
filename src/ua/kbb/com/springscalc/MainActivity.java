package ua.kbb.com.springscalc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends MenuActivity implements OnClickListener {
	
	Button btnWithChamf, btnNoChamf, btnTheoryData;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		btnWithChamf = (Button) findViewById(R.id.btnWithChamf);
		btnWithChamf.setOnClickListener(this);
		
		btnNoChamf = (Button) findViewById(R.id.btnNoChamf);
		btnNoChamf.setOnClickListener(this);
		
		btnTheoryData = (Button) findViewById(R.id.btnTheoryData);
		btnTheoryData.setOnClickListener(this);
		
		//setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
	}
	
//  ------------------------------создание меню--------------------------------------
   
//-----------------------------------------------------------------------------------
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent intent;
		
		switch (v.getId())
		{
		case R.id.btnWithChamf:
		// Событие при нажатии на "С фаской"
			//intent = new Intent(this, ChamferCalc.class);
			//startActivity(intent);
			Toast toast = Toast. makeText( this, "В бесплатной версии приложения данный вид расчета неактивен!" , Toast.LENGTH_LONG );
			toast.setGravity(Gravity.CENTER , 0, 0);
			toast.show();

			break;
		case R.id.btnNoChamf:
		//Событие при нажатии на "Без фаски"
			intent = new Intent(this, ChamferCalc.class);
			intent.putExtra("ChamferPressed", true);
			startActivity(intent);
			
			//Сюда надо добавить отличие в расчетах от варианта с кромкой
			break;
		case R.id.btnTheoryData:
			//Событие при нажатии на "Теоретические данные
			intent = new Intent(this, TeoryData.class);
			startActivity(intent);
			break;
		
		}
			
	}
	
	public void toast (String msg)
	{
	    Toast.makeText (getApplicationContext(), msg, Toast.LENGTH_SHORT).show ();
	} 
}
