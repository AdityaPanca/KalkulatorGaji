package com.adit.kalkulatorgaji.util;

public class GajiKaryawan {

    public static final int MALE = 0;
    public static final int FEMALE = 1;

    private  int jam;
    private  int gender;
    private  double lembur;
    private  float index;

    public GajiKaryawan(int jam, int gender, double lembur) {
        this.jam = jam;
        this.gender = gender;
        this.lembur = lembur;
        this.index = hitung();
    }
    public  float getIndex(){

        return index;
    }

    private float hitung() {
        switch (gender){
            case MALE: return (float) ((100000 * jam) + lembur);
            case FEMALE: return (float) ((50000 * jam) + lembur);
            default: return  0f;
        }

    }
}
