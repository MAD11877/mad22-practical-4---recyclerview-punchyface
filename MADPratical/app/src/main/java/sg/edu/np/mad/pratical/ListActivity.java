package sg.edu.np.mad.pratical;
import java.util.ArrayList;
import java.util.Random;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;


public class ListActivity extends AppCompatActivity {
    private ArrayList<User> userList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        createuser(20);

        //RecyclerView
        RecyclerView recyclerView;
        recyclerView = findViewById(R.id.recyclerView);
        Adapter adapter = new Adapter(this, userList, R.mipmap.ic_launcher_round);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));




    }
    public void createuser(Integer totaluser){
        for (Integer i = 1; i <= totaluser; i++){
            Random rand = new Random();
            Integer randomnum1 = rand.nextInt(999999999);
            String name = "Name " + randomnum1;
            Integer randomnum2 = rand.nextInt(999999999);
            String description = "Description " + randomnum2;
            User myUser = new User(name, description, i, false);
            userList.add(myUser);
        }
    }
}