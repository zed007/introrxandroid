package retrofitrxandroid.android.com.tutoretrofitrxandroid.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofitrxandroid.android.com.tutoretrofitrxandroid.R;

public class UserViewHolder extends RecyclerView.ViewHolder{

    @BindView(R.id.tvName)
    public TextView tvName;
    @BindView(R.id.tvEmail)
    public TextView tvEmail;

    public UserViewHolder(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }
}
