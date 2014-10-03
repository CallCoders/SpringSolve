package ua.kbb.com.springscalc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DialogActivity extends Activity implements OnClickListener{

	TextView txtInfoDialog;
	Button btnOk;
	ImageView imgInfoDialod;
	
	int imageResource = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); // Отключаем заголовок
		setContentView(R.layout.dialog);
		
		
		//Читаем текстовую строку из Intent и вносим значение в наш TextView
		txtInfoDialog= (TextView) findViewById(R.id.txtInfoDialog);
		 Intent intent = getIntent();
		 String text = intent.getStringExtra("Text");
		
		 if("puasson".equalsIgnoreCase(text))
		 {
			txtInfoDialog.setText(Html.fromHtml(getString(R.string.kPuasson)));
		 }
		 else if ("modElast".equalsIgnoreCase(text))
		 {
			 txtInfoDialog.setText(Html.fromHtml(getString(R.string.modElast)));
		 }
		 else if ("steelDensity".equalsIgnoreCase(text))
		 {
			 txtInfoDialog.setText(Html.fromHtml(getString(R.string.steelDensity)));
		 }
		 else	txtInfoDialog.setText(text);
			
		//------------------------------------------------------------------
		
		//Читаем адрес картинки из Intent и пихаем его в адрес бэкграунта кашего ImageView
		imgInfoDialod = (ImageView) findViewById(R.id.imgInfoDialod);
		int imagePath = intent.getIntExtra("imagePath", 0);
		imgInfoDialod.setBackgroundResource(imagePath);
		//------------------------------------------------------------------
		
		btnOk = (Button) findViewById(R.id.btnOkDialog);
		btnOk.setOnClickListener(this);
		
		
	}
	@Override
	public void onClick(View v) {
		finish();
		
	}
}
