package ua.kbb.com.springscalc;

import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;

public class MenuActivity extends Activity {

	 // создание меню
	@Override
    public boolean onCreateOptionsMenu(Menu menu)
	{
		menu.add(0, 0, 1, "О приложении");
		menu.add(0, 1, 1, "Настройки");
		menu.add(1, 2, 1, "Выход");
		
		return super.onCreateOptionsMenu(menu);
	}
	
	// обновление меню
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
      return super.onPrepareOptionsMenu(menu);
    }
    
 // обработка нажатий
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
      
    	switch (item.getItemId())
    	{
    	case 0: //О приложении
    		Intent intent = new Intent(this, About.class);
    		startActivity(intent);
    		break;
    	case 1: //Настройки
    		
    		break;
    	case 2: //Выход
    		finish();
    		break;
    	}      
      return super.onOptionsItemSelected(item);
    }
}
