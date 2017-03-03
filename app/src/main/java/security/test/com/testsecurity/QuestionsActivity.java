package security.test.com.testsecurity;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;

public class QuestionsActivity extends SingleFragmentActivity {
    ArrayList<Question> questions;

    @Override
    protected Fragment createFragment() {
        InputStream is = getResources().openRawResource(R.raw.test);
        ListQuestions listQuestions=new ListQuestions(is);
        QuestionFragment questionFragment=new QuestionFragment();
        return questionFragment;
    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_questions);
//
//    }
}
