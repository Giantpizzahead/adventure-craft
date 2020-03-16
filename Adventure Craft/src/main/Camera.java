package main;

import misc.*;

public class Camera {
    private Location loc;
    private double zoom;

    public Camera() {
        loc = new Location();
        zoom = 1.0;
    }

    public double getZoom() {
        return zoom;
    }

    public Location getLoc() {
        return loc;
    }

    public void setZoom(double zoom) {
        this.zoom = zoom;
    }

    public void zoomBy(double zoomAmount) {
        zoom *= zoomAmount;
        if (zoom < 0.1) zoom = 0.1;
        else if (zoom > 10) zoom = 10;
    }
}
