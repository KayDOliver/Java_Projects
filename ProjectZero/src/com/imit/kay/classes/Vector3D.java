package com.imit.kay.classes;

public class Vector3D {
    public double Getx() {
        return x;
    }

    public void setx(float x) {
        this.x = x;
    }

    public double Gety() {
        return y;
    }

    public void sety(float y) {
        this.y = y;
    }

    public double getz() {
        return z;
    }

    public void setz(float z) {
        this.z = z;
    }

    protected double x;
    protected double y;
    protected double z;

    public Vector3D() {
        x = 0;
        y = 0;
        z = 0;
    }

    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3D(Point3D a, Point3D b){
        this.x = a._x - b._x;
        this.y = a._y - b._y;
        this.z = a._z - b._z;
    }

    public double Length(){
        return Math.sqrt(x * x + y * y + z * z);
    }

    private boolean EqualNumber(double a, double b) {
        double eps = 1e-9;
        return Math.abs(a - b) < eps;

    }

    public boolean Equal(Vector3D v){
        return EqualNumber(this.x, v.x) && EqualNumber(this.y, v.y) && EqualNumber(this.z, v.z);
    }

    public void Print() {
        System.out.format("Vector: (%.3f, %.3f, %.3f)\n", x, y, z);
    }
}
