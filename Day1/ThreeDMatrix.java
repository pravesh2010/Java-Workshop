package com.mphasis.assignment.day1;

/*
 *   perfoming array operations and creating three diamention matrix
 */
public class ThreeDMatrix {
    public static void main(String[] args) {

        int threeD[][][] = new int[4][4][4];

        int i, j, k, l= 0;

        for(i=0; i<4; i++)
            for (j = 0; j < i+1; j++)
                for(k=0; k<j+1; k++){
                    threeD[i][j][k] = l;
                    l++;

                }
        for(i=0; i<4; i++) {
            for(j=0; j<i+1; j++)
                for(k=0; k<j+1; k++)
                System.out.print(threeD[i][j][k] + " ");
            System.out.println();
        }

    }
}
