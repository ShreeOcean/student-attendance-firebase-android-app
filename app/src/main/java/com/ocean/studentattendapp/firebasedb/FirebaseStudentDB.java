package com.ocean.studentattendapp.firebasedb;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.ocean.studentattendapp.model.StudentPOJO;

public class FirebaseStudentDB {

    public DatabaseReference databaseReference;

    public FirebaseStudentDB(){
        databaseReference = FirebaseDatabase.getInstance().getReference(StudentPOJO.class.getSimpleName());
    }

    //Insert to firebase
    public Task<Void> insert(StudentPOJO studentPOJO){
        return databaseReference.push().setValue(studentPOJO);
    }
}
