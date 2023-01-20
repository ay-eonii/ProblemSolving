//solution1
class Solution1 {

  public String[] solution(int n, int[] arr1, int[] arr2) {
    String[] binaryArr1 = new String[n];
    String[] binaryArr2 = new String[n];
    for (int i = 0; i < n; i++) {
      binaryArr1[i] = Integer.toBinaryString(arr1[i]);
      while (binaryArr1[i].length() < n) {
        binaryArr1[i] = "0" + binaryArr1[i];
      }
      binaryArr2[i] = Integer.toBinaryString(arr2[i]);
      while (binaryArr2[i].length() < n) {
        binaryArr2[i] = "0" + binaryArr2[i];
      }
    }

    String[] answer = new String[n];
    for (int i = 0; i < n; i++) {
      answer[i] = "";
      String[] binaryArr1_split = binaryArr1[i].split("");
      String[] binaryArr2_split = binaryArr2[i].split("");
      for (int j = 0; j < n; j++) {
        answer[i] +=
          (binaryArr1_split[j].equals("1") || binaryArr2_split[j].equals("1"))
            ? "#"
            : " ";
      }
    }
    return answer;
  }
}

//solution2
class Solution2 {

  public String[] solution(int n, int[] arr1, int[] arr2) {
    String binaryArr[] = new String[n];
    for (int i = 0; i < n; i++) {
      binaryArr[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
      while (binaryArr[i].length() < n) {
        binaryArr[i] = "0" + binaryArr[i];
      }
    }

    String[] answer = new String[n];
    for (int i = 0; i < n; i++) {
      answer[i] = "";
      String[] binaryArr_split = binaryArr[i].split("");
      for (String str : binaryArr_split) {
        answer[i] += (str.equals("1")) ? "#" : " ";
      }
    }
    return answer;
  }
}
