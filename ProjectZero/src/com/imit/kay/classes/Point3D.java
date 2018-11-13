package com.imit.kay.classes;

public class Point3D {
    public float Get_x() {
        return _x;
    }

    public void set_x(float _x) {
        this._x = _x;
    }

    public float Get_y() {
        return _y;
    }

    public void set_y(float _y) {
        this._y = _y;
    }

    public float get_z() {
        return _z;
    }

    public void set_z(float _z) {
        this._z = _z;
    }

    protected float _x;
    protected float _y;
    protected float _z;

    public Point3D() {
        _x = 0;
        _y = 0;
        _z = 0;
    }

    public Point3D(float x, float y, float z) {
        _x = x;
        _y = y;
        _z = z;
    }

    public void Print() {
        System.out.format("Point position: (%.3f, %.3f, %.3f)\n", _x, _y, _z);
    }
}
