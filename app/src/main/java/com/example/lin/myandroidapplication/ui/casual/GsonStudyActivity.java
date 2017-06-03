package com.example.lin.myandroidapplication.ui.casual;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.lin.myandroidapplication.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class GsonStudyActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String JSON_STRING_01 = "{'name':'John', 'age':20}";
    public static final String JSON_STRING_03 = "[{'name':'John','age': 14, 'grade':[{'course':'English','score':100},{'course':'Math','score':78}]},{'name':'Tom', 'age': 15, 'grade':[{'course':'English','score':86},{'course':'Math','score':90}]}]";
    public static final String JSON_STRING_04 = "{'name':'tom','score':{'Math':98,'English':90}}";

    private Button mGsonBtn01;
    private Button mGsonBtn02;
    private Button mGsonBtn03;
    /**
     * object转换gson(array)
     */
    private Button mGsonBtn04;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gson_study);
        initView();
    }

    private void initView() {
        mGsonBtn01 = (Button) findViewById(R.id.gson_btn_01);
        mGsonBtn01.setOnClickListener(this);
        mGsonBtn02 = (Button) findViewById(R.id.gson_btn_02);
        mGsonBtn02.setOnClickListener(this);
        mGsonBtn03 = (Button) findViewById(R.id.gson_btn_03);
        mGsonBtn03.setOnClickListener(this);
        mGsonBtn04 = (Button) findViewById(R.id.gson_btn_04);
        mGsonBtn04.setOnClickListener(this);
    }

    private static final String TAG = "GsonStudyActivity";

    @Override
    public void onClick(View v) {
        Gson gson = new Gson();
        switch (v.getId()) {
            case R.id.gson_btn_01:
//                Student student = gson.fromJson(JSON_STRING_01, Student.class);
                Student student = gson.fromJson(JSON_STRING_01, new TypeToken<Student>() {
                }.getType());
                Log.d(TAG, student.toString());
                break;
            case R.id.gson_btn_02:
                List<Student> students = gson.fromJson(JSON_STRING_03, new TypeToken<List<Student>>() {
                }.getType());
                for (Student student2 : students) {
                    Log.d(TAG, student2.toString());
                }
                break;
            case R.id.gson_btn_03:
                try {
                    JSONObject jsonObject = new JSONObject(JSON_STRING_01);
                    String name = (String) jsonObject.get("name");
                    int age = (int) jsonObject.get("age");
                    Log.d(TAG, "name: " + name + "  age: " + age);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.gson_btn_04:
                try {
                    JSONArray jsonArray = new JSONArray(JSON_STRING_03);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject object = jsonArray.getJSONObject(i);
                        String name = object.getString("name");
                        int age = object.getInt("age");
                        JSONArray array = object.getJSONArray("grade");
                        for (int j = 0; j < array.length(); j++) {
                            JSONObject gradeObject = array.getJSONObject(j);
                            String gradeName = gradeObject.getString("course");
                            int gradeScore = gradeObject.getInt("score");
                            Log.d(TAG, "name: " + name + "  age: " + age
                                    + "  gradeName: " + gradeName + "  gradeScore: " + gradeScore);
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    public static class Student {
        private String name;
        private int age;
        private List<Grade> grade;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public static class Grade {
            private String course;
            private String level;
            private int score;

            public String getCourse() {
                return course;
            }

            public void setCourse(String course) {
                this.course = course;
            }

            public String getLevel() {
                return level;
            }

            public void setLevel(String level) {
                this.level = level;
            }

            public int getScore() {
                return score;
            }

            public void setScore(int score) {
                this.score = score;
            }

            @Override
            public String toString() {
                return "grade{" +
                        "course='" + course + '\'' +
                        ", level='" + level + '\'' +
                        ", score=" + score +
                        '}';
            }
        }

        public List<Grade> getGrade() {
            return grade;
        }

        public void setGrade(List<Grade> grade) {
            this.grade = grade;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", grade=" + grade +
                    '}';
        }
    }

}
