import java.util.*;

class Solution {

  public int[] solution(int[] arr) {
    Stack<Integer> st = new Stack<>();
    st.push(arr[0]);
    for (int i : arr) {
      if (st.peek() != i) {
        st.push(i);
      }
    }
    return st.stream().mapToInt(i -> i).toArray();
  }
}
