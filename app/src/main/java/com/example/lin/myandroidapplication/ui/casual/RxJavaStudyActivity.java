package com.example.lin.myandroidapplication.ui.casual;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.lin.myandroidapplication.R;
import com.example.lin.myandroidapplication.data.net.BaseBean;
import com.example.lin.myandroidapplication.network.ErrorAction;
import com.example.lin.myandroidapplication.network.SuccessAction;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;

public class RxJavaStudyActivity extends AppCompatActivity {

    private static final String TAG = "RxJavaStudyActivity";
    private static int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_java_study);
        ////
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onCompleted() {
                Log.d(TAG, "completed");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                Log.d(TAG, s);
            }
        };

        Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("你好");
                subscriber.onNext("RxJava");
                subscriber.onCompleted();
            }
        });
        observable.subscribe(observer);
        /////
        Observable.just("Hello", "again RxJava")
                .subscribe(new Observer<String>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "completed");
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(String s) {
                        Log.d(TAG, s);
                    }
                });
        ////
        List<Student.Course> courses = new ArrayList<>();
        courses.add(new Student.Course("物理" + count++));
        courses.add(new Student.Course("化学" + count++));
        courses.add(new Student.Course("数学" + count++));
        courses.add(new Student.Course("生物" + count++));

        Student student = new Student("小明", 17, courses);
        List<Student> students = new ArrayList<>();
        students.add(student);
        students.add(new Student("小红", 17, courses));
        students.add(new Student("小张", 17, courses));

        Observable.just(student)
                .map(new Func1<Student, List<Student.Course>>() {
                    @Override
                    public List<Student.Course> call(Student student) {
                        return student.getCourses();
                    }
                })
                .subscribe(new Action1<List<Student.Course>>() {
                    @Override
                    public void call(List<Student.Course> courses) {
                        for (Student.Course course : courses) {
                            Log.d("RxJavaStudyActivity", course.getName());
                        }
                    }
                });

        /////

        Observable.from(students)
                .flatMap(new Func1<Student, Observable<Student.Course>>() {
                    @Override
                    public Observable<Student.Course> call(Student student) {
                        return Observable.from(student.getCourses());
                    }
                })

                .subscribe(new Action1<Student.Course>() {
                    @Override
                    public void call(Student.Course course) {
                        Log.d(TAG, course.getName());
                    }
                });
        /////
        StudentBean studentBean = new StudentBean();
        Observable.just(studentBean)
                .subscribe(new SuccessAction<StudentBean>() {

                    @Override
                    public void success(StudentBean studentBean) {

                    }
                }, new ErrorAction() {
                    @Override
                    public void error(Throwable throwable) {

                    }
                });

    }

    static class Student{
        private String name;
        private int age;
        List<Course> courses;

        public Student(String name, int age, List<Course> courses) {
            this.name = name;
            this.age = age;
            this.courses = courses;
        }

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

        public List<Course> getCourses() {
            return courses;
        }

        public void setCourses(List<Course> courses) {
            this.courses = courses;
        }

        static class Course {
            private String name;

            public Course(String name) {
                this.name = name;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }

    class StudentBean extends BaseBean<Student> {


        private Student student;

        public Student getStudent() {
            return student;
        }

        public void setStudent(Student student) {
            this.student = student;
        }
    }
}
