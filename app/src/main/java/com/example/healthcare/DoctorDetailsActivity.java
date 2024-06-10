package com.example.healthcare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {


    private String[][] doctor_details1 = {
            {"Doctor Name: Ajit Saste", "Hospital Address: Pimpri", "Exp: 5yrs", "Mobile No: 9898989898", "600"},
            {"Doctor Name: Prasad Pawan", "Hospital Address: Nigdi", "Exp: 15yrs", "Mobile No: 7898989898", "908"},
            {"Doctor Name: Ashok Panda", "Hospital Address: Katraj", "Exp: 7yrs", "Mobile No: 7798989898", "800"}
    };

    private String[][] doctor_details2 = {
            {"Doctor Name: Heeralal Kale", "Hospital Address: Pune", "Exp: 8yrs", "Mobile No: 8898929898", "300"},
            {"Doctor Name: Mayuri Deshmukh", "Hospital Address: Chinchwad", "Exp: 6yrs", "Mobile No: 9893000900", "500"},
            {"Doctor Name: Minakshi Panda", "Hospital Address: Katraj", "Exp: 7yrs", "Mobile No: 7798989898", "800"}
    };

    private String[][] doctor_details3 = {
            {"Doctor Name: Seema Patil", "Hospital Address: Pimpri", "Exp: 4yrs", "Mobile No: 9898989898", "200"},
            {"Doctor Name: Pankaj Parab", "Hospital Address: Nigdi", "Exp: 5yrs", "Mobile No: 7898989898", "380"},
            {"Doctor Name: Monish Jain", "Hospital Address: Pune", "Exp: 7yrs", "Mobile No: 8898989898", "300"}
    };
    private String[][] doctor_details4 = {
            {"Doctor Name: Anil Gaud", "Hospital Address: Pimpri", "Exp: 5yrs", "Mobile No: 9898989898", "600"},
            {"Doctor Name: Deepak Deshpande", "Hospital Address: Chinchwad", "Exp: 6yrs", "Mobile No: 9898080000", "580"},
            {"Doctor Name: Ashok Singh", "Hospital Address: Katraj", "Exp: 7yrs", "Mobile No: 7798989898", "800"}
    };

    private String[][] doctor_details5 = {
            {"Doctor Name: Anil Gaud", "Hospital Address: Pimpri", "Exp: 5yrs", "Mobile No: 9898989898", "600"},
            {"Doctor Name: Prasad Pawan", "Hospital Address: Nigdi", "Exp: 15yrs", "Mobile No: 7898989898", "909"},
            {"Doctor Name: Katesh Kate", "Hospital Address: Pune", "Exp: 8yrs", "Mobile No: 8898989898", "1300"},
            {"Doctor Name: Shashank Lele", "Hospital Address: Pune", "Exp: 8yrs", "Mobile No: 8898989898", "1300"},
            {"Doctor Name: Deepak Kumar", "Hospital Address: Chinchwad", "Exp: 6yrs", "Mobile No: 9899009008", "1500"},
            {"Doctor Name: Ankyl Panda", "Hospital Address: Katraj", "Exp: 7yrs", "Mobile No: 7798989898", "1800"}
    };

    private TextView tv;
    private Button btn;
    String[][] doctor_details = {};
    ArrayList List;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv = findViewById(R.id.textViewDDTitle);
//        btn = findViewById(R.id.buttonDDBack);

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("Family Physicians")==0)
            doctor_details = doctor_details1;
        else
        if(title.compareTo("Dietecian")==0)
            doctor_details = doctor_details1;
        else
        if(title.compareTo("Dentists")==0)
            doctor_details = doctor_details1;
        else
        if(title.compareTo("Surgeon")==0)
            doctor_details = doctor_details1;
        else
            doctor_details = doctor_details1;
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this, FindDoctorActivity.class));
            }
        });

        List = new ArrayList();
        for (int i=0;i<doctor_details.length;i++){
            HashMap<String, String> item = new HashMap<String, String>();
            item.put("Line1", doctor_details[i][0]);
            item.put("Line2", doctor_details[i][1]);
            item.put("Line3", doctor_details[i][2]);
            item.put("Line4", doctor_details[i][3]);
            item.put("Line5", "Cons Fees:"+doctor_details[i][4]+"/-");
           List.add(item); 
        }
        SimpleAdapter sa = new SimpleAdapter(this,List,
                R.layout.multi_lines,
                new String[]{"Line1","Line2","Line3","Line4","Line5"},
                new int[]{R.id.Line_a,R.id.Line_b,R.id.Line_c,R.id.Line_d,R.id.Line_e}
        );
        ListView lst = findViewById(R.id.listViewDD);
        lst.setAdapter(sa);

        lst.setOnClickListener(new Ad);
    }
}