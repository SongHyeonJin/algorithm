import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, k, cnt, answer = -1;
    static int[] arr, tmp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n];
        tmp = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        merge_sort(0, arr.length-1);
        System.out.println(answer);
    }
    static void merge_sort(int left, int right) {
        if (cnt > k) return;

        if (left < right) {
            int mid = (left + right) / 2;
            merge_sort(left, mid);
            merge_sort(mid + 1, right);
            merge(left, mid, right);
        }
    }
    static void merge(int left, int mid, int right) {
        int i = left, j = mid + 1, t = 0;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                tmp[t++] = arr[i++];
            } else {
                tmp[t++] = arr[j++];
            }
        }

        while (i <= mid) {
            tmp[t++] = arr[i++];
        }

        while (j <= right) {
            tmp[t++] = arr[j++];
        }

        i = left;
        t = 0;

        while (i <= right) {
            cnt++;

            if (cnt==k) {
                answer = tmp[t];
                return;
            }

            arr[i++] = tmp[t++];
        }
    }
}
