package sg.edu.np.mad.pratical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String TAG = "Main Activity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button dfollow = findViewById(R.id.followbtn);
        Button dmessage = findViewById(R.id.messagbtn);
        TextView dname = findViewById(R.id.helloWorld);
        TextView ddescription = findViewById(R.id.Description);

        User myUser = helloUser(dfollow, dname, ddescription);
        dfollow.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (myUser.isFollowed() == false){
                    myUser.setFollowed(true);
                    dfollow.setText("Unfollow");
                    Log.v(TAG, "Successfully followed " + myUser.getName());
                    Toast.makeText(MainActivity.this, "Followed", Toast.LENGTH_SHORT).show();
                }
                else {
                    myUser.setFollowed(false);
                    dfollow.setText("Follow");
                    Log.v(TAG, "Successfully unfollowed " + myUser.getName());
                    Toast.makeText(MainActivity.this, "Unfollowed", Toast.LENGTH_SHORT).show();
                }

            }
        });
        dmessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendtomsg = new Intent(MainActivity.this, MessageGroup.class);
                startActivity(sendtomsg);
            }
        });


    }
    public User helloUser(Button dfollow, TextView dname, TextView ddescription){
        Intent recievetomain = getIntent();
        User myUser = (User) recievetomain.getSerializableExtra("user");

        if (myUser.isFollowed() == false){
            dfollow.setText("Follow");
        }
        else {
            dfollow.setText("Unfollow");
        }
        ddescription.setText(myUser.getDescription());
        dname.setText(myUser.getName());
        return myUser;
    }
}