package rohanstech.dev.firsttask1;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Profile extends AppCompatActivity
{

    private TextView mTextMessage;
    ListView mListView;

    int [] images =     {R.drawable.wishlist,
                                    R.drawable.saved_cards,
                                    R.drawable.calender,
                                    R.drawable.coupon,
                                    R.drawable.settings,
                                    R.drawable.logout};

    String [] List={"Wishlist","Saved Cards","Set Gift Remainder","Invite","Settings","Logout"};



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_Me:
                    mTextMessage.setText(R.string.me);
                    return true;
                case R.id.navigation_buy:
                    mTextMessage.setText(R.string.buy);
                    return true;
                case R.id.navigation_wallet:
                    mTextMessage.setText(R.string.eWallet);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        mListView=findViewById(R.id.listViewProfie);

        CustomAdaptor customAdaptor=new CustomAdaptor();
        mListView.setAdapter(customAdaptor);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    class CustomAdaptor extends BaseAdapter {


        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = getLayoutInflater().inflate(R.layout.custom_layout,null);
            ImageView mImageView= view.findViewById(R.id.imageViewCustom);
            TextView mTextView= view.findViewById(R.id.textViewCustom);

            mImageView.setImageResource(images[i]);
            mTextView.setText(List[i]);
            return view;
        }
    }

}
