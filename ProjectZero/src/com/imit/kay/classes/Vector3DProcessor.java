package com.imit.kay.classes;

public abstract class Vector3DProcessor {
    public static Vector3D Sum(Vector3D a, Vector3D b) {
        return new Vector3D(a._x + b._x, a._y + b._y, a._z + b._z);
    }

    public static Vector3D Sub(Vector3D a, Vector3D b) {
        return new Vector3D(a._x - b._x, a._y - b._y, a._z - b._z);
    }

    public static float ScalarMul(Vector3D a, Vector3D b) {
        return (a._x * b._x + a._y * b._y + a._z * b._z);
    }

    public static Vector3D VectorMul(Vector3D a, Vector3D b) {
        return new Vector3D(a._y * b._z - a._z * b._y,
                a._z * b._x - a._x * b._z,
                a._x * b._y - a._y * b._x);
    }

    public static boolean IsColl(Vector3D a, Vector3D b) {
        boolean zeroX = b._x == 0, zeroY = b._y == 0, zeroZ = b._z == 0;

        if (zeroX && a._x != b._x)
            return false;

        if (zeroY && a._y != b._y)
            return false;
        if (zeroZ && a._z != b._z)
            return false;

        return ((zeroX || zeroY || a._x / b._x == a._y / b._y)
                && (zeroZ || zeroY || a._z / b._z == a._y / b._y)
                && (zeroX || zeroZ || a._x / b._x == a._z / b._z));
    }

    // к задаче с Vector3DArray
    public static Point3D TranslatePoint(Vector3D v, Point3D p) {
        return new Point3D(v._x + p._x, v._y + p._y, v._z + p._z);
    }

    public static Vector3D MulConst(Vector3D v, float c) {
        return new Vector3D(v._x * c, v._y * c, v._z * c);
    }

}
