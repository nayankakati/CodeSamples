package old;

class Solution {

  static final int MOD=1000000007;
  public int solution(int A, int B, int N) {
    return checkFibonaciSequence(A,B,N);
  }

  static int checkFibonaciSequence(int a, int b, int n) {
    int buildMatrix[][] = new int[][]{{1,1},{1,0}};
    if (n == 0)
      return 0;
    calculatePower(buildMatrix, n-1);

    long ans=(((a%MOD)*(buildMatrix[0][1]%MOD))%MOD+ (b%MOD)*(buildMatrix[0][0]%MOD)%MOD)%MOD;

    return (int)(ans);
  }
  
  static void calculatePower(int F[][], int n) {
    int i;
    int powerMatrix[][] = new int[][]{{1,1},{1,0}};

    for (i = 2; i <= n; i++)
      calculateMultiply(F, powerMatrix);
  }

  static void calculateMultiply(int buildMatrix[][], int powerMatrix[][]) {
    int x =  ((buildMatrix[0][0]*powerMatrix[0][0])%MOD + (buildMatrix[0][1]*powerMatrix[1][0])%MOD)%MOD;
    int y =  ((buildMatrix[0][0]*powerMatrix[0][1])%MOD + (buildMatrix[0][1]*powerMatrix[1][1])%MOD)%MOD;
    int z =  ((buildMatrix[1][0]*powerMatrix[0][0])%MOD + (buildMatrix[1][1]*powerMatrix[1][0])%MOD)%MOD;
    int w =  ((buildMatrix[1][0]*powerMatrix[0][1])%MOD + (buildMatrix[1][1]*powerMatrix[1][1])%MOD)%MOD;

    buildMatrix[0][0] = x;
    buildMatrix[0][1] = y;
    buildMatrix[1][0] = z;
    buildMatrix[1][1] = w;
  }
}
