package android.cnews.com.cnewsprototype;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText messageET;
    private ListView messagesContainer;
    private ChatAdapter adapter;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Chat Bot");
        fab = (FloatingActionButton) findViewById(R.id.chatSendButton);
        initControls();
    }

    private void initControls() {
        messagesContainer = (ListView) findViewById(R.id.messagesContainer);

        if(adapter == null){
            adapter = new ChatAdapter(MainActivity.this, new ArrayList<ChatMessage>());
        }
        messagesContainer.setAdapter(adapter);

        messageET = (EditText) findViewById(R.id.messageEdit);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String messageText = messageET.getText().toString();
                if (TextUtils.isEmpty(messageText)) {
                    return;
                }
                // KODE setSenderID untuk menentukan siapa yang mengirim
                // Kalau 1 itu pengguna
                // Kalau 2 itu bot
                // Tinggal dikuli beritanya, dengan cara misal bikin if kalau pengguna inputnya apa
                // ntar di cek messageText nya apa
                // untuk diisi ke newMessage.setMessage('sesuai dengan if')
                ChatMessage chatMessage = new ChatMessage();
                chatMessage.setSenderId("1");
                chatMessage.setMessage(messageText);
                Long timeStamptSender = Long.valueOf(0);
                chatMessage.setTimestamp(timeStamptSender);
                displayMessage(chatMessage);
                messageET.setText("");

                ChatMessage newMessage = new ChatMessage();
                newMessage.setSenderId("2");
                newMessage.setMe(false);
                newMessage.setMessage("reply okay");
                Long timeStamptResponse = Long.valueOf(10);
                newMessage.setTimestamp(timeStamptResponse);
                displayMessage(newMessage);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void displayMessage(ChatMessage message) {
        adapter.add(message);
        adapter.notifyDataSetChanged();
        scroll();
    }

    private void scroll() {
        messagesContainer.setSelection(messagesContainer.getCount() - 1);
    }
}
