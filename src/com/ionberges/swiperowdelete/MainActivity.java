package com.ionberges.swiperowdelete;

import java.util.ArrayList;




import android.os.Bundle;
import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {


	ListView listView;
	ArrayList<String> arrayList = new ArrayList<String>();
	ArrayAdapter<String> adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		
		listView = (ListView) findViewById(R.id.listView1);

		
		arrayList.add("Row 1");
		arrayList.add("Row 2");
		arrayList.add("Row 3");
		arrayList.add("Row 4");
		arrayList.add("Row 5");
		arrayList.add("Row 6");
		arrayList.add("Row 7");
		arrayList.add("Row 8");
		arrayList.add("Row 9");
		arrayList.add("Row 10");

		
		adapter = new ArrayAdapter<String>( this, android.R.layout.simple_list_item_1, arrayList);
		listView.setAdapter(adapter);

		
		SwipeListViewTouchListener touchListener =new SwipeListViewTouchListener(listView,new SwipeListViewTouchListener.OnSwipeCallback() {
			@Override
			public void onSwipeLeft(ListView listView, int [] reverseSortedPositions) {
				
				arrayList.remove(reverseSortedPositions[0]);
				adapter.notifyDataSetChanged();
			}

			@Override
			public void onSwipeRight(ListView listView, int [] reverseSortedPositions) {
				
				arrayList.remove(reverseSortedPositions[0]);
				adapter.notifyDataSetChanged();
			}
		},true, false);
		
		
		listView.setOnTouchListener(touchListener);
		listView.setOnScrollListener(touchListener.makeScrollListener());
	}

}
