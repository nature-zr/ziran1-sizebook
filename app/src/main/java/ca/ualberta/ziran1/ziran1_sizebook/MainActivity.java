package ca.ualberta.ziran1.ziran1_sizebook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onResume() {
        super.onResume();
        print_info();
    }

    public void print_info() {
        ArrayList<Person> persons = read_info();
        TextView count = (TextView) findViewById(R.id.count);
        ListView info_list = (ListView) findViewById(R.id.info_list);

        count.setText("Total count: " + new Integer(persons.size()).toString());
        String[] name_array = get_name(persons);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, R.layout.activity_listview, name_array);
        info_list.setAdapter(adapter);
    }

    public String[] get_name(ArrayList<Person> persons) {
        String[] names = new String[persons.size()];

        for (int i = 0; i < persons.size(); i++) {
            names[i] =  persons.get(i).name;
        }
        return names;
    }
    public void start_create(View view) {
        Intent intent = new Intent(this, userInput.class);
        startActivity(intent);
    }

    public ArrayList<Person> read_info() {
        ArrayList<Person> persons = new ArrayList<Person>();
        try {
            FileInputStream fis = openFileInput("persons_info");
            ObjectInputStream ois = new ObjectInputStream(fis);
            persons = (ArrayList<Person>) ois.readObject();
            ois.close();
            fis.close();

        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        } catch (ClassNotFoundException e) {
        }
        return persons;
    }
}
