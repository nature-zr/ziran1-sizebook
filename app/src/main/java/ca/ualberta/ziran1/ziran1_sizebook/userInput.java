package ca.ualberta.ziran1.ziran1_sizebook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class userInput extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_input);
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

    public void write_file(ArrayList<Person> persons) {
        try{
            FileOutputStream fos = openFileOutput("person_info", this.MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(persons);
            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
    }

    public void cancel(View view) {
        finish();
    }

    public void store_info(View view) {

        ArrayList<Person> persons = read_info();

        EditText name_text = (EditText) findViewById(R.id.edit_name);
        String name_str = name_text.getText().toString();
        EditText date_text = (EditText) findViewById(R.id.edit_date);
        String date_str = name_text.getText().toString();
        EditText neck_text = (EditText) findViewById(R.id.edit_neck_size);
        String neck_str = name_text.getText().toString();
        EditText bust_text = (EditText) findViewById(R.id.edit_bust_size);
        String bust_str = name_text.getText().toString();
        EditText chest_text = (EditText) findViewById(R.id.edit_chest_size);
        String chest_str = name_text.getText().toString();
        EditText waist_text = (EditText) findViewById(R.id.edit_waist_size);
        String waist_str = name_text.getText().toString();
        EditText hip_text = (EditText) findViewById(R.id.edit_hip_size);
        String hip_str = name_text.getText().toString();
        EditText inseam_text = (EditText) findViewById(R.id.edit_inseam_size);
        String inseam_str = name_text.getText().toString();
        EditText comment_text = (EditText) findViewById(R.id.edit_comment);
        String comment_str = name_text.getText().toString();

        if (name_str.length() == 0) {
            TextView warning = (TextView) findViewById(R.id.warning);
            warning.setTextColor(0x000000);
        }
        else {
            Person person = new Person(name_str, date_str, neck_str, bust_str,
                    chest_str, waist_str, hip_str, inseam_str, comment_str);
            persons.add(person);
            write_file(persons);
            finish();
        }
    }

}
