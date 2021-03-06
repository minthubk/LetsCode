/*******************************************************************************
 * Este código está bajo la licencia CC by sa 
 * http://creativecommons.org/licenses/by-sa/2.5/es/
 * 
 * Licencia que le permite copiar, distribuir y comunicar públicamente la obra, transformar la obra o hacer un uso comercial de esta obra siempre y cuando cumpla las condiciones de:
 * Reconocimiento — Debe reconocer los créditos de la obra de la manera especificada por el autor Jose B. Cortés (pero no de una manera que sugiera que tiene su apoyo o apoyan el uso que hace de su obra).
 * 
 * Compartir bajo la misma licencia — Si altera o transforma esta obra, o genera una obra derivada, sólo puede distribuir la obra generada bajo una licencia idéntica a ésta.
 ******************************************************************************/
package lets.code.project.intents;

import lets.code.project.R;
import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class IntentActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.intents);
		findViewById(R.id.llamar).setOnClickListener(callClickListener);
		findViewById(R.id.send).setOnClickListener(sendClikListener);
		findViewById(R.id.dial).setOnClickListener(dialClickListener);
		findViewById(R.id.mail).setOnClickListener(mailClickListener);
		findViewById(R.id.web_search).setOnClickListener(webSearchClickListener);
		findViewById(R.id.web).setOnClickListener(webClickListener);
		findViewById(R.id.geo).setOnClickListener(geoClickListener);
	}

	OnClickListener callClickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			
			Intent intent = new Intent(Intent.ACTION_CALL);
			intent.setData(Uri.parse("tel:+121231"));
			startActivity(intent);

		}
	};

	OnClickListener sendClikListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			Intent intent = new Intent(Intent.ACTION_SEND);
			intent.setType("text/plain");
			intent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
			intent.putExtra(Intent.EXTRA_TEXT, "Texto del Mail");
			startActivity(intent);

		}
	};

	OnClickListener mailClickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			Intent intent = new Intent(Intent.ACTION_SEND);
			intent.setType("application/octet-stream");  
			intent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
			intent.putExtra(Intent.EXTRA_TEXT, "Texto del Mail");
			intent.putExtra(Intent.EXTRA_EMAIL, new String[] {"user@example.com"});
			startActivity(intent);

		}
	};

	OnClickListener dialClickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			Intent intent = new Intent(Intent.ACTION_DIAL);
			startActivity(intent);

		}
	};


	OnClickListener webSearchClickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			
			Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
			intent.putExtra(SearchManager.QUERY, "Busqueda");
			startActivity(intent);

		}
	};

	OnClickListener webClickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			
			
			Intent intent = new Intent(Intent.ACTION_VIEW);
			intent.setData(Uri.parse("http://developing.frogtek.org/"));
			startActivity(intent);

		
		}
	};

	OnClickListener geoClickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			Intent intent = new Intent(Intent.ACTION_VIEW);
			intent.setData(Uri.parse("geo:42.135391,-0.403331"));
			startActivity(intent);
		}
	};





}
