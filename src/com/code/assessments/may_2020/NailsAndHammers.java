package code.assessments.may_2020;

public class NailsAndHammers {
    public static void main(String[] args) {
        int A[] = {1,1,3,3,3,4,5,5,5,5}; // 5
        //int A[] = {1,1,3,3,3,4,5,5,5,5,7,7,7,7,7,7,7}; // 7
        //int A[] = {1,1,3,3,3,4,5,5,5,5,7,7,7}; // 6
        int Y = 2;


        int previousMax = 0;
        int previousValue = 0;

        int max = 0;
        int maxValue = 0;

        int count = 1;
        boolean check = false;

        for (int i=0; i< A.length ; i++) {

            if(i != A.length-1 && A[i] == A[i+1]) {
                count++;
                continue;
            }

            if(previousMax == count)
                previousValue = A[i];

            if(count > max) {
                previousMax = max;
                previousValue = maxValue;

                max = count;
                maxValue = A[i];

                count = 1;
            }
        }
        // if Max is at right side

        if (previousMax + Y > max)
            if(previousValue < maxValue)
              System.out.println(previousMax + Y);
            else
                System.out.println(max + Y);
        else
              System.out.println(max);


       /* if (previousValue > maxValue) {
            if (previousMax + Y > max)
                System.out.println(previousMax + Y);
            else
                System.out.println(max);
        } else if(maxValue > previousValue) { // if Max is at left side
            System.out.println(max);
        }*/
    }
}
