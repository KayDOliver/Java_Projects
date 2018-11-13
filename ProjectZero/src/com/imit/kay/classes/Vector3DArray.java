package com.imit.kay.classes;

import java.util.Arrays;

public class Vector3DArray {
    private int _n;
    private Vector3D _m[];

    public Vector3DArray(int n) {
        this._n = Math.max(0, n);
        _m = new Vector3D[_n];

        for (int i = 0; i<_n; i++)
            _m[i] = new Vector3D();
    }

    public int Size() {
        return _n;
    }

    public void Set(Vector3D v, int i) {
        _m[i] = v;
    }

    public double MaxLen() {
        return Arrays.stream(_m).max((a, b) -> a.Length() < b.Length() ? -1 : 0).get().Length();
    }

    public int IndexOf(Vector3D v){
        for (int i = 0; i < _n; i++)
            if ( v.Equal(_m[i]))
                return i;

        return -1;
    }

    public Vector3D Sum(){
        Vector3D v0 = new Vector3D();
        for (Vector3D v : _m)
            v0= Vector3DProcessor.Sum(v0, v);

        return v0;
    }

    public Point3D[] PointArray(Point3D p){
        Point3D points[] = new Point3D[_n];
        for (int i = 0; i < _n; i++)
            points[i]= Vector3DProcessor.TranslatePoint( _m[i], p);

        return points;
    }

    public Vector3D LineComb(float k[]) throws IllegalArgumentException{
        if(k.length!=_n)
            throw new IllegalArgumentException("\nIncorrect size of k-massive\n");

        Vector3D v0 = new Vector3D();
        for (int i = 0; i < _n; i++)
            v0= Vector3DProcessor.Sum(v0, Vector3DProcessor.MulConst(_m[i],k[i]));

        return v0;
    }

    public void Print(){
        System.out.println("\nArray content:\n{ ");
        for (Vector3D v : _m){
            System.out.print("\t");
            v.Print();
        }
        System.out.println("}");
    }

}
