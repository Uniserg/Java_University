package com.company;

import java.util.Random;

public class Vector3D {
    public final double x;
    public final double y;
    public final double z;

    public Vector3D(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getLength(){
        return Math.sqrt(x * x + y * y + z * z);
    }

    public double scalarProduct(Vector3D b){
        return x * b.x + y * b.y + z * b.z;
    }

    public static double scalarProduct(Vector3D a, Vector3D b){
        return a.scalarProduct(b);
    }

    public Vector3D mul(Vector3D b){
        return new Vector3D(y * b.z - z * b.y,
                            z * b.x - x * b.z,
                            x * b.y - y * b.x);
    }

    public static Vector3D mul(Vector3D a, Vector3D b){
        return a.mul(b);
    }

    public double angle(Vector3D b){
        return Math.toDegrees(Math.acos(scalarProduct(b) / (getLength() * b.getLength())));
    }

    public static double angle(Vector3D a, Vector3D b) {
        return a.angle(b);
    }

    public Vector3D neg(){
        return new Vector3D(-x, -y, -z);
    }

    public Vector3D add(Vector3D b){
        return new Vector3D(x + b.x, y + b.y, z + b.z);
    }

    public static Vector3D add(Vector3D a, Vector3D b){
        return a.add(b);
    }

    public Vector3D sub(Vector3D b){
        return add(b.neg());
    }

    public static Vector3D sub(Vector3D a, Vector3D b){
        return a.sub(b);
    }

    public static Vector3D[] generateVectors(int n){
        Vector3D[] result = new Vector3D[n];
        Random random = new Random();
        for (int i = 0; i < n; i++){
            result[i] = new Vector3D(random.nextInt(n), random.nextInt(n), random.nextInt(n));
        }
        return result;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }
}
