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

public class MyCardAsignatura extends Card {

	public MyCardAsignatura(String title, String desc, String ho, String hf){
		super(title, desc, ho, hf);
	}

	@Override
	public View getCardContent(Context context) {
		View view = LayoutInflater.from(context).inflate(R.layout.card_ex, null);

		((TextView) view.findViewById(R.id.title)).setText(title);
		((TextView) view.findViewById(R.id.description)).setText(desc);
		((TextView) view.findViewById(R.id.timeo)).setText(ho);
		((TextView) view.findViewById(R.id.time)).setText(hf);
		//TODO: Cases for colors

		
		return view;
	}

	
	
	
}
