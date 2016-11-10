package com.buildings;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Flat [] flats=new Flat [9];

        Flat [] flats1=new Flat [9];

        Flat [] flats2=new Flat [9];

        int [] flats3={3,5,8,43,6,8,9,12,7};

        DwellingFloor [] dwellingfloor = new DwellingFloor[4];

        for (int i = 0; i <9; i++) {
            if (i<4)
                flats[i]=new Flat();
            if((i>=3)&&(i<7))
                flats[i]=new Flat(i*30);
            if ((i>=6)&&(i<9))
                flats[i]=new Flat(i*30,i*2);
        }

        for (int i = 0; i <9; i++) {
            if (i<4)
                flats1[i]=new Flat();
            if((i>=3)&&(i<7))
                flats1[i]=new Flat(i*20);
            if ((i>=6)&&(i<9))
                flats1[i]=new Flat(i*20,i*3);
        }

        for (int i = 0; i <9; i++) {
            if (i<4)
                flats2[i]=new Flat();
            if((i>=3)&&(i<7))
                flats2[i]=new Flat(i*20);
            if ((i>=6)&&(i<9))
                flats2[i]=new Flat(i*20,i*3);
        }

        for (int i = 0; i <4; i++) {
            switch (i){
                case 0:{
                    dwellingfloor[i]=new DwellingFloor(flats);
                    break;
                }

                case 1:{
                    dwellingfloor[i]=new DwellingFloor(flats1);
                    break;
                }

                case 2:{
                    dwellingfloor[i]=new DwellingFloor(flats2);
                    break;
                }

                case 3:{
                    dwellingfloor[i]=new DwellingFloor(10);
                    break;
                }

            }
        }

        Dwelling dwelling1 =new Dwelling(dwellingfloor);

        Dwelling dwelling2 =new Dwelling(9,flats3);

        System.out.println(dwelling1.getCountOfFloors());
        System.out.println(dwelling2.getCountOfFloors());

        System.out.println(dwelling1.getSquare());
        System.out.println(dwelling2.getSquare());

        System.out.println(dwelling1.getRooms());
        System.out.println(dwelling2.getRooms());

        System.out.println(Arrays.toString(dwelling1.getDwellingFloors()));
        System.out.println(Arrays.toString(dwelling2.getDwellingFloors()));


        System.out.println(dwelling1.getDfellingFloor(1));
        System.out.println(dwelling2.getDfellingFloor(4));

        dwelling1.editDwellingFloor(3,new DwellingFloor(6));
        Flat [] flat4={new Flat(12)};
        dwelling2.editDwellingFloor(5,new DwellingFloor(flat4));

        System.out.println(dwelling1.getFlat(1));
        System.out.println(dwelling2.getFlat(6));

        dwelling1.editFlat(7, new Flat());
        dwelling2.editFlat(7, new Flat());

        dwelling1.addNewFlat(45, new Flat());
        dwelling2.addNewFlat(7, new Flat());

        System.out.println(dwelling1.getCountOfFlats());
        System.out.println(dwelling2.getCountOfFlats());

        dwelling1.deleteFlat(7);
        dwelling2.deleteFlat(7);

        System.out.println(dwelling1.getCountOfFlats());
        System.out.println(dwelling2.getCountOfFlats());

        System.out.println(dwelling1.getBestSpace());
        System.out.println(dwelling2.getBestSpace());

        System.out.println(Arrays.toString(dwelling1.getSortedFlats()));
        System.out.println(Arrays.toString(dwelling2.getSortedFlats()));


    }
}
