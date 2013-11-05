package com.example.taschenrechner;

import android.os.Bundle;
import android.app.Activity;
import android.content.res.Configuration;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import android.widget.Toast;
import de.congrace.exp4j.Calculable;
import de.congrace.exp4j.ExpressionBuilder;
import de.congrace.exp4j.UnknownFunctionException;

/**
 * Einfache Implementierung eines Taschenrechners
 * @author marc, mathias
 * @version 30.10.13
 */


public class Taschenrechner extends Activity
{
	//Flag zur Pruefung ob ein Komma setzbar ist
	private boolean dottable = true;
	
	//Deklaration der Operatoren und Operanden als Klassenkonstanten
	private static final String ONE 	= "1";
	private static final String TWO 	= "2";
	private static final String THREE 	= "3";
	private static final String FOUR 	= "4";
	private static final String FIVE 	= "5";
	private static final String SIX 	= "6";
	private static final String SEVEN 	= "7";
	private static final String EIGHT 	= "8";
	private static final String NINE 	= "9";
	private static final String ZERO 	= "0";
	private static final String PLUS 	= "+";
	private static final String MINUS 	= "-";
	private static final String MULT 	= "*";
	private static final String DIV 	= "/";
	private static final String DOT 	= ".";
	private static final String POWER 	= "^";
	private static final String TAN 	= "tan";
	private static final String COS 	= "cos";
	private static final String SIN 	= "sin";
	private static final String OPEN_BRACKET 	= "(";
	private static final String CLOSE_BRACKET 	= ")";
	
	//Deklaration der Widgets als Attribute
	private TextView 	ergebnisanzeige;
	private Button		einsbutton;
	private Button		zweibutton;
	private Button		dreibutton;
	private Button		vierbutton;
	private Button		fuenfbutton;
	private Button		sechsbutton;
	private Button		siebenbutton;
	private Button		achtbutton;
	private Button		neunbutton;
	private Button		zerobutton;
	private Button		plusbutton;
	private Button		minusbutton;
	private Button		mulbutton;
	private Button		divbutton;
	private Button 		gleichbutton;
	private Button 		punktbutton;
	private Button 		deletebutton;
	private Button		openbutton;
	private Button		closebutton;
	private Button		sinusbutton;
	private Button		cosinusbutton;
	private Button		tangensbutton;
	private Button		quadratbutton;
	
	//Deklaration der Listener
	OnClickListener ergebnisListener  = new OnClickListener()
	{
		public void onClick(View v)
		{
			try
			{
				//Berechnung des Ergebnisses
				Calculable calc = new ExpressionBuilder(ergebnisanzeige.getText().toString()).build();
				ergebnisanzeige.setText(String.valueOf(calc.calculate()));
			}catch(UnknownFunctionException e)
			{
				e.printStackTrace();
			}catch(Exception e)
			{	
				e.printStackTrace();
				Toast.makeText(Taschenrechner.this,"Keine Auswertung moeglich!",Toast.LENGTH_LONG).show();
			}
		}
	};
	
	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_taschenrechner);
		
		//Initialisierung der Widgetattribute und Setzen der Listener
		ergebnisanzeige = (TextView) findViewById(R.id.ergebnis);
		ergebnisanzeige.setText(ZERO);
		
		//Abfrage der gespeicherten Daten des Ergebnisfeldes bei Aenderung der Displayorientierung
		String data = (String) getLastNonConfigurationInstance();
		if(data != null)
			ergebnisanzeige.setText((String)getLastNonConfigurationInstance());
		
		gleichbutton = (Button) findViewById(R.id.Button_gleich);
		gleichbutton.setOnClickListener(ergebnisListener);
		
		einsbutton = (Button) findViewById(R.id.Button_eins);
		einsbutton.setOnClickListener(einsListener);
		
		zweibutton = (Button) findViewById(R.id.Button_zwei);
		zweibutton.setOnClickListener(zweiListener);
     
		dreibutton = (Button) findViewById(R.id.Button_drei);
		dreibutton.setOnClickListener(dreiListener);
     
     	vierbutton = (Button) findViewById(R.id.Button_vier);
     	vierbutton.setOnClickListener(vierListener);
     
     	fuenfbutton = (Button) findViewById(R.id.Button_fuenf);
     	fuenfbutton.setOnClickListener(fuenfListener);
     
     	sechsbutton = (Button) findViewById(R.id.Button_sechs);
     	sechsbutton.setOnClickListener(sechsListener);
     
     	siebenbutton = (Button) findViewById(R.id.button_sieben);
     	siebenbutton.setOnClickListener(siebenListener);
     
     	achtbutton = (Button) findViewById(R.id.Button_acht);
     	achtbutton.setOnClickListener(achtListener);
     
     	neunbutton = (Button) findViewById(R.id.Button_neun);
     	neunbutton.setOnClickListener(neunListener);
     
     	zerobutton = (Button) findViewById(R.id.Button_null);
     	zerobutton.setOnClickListener(nullListener);
     
     	plusbutton = (Button) findViewById(R.id.Button_plus);
     	plusbutton.setOnClickListener(plusListener);
     
     	minusbutton = (Button) findViewById(R.id.Button_sub);
     	minusbutton.setOnClickListener(minusListener);
     
     	divbutton = (Button) findViewById(R.id.Button_div);
     	divbutton.setOnClickListener(divListener);
     
     	mulbutton = (Button) findViewById(R.id.Button_mul);
     	mulbutton.setOnClickListener(multListener);
     
     	punktbutton = (Button) findViewById(R.id.Button_punkt);
     	punktbutton.setOnClickListener(dotListener);
     
     	deletebutton = (Button) findViewById(R.id.delete);
     	deletebutton.setOnClickListener(delListener);
     	
     	openbutton = (Button) findViewById(R.id.Button_bracket_open);
     	openbutton.setOnClickListener(openListener);
     	
     	closebutton = (Button) findViewById(R.id.Button_bracket_close);
     	closebutton.setOnClickListener(closeListener);
     	

     	
     	
	}
	
//	Configuration conf = getResources().getConfiguration(){ 
//	
//
//	if (conf.screenLayout == Configuration.SCREENLAYOUT_SIZE_XLARGE) {
//		
//		OnClickListener sinusListener = new View.OnClickListener()
//    	{
//    		public void onClick(View v)
//    		{
//    			dottable = true;
//    	    	
//    	    	if(ergebnisanzeige.getText().toString().equals(ZERO)) {
//    				ergebnisanzeige.setText(SIN);
//    	    		ergebnisanzeige.append(OPEN_BRACKET);
//    	    	} else {
//    				ergebnisanzeige.append(SIN);
//    				ergebnisanzeige.append(OPEN_BRACKET);
//    			}
//    		}
//    	};
//    	
//    	OnClickListener cosinusListener = new View.OnClickListener()
//    	{
//    		public void onClick(View v)
//    		{
//    			dottable = true;
//    	    	
//    	    	if(ergebnisanzeige.getText().toString().equals(ZERO)) {
//    				ergebnisanzeige.setText(COS);
//    	    		ergebnisanzeige.append(OPEN_BRACKET);
//    	    	} else {
//    				ergebnisanzeige.append(COS);
//    				ergebnisanzeige.append(OPEN_BRACKET);
//    			}
//    		}
//    	};
//    	
//    	OnClickListener tangensListener = new View.OnClickListener()
//    	{
//    		public void onClick(View v)
//    		{
//    			dottable = true;
//    	    	
//    	    	if(ergebnisanzeige.getText().toString().equals(ZERO)) {
//    				ergebnisanzeige.setText(TAN);
//    	    		ergebnisanzeige.append(OPEN_BRACKET);
//    	    	} else {
//    				ergebnisanzeige.append(TAN);
//    				ergebnisanzeige.append(OPEN_BRACKET);
//    			}
//    		}
//    	};
//    	
//    	OnClickListener quadratListener = new View.OnClickListener()
//    	{
//    		public void onClick(View v)
//    		{
//    			dottable = true;
//    	    	
//    	    	if(ergebnisanzeige.getText().toString().equals(ZERO)) {
//    				ergebnisanzeige.setText(POWER);
//    	    		ergebnisanzeige.append(OPEN_BRACKET);
//    	    	} else {
//    				ergebnisanzeige.append(POWER);
//    				ergebnisanzeige.append(OPEN_BRACKET);
//    			}
//    		}
//    	};
//			
//			
//			
//			sinusbutton = (Button) findViewById(R.id.Button_sinus);
//	     	sinusbutton.setOnClickListener(sinusListener);
//	     	
//	     	cosinusbutton = (Button) findViewById(R.id.Button_cosinus);
//	     	cosinusbutton.setOnClickListener(cosinusListener);
//	     	
//	     	tangensbutton = (Button) findViewById(R.id.Button_tangens);
//	     	tangensbutton.setOnClickListener(tangensListener);
//	     	
//	     	quadratbutton = (Button) findViewById(R.id.Button_quadrat);
//	        quadratbutton.setOnClickListener(quadratListener);
//	        
//	}
//		
		
		
//	switch (conf.screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) {
//	
//	
//		case Configuration.SCREENLAYOUT_SIZE_NORMAL: {
//			
//			
//			break; 	}
//			
//		case Configuration.SCREENLAYOUT_SIZE_XLARGE: {
//			
//			
//			
//			break; 	} 
//		
//		default: {
//			
//			break;  }
//		
//	}
//	
//	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.menu_main_taschenrechner, menu);
	    return true;
	}
	
	
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	
		switch (item.getItemId()) {
		
	    case R.id.weitere:
	    	    	
	    return true;
	    
	    case R.id.sinus:
	    	
	    	dottable = true;
	    	
	    	if(ergebnisanzeige.getText().toString().equals(ZERO)) {
				ergebnisanzeige.setText(SIN);
	    		ergebnisanzeige.append(OPEN_BRACKET);
	    	} else {
				ergebnisanzeige.append(SIN);
				ergebnisanzeige.append(OPEN_BRACKET);
			}
	    
	    return true;
	    
	    case R.id.cosinus:
	    	
	    	dottable = true;
	    	
	    	if(ergebnisanzeige.getText().toString().equals(ZERO)) {
				ergebnisanzeige.setText(COS);
				ergebnisanzeige.append(OPEN_BRACKET);
	    	} else {
				ergebnisanzeige.append(COS);
				ergebnisanzeige.append(OPEN_BRACKET);
	    	}
	    return true;
	    	
	    case R.id.tangens:
	    
	    	dottable = true;
	    	
	    	if(ergebnisanzeige.getText().toString().equals(ZERO)) {
				ergebnisanzeige.setText(TAN);
	    		ergebnisanzeige.append(OPEN_BRACKET);
	    	} else {
				ergebnisanzeige.append(TAN);
	    		ergebnisanzeige.append(OPEN_BRACKET);	
	    	}
	    return true;
	    
	    case R.id.quadrat:
	    	
	    	dottable = true;
	    	
	    	if(ergebnisanzeige.getText().toString().equals(ZERO))
				ergebnisanzeige.setText(POWER);
			else
				ergebnisanzeige.append(POWER);
	    	
	    return true;
	    
	    default:
	    return super.onOptionsItemSelected(item);
	}
	}
	
	
			
	OnClickListener einsListener = new View.OnClickListener()
	{
		public void onClick(View v)
		{
			if(ergebnisanzeige.getText().toString().equals(ZERO))
				ergebnisanzeige.setText(ONE);
			else
				ergebnisanzeige.append(ONE);
		}
	};
	    
	OnClickListener zweiListener =  new OnClickListener()
	{
		public void onClick(View v)
		{
			if(ergebnisanzeige.getText().toString().equals(ZERO))
				ergebnisanzeige.setText(TWO);
			else
				ergebnisanzeige.append(TWO);
		}
	};  
	    
	OnClickListener dreiListener = new View.OnClickListener()
	{
		public void onClick(View v)
		{
			if(ergebnisanzeige.getText().toString().equals(ZERO))
				ergebnisanzeige.setText(THREE);
			else
				ergebnisanzeige.append(THREE);
		}
	};
	    
	OnClickListener vierListener = new View.OnClickListener()
	{
		public void onClick(View v)
		{
			if(ergebnisanzeige.getText().toString().equals(ZERO))
				ergebnisanzeige.setText(FOUR);
			else
				ergebnisanzeige.append(FOUR);
		}
	};
	    
	OnClickListener fuenfListener = new View.OnClickListener()
	{
		public void onClick(View v)
		{
			if(ergebnisanzeige.getText().toString().equals(ZERO))
				ergebnisanzeige.setText(FIVE);
			else
				ergebnisanzeige.append(FIVE);
		}
	};
	    
	OnClickListener sechsListener = new View.OnClickListener()
	{
		public void onClick(View v)
		{
			if(ergebnisanzeige.getText().toString().equals(ZERO))
				ergebnisanzeige.setText(SIX);
			else
				ergebnisanzeige.append(SIX);
		}
	};
	    
	OnClickListener siebenListener = new View.OnClickListener()
	{
		public void onClick(View v)
		{
			if(ergebnisanzeige.getText().toString().equals(ZERO))
				ergebnisanzeige.setText(SEVEN);
			else
				ergebnisanzeige.append(SEVEN);
		}
	};
	    
	OnClickListener achtListener = new View.OnClickListener() 
	{
		public void onClick(View v)
		{
			if(ergebnisanzeige.getText().toString().equals(ZERO))
				ergebnisanzeige.setText(EIGHT);
			else
				ergebnisanzeige.append(EIGHT);
		}
	};
	    
	OnClickListener neunListener = new View.OnClickListener()
	{
		public void onClick(View v)
		{
			if(ergebnisanzeige.getText().toString().equals(ZERO))
				ergebnisanzeige.setText(NINE);
			else
				ergebnisanzeige.append(NINE);
		}
	};
	    
	OnClickListener nullListener = new View.OnClickListener()
	{
		public void onClick(View v)
		{
			if(!ergebnisanzeige.getText().toString().equals(ZERO))
				ergebnisanzeige.append(ZERO);
		}
	};
	    
	OnClickListener plusListener = new View.OnClickListener()
	{
		public void onClick(View v)
		{
			dottable = true;
			ergebnisanzeige.append(PLUS);
		}
	};
	    
	OnClickListener minusListener = new View.OnClickListener()
	{
		public void onClick(View v)
		{
			dottable = true;
			ergebnisanzeige.append(MINUS);
		}
	};
	    
	OnClickListener multListener = new View.OnClickListener()
	{
		public void onClick(View v)
		{
			dottable = true;
			ergebnisanzeige.append(MULT);
		}
	};
	    		
	OnClickListener divListener = new View.OnClickListener()
	{
		public void onClick(View v)
		{
			dottable = true;
			ergebnisanzeige.append(DIV);
		}
	};
	
	
	OnClickListener openListener = new View.OnClickListener()
	{
		public void onClick(View v)
		{
			dottable = true;
			ergebnisanzeige.append(OPEN_BRACKET);
		}
	};
	
	OnClickListener closeListener = new View.OnClickListener()
	{
		public void onClick(View v)
		{
			dottable = true;
			ergebnisanzeige.append(CLOSE_BRACKET);
		}
	};
	

		
	OnClickListener delListener = new View.OnClickListener()
	{
		public void onClick(View v)
		{
			if(ergebnisanzeige.length() == 1)
				ergebnisanzeige.setText(ZERO);
			if(!(ergebnisanzeige.getText().toString().equals(ZERO)))
			{
				if(ergebnisanzeige.getText().toString().charAt(ergebnisanzeige.getText().toString().length() - 1) == '.')
					dottable = true;
				ergebnisanzeige.setText(ergebnisanzeige.getText().toString().substring
									   (0, ergebnisanzeige.getText().toString().length() -1));
			}
		}
	};
		
	OnClickListener dotListener = new View.OnClickListener()
	{
		public void onClick(View v)
		{
			if(dottable)
			{
				dottable = false;
				ergebnisanzeige.append(DOT);
			}
		}
	};
	
	@Override
	/**
	 * Speichern der aktuellen Erbenisanzeige fuer Aenderung der Displayorientierung
	 * @return aktueller Wert der Anzeige-Textview
	 */
	public Object onRetainNonConfigurationInstance()
	{
		return ergebnisanzeige.getText().toString();
	}
	
	
}
