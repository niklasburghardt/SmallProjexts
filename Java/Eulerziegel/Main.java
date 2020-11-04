public class Main{
    int dist= 10000;

    

    public boolean isInt(double n){
        return Math.floor(n)*Math.floor(n) == n*n;
    }

    public void search(){
        int count = 0;
        for(int i = 10; i<dist; i++){
            for(int j = 10; j<dist; j++){
                for(int k = 10; k<dist; k++){
                    if(isInt(Math.sqrt(i*i + j*j)) && isInt(Math.sqrt(i*i + k*k)) && isInt(Math.sqrt(j*j + k*k))){
                        count++;
                        System.out.println(count+": "+i+", "+j+", "+k);
                    }
                }
            }
        }
    }

    public static void main(String[] args){
        Main m = new Main();
        m.search();
    }
}