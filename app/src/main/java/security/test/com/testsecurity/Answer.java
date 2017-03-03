package security.test.com.testsecurity;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by root on 13.02.17.
 */
public class Answer {
    String answerid;
    String answerstring;
    boolean answerbool;

    public String getAnswerid() {
        return answerid;
    }

    public void setAnswerid(String answerid) {
        this.answerid = answerid;
    }

    public String getAnswerstring() {
        return answerstring;
    }

    public void setAnswerstring(String answerstring) {
        this.answerstring = answerstring;
    }

    public boolean getAnswerbool() {
        return answerbool;
    }

    public void setAnswerbool(boolean answerbool) {
        this.answerbool = answerbool;
    }

    Answer(){

    }

    public void getAnswerFromJSON(JSONObject jsonObjectAnswer){
        try {
            if (jsonObjectAnswer.has("answerid")) {
                this.answerid = jsonObjectAnswer.getString("answerid");
            }
            if (jsonObjectAnswer.has("answerbool")) {
                this.answerbool = Boolean.valueOf(jsonObjectAnswer.getString("answerbool"));
            }
            if (jsonObjectAnswer.has("answerstring")) {
                this.answerstring = jsonObjectAnswer.getString("answerstring");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
