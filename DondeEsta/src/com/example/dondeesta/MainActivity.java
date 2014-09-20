package com.example.dondeesta;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends ActionBarActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//Crear los objetos que tendran representacion grafica y acciones
		final Button boton = (Button)findViewById(R.id.button1);
		final EditText texto = (EditText)findViewById(R.id.editText1);
		
		//Crear el oyente para el boton
		boton.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View v) {
				//comprueba que texto contenga algun valor
				//si texto eesta vacio, no se creará en intent ni se lanzará la activity
				if (!texto.getText().toString().isEmpty()){
					//Crea el intent para maps
					Intent mapa = new Intent (android.content.Intent.ACTION_VIEW,
						Uri.parse("geo:0,0?q="+ texto.getText().toString()));
				
					//lanza la activity
					startActivity(mapa);
				}						
			}		
		});			
	}

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
	}
}
