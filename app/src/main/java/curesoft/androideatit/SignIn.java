package curesoft.androideatit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;

import curesoft.androideatit.Model.User;

public class SignIn extends AppCompatActivity {


    EditText edtPhone, edtPassword;
    Button btnSignIn;
    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference mDatabseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        edtPhone = (MaterialEditText) findViewById(R.id.edtPhone);
        edtPassword = (MaterialEditText) findViewById(R.id.edtPassword);
        btnSignIn = (Button) findViewById(R.id.btnSignin);
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mDatabseReference = mFirebaseDatabase.getReference("user");
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDatabseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if (dataSnapshot.child(edtPhone.getText().toString()).exists()) {

                            User user = dataSnapshot.child(edtPhone.getText().toString()).getValue(User.class);
                            if(user.getPassword().equals(edtPassword.getText().toString())){
                                Toast.makeText(SignIn.this,"signedIn successfully",Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                Toast.makeText(SignIn.this,"wrong password",Toast.LENGTH_SHORT).show();
                            }

                        } else {
                            Toast.makeText(SignIn.this, "wrong data", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });
    }
}
