package com.company;

public class Matrix {
    final double[][] matrix;
    final int rowsLength;
    final int columnsLength;

    public Matrix(int rows, int columns) {
        this.rowsLength = rows;
        this.columnsLength = columns;
        matrix = new double[rows][columns];
    }

    public Matrix(double[][] array) {
        int columnLen = array[0].length;
        for (double[] el: array){
            if (el.length != columnLen) throw new ArrayIndexOutOfBoundsException();
        }
            matrix = array;
            rowsLength = matrix.length;
            columnsLength = matrix[0].length;
    }

    public Matrix add(Matrix b) {
        Matrix newM = new Matrix(rowsLength, columnsLength);

        if (rowsLength != b.rowsLength || columnsLength != b.columnsLength) throw new ArithmeticException();
        for (int i = 0; i < rowsLength; i++) {
            for (int j = 0; j < columnsLength; j++) {
                newM.matrix[i][j] = matrix[i][j] + b.matrix[i][j];
            }
        }
        return newM;
    }

    public static Matrix add(Matrix a, Matrix b) {
        return a.add(b);
    }

    public Matrix neg() {
        Matrix newM = new Matrix(rowsLength, columnsLength);

        for (int i = 0; i < rowsLength; i++) {
            for (int j = 0; j < columnsLength; j++) {
                newM.matrix[i][j] = -matrix[i][j];
            }
        }
        return newM;
    }

    public Matrix sub(Matrix b) {
        return add(b.neg());
    }

    public static Matrix sub(Matrix a, Matrix b) {
        return add(a, b.neg());
    }

    public Matrix mul(Matrix b) {
        Matrix result = new Matrix(rowsLength, b.columnsLength);

        for (int i = 0; i < rowsLength; i++) {
            for (int j = 0; j < b.columnsLength; j++) {
                for (int k = 0; k < b.rowsLength; k++) {
                    result.matrix[i][j] += matrix[i][k] * b.matrix[k][j];
                }
            }
        }
        return result;
    }

    public Matrix mul(double b){
        Matrix result = new Matrix(rowsLength, columnsLength);
        for (int i = 0; i < rowsLength; i++){
            for (int j = 0; j < columnsLength; j++){
                result.matrix[i][j] *= b;
            }
        }
        return result;
    }

    public static Matrix mul(Matrix a, int b){
        return a.mul(b);
    }

    public static Matrix mul(Matrix a, Matrix b) {
        return a.mul(b);
    }

    public Matrix transpose() {
        Matrix result = new Matrix(columnsLength, rowsLength);
        for (int i = 0; i < result.rowsLength; i++) {
            for (int j = 0; j < result.columnsLength; j++) {
                result.matrix[i][j] = matrix[j][i];
            }
        }
        return result;
    }

    public static Matrix transpose(Matrix a) {
        return a.transpose();
    }

    public Matrix pow(int n) {
        if (rowsLength != columnsLength || n <= 0) throw new ArithmeticException();

        Matrix result = new Matrix(matrix);
        for (int i = 0; i < n - 1; i++) {
            result = mul(result, this);
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < rowsLength; i++) {
            for (int j = 0; j < columnsLength; j++) {
                s.append(String.format("%10.2f", Math.round(matrix[i][j] * 100) / 100.0)).append("\t\t");
            }
            s.append('\n');
        }
        return s.toString();
    }
}
