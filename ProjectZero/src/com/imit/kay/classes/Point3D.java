package com.imit.kay.classes;

public class Point3D {
    public double Get_x() {
        return _x;
    }

    public void set_x(double _x) {
        this._x = _x;
    }

    public double Get_y() {
        return _y;
    }

    public void set_y(double _y) {
        this._y = _y;
    }

    public double get_z() {
        return _z;
    }

    public void set_z(double _z) {
        this._z = _z;
    }

    protected double _x;
    protected double _y;
    protected double _z;

    public Point3D() {
        _x = 0;
        _y = 0;
        _z = 0;
    }

    public Point3D(double x, double y, double z) {
        _x = x;
        _y = y;
        _z = z;
    }

    public void Print() {
        System.out.format("Point position: (%.3f, %.3f, %.3f)\n", _x, _y, _z);
    }
}
