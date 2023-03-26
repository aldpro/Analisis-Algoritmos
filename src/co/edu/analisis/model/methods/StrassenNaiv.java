package co.edu.analisis.model.methods;

public class StrassenNaiv {

    public double[][] strassenNaiv(double[][] a, double[][] b, double[][] c, int n, int p, int m) {

        int MaxSize, k, mm, NewSize, i, j;

        MaxSize = max(n,p);


        if (MaxSize < 16) {
            MaxSize = 16; 
        }
        k = (int) Math.floor(Math.log(MaxSize)/Math.log(2)) - 4;
        mm = (int) Math.floor(MaxSize * Math.pow(2,-k)) + 1;

        NewSize = mm * (int) Math.pow(2,k);

        // add zero rows and columns to use Strassens algorithm
        double[][] aNew = new double[NewSize][];
        double[][] bNew = new double[NewSize][];
        double[][] auxResult = new double[NewSize][];
        for (i = 0; i < NewSize; i++){
            aNew[i] = new double[NewSize];
            bNew[i] = new double[NewSize];
            auxResult[i] = new double[NewSize];
        }


        for (i = 0; i < NewSize; i++) {
            for (j = 0; j < NewSize; j++) {
                aNew[i][j] = 0.0;
                bNew[i][j] = 0.0;
            }
        }
        for (i = 0; i < n; i++) {
            for (j = 0; j < p; j++) {
                aNew[i][j] = a[i][j];
            }
        }
        for (i = 0; i < p; i++) {
            for (j = 0; j < m; j++) {
                bNew[i][j] = b[i][j];
            }
        }
        
        strassenNaivStep(aNew, bNew, auxResult, NewSize, mm);
 
        for (i = 0; i < n; i++) {
            for (j = 0; j < m; j++) {
                c[i][j] = auxResult[i][j]; //Result
            }
        }
        return c;
    }

    public int max (int n, int p){
        if (n < p){
            return p;
        } else {
            return n;
        }

    }


    private void minus(double[][] a, double[][] b, double[][] c, int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                c[i][j] = a[i][j] - b[i][j];
            }
        }
    }

    private void plus(double[][] a, double[][] b, double[][] c, int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                c[i][j] = a[i][j] + b[i][j];
            }
        }
    }

    public double[][] strassenNaivStep(double[][] a, double[][] b, double[][] c, int n, int m) {
    	NaivStandard metodo = new NaivStandard();
    	
        int i, j, NewSize;

        if ((n % 2 == 0) && (n > m)){
            NewSize = n / 2;

            // decompose A and B
            // create ResultPart, Aux1,...,Aux7 and Helper1, Helper2
            double[][] A11 = new double[NewSize][];
            double[][] A12 = new double[NewSize][];
            double[][] A21 = new double[NewSize][];
            double[][] A22 = new double[NewSize][];
            double[][] B11 = new double[NewSize][];
            double[][] B12 = new double[NewSize][];
            double[][] B21 = new double[NewSize][];
            double[][] B22 = new double[NewSize][];

            double[][] ResultPart11 = new double[NewSize][];
            double[][] ResultPart12 = new double[NewSize][];
            double[][] ResultPart21 = new double[NewSize][];
            double[][] ResultPart22 = new double[NewSize][];

            double[][] Helper1 = new double[NewSize][];
            double[][] Helper2 = new double[NewSize][];

            double[][] Aux1 = new double[NewSize][];
            double[][] Aux2 = new double[NewSize][];
            double[][] Aux3 = new double[NewSize][];
            double[][] Aux4 = new double[NewSize][];
            double[][] Aux5 = new double[NewSize][];
            double[][] Aux6 = new double[NewSize][];
            double[][] Aux7 = new double[NewSize][];

            for (i = 0; i < NewSize; i++){

                A11[i] = new double[NewSize];
                A12[i] = new double[NewSize];
                A21[i] = new double[NewSize];
                A22[i] = new double[NewSize];
                B11[i] = new double[NewSize];
                B12[i] = new double[NewSize];
                B21[i] = new double[NewSize];
                B22[i] = new double[NewSize];

                ResultPart11[i] = new double[NewSize];
                ResultPart12[i] = new double[NewSize];
                ResultPart21[i] = new double[NewSize];
                ResultPart22[i] = new double[NewSize];

                Helper1[i] = new double[NewSize];
                Helper2[i] = new double[NewSize];

                Aux1[i] = new double[NewSize];
                Aux2[i] = new double[NewSize];
                Aux3[i] = new double[NewSize];
                Aux4[i] = new double[NewSize];
                Aux5[i] = new double[NewSize];
                Aux6[i] = new double[NewSize];
                Aux7[i] = new double[NewSize];
            }

            //fill new matrices
            for( i = 0; i < NewSize; i++){
                for( j = 0; j < NewSize; j++){
                    A11[i][j] = a[i][j];
                }
            }

            for( i = 0; i < NewSize; i++){
                for( j = 0; j < NewSize; j++){
                    A12[i][j] = a[i][NewSize + j];
                }
            }
            for( i = 0; i < NewSize; i++){
                for( j = 0; j < NewSize; j++){
                    A21[i][j] = a[NewSize + i][j];
                }
            }

            for( i = 0; i < NewSize; i++) {
                for (j = 0; j < NewSize; j++) {
                    A22[i][j] = a[NewSize + i][NewSize + j];
                }
            }

            for( i = 0; i < NewSize; i++){
                for( j = 0; j < NewSize; j++){
                    B11[i][j] = b[i][j];
                }
            }
            for( i = 0; i < NewSize; i++){
                for( j = 0; j < NewSize; j++){
                    B12[i][j] = b[i][NewSize + j];
                }
            }
            for( i = 0; i < NewSize; i++){
                for( j = 0; j < NewSize; j++){
                    B21[i][j] = b[NewSize + i][j];
                }
            }
            for( i = 0; i < NewSize; i++){
                for( j = 0; j < NewSize; j++){
                    B22[i][j] = b[NewSize + i][NewSize + j];
                }
            }

            // computing the seven aux. variables
            plus(A11, A22, Helper1, NewSize, NewSize);
            plus(B11, B22, Helper2, NewSize, NewSize);
            strassenNaivStep(Helper1, Helper2, Aux1, NewSize, m);

            plus(A21, A22, Helper1, NewSize, NewSize);
            strassenNaivStep(Helper1, B11, Aux2, NewSize, m);

            minus(B12, B22, Helper1, NewSize, NewSize);
            strassenNaivStep(A11, Helper1, Aux3, NewSize, m);

            minus(B21, B11, Helper1, NewSize, NewSize);
            strassenNaivStep(A22, Helper1, Aux4, NewSize, m);

            plus(A11, A12, Helper1, NewSize, NewSize);
            strassenNaivStep(Helper1, B22, Aux5, NewSize, m);

            minus(A21, A11, Helper1, NewSize, NewSize);
            plus(B11, B12, Helper2, NewSize, NewSize);
            strassenNaivStep(Helper1, Helper2, Aux6, NewSize, m);

            minus(A12, A22, Helper1, NewSize, NewSize);
            plus(B21, B22, Helper2, NewSize, NewSize);
            strassenNaivStep(Helper1, Helper2, Aux7, NewSize, m);

            // computing the four parts of the result
            plus(Aux1, Aux4, ResultPart11, NewSize, NewSize);
            minus(ResultPart11, Aux5, ResultPart11, NewSize, NewSize);
            plus(ResultPart11, Aux7, ResultPart11, NewSize, NewSize);

            plus(Aux3, Aux5, ResultPart12, NewSize, NewSize);

            plus(Aux2, Aux4, ResultPart21, NewSize, NewSize);

            plus(Aux1, Aux3, ResultPart22, NewSize, NewSize);
            minus(ResultPart22, Aux2, ResultPart22, NewSize, NewSize);
            plus(ResultPart22, Aux6, ResultPart22, NewSize, NewSize);

            // store results in the "result matrix"
            for( i = 0; i < NewSize; i++){
                for( j = 0; j < NewSize; j++){
                    c[i][j] = ResultPart11[i][j];
                }
            }

            for( i = 0; i < NewSize; i++){
                for( j = 0; j < NewSize; j++){
                    c[i][NewSize + j] = ResultPart12[i][j];
                }
            }

            for( i = 0; i < NewSize; i++){
                for( j = 0; j < NewSize; j++){
                    c[NewSize + i][j] = ResultPart21[i][j];
                }
            }

            for( i = 0; i < NewSize; i++){
                for( j = 0; j < NewSize; j++){
                    c[NewSize + i][NewSize + j] = ResultPart22[i][j];
                }
            }

            // free helper variables
            A11 = null;
            A12 = null;
            A21 = null;
            A22 = null;

            B11 = null;
            B12 = null;
            B21 = null;
            B22 = null;

            ResultPart11 = null;
            ResultPart12 = null;
            ResultPart21 = null;
            ResultPart22 = null;

            Helper1 = null;
            Helper2 = null;

            Aux1 = null;
            Aux2 = null;
            Aux3 = null;
            Aux4 = null;
            Aux5 = null;
            Aux6 = null;
            Aux7 = null;

        } else {
            // use naiv algorithm
        	c = metodo.naivStandard(a, b, c, n, n, n);
        }
        return c;
    }
}
