package com.myapplicationdev.android.p04_revisionnotes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class RevisionNotesArrayAdapter extends ArrayAdapter<Note> {
	private Context context;
	private ArrayList<Note> notes;
	private int resource;
	private ImageView iv1, iv2, iv3, iv4, iv5;

	TextView tvNotes;

	public RevisionNotesArrayAdapter(Context context, int resource, ArrayList<Note> objects) {
		super(context, resource, objects);
		this.context = context;
		this.resource = resource;
		notes = objects;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		View rowView = inflater.inflate(R.layout.row, parent, false);

		iv1 = (ImageView) rowView.findViewById(R.id.imageView1star);
		iv2 = (ImageView) rowView.findViewById(R.id.imageView2star);
		iv3 = (ImageView) rowView.findViewById(R.id.imageView3star);
		iv4 = (ImageView) rowView.findViewById(R.id.imageView4star);
		iv5 = (ImageView) rowView.findViewById(R.id.imageView5star);
		tvNotes = (TextView) rowView.findViewById(R.id.textViewNote);

		Note note = notes.get(position);

		//Check if the property for starts >= 5, if so, "light" up the stars
		tvNotes.setText(note.getNoteContent().toString());
		if (note.getStars() == 5) {
			iv5.setImageResource(android.R.drawable.btn_star_big_on);
			iv4.setImageResource(android.R.drawable.btn_star_big_on);
			iv3.setImageResource(android.R.drawable.btn_star_big_on);
			iv2.setImageResource(android.R.drawable.btn_star_big_on);
			iv1.setImageResource(android.R.drawable.btn_star_big_on);
		} else if (note.getStars() == 4){
			iv5.setImageResource(android.R.drawable.btn_star_big_off);
			iv4.setImageResource(android.R.drawable.btn_star_big_on);
			iv3.setImageResource(android.R.drawable.btn_star_big_on);
			iv2.setImageResource(android.R.drawable.btn_star_big_on);
			iv1.setImageResource(android.R.drawable.btn_star_big_on);
		} else if (note.getStars() == 3){
			iv5.setImageResource(android.R.drawable.btn_star_big_off);
			iv4.setImageResource(android.R.drawable.btn_star_big_off);
			iv3.setImageResource(android.R.drawable.btn_star_big_on);
			iv2.setImageResource(android.R.drawable.btn_star_big_on);
			iv1.setImageResource(android.R.drawable.btn_star_big_on);

		} else if (note.getStars() == 2){
			iv5.setImageResource(android.R.drawable.btn_star_big_off);
			iv4.setImageResource(android.R.drawable.btn_star_big_off);
			iv3.setImageResource(android.R.drawable.btn_star_big_off);
			iv2.setImageResource(android.R.drawable.btn_star_big_on);
			iv1.setImageResource(android.R.drawable.btn_star_big_on);

		} else if (note.getStars() == 1){
			iv5.setImageResource(android.R.drawable.btn_star_big_off);
			iv4.setImageResource(android.R.drawable.btn_star_big_off);
			iv3.setImageResource(android.R.drawable.btn_star_big_off);
			iv2.setImageResource(android.R.drawable.btn_star_big_off);
			iv1.setImageResource(android.R.drawable.btn_star_big_on);
		}

		return rowView;
	}



}
