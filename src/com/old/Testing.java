package com.old;

public class Testing {
    
    public static void main(String[] args) {


      /*String[] strings = {"25626","25757","24367", "24267", "16", "100","2", "7277"};
//      int n = 0;
      Scanner scan = newTasks Scanner(System.in);

      System.out.println("Please enter String ");
      String n =  scan.nextLine();
      String[] numberstring = n.split("\\Employees+");
      final int [] numbers = newTasks int[numberstring.length];
      int count = 0;
      for (String Employees : Arrays.asList(numberstring)) {
        numbers[count++] = Integer.parseInt(Employees);
      }
      StringBuilder builder  =  newTasks StringBuilder();

      builder.append(numbers[0]);
      for(int i=1 ;i<numbers.length;i++) {
          int diff = numbers[i] - numbers [i-1];
          if(diff <= 127 && diff >= -127) {
            builder.append(diff + " ");
          } else {
            builder.append(" -128 ").append(diff+ " ");
          }
      }

      System.out.println(builder.toString());*/

      /*int c1 =-1;
      int a =4,c=0;
      try {
        c1 = a / c;
      } catch (Exception e) {
        System.out.println("Exception");

      } finally {
        System.out.println("finlly");
      }
      System.out.println(c1);
      List binaryTreeArr = newTasks ArrayList();
      binaryTreeArr.add(1);
      for(int i=0 ; i<binaryTreeArr.size();i++){
        binaryTreeArr.get
      }
    }*/


      /*int a[] = {1,5,3,4,2}, k=2;
      int count =0;

      Map map = newTasks HashMap();

      for(int i =0; i<a.length; i++) {
        map.put(a[i],i);
      }

      for(int i=0; i<a.length;i++) {
        int c = a[i] + k;
        if(map.containsKey(c))
          count++;
      }
      System.out.println(count);
    }*/
      //System.out.println(sameContents(newTasks String[]{"a","b"},newTasks String[]{"a"}));
      System.out.println(friendlyWords(new String[]{"cheating","teaching"})[0]);
}


    static String[] friendlyWords(String[] input) {

        String[] result = new String[input.length];
        int size=0;
        //car,lead,deal,dale,cheating,teaching

        for(int i =0;i<input.length;i++) {
             char[] word =  input[i].toCharArray();
             for(int j=0;j<input.length;j++) {
                 if(i==j) continue;
                 char[] target = input[j].toCharArray();
                 if(word.length == target.length) {
                    if(sameContents(word,target))
                        result[size++] = input[i] + " " + input[j];
                 }
             }
        }
        return result;
    }




// AAB, ABA
    //A

    static boolean sameContents(char[] a, char[] b) {

        int count =0;
        if(a == null || b == null || a.length != b.length)
            return false;

        for (int i = 0; i < a.length; i++) {
            for(int j=0;j<b.length;j++) {
                if(a[i] == b[j]) {
                    count++;
                    b[j] = '*';
                    break;
                }
            }
        }

        if(count == a.length)
            return true;

        return false;
    }

    static boolean sameContents(String[] a, String[] b) {

        int count =0;
        if(a == null || b == null || a.length != b.length)
            return false;

        for (int i = 0; i < a.length; i++) {
            for(int j=0;j<b.length;j++) {
                if(a[i].equals(b[j])) {
                    count++;
                    b[j] = "*";
                    break;
                }
            }
        }

        if(count == a.length)
        return true;

        return false;
    }
}
