package com.codegus.walkingbolivia.models.Country;


import android.util.Log;

import com.codegus.walkingbolivia.models.RegValues;
import com.codegus.walkingbolivia.models.Value;

public class BolivianDepartaments extends Region {

    private Region beni;
    private Region chuquisaca;
    private Region cochabamba;
    private Region laPaz;
    private Region oruro;
    private Region pando;
    private Region potosi;
    private Region santaCruz;
    private Region tarija;

    public BolivianDepartaments(){
        int i = -1;
        beni = new Region(i++, Value.BENI[0], Value.BENI[1]);
        chuquisaca = new Region(i++, Value.CHUQUISACA[0], Value.CHUQUISACA[1]);
        cochabamba = new Region(i++, Value.COCHABAMBA[0], Value.COCHABAMBA[1]);
        laPaz = new Region(i++, Value.LA_PAZ[0], Value.LA_PAZ[1]);
        oruro = new Region(i++, Value.ORURO[0], Value.ORURO[1]);
        pando = new Region(i++, Value.PANDO[0], Value.PANDO[1]);
        potosi = new Region(i++, Value.POTOSI[0], Value.POTOSI[1]);
        santaCruz = new Region(i++, Value.SANTA_CRUZ[0], Value.SANTA_CRUZ[1]);
        tarija = new Region(i++, Value.TARIJA[0], Value.TARIJA[1]);
    }
    // BENI
    public Region getDepartament(String collectionName){
        String [][] col;
        Region region;
        if(collectionName.equals(Value.BENI[0])){
            col = RegValues.BENI;
            region = beni;
        }else if(collectionName.equals(Value.CHUQUISACA[0])){
            col = RegValues.CHUQUISACA;
            region = chuquisaca;
        }else if(collectionName.equals(Value.COCHABAMBA[0])){
            col = RegValues.COCHABAMBA;
            region = cochabamba;
        }else if(collectionName.equals(Value.LA_PAZ[0])){
            col = RegValues.LA_PAZ;
            region = laPaz;
        }else if(collectionName.equals(Value.ORURO[0])){
            col = RegValues.ORURO;
            region = oruro;
        }else if(collectionName.equals(Value.PANDO[0])){
            col = RegValues.PANDO;
            region = pando;
        }else if(collectionName.equals(Value.POTOSI[0])){
            col = RegValues.POTOSI;
            region = potosi;
        }else if(collectionName.equals(Value.SANTA_CRUZ[0])){
            col = RegValues.SANTA_CRUZ;
            region = santaCruz;
        }else if(collectionName.equals(Value.TARIJA[0])){
            col = RegValues.TARIJA;
            region = tarija;
        }else{
            col = new String[0][0];
            region = new Region();
        }
        for(int i = 0; i < col.length ; i++){
            region.putSubRegion(new Region(i, col[i][0], col[i][1]));
        }
        return region;
    }

    public String[] getDepartamentSubregionsVector(String collectionName, boolean withCapital){

        Region region = getDepartament(collectionName);
        String [] vector = new String[region.getSubRegionList().size()];
        for(int i = 0 ; i < region.getSubRegionList().size(); i++){
            if(withCapital) vector[i] = region.getSubRegionList().get(i).getName() + " ("+region.getSubRegionList().get(i).getCapital()+")";
            else vector[i] = region.getSubRegionList().get(i).getName();
        }
        return vector;
    }

    public String [] getDepartamentVector(boolean withCapital){
        String [] vector = new String[RegValues.BOLIVIA.length];
        for(int i = 0; i < RegValues.BOLIVIA.length;  i++){
            if(withCapital) vector[i] = RegValues.BOLIVIA[i][0] + " (" + RegValues.BOLIVIA[i][1] + ")";
            else vector[i] = RegValues.BOLIVIA[i][0];
        }
        return vector;
    }

}
