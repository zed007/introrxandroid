package retrofitrxandroid.android.com.tutoretrofitrxandroid.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofitrxandroid.android.com.tutoretrofitrxandroid.R;
import retrofitrxandroid.android.com.tutoretrofitrxandroid.models.User;
import retrofitrxandroid.android.com.tutoretrofitrxandroid.viewholders.UserViewHolder;

public class UsersListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<User> mListUsers = new ArrayList<>();

    public UsersListAdapter(List<User> list) {
        mListUsers.addAll(list);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new UserViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user_view_holder, parent, false));
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        User user = mListUsers.get(position);

        UserViewHolder viewHolder = (UserViewHolder) holder;
        viewHolder.tvName.setText(user.getName());
        viewHolder.tvEmail.setText(user.getEmail());
    }

    @Override
    public int getItemCount() {
        return mListUsers.size();
    }
}
