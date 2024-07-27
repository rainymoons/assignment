package assign725.bubbleSort;

import java.util.Random;

/**
 * 버블 정렬 : 배열의 크기가 증가할떄 서로 인접한 두 원소의 크기를 비교하여 오름차순으로 자료를 정렬하는 방식(swap)
 *  순회 목록
 * [1] [2] [3] [4] [5] [6] [7] [8] [9] [10] ........, [60]:  배열의 크기 n
 *  1,  2,  3,  4,  5,  6,  7,  8,  9,  10,  .... , 59    : 총 라운드 수 n - 1
 *  59  58  57  56  55  54  53  52  51  50 , .. 58        : 라운드당 비교 횟수 n - i
 * {11} {5} {8} {10}{12}{15}{18} {19}{20}{21} ....... {60} => 배열에 실제로 들어가 있는 수
 * (해석) 총 30번의 라운드. 첫 라운드는 배열의 첫째 원소인 {11}과 {5}를 비교 하는 것 부터 시작해서 배열의 마지막 원소인 {60}까지 비교한다.
 *  배열 전체를 돌면서 비교 연산을 수행하는 것. -> 오름차순 정렬
 *
 *  # Point #
 *  - arr[j]가 arr[j+1]보다 크다면 둘의 자리를 바꿔라!
 *  - 두번째 for 문의 조건식이 n - i 인 이유
 *    -> 첫번째 라운드가 끝나면 가장 큰 수는 배열의 제일 마지막에 위치하게 된다. 그래서 제일 마지막 수는 비교할 필요가 없는 것(비교는 배열 전체를 돌며 수행하니까)
 *    -> 따라서 2라운드에서는 배열의 58번째 수 까지만 비교하면 된다.
 *
 *  버블 정렬의 단점 : 시간복잡도가 높다 - O(n^2)
 *  극복 방안 : 연산 횟수 줄이기 => 교환이 필요하지 않는 경우 정렬을 수행하지 않는다.
 *  조건 : 만약(if) == arr[j+1] > arr[j] 일 경우? -> 정렬을 수행하지 않는다. 비교 연산만 수행.
 *        만약(if) == arr[j+1] = arr[j] 일 경우? -> arr[j] > arr[j+1] 조건이 false가 되어 정렬을 수행하지 않는다.
 *  이 경우 시간복잡도는 O(n)이 된다.
 */
public class BubbleSort {

    public static void bubleSort(int[] arr) {
        int n = arr.length; // 배열 크기
        boolean swapped = false;

        for (int i = 1; i < n - 1; i++) { // 반복 횟수는 배열 크기 - 1
            swapped = false; // 매 반복시마다 swpped를 False로 초기화
            for (int j = 0; j < n - i; j++) {
                if (arr[j] > arr[j + 1]) { // 이 경우 교환이 이루어진다. -> C의 포인터 개념을 사용하여 스왑 함수를 만들수도 있음.
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true; // 교환이 발생하면 swapped를 true로 변경한다. -> 남은 배열 순회를 계속한다.
                }
            }
            if (!swapped) { // 교환이 이루어지지 않았으면 배열의 정렬이 끝난 상태이다.
                break;  // 정렬이 끝났으므로 다음 라운드 정렬
            }
        }
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print("[" + i +"]" + ":" + arr[i] + " ");
        }
        System.out.println();
        System.out.println();
    }

    public static void main(String[] args) {
        int arrSize = 30;
        int[] array = new int[arrSize];
        Random random = new Random();

        for (int i = 0; i < arrSize; i++) {
            array[i] = random.nextInt(50);
        }

        printArray(array); // 초기 배열 상태
        bubleSort(array); // 정렬 진행
        printArray(array); // 정렬 후 배열 상태

    }
}

