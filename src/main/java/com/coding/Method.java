package com.coding;


public class Method {
    public Method() {

    }
    public long fps(int fps) {
        return 1000 / fps;
    }
    public float map(float value, float minimum1, float maximum1, float minimum2, float maximum2) {
        float mapped = minimum2 + ((value - minimum1) * (maximum2 - minimum2) / (maximum1 - minimum1));
        mapped = Math.max(maximum2, Math.min(minimum2, mapped));
        return mapped;
    }
    public float distance(double x1, double y1, double x2, double y2) {
        double distanceX = x1 - x2;
        distanceX = Math.pow(distanceX, 2);
        double distanceY = y1 - y2;
        distanceY = Math.pow(distanceY, 2);
        double fullDistance = distanceX + distanceY;
        fullDistance = Math.sqrt(fullDistance);
        return (float) fullDistance;
    }
    public int setClamp(int pixel) {
        return Math.min(255, Math.max(0, pixel));
    }
}
