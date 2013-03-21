package com.mercerodoreda.app;


import com.mercerodoreda.app.R;
import com.fima.cardsui.objects.CardStack;
import com.fima.cardsui.views.CardUI;
import com.slidingmenu.lib.app.SlidingActivity;

import android.os.Bundle;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class MainActivity extends SlidingActivity {
	
	public static final String PREFS_NAME = "MyPreferencesFile";
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setBehindContentView(R.layout.sidebar);
		setSlidingActionBarEnabled(false);
		getActionBar().setDisplayShowTitleEnabled(false);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		//Custom Action Bar
		//getActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
		//getActionBar().setCustomView(R.layout.bottom_action_bar);
		getSlidingMenu().setBehindOffsetRes(R.dimen.sm_default);
		getSlidingMenu().setShadowWidthRes(R.dimen.shadow_width);
		getSlidingMenu().setShadowDrawable(R.drawable.shadow);
		//Sliding Menu
        //SlidingMenu menu = new SlidingMenu(this);
        //menu.setMode(SlidingMenu.LEFT);
        //menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);
       // menu.setShadowWidthRes(R.dimen.shadow_width);
       // menu.setShadowDrawable(R.drawable.shadow);
       // menu.setFadeDegree(0.35f);
        //menu.setBehindOffsetRes(R.dimen.sm_default);
       // menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
       // menu.setMenu(R.layout.sidebar);
        
        
        CardUI mCardView = (CardUI) findViewById(R.id.cardsview);
        mCardView.setSwipeable(false);
        


     		// add AndroidViews Cards
     		mCardView.addCard(new MyCard("Nova aplicació de l'Institut","Test"));
     		mCardView.addCardToLastStack(new MyCard("Mercè Rodoreda", "Test"));
     		MyCard androidViewsCard = new MyCard("Per dispositius Android","Test");
     		androidViewsCard.setOnClickListener(new OnClickListener() {

     			@Override
     			public void onClick(View v) {
     					shownotification();
     			}
     		});
     		mCardView.addCardToLastStack(androidViewsCard);

     		// add one card, and then add another one to the last stack.
     		mCardView.addCard(new MyCardAsignatura("Català","Mònica Pèrez", "9:00", "10:00"));
     		//mCardView.addCardToLastStack(new MyCard("2 cards","test"));
     		//mCardView.addCardToLastStack(new MyCard("2 cards","test"));

     		// add one card
     		mCardView.addCard(new MyImageCard("Nexus 4 Part 1",R.drawable.url1));
     		mCardView.addCardToLastStack(new MyImageCard("Nexus 4 Part 2",R.drawable.url2));
     		mCardView.addCardToLastStack(new MyImageCard("Nexus 4 Part 3", R.drawable.url3));

     		
     		
     		// create a stack
     		CardStack stack = new CardStack();
     		stack.setTitle("Títol de l'apartat");

     		// add 3 cards to stack
     		stack.add(new MyCard("3 cards", "test"));
     		stack.add(new MyCard("3 cards", "test"));
     		stack.add(new MyCard("3 cards", "test"));
     		
     		mCardView.addCard(new MyImageCard("Nexus 4 Part 1",R.drawable.url1));
     		mCardView.addCardToLastStack(new MyImageCard("Nexus 4 Part 2",R.drawable.url2));
     		mCardView.addCardToLastStack(new MyImageCard("Nexus 4 Part 3", R.drawable.url3));


     		// add stack to cardView
     		mCardView.addStack(stack);

     		// draw cards
     		mCardView.refresh();
     		
     		//SharedPreferences
     		SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
     		TextView v = (TextView)findViewById(R.id.username_TextView);
     		v.setText(settings.getString("username", "Inicia la Sessió"));
     		
     		//Sidebar Buttons
     		//String[] navigation = getResources().getStringArray(R.array.navigation);
            // Binding resources Array to ListAdapter
            //this.setListAdapter(new ArrayAdapter<String>(this, R.layout.navigation_item, R.id.navigation_item_view, navigation));
	}


	protected void shownotification() {
		NotificationCompat.Builder mBuilder =
		        new NotificationCompat.Builder(this)
		        .setSmallIcon(R.drawable.merce_rodoreda_logo)
		        .setContentTitle("My notification")
		        .setContentText("Hello World!");
		// Creates an explicit intent for an Activity in your app
		Intent resultIntent = new Intent(this, MainActivity.class);

		// The stack builder object will contain an artificial back stack for the
		// started Activity.
		// This ensures that navigating backward from the Activity leads out of
		// your application to the Home screen.
		TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
		// Adds the back stack for the Intent (but not the Intent itself)
		stackBuilder.addParentStack(MainActivity.class);
		// Adds the Intent that starts the Activity to the top of the stack
		stackBuilder.addNextIntent(resultIntent);
		PendingIntent resultPendingIntent =
		        stackBuilder.getPendingIntent(
		            0,
		            PendingIntent.FLAG_UPDATE_CURRENT
		        );
		mBuilder.setContentIntent(resultPendingIntent);
		NotificationManager mNotificationManager =
		    (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		// mId allows you to update the notification later on.
		mNotificationManager.notify(0, mBuilder.build());
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	public boolean onOptionsItemSelected (MenuItem item) {
		switch (item.getItemId()) {
		case R.id.menu_login:
			startActivity (new Intent (this, LoginActivity.class));
			return true;
		case R.id.menu_settings:
			startActivity (new Intent (this, SettingsActivity.class));
			return true;
		case android.R.id.home:
            // app icon in action bar clicked; go home
            toggle();
            return true;
			
			default:
				return super.onOptionsItemSelected(item);
		}
	}
	
	public void gotoLogin (View v){
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        MainActivity.this.startActivity(intent);
	}

	public void EditUsername (View v) {
		TextView text = (TextView) findViewById(R.id.username_TextView);
		text.setText("Hola");
	}
	
		
}
