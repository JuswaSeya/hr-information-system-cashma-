package com.example.hello_world.DashBoard;

import static android.content.Context.MODE_PRIVATE;


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

import com.example.hello_world.DashBoard.ActiveEmployee.ActiveEmployee;
import com.example.hello_world.Query.EmployeeSqlQuery;
import com.example.hello_world.R;
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

    private String name;



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




        SharedPreferences prefs = requireActivity()
                .getSharedPreferences("UserSession", MODE_PRIVATE);
        employeeID = prefs.getString("emp_id", null);




        TextView underCapacityDisplay = view.findViewById(R.id.underCapacityNumber);
        TextView numLeave = view.findViewById(R.id.numleaves);                                           //for leaves number in dashboard

                       //for undercapacity number in dashboard

        TextView nameLayout = view.findViewById(R.id.textView7);
        TextView position = view.findViewById(R.id.jobtitle);
        ImageView image = view.findViewById(R.id.imageView2);
        TextView incident_display= view.findViewById(R.id.incidentReportNum);
        Employee employee= new Employee();
        TextView AnnouncementDisplay = view.findViewById(R.id.announcementNumber);
        TextView active_count = view.findViewById(R.id.activeEmployeeCount);


        active_count.setText( String.valueOf(new EmployeeSqlQuery().activeNum(requireContext())));
        AnnouncementDisplay.setText(String.valueOf(employee.getAnnouncment_display()));

        employee= new EmployeeSqlQuery().value(employeeID, requireContext());


        incident_display.setText(String.valueOf( employee.getIncidentNumber()));

        numLeave.setText(String.valueOf(employee.getLeavesToday()) );                                       //to call your leaves number in dashbaord
        underCapacityDisplay.setText(String.valueOf(employee.getUnderCapacityNumber()));
        nameLayout.setText(employee.getName());
        position.setText(employee.getPosition());
        name = employee.getName();
        Toast.makeText(requireContext(), name +" \t" + employeeID, Toast.LENGTH_SHORT).show();






        if (employee.getImageByte() != null && employee.getImageByte().length > 0) {
            Bitmap bitmap = BitmapFactory.decodeByteArray(employee.getImageByte(), 0, employee.getImageByte().length);
            image.setImageBitmap(bitmap);
        } else {
            image.setImageResource(R.drawable.profile); // optional default image
        }

        LinearLayout activeEmployee= view.findViewById(R.id.actempButton);

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

            Intent intent = new Intent(requireContext(), leaves.class);
            intent.putExtra("EMP_ID", employeeID);
            startActivity(intent);


        });


                                                                                                                //for leaves display

        EmployeeSqlQuery employeeLeaves = new EmployeeSqlQuery();

        new Thread(() -> {

            int totalLeaves = employeeLeaves.leavesToday(employeeID,requireContext());

            requireActivity().runOnUiThread(() -> {
                numLeave.setText(Integer.toString(totalLeaves));
            });

        }).start();
                                                                                                                    // for underCapacityDisplay
        EmployeeSqlQuery employeeUnderCapacity = new EmployeeSqlQuery();

        new Thread(() -> {

            int undercapacityINT = employeeUnderCapacity.underCapacityDisplay (employeeID,requireContext());

            requireActivity().runOnUiThread(() -> {
                underCapacityDisplay.setText(Integer.toString(undercapacityINT));
            });

        }).start();




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




