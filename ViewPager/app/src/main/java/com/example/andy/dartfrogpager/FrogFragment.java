package com.example.andy.dartfrogpager;



import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 *
 */
public class FrogFragment extends Fragment {


    public final static String FROG_SCIENTIFIC_NAME = "frog scientific name";
    public final static String FROG_DESCRIPTION = "frog description";
    public final static String FROG_IMAGE = "frog image";


    public FrogFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_frog, container, false);

        Bundle args = getArguments();
        if (args != null) {
            setViews(view, args);
        }


        return view;
    }

    private void setViews(View view, Bundle args) {
        TextView frogName = (TextView) view.findViewById(R.id.frogName);
        TextView frogDescription = (TextView) view.findViewById(R.id.frogDescription);
        ImageView frogImage = (ImageView) view.findViewById(R.id.frogImage);

        frogName.setText(args.getString(FROG_SCIENTIFIC_NAME));
        frogDescription.setText(args.getString(FROG_DESCRIPTION));
        frogImage.setImageResource(args.getInt(FROG_IMAGE));
    }


}
