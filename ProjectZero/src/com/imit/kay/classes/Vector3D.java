package com.imit.kay.classes;

import sun.security.util.Length;

public class Vector3D extends Point3D {
    public Vector3D(){
        super();
    }

    public Vector3D(float x, float y, float z){
        super(x, y, z);
    }

    public Vector3D(Point3D a, Point3D b){
        super(b._x-a._x, b._y-a._y, b._z-a._z);
    }

    public double Length(){
        return Math.sqrt(_x*_x + _y*_y + _z*_z);
    }

    public boolean Equal(Vector3D v){
       return (this._x==v._x && this._y==v._y && this._z==v._z);
    }

    @Override
    public void Print() {
        System.out.format("Vector: (%.3f, %.3f, %.3f)\n", _x, _y, _z);
    }
}
