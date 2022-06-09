public class Function1 {
    public static void main(String[] args) {
        System.out.println("Function testing:");
        System.out.printf("Test 1 %s.\n", ClassForTest.compareResults(findMax(new int[]{3, 4, 10, -1}), 10) ? "passed" : "failed");

        try {
            findMax(new int[0]);
            System.out.println("Test 2: failed.");
        } catch (RuntimeException e) {
            System.out.println("Test 2: passed.");
        }
    }

    // реализовать функцию, которая будет находить максимум в массиве
    // обработать случай, когда длина массива равна нулю
    // в этом случае выбрасывать исключение
    private static int findMax(int[] arr) {
        int max_num = -1000000;
        if (arr.length == 0){
            throw new NullPointerException("Длина массива равна нулю");
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (max_num < arr[i]){
                    max_num = arr[i];
                }
            }
        }
        return max_num;
    }
}
