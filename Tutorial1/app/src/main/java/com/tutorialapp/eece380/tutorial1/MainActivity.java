package com.tutorialapp.eece380.tutorial1;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.content.Intent;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //When the activity is created
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//set the XML Layout
    }

    public void onClickButton1(View view){
        //The method that is called by the XML code when button is clicked
        getFragmentManager().beginTransaction().add(R.id.container, new MyFragment()).commit();//creates the fragment
    }

    public void onClickButton3(View view){
        //The method that is called by the XML code when button3 is clicked
        Intent intent = new Intent(this, Activity2.class);
        intent.putExtra("Extra_Message", "Hello World!");//pass data between activities
        startActivity(intent);//start the activity
    }

    public static class MyFragment extends Fragment{

        public MyFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            //When the fragment is created
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            final Button b = (Button) rootView.findViewById(R.id.button2);//create a button defined in the XML code
            b.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(final View v) {
                    onClickb(v);//Called when the button is clicked
                }
            });
            return rootView;
        }

        public void onClickb(View v) {
            getActivity().getFragmentManager().beginTransaction().remove(this).commit();//removes the fragment
        }
    }
}
