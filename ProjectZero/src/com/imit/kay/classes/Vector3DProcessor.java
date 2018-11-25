package com.imit.kay.classes;

public abstract class Vector3DProcessor {
    public static Vector3D Sum(Vector3D a, Vector3D b) {
        return new Vector3D(a.x + b.x, a.y + b.y, a.z + b.z);
    }

    public static Vector3D Sub(Vector3D a, Vector3D b) {
        return new Vector3D(a.x - b.x, a.y - b.y, a.z - b.z);
    }

    public static double ScalarMul(Vector3D a, Vector3D b) {
        return (a.x * b.x + a.y * b.y + a.z * b.z);
    }

    public static Vector3D VectorMul(Vector3D a, Vector3D b) {
        return new Vector3D(a.y * b.z - a.z * b.y,
                a.z * b.x - a.x * b.z,
                a.x * b.y - a.y * b.x);
    }

    public static boolean IsColl(Vector3D a, Vector3D b) {
        boolean zeroX = b.x == 0, zeroY = b.y == 0, zeroZ = b.z == 0;

        if (zeroX && a.x != b.x)
            return false;

        if (zeroY && a.y != b.y)
            return false;
        if (zeroZ && a.z != b.z)
            return false;

        return ((zeroX || zeroY || a.x / b.x == a.y / b.y)
                && (zeroZ || zeroY || a.z / b.z == a.y / b.y)
                && (zeroX || zeroZ || a.x / b.x == a.z / b.z));
    }

    // к задаче с Vector3DArray
    public static Point3D TranslatePoint(Vector3D v, Point3D p) {
        return new Point3D(v.x + p._x, v.y + p._y, v.z + p._z);
    }

    public static Vector3D MulConst(Vector3D v, double c) {
        return new Vector3D(v.x * c, v.y * c, v.z * c);
    }

}
