package ua.kbb.com.springscalc;

public class DoubleColor {
	
	
	static String change (double x, int uslovie)
	{
	String f;

	if(x > uslovie)
	{
	f = "<br><font color=\"red\" face=\"Times New Roman\">" + x + "</font>";
	}
	else f = "<br><font color=\"blue\">" + x + "</font>";

	return f;
	}

}

