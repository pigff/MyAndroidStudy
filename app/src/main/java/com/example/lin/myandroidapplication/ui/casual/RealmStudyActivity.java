package com.example.lin.myandroidapplication.ui.casual;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.lin.myandroidapplication.R;
import com.example.lin.myandroidapplication.realm.data.Dog;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmAsyncTask;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;

public class RealmStudyActivity extends AppCompatActivity implements View.OnClickListener {

    private Realm mRealm;
    private RealmAsyncTask mAsyncTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realm_study);
        mRealm = Realm.getDefaultInstance();
        Button addBtn = (Button) findViewById(R.id.btn_add_data);
        Button deleteBtn = (Button) findViewById(R.id.btn_delete_data);
        Button queryBtn = (Button) findViewById(R.id.btn_query_data);
        Button updateBtn = (Button) findViewById(R.id.btn_update_data);
        addBtn.setOnClickListener(this);
        deleteBtn.setOnClickListener(this);
        queryBtn.setOnClickListener(this);
        updateBtn.setOnClickListener(this);
        Button syncAddBtn = (Button) findViewById(R.id.btn_sync_add_data);
        Button syncDeleteBtn = (Button) findViewById(R.id.btn_sync_delete_data);
        Button syncQueryBtn = (Button) findViewById(R.id.btn_sync_query_data);
        Button syncUpdateBtn = (Button) findViewById(R.id.btn_sync_update_data);
        syncAddBtn.setOnClickListener(this);
        syncDeleteBtn.setOnClickListener(this);
        syncQueryBtn.setOnClickListener(this);
        syncUpdateBtn.setOnClickListener(this);
        Button clearBtn = (Button) findViewById(R.id.btn_clear_data);
        clearBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add_data:
                addData();
                break;
            case R.id.btn_delete_data:
                deleteData();
                break;
            case R.id.btn_query_data:
                queryData();
                break;
            case R.id.btn_update_data:
                updateData();
                break;
            case R.id.btn_sync_add_data:
                syncAddData();
                break;
            case R.id.btn_sync_delete_data:
                syncDeleteData();
                break;
            case R.id.btn_sync_query_data:
                syncQueryData();
                break;
            case R.id.btn_sync_update_data:
                syncUpdateData();
                break;
            case R.id.btn_clear_data:
                clearData();
            default:
                break;
        }
    }

    private void clearData() {
        final RealmResults<Dog> dogs = mRealm.where(Dog.class).findAll();
        mRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                dogs.deleteAllFromRealm();

            }
        });
    }

    private void syncQueryData() {
        RealmResults<Dog> dogs = mRealm.where(Dog.class).findAllAsync();
        dogs.addChangeListener(new RealmChangeListener<RealmResults<Dog>>() {
            @Override
            public void onChange(RealmResults<Dog> element) {
                List<Dog> dogList = mRealm.copyFromRealm(element);
                for (Dog dog : dogList) {
                    Log.d("RealmStudyActivity", dog.toString());
                }
            }
        });
    }

    private void syncDeleteData() {
        mAsyncTask = mRealm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Dog dog = realm.where(Dog.class).findFirst();
                dog.deleteFromRealm();
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                Toast.makeText(RealmStudyActivity.this, "删除成功", Toast.LENGTH_SHORT).show();
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                Toast.makeText(RealmStudyActivity.this, "删除失败", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void syncUpdateData() {
        mAsyncTask = mRealm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Dog dog = realm.where(Dog.class).findFirst();
                dog.setName("我是新的狗狗");
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                Toast.makeText(RealmStudyActivity.this, "更新成功", Toast.LENGTH_SHORT).show();
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                Toast.makeText(RealmStudyActivity.this, "更新失败", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void syncAddData() {
        mAsyncTask = mRealm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Dog dog = new Dog();
                dog.setName("我是新的阿拉斯加");
                dog.setAge(2);
                realm.copyToRealm(dog);
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                Toast.makeText(RealmStudyActivity.this, "添加成功", Toast.LENGTH_SHORT).show();
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                Toast.makeText(RealmStudyActivity.this, "添加失败", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void updateData() {
        //同样也可以用事务块来更新数据
        Dog dog = mRealm.where(Dog.class).equalTo("name", "阿拉斯加").findFirst();
        mRealm.beginTransaction();
        dog.setName("藏獒");
        mRealm.commitTransaction();
    }

    /**
     * 常见的查询条件入下：
     * between()，greaterThan(),lessThan(), greaterThanOrEqualTo(), lessThanOrEqualTo()
     * equalTo(), notEqualTo()
     * contains(), beginsWith(), endsWith()
     * isNull(), isNotNull()
     * isEmpty(), isNotEmpty()
     */
    private void queryData() {
        RealmResults<Dog> dogs = mRealm.where(Dog.class).findAll();
        List<Dog> dogList = mRealm.copyFromRealm(dogs);
        for (Dog dog : dogList) {
            Log.d("RealmStudyActivity", dog.toString());
        }
    }

    private void deleteData() {
        final RealmResults<Dog> dogs = mRealm.where(Dog.class).findAll();
        mRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                //第一种
//                Dog dog = dogs.get(4);
//                dog.deleteFromRealm();
                //第二种
                dogs.deleteFirstFromRealm();
//                dogs.deleteLastFromRealm();
//                dogs.deleteFromRealm(1);
//                dogs.deleteAllFromRealm();
                //除此之外还可以使用同上的beginTransaction和commitTransaction方法进行删除
            }
        });
    }

    private void addData() {
//        mRealm.beginTransaction();
//        // 新建一个对象并进行存储
//        Dog dog = mRealm.createObject(Dog.class, new Dog());
//        dog.setName("阿拉斯加");
//        dog.setAge(1);
//        mRealm.commitTransaction();
        //复制一个对象到Realm数据库
        Dog dog1 = new Dog();
        dog1.setName("萨摩耶");
        dog1.setAge(5);
        dog1.setId("2");
        mRealm.beginTransaction();
        mRealm.copyToRealm(dog1);
        mRealm.commitTransaction();
        //使用事务块
        final Dog dog2 = new Dog();
        dog2.setName("金毛");
        dog2.setAge(2);
        dog2.setId("1");
        mRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealm(dog2);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mAsyncTask != null && !mAsyncTask.isCancelled()) {
            mAsyncTask.cancel();
        }
    }
}
