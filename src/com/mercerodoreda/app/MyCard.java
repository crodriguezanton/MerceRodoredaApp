package com.mercerodoreda.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mercerodoreda.app.R;
import com.mercerodoreda.app.R.id;
import com.mercerodoreda.app.R.layout;
import com.fima.cardsui.objects.Card;

public class MyCard extends Card {

	public MyCard(String title, String desc){
		super(title, desc);
	}

	@Override
	public View getCardContent(Context context) {
		View view = LayoutInflater.from(context).inflate(R.layout.card, null);

		((TextView) view.findViewById(R.id.title)).setText(title);
		((TextView) view.findViewById(R.id.description)).setText(desc);

		
		return view;
	}

	
	
	
}
