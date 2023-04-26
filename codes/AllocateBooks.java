import java.util.ArrayList;

// https://www.interviewbit.com/problems/allocate-books/

public class AllocateBooks {
  public int books(ArrayList<Integer> A, int B) {
    int sz = A.size();
    if(B > A.size()) return -1;

    int low = 0, high = 0, res = 0, sum = 0;
    for(int i = 0; i < sz; i++) {
      low = Math.max(low, A.get(i));
      high += A.get(i);
    }

    for (int i = 0; i < sz; i++) {
      sum += A.get(i);
    }

    while(low <= high) {
      int mid = low + (high - low) / 2;
      if(isPossible(A, B, mid, sum)) {
        res = mid;
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return res;
  }

  private boolean isPossible(ArrayList<Integer> books, int students, long maxPage, long totalPages) {
    if(maxPage < totalPages / students) return false;

    int index = 0;
    int sz = books.size();

    // for each students, try to assign books until number of pages in books is greater than max page.
    for(int i = 0; i < students && index < sz; i++) {
      long total = 0;

      while(total < maxPage && index < sz) {
        total += books.get(index);
        if(total > maxPage) break;
        index++;
      }
    }
    if(index < sz) return false;
    return true;
  }
}
