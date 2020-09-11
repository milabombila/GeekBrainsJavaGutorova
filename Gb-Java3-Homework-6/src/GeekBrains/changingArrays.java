package GeekBrains;

public class changingArrays {

    public static int[] refactorArray(int[] arr) {
        if(arr == null){
            throw new RuntimeException("Array cannot be null");
        }
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 4) {
                idx = i+1;
            }
        } if (idx==0){
                throw new RuntimeException("There is no number 4 in this array");
        }
        int[] array = new int[arr.length - (idx)];
        for (int i = 0, j = idx; j < arr.length; i++, j++) {
            array[i] = arr[j];
        }
        return array;
    }
    public static boolean arrayCheckForOneAndFour(int[] arr) {
        if(arr == null){
            throw new RuntimeException("Array cannot be null");
        }
        int countFor1 = 0;
        int countFor4 = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != 1 && arr[i] != 4){
                throw new RuntimeException("Array should contain only 1 or 4");
            }
            if (arr[i] == 1) {
                countFor1++;
            }
            if (arr[i] == 4) {
                countFor4++;
            }
        }
        if (countFor1 == 0 || countFor4 == 0) {
            return false;
        }
        return true;
    }
}
