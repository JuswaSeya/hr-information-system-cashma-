package com.example.hello_world;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hello_world.Query.EmployeeLogin;
import com.example.hello_world.models.Employee;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DashBoardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DashBoardFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private String employeeID;
    private String EmpName;



    public DashBoardFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DashBoardFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DashBoardFragment newInstance(String param1, String param2) {
        DashBoardFragment fragment = new DashBoardFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_dash_board, container, false);

        LinearLayout activeEmployee= view.findViewById(R.id.actempButton);

        SharedPreferences prefs = requireActivity()
                .getSharedPreferences("UserSession", Context.MODE_PRIVATE);
        employeeID = prefs.getString("emp_id", null);
        Toast.makeText(requireContext(), "Employee ID"+employeeID, Toast.LENGTH_SHORT).show();
        TextView nameLayout = view.findViewById(R.id.textView7);
        TextView position = view.findViewById(R.id.jobtitle);

        ImageView image = view.findViewById(R.id.imageView2);

        Employee employee= new Employee();


        employee= new EmployeeLogin().value(employeeID, requireContext());
        nameLayout.setText(employee.getName());
        position.setText(employee.getPosition());
        if (employee.getImageByte() != null && employee.getImageByte().length > 0) {
            Bitmap bitmap = BitmapFactory.decodeByteArray(employee.getImageByte(), 0, employee.getImageByte().length);
            image.setImageBitmap(bitmap);
        } else {
            image.setImageResource(R.drawable.profile); // optional default image
        }



        activeEmployee.setOnClickListener(v -> {;

            Intent intent = new Intent(requireContext(), ActiveEmployee.class);
            startActivity(intent);

        });



        LinearLayout announcement= view.findViewById(R.id.AnnouncementButton);

        announcement.setOnClickListener(v -> {;

            Intent intent = new Intent(requireContext(), Announcement.class);
            startActivity(intent);

        });

        LinearLayout UnderCapacity= view.findViewById(R.id.undercapacityButton);
        UnderCapacity.setOnClickListener(v -> {
            startActivity(new Intent(requireContext(), UnderCapacity.class));
        });

        LinearLayout leaves= view.findViewById(R.id.numLeavesButton);
        leaves.setOnClickListener(v -> {
            startActivity(new Intent(requireContext(), leaves.class));



        });



        LinearLayout tardiness = view.findViewById(R.id.tardinessButton);
        tardiness.setOnClickListener(v -> {
            startActivity(new Intent(requireContext(), tardiness.class));
        });

        LinearLayout incidentReport=view.findViewById(R.id.incidentReportsButton);
        incidentReport.setOnClickListener(v -> {
            startActivity(new Intent(requireContext(), incident_report.class));
        });

        LinearLayout obtbutton=view.findViewById(R.id.OBTbutton);
        obtbutton.setOnClickListener(v -> {
            startActivity(new Intent(requireContext(), obtfiledtoday.class));
        });

        return view;
    }









    }




