package example.android.com.pinnedlistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    TextView mListTopDate;
    private LinearLayoutManager mLayoutManager;

    private EmpChatRecyclerAdapter mEmployeeChatAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListTopDate = (TextView) findViewById(R.id.titledate);
        initViews();
    }

    private void initViews() {
        recyclerView = (RecyclerView) findViewById(R.id.chat_list_view);
        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);

        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mLayoutManager);

        ArrayList<ChatItemData> androidVersions = prepareData();
        mEmployeeChatAdapter = new EmpChatRecyclerAdapter(getApplicationContext(), androidVersions);
        recyclerView.setAdapter(mEmployeeChatAdapter);


        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == recyclerView.SCROLL_STATE_IDLE) {
                    mListTopDate.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                try {
                    mListTopDate.setVisibility(View.VISIBLE);
                    //String pDate = mEmployeeChatAdapter.getItem(mRecyclerViewPositionHelper.findFirstVisibleItemPosition()).PostedDateTime;
                    String pDate = mEmployeeChatAdapter.getItem(mLayoutManager.findFirstVisibleItemPosition()).getDate();
                    mListTopDate.setText("" + pDate);
                } catch (Exception e) {
            //        mListTopDate.setVisibility(View.INVISIBLE);
                    e.printStackTrace();
                }
            }
        });
    }

    private ArrayList<ChatItemData> prepareData() {

        ArrayList<ChatItemData> android_version = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            ChatItemData androidVersion = new ChatItemData();
            androidVersion.setDate("May 11,2017");
            androidVersion.setTitle("Title 1");
            androidVersion.setSubtitle("Subtitle 1");
            android_version.add(androidVersion);

        }

        for (int i = 0; i < 5; i++) {
            ChatItemData androidVersion = new ChatItemData();
            androidVersion.setDate("May 12,2017");
            androidVersion.setTitle("Title 1");
            androidVersion.setSubtitle("Subtitle 1");
            android_version.add(androidVersion);

        }

        for (int i = 0; i < 5; i++) {
            ChatItemData androidVersion = new ChatItemData();
            androidVersion.setDate("May 13,2017");
            androidVersion.setTitle("Title 1");
            androidVersion.setSubtitle("Subtitle 1");
            android_version.add(androidVersion);

        }

        for (int i = 0; i < 5; i++) {
            ChatItemData androidVersion = new ChatItemData();
            androidVersion.setDate("May 14,2017");
            androidVersion.setTitle("Title 1");
            androidVersion.setSubtitle("Subtitle 1");
            android_version.add(androidVersion);

        }
        for (int j = 0; j < 5; j++) {
            ChatItemData androidVersion1 = new ChatItemData();
            androidVersion1.setDate("May 15,2017");
            androidVersion1.setTitle("Title 2");
            androidVersion1.setSubtitle("Subtitle 2");
            android_version.add(androidVersion1);
        }
        for (int k = 0; k < 5; k++) {
            ChatItemData androidVersion2 = new ChatItemData();
            androidVersion2.setDate("May 16,2017");
            androidVersion2.setTitle("Title 2");
            androidVersion2.setSubtitle("Subtitle 2");
            android_version.add(androidVersion2);
        }
        return android_version;
    }


}
