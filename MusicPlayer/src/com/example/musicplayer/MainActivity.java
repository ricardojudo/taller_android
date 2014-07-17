package com.example.musicplayer;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

import com.example.musicplayer.model.Tune;

public class MainActivity extends Activity {

	private List<Tune> tunes;

	private ListIterator<Tune> itTunes;

	private Tune currentTune;

	private ImageView album;

	private RatingBar ratingBar;

	private SeekBar seekBar;
	
	private Gallery gallery;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		tunes = new ArrayList<Tune>();
		tunes.add(new Tune("3.01", R.drawable.fuck_me_too));
		tunes.add(new Tune("3.01", R.drawable.alien_vampires));
		tunes.add(new Tune("3.01", R.drawable.grendel));

		album = (ImageView) findViewById(R.id.album);
		ratingBar = (RatingBar) findViewById(R.id.ratingBar);
		ratingBar.setOnRatingBarChangeListener(new OnRatingBarChangeListener() {
			@Override
			public void onRatingChanged(RatingBar ratingBar, float rating,
					boolean fromUser) {
				currentTune.setRating(rating);
			}
		});

		seekBar = (SeekBar) findViewById(R.id.seekBar);
		seekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				// TODO Auto-generated method stub
				
			}
		});
		itTunes = tunes.listIterator();
	}

	public void nextTune(View view) {
		if (!itTunes.hasNext()) {
			itTunes = tunes.listIterator();
		}

		currentTune = itTunes.next();
		album.setImageResource(currentTune.getImage());
		ratingBar.setRating(currentTune.getRating());
	}

	public void prevTune(View view) {
		if (!itTunes.hasPrevious()) {
			itTunes = tunes.listIterator(tunes.size());
		}

		currentTune = itTunes.previous();
		album.setImageResource(currentTune.getImage());
		ratingBar.setRating(currentTune.getRating());
	}

}
