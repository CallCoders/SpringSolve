package ua.kbb.com.springscalc;

import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;

public class MenuActivity extends Activity {

	 // �������� ����
	@Override
    public boolean onCreateOptionsMenu(Menu menu)
	{
		menu.add(0, 0, 1, "� ����������");
		menu.add(0, 1, 1, "���������");
		menu.add(1, 2, 1, "�����");
		
		return super.onCreateOptionsMenu(menu);
	}
	
	// ���������� ����
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
      return super.onPrepareOptionsMenu(menu);
    }
    
 // ��������� �������
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
      
    	switch (item.getItemId())
    	{
    	case 0: //� ����������
    		Intent intent = new Intent(this, About.class);
    		startActivity(intent);
    		break;
    	case 1: //���������
    		
    		break;
    	case 2: //�����
    		finish();
    		break;
    	}      
      return super.onOptionsItemSelected(item);
    }
}
