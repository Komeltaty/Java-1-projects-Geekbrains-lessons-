public class Bowl {

    int volume; //это объем миски
    int volumeFood;   //это количество еды в миске

    public Bowl (){
        this.volume = 10;
        this.volumeFood=0;

    }
    public Bowl (int volume, int volumeFood){
        this.volume = volume;
        this.volumeFood=volumeFood;

    }

    //в этом методе мы наполним миску
    public int full( int volumeFood){

    if (this.volumeFood==0){
        System.out.println("Еда в миске кончилась, нужно наполнить!");
        this.volumeFood=this.volume;
        System.out.println("В миске снова " + this.volumeFood +" единиц еды!");
        System.out.println("Котики, идите кушать!!");
        System.out.println();
    }
    else System.out.println("В миске " + this.volumeFood + " единиц еды.");
     return this.volumeFood;
    }

    //метод получения информации о количестве еды
    public int getVolumeFood(){
     return volumeFood;
    }
    public void setVolumeFood(int volumeFood){
        this.volumeFood=volumeFood;
    }


}
