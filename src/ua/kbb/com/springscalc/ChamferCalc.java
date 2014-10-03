package ua.kbb.com.springscalc;

import java.math.BigDecimal;
import java.math.RoundingMode;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class ChamferCalc extends MenuActivity implements OnClickListener{

	Button 
		btnBack, 
		btnSolve;
	EditText 
		etD,
		etd,
		etMaxDef,
		ett;
	
	TextView 
		tvF,
		tvS1,
		tvS2,
		tvS3,
		tvC;
	
	EditText
		edtChamferWidth;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.chamfer);
		
		btnSolve = (Button)findViewById(R.id.btnSolve);
		btnSolve.setOnClickListener(this);
		
		btnBack = (Button)findViewById(R.id.btnBack);
		btnBack.setOnClickListener(this);
		
		etD = (EditText)findViewById(R.id.etD);
		etd = (EditText)findViewById(R.id.etd);
		etMaxDef = (EditText)findViewById(R.id.etMaxDef);
		ett = (EditText)findViewById(R.id.ett);		
		
		tvF = (TextView) findViewById(R.id.tvF);
		tvC = (TextView) findViewById(R.id.tvC);
		
		tvS1 = (TextView)findViewById(R.id.tvS1);
		tvS2 = (TextView)findViewById(R.id.tvS2);
		tvS3 = (TextView)findViewById(R.id.tvS3);
	}

	@Override
	public void onClick(View v){
		
		double D = 0, d = 0, S3 = 0, t = 0, A;
		double E = 2.06;
		double mu = 0.3;
		double ro = 7.85;
		
		
		switch (v.getId()) {
		case R.id.btnBack:
			finish();
			break;

		case R.id.btnSolve:
			
			String strD, strd, strS3, strt;
			
			strD = etD.getText().toString();
			strd = etd.getText().toString();
			strS3 = etMaxDef.getText().toString();
			strt = ett.getText().toString();
			
			//Проверка. Если поля незаполнены или значение = 0, то появляется предупреждение.
			if((etD.getText().toString()).isEmpty() || "0".equals(strD)){
				Toast.makeText(this, "Проверьте данные в поле D", Toast.LENGTH_LONG).show();
			}
			else if(strd.isEmpty() || "0".equals(strd)){
				Toast.makeText(this, "Проверьте данные в поле d", Toast.LENGTH_LONG).show();
			}
			else if(strS3.isEmpty() || "0".equals(strS3)){
				Toast.makeText(this, "Проверьте данные в поле S3", Toast.LENGTH_LONG).show();
			} else if(strt.isEmpty() || "0".equals(strt)){
				Toast.makeText(this, "Проверьте данные в поле t", Toast.LENGTH_LONG).show();
			} else {
				//Проврека пройдена! Далее происходит расчет и вывод данных
				//Парсинг значений из 4-ех EditText в тип double для дальнейших расчетов
				D = Double.parseDouble(etD.getText().toString());
				d = Double.parseDouble(etd.getText().toString());
				S3 = Double.parseDouble(etMaxDef.getText().toString());
				t = Double.parseDouble(ett.getText().toString());
			
				// Проверка. Если внешний диаметр меньше внутреннего, то вывод предупреждения 
			
				if (D<=d) Toast.makeText(this, "Непуть, наружный диаметр всегда больше внутреннего!", Toast.LENGTH_LONG).show();
				else
				{
					A=D/d;
					
					double Y=1/Math.PI*6/Math.log(A)*Math.pow(((A-1)/A), 2);
					double m = (ro*Math.pow(10,-6)*Math.PI)/4*(Math.pow(D, 2) - Math.pow(d, 2))*t;
				 	double w = new BigDecimal(m).setScale(2, RoundingMode.UP).doubleValue();
					double C1 = 1/Math.PI*6/Math.log(A)*((A-1)/Math.log(A) -1);
					double C2 = (3*(A-1))/(Math.PI*Math.log(A));
					
					String str = "\u03C3";		
					String r="";
					String aa="";
					String bb="";
					tvF.setText(null);
					tvS1.setText(null);
					tvS2.setText(null);
					tvS3.setText(null);
					tvC.setText(null);
					tvF.append("Масса пружины"  + "=" + w + "	" + "кг" + "\n" + "\n");
					
					for (double a=0.2;a<=1;a=a+0.2)
					{
						double g = new BigDecimal(a).setScale(1, RoundingMode.DOWN).doubleValue();		 
						double s = S3*a;
				      	double Fa = (((4*E*Math.pow(10, 5)*s))/((1-mu*mu)*Y*D*D))*((S3-s)*(S3-s/2)*t+t*t*t);
				      	double k = new BigDecimal(Fa).setScale(2, RoundingMode.UP).doubleValue();	
				      	
				       	double SigaI=((4*E*Math.pow(10,5)*s)/((1-mu*mu)*Y*D*D))*(-(S3-s/2)*C1-(C2*t));  
				      	double x = new BigDecimal(SigaI).setScale(2, RoundingMode.UP).doubleValue();
				     	r=DoubleColor.change(x, 2940);
				      	 
				      	double SigaII=((4*E*Math.pow(10,5)*s)/((1-mu*mu)*Y*D*D))*(-(S3-s/2)*C1+(C2*t));
				      	double l = new BigDecimal(SigaII).setScale(2, RoundingMode.UP).doubleValue();
				      	aa=DoubleColor.change(l, 1760);
				      	
				      	double SigaIII=((4*E*Math.pow(10,5)*s*d)/((1-mu*mu)*Y*D*D*D))*((2*C2-C1)*(S3-s/2)+C2*t);
				      	double n = new BigDecimal(SigaIII).setScale(2, RoundingMode.UP).doubleValue();
				      	bb=DoubleColor.change(n, 1760);
				      	
				      	//double C=(((4*E*Math.pow(10,5)*Math.pow(s,3))/((1-Math.pow(mu,2))*Y*Math.pow(D,2))))*((Math.pow((S3/t),2)-3*(S3/t)*(s/t)+3/2*Math.pow((s/t),2)+1));
				      	double C=((4*E*Math.pow(10, 5))/(1-Math.pow(mu, 2)))*(Math.pow(s, 3)/(Y*Math.pow(D, 2)))*((Math.pow(S3/t, 2))-(3*S3/t*s/t)+(3/2*Math.pow(s/t, 2)+1));
				      	double z = new BigDecimal(C).setScale(2, RoundingMode.UP).doubleValue();
				      	//tvResult.append("Напряжение на первой кромке = "+"\n"+ x );
				      	//tvResult.append("Напряжение на второй кромке ="+"\n" + l );
				        //tvResult.append("Напряжение на третьей кромке ="+"\n" + n);
				       // tvResult.append("Напряжение на третьей кромке ="+"\n" + z);
				      	
				    	
				      	if (x>2940) 
				      	{ if (l>1760)
				      	{ if (n>1760){
				        Toast toast = Toast.makeText(getApplicationContext(), 
				      	"Воу оу оу , полегче!", Toast.LENGTH_SHORT); 
				      	toast.show(); 
				      	}}}
				      	tvF.setMovementMethod(new ScrollingMovementMethod());
				      	tvF.append("F" + "	" + "(" + g + ")" + "=" + k + "	" + "Н" + "\n" );
				      	tvS1.append((str + "" + "I" + "(" + g + ")" + "=" + x + "\t" + "МПа" + "\n"));
						tvS2.append((str + "" + "II" + "(" + g + ")" + "=" + n + "\t" + "МПа") + "\n");
						tvS3.append((str + "" + "III" + "(" + g + ")" + "=" + z + "\t" + "МПа" )+ "\n");
				      	tvC.append("C" + "	" + "(" + g + ")" + "=" + z + "	" + "Н/мм" + "\n" );
					}
				}
				 
			}

			break;
		}
	}
			
		
}
	
	

