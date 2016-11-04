package com.buildings;

public class Dwelling {

    private int floors; //количество этажей
    //private int [] flatsOnFloor; //массив квартир на этаже
    private DwellingFloor dwellingFloor []; //массив этажей
    static int l=0;
    int s=0;


    public Dwelling(int floors, int [] dR) {
        this.floors=floors;
        if (floors!= dR.length) {System.out.print("Error");}
        dwellingFloor=new DwellingFloor[floors];
        for (int i = 0; i <dwellingFloor.length ; i++) {
            dwellingFloor[i]=new DwellingFloor(dR[i]);
        }
    }

    public Dwelling(DwellingFloor dwellingFloor []){
        this.dwellingFloor=dwellingFloor;
        this.floors=dwellingFloor.length;
    }

    public int getHouseFloors() { //общее кол-во этажей
      return dwellingFloor.length;
    }

    public int getHouseFlats() { //ббщее кол-во квартир
        int r=0;
        for (DwellingFloor dw:dwellingFloor) {
                r=r+dw.getKolvo();
            }
        return r;
    }

    public int getHouseSquare() { //общая площадь
        int s=0;
        for (DwellingFloor dw:dwellingFloor) {
            s=s+dw.getFlatsSquare();
        }
        return s;
    }

    public int getHouseRooms() { //общее кол-во комнат
        int r=0;
        for (DwellingFloor dw:dwellingFloor) {
            r=r+dw.getFlatsRooms();
        }
        return r;
    }

    public DwellingFloor[] getDwellingFloor(){

        return dwellingFloor;
    } //получение массива тажей

    public DwellingFloor getDwellinFloor(int i) { //этаж по номеру
        return dwellingFloor[i];

    }

    public DwellingFloor editDwellingFloor(int i,DwellingFloor dw){//изменение этажа
        dwellingFloor[i]=dw;
        return dwellingFloor[i];
    }

    public Flat getFlat(int i) { //получение квартиры
        int ii=i-1;
        int k=0;
        int c=0;
        Flat[] flats=null;
        for (int j = 0; j <dwellingFloor.length ; j++) {
            k=k+dwellingFloor[j].getKolvo();
            if (ii<=k) {
                flats= dwellingFloor[j].getFlats();
                s=j;
                if (ii>dwellingFloor[j].getKolvo()) {
                    c = dwellingFloor[j].getKolvo() % j;
                }
                else {c=ii;}
                break;
            }
        }
        return flats[c];
    }

    public DwellingFloor  editFlat(int i, Flat fl)  {//изменение квартиры
        int ii=i-1;
        int k=0;
        int c=0;
        int l=0;
        Flat[] flats=null;
        for (int j = 0; j <dwellingFloor.length ; j++) {
            k = k + dwellingFloor[j].getKolvo();
            if (ii <= k) {
                l=j;
                flats = dwellingFloor[j].getFlats();;
                if (ii >= dwellingFloor[j].getKolvo()) {
                    c = ii % (k-dwellingFloor[j].getKolvo());
                } else {
                    c = ii;
                }
                break;
            }
        }

        dwellingFloor[l].edit(c,fl);
        return dwellingFloor[l];



    }

    public void pasteFlat(int i, Flat fl)  { //всавка квартиры по номеру в доме
        int ii=i-1;
        int k=0;
        int c=0;
        int l=0;
        Flat[] flats=null;
        for (int j = 0; j <dwellingFloor.length ; j++) {
            k = k + dwellingFloor[j].getKolvo();
            if (ii <= k) {
                l=j;
                flats = dwellingFloor[j].getFlats();
                if (ii >= dwellingFloor[j].getKolvo()) {
                    c = ii % (k-dwellingFloor[j].getKolvo());
                } else {
                    c = ii;
                }
                break;
            }
        }

         dwellingFloor[l].newFlat(c,fl);
        //return dwellingFloor[l];

    }


    public DwellingFloor deleteFlat(int i) { //удаление квартиры по номеру в доме
        int ii=i-1;
        int k=0;
        int c=0;
        int l=0;
        Flat[] flats=null;
        for (int j = 0; j <dwellingFloor.length ; j++) {
            k = k + dwellingFloor[j].getKolvo();
            if (ii <= k) {
                l=j;
                flats = dwellingFloor[j].getFlats();
                if (ii >= dwellingFloor[j].getKolvo()) {
                    c = ii % (k-dwellingFloor[j].getKolvo());;
                } else {
                    c = ii;
                }
                break;
            }
        }

        dwellingFloor[l].deleteFlat(c);
        return dwellingFloor[l];

    }

    public Flat getBestSpase() {
        Flat fl = null;
        int c = 0;
        for (int i = 0; i < dwellingFloor.length; i++) {
            if (dwellingFloor[i].getBestSpace().getSquare() > c) {
                c = dwellingFloor[i].getBestSpace().getSquare();
                fl = dwellingFloor[i].getBestSpace();
            }
        }
        return fl;
    }

    public void sort(){
        Flat[] flat=new Flat[getHouseFlats()];
        DwellingFloor dw=null;
        int k=0;

        for (int j = 0; j <dwellingFloor.length; j++) {
            Flat[] fl = dwellingFloor[j].getFlats();
            for (int m = k; m <fl.length+k ; m++) {
                flat[m]=fl[m-k];
            }
            k=fl.length+k;
        }


        for (int i = flat.length-1; i >0 ; i--) {
            for (int j = 0; j <i ; j++) {
                if(flat[j].getSquare()<flat[j+1].getSquare()) {
                    Flat tmp=flat[j];
                    flat[j]=flat[j+1];
                    flat[j+1]=tmp;
                }

            }

        }
        for (int i = 0; i <flat.length; i++) {
            Flat.info(flat[i]);

        }


    }

    public static void info(Dwelling dw) {
        System.out.println("floors: "+dw.floors+ " house square: " +dw.getHouseSquare()+" house flats: "+ dw.getHouseFlats()+" house rooms: "+dw.getHouseRooms());
        System.out.println(" ");
        for (int i = 0; i <dw.dwellingFloor.length ; i++) {
            int k=i+1;
            System.out.println("floor: "+k);
            DwellingFloor.info2(dw.dwellingFloor[i]);

        }
    }


                
}




