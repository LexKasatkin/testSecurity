package security.test.com.testsecurity;

import android.text.AndroidCharacter;

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
public class Question {
    String questionid;
    String questionstring;
    List<Answer> answers;

    Question(){
        answers=new ArrayList<Answer>();
    }

    public String getQuestionid() {
        return questionid;
    }

    public void setQuestionid(String questionid) {
        this.questionid = questionid;
    }

    public String getQuestionstring() {
        return questionstring;
    }

    public void setQuestionstring(String questionstring) {
        this.questionstring = questionstring;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public  void getQuestionFromJSON(JSONObject jsonObjectQuestion){

        try {
            if (jsonObjectQuestion.has("questionid")) {
                this.questionid = jsonObjectQuestion.getString("questionid");
            }
            if(jsonObjectQuestion.has("questionstring")){
                this.questionstring=jsonObjectQuestion.getString("questionstring");
            }
            if(jsonObjectQuestion.has("answers")){
                JSONArray jsonArrayAnswers= jsonObjectQuestion.getJSONArray("answers");
                for(int i=0; i<jsonArrayAnswers.length(); i++){
                    Answer answer=new Answer();
                    JSONObject jsonObjectAnswer=jsonArrayAnswers.getJSONObject(i);
                    answer.getAnswerFromJSON(jsonObjectAnswer);
                    this.answers.add(answer);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
