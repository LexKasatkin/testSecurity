package security.test.com.testsecurity;

import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.io.InputStream;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link QuestionFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link QuestionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QuestionFragment extends android.support.v4.app.Fragment {


    private OnFragmentInteractionListener mListener;
    private RadioGroup rg;
    private RadioButton rb;
    TextView tvQuestion;
    int numberQuestion=0;
    int rightAnswer;
    Button btnAnswer;
    ImageButton btnNext;
    ImageButton btnBack;

    public QuestionFragment() {

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment QuestionFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static QuestionFragment newInstance(String param1, String param2) {
        QuestionFragment fragment = new QuestionFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_question, container, false);
        tvQuestion=(TextView)v.findViewById(R.id.tvQuestion);
        rg = (RadioGroup) v.findViewById(R.id.radio_group);
        btnNext= (ImageButton) v.findViewById(R.id.btnNext);
        btnBack=(ImageButton)v.findViewById(R.id.btnBack);
        InputStream is = getResources().openRawResource(R.raw.test);
        final ListQuestions listQuestions=new ListQuestions(is);
        tvQuestion.setText(listQuestions.questions.get(numberQuestion).questionstring);
        ArrayList<String> s=new ArrayList<String>();
        for(int i=0;i<listQuestions.questions.get(numberQuestion).answers.size();i++) {
             s.add(listQuestions.questions.get(numberQuestion).answers.get(i).answerstring);
        }
        showRadioButtonDialog(s, v);
        numberQuestion++;
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(numberQuestion+1==listQuestions.questions.size()){
                    btnNext.setVisibility(View.INVISIBLE);
                } else if(numberQuestion!=1){
                    btnBack.setVisibility(View.VISIBLE);
                }
                if (numberQuestion < listQuestions.questions.size()) {
                    rg.removeAllViews();
                    tvQuestion.setText(listQuestions.questions.get(numberQuestion).questionstring);
                    ArrayList<String> s = new ArrayList<String>();
                    for (int i = 0; i < listQuestions.questions.get(numberQuestion).answers.size(); i++) {
                        s.add(listQuestions.questions.get(numberQuestion).answers.get(i).answerstring);
                        if(listQuestions.questions.get(numberQuestion).answers.get(i).answerbool){
                            rightAnswer=i;
                        }
                    }
                    showRadioButtonDialog(s, v);
                    numberQuestion++;
                }
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(numberQuestion==1){
                    btnBack.setVisibility(View.INVISIBLE);
                }else if(numberQuestion+1!=listQuestions.questions.size()){
                    btnNext.setVisibility(View.VISIBLE);
                }
                numberQuestion--;
                if (numberQuestion < listQuestions.questions.size()) {
                    rg.removeAllViews();
                    tvQuestion.setText(listQuestions.questions.get(numberQuestion).questionstring);
                    ArrayList<String> s = new ArrayList<String>();
                    for (int i = 0; i < listQuestions.questions.get(numberQuestion).answers.size(); i++) {
                        s.add(listQuestions.questions.get(numberQuestion).answers.get(i).answerstring);
                        if(listQuestions.questions.get(numberQuestion).answers.get(i).answerbool){
                            rightAnswer=i;
                        }
                    }
                    showRadioButtonDialog(s, v);
                }
            }
        });
        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    private void showRadioButtonDialog(ArrayList<String> arrayList, View v) {
        ArrayList<String> stringList=new ArrayList<>();  // here is list
        for(int i=0;i<arrayList.size();i++){
            rb=new RadioButton(getActivity()); // dynamically creating RadioButton and adding to RadioGroup.
            rb.setText(arrayList.get(i).toString());
//            rb.setChecked(true);
            rg.addView(rb);
        }
    }

}
