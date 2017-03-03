package security.test.com.testsecurity;

import android.app.Activity;
import android.content.Context;

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
import java.util.List;

/**
 * Created by root on 13.02.17.
 */
public class ListQuestions{
    ArrayList<Question> questions;
    private static ListQuestions instance;
    InputStream thisis;

    ListQuestions(InputStream is){
        thisis=is;
        questions=new ArrayList<Question>();
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];
        try {
            Reader reader = new BufferedReader(new InputStreamReader(thisis, "UTF-8"));
            int n;
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        String jsonString = writer.toString();
        try {
            JSONArray jsonArrayQuestions=new JSONArray(jsonString);
            for (int i=0 ; i<jsonArrayQuestions.length();i++){
                Question question=new Question();
                JSONObject jsonObjectQuestion=jsonArrayQuestions.getJSONObject(i);
                question.getQuestionFromJSON(jsonObjectQuestion);
                questions.add(question);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

//    public static ListQuestions getInstance(){
//        if (null == instance){
//            instance = new ListQuestions();
//        }
//        return instance;
//    }
}

