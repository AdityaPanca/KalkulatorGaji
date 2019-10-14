package com.adit.kalkulatorgaji.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.adit.kalkulatorgaji.R;
import com.adit.kalkulatorgaji.util.GajiKaryawan;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HitungGajiFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class HitungGajiFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    private RadioGroup radioGroup;
    private EditText jamKerja;
    private RadioButton tidakLembur, sedikitLembur, seringLembur;

    public HitungGajiFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hitung_gaji, container, false);
        radioGroup = view.findViewById(R.id.radioGrupGender);
        jamKerja = view.findViewById(R.id.editJamKerja);
        tidakLembur = view.findViewById(R.id.radioTidakLembur);
        sedikitLembur = view.findViewById(R.id.radioSedikitLembur);
        seringLembur = view.findViewById(R.id.radioCukupLembur);


        Button buttonHitung = view.findViewById(R.id.butttonHitung);
        buttonHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mListener != null){
                    String jamKerjaString = jamKerja.getText().toString();
                    int checkID =  radioGroup.getCheckedRadioButtonId();
                    if ((checkID != -1) && !TextUtils.isEmpty(jamKerjaString)){
                        int jam = Integer.parseInt(jamKerjaString);
                        int gender = (checkID == R.id.radioLaki_Laki) ? GajiKaryawan.MALE : GajiKaryawan.FEMALE;
                        if (tidakLembur.isChecked()){
                            GajiKaryawan gajiKaryawan = new GajiKaryawan(jam,gender,  200000);
                            mListener.onCalculateButtonGajiClicked(gajiKaryawan.getIndex());

                        }
                        else if (sedikitLembur.isChecked()){

                            GajiKaryawan gajiKaryawan = new GajiKaryawan(jam,gender, 300000);
                            mListener.onCalculateButtonGajiClicked(gajiKaryawan.getIndex());

                        }
                        else if (seringLembur.isChecked()){

                            GajiKaryawan gajiKaryawan = new GajiKaryawan(jam,gender,  500000);
                            mListener.onCalculateButtonGajiClicked(gajiKaryawan.getIndex());
                        }
                    }

                    else {
                        Toast.makeText(getActivity(),"Silahkan isi form dan radio button",Toast.LENGTH_SHORT).show();
                    }

                }
                userAnswer();
            }
        });

        return view;
    }

    private void userAnswer(){


    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        void onCalculateButtonGajiClicked(float index);

    }
}
