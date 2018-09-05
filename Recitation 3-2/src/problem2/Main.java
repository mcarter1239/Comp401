package problem2;

public class Main {
    public static void main(String[] args){

        int const_width = 5;
        int const_height = 5;

        StarMap starMap = new StarMap(const_width,const_height);
        starMap.PlotStar(0, 0);
        starMap.PlotStar(const_width-1, 0);
        starMap.PlotStar(const_width-1,const_height-1);
        System.out.println("Can I see a map?");
        starMap.PrintMap();

        System.out.println("Alright. Remove a star please?");
        starMap.RemovePlot(const_width-1, 0);
        starMap.PrintMap();
    }
}
