package Strutturali.Adapter.Cardin;

public final class AreaCalculator {

    public double rectangleArea(ExtPoint upper, ExtPoint lower){
        return 0.0D;
    }

    public static class ExtPoint {
        private final double x, y;

        public ExtPoint(double x, double y){
            this.x = x;
            this.y = y;
        }
    }
}