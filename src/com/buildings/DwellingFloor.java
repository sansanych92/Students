package com.buildings;

public class DwellingFloor {
    private int kolvo;
    private Flat [] flats;
    static int l;

    public DwellingFloor(int kolvo){
        this.kolvo=kolvo;
        flats=new Flat[kolvo];
        for (int i = 0; i <flats.length ; i++) {
            flats[i]=new Flat();

        }
    }

    public DwellingFloor(Flat [] flats){
        this.flats=flats;
        this.kolvo=flats.length;
    }

    public int getKolvo() {
        return flats.length;
    }

    public int getFlatsSquare(){
        int i=0;
        for (Flat flat:flats) {
            i+=flat.getSquare();
        }
        return i;
    }

    public int getFlatsRooms() {
        int i=0;
        for (Flat flat:flats) {
            i+=flat.getRooms();
        }
        return i;
    }

    public Flat[] getFlats() {
        return flats;
    }

    public Flat onNumber(int number) {
        return flats[number];
    }

    public Flat edit(int number, Flat flat) {
        flats[number]=flat;
        return flats[number];
    }

    public void newFlat(int number, Flat flat)  {
        int n=number;
        Flat [] newFlats=new Flat[flats.length+1];
        int i=flats.length;
        for (int j = 0; j <newFlats.length ; j++) {
            if(j<n) {
                newFlats[j]=flats[j];
            }
            else if(j==n) {
                newFlats[j]=flat;
            }
            else if(j>n) {
                newFlats[j]=flats[j-1];
            }

        }
        flats=newFlats;


       // return flats;
    }


    public void deleteFlat (int number){
        Flat []flats2=new Flat[flats.length-1];
        for (int i = 0; i < flats2.length; i++) {
            if(i<(number)) {
                flats2[i]=flats[i];
            }
            else {
                flats2[i]=flats[i+1];
            }

        }
        flats=flats2;
    }

    public Flat getBestSpace(){
        int square=flats[0].getSquare();
        Flat bigestSquareFlat=new Flat();
        for (int i = 0; i <flats.length ; i++) {
            if (flats[i].getSquare()>=square){
                square=flats[i].getSquare();
                bigestSquareFlat=flats[i];
            }
        }
    return bigestSquareFlat;
    }

    public static void info(DwellingFloor fs) {
        int n=fs.getFlatsRooms();
        int m=fs.getFlatsSquare();
        //int l=0;
        System.out.println("rooms: "+ n+ " square: "+m);
        System.out.println("flats: "+fs.kolvo);
        for (int i = 0; i <fs.flats.length; i++) {
            int k=1+i;
            System.out.print("number flat on floor : "+k+"  " );
            Flat.info(fs.flats[i]);
        }
    }

    public static void info2(DwellingFloor fs){
        int n=fs.getFlatsRooms();
        int m=fs.getFlatsSquare();
        //int l=0;
        System.out.println("rooms: "+ n+ " square: "+m);
        System.out.println("flats: "+fs.kolvo);
        System.out.println(" ");
        for (int i = 0; i <fs.flats.length; i++) {
            int k=1+i;
            l=l+1;
            System.out.print("number flat on house: "+ l+" number flat on floor : "+k+"  " );
            Flat.info(fs.flats[i]);
        }
        System.out.println(" ");
    }

}
