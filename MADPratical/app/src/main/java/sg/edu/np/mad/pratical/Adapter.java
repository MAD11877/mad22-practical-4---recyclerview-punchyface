package sg.edu.np.mad.pratical;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    Context ct;
    ArrayList<User> userList;
    int images;

    public Adapter(Context ct, ArrayList<User> userList, int images) {
        this.ct = ct;
        this.userList = userList;
        this.images = images;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(ct);
        View view = inflater.inflate(R.layout.my_row, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        User userobj = userList.get(position);
        holder.ddescription.setText(userobj.getDescription());
        holder.dname.setText(userobj.getName());
        holder.dimages.setImageResource(images);
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView dname;
        TextView ddescription;
        ImageView dimages;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            dname = itemView.findViewById(R.id.Name);
            ddescription = itemView.findViewById(R.id.Description);
            dimages = itemView.findViewById(R.id.homeicon);
        }
    }
}
