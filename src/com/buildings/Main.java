package com.buildings;

public class Main {

    public static void main(String[] args){
	// write your code here
       /* Flat [] flats=new Flat[3];
        flats[0]=new Flat(70,3);
        flats[1]=new Flat(50,2);
        flats[2]=new Flat(130,1);
        DwellingFloor [] dwellingFloors=new DwellingFloor[3];
        dwellingFloors[0]=new DwellingFloor(flats);
        dwellingFloors[1]=new DwellingFloor(4);
        dwellingFloors[2]=new DwellingFloor(3);
        Dwelling dwelling=new Dwelling(dwellingFloors);
        Dwelling.info(dwelling);
        dwelling.pasteFlat(6,new Flat(77,2));
        dwelling.deleteFlat(6);
        dwelling.editFlat(9, new Flat(5,300));
        Dwelling.info(dwelling);
        Flat flatWithBestSquare=dwelling.getBestSpase();
        Flat.info(flatWithBestSquare);
        dwelling.sort(); */
        Office [] offices=new Office[3];
        offices[0]=new Office(1,60);
        offices[2]=new Office(2,80);
        offices[1]=new Office(3,100);
        OfficeFloor officeFloor=new OfficeFloor(offices);
        officeFloor.add(offices[2],1);
       // officeFloor.add(offices[2],3);
        officeFloor.output();





        }




}
