/**
 * Created by anandmishra on 02/08/17.
 */
public class ArrayRotation {

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7};

        int temp[] = new int[arr.length];

        int rotateBy = 5;
        int index = 0;
        for (int i = rotateBy; i < arr.length; i++) {
            temp[index] = arr[i];
            index++;
        }
        for (int i = 0; i < index; i++) {
            System.out.println(temp[i]);
        }
        System.out.println("break");
        for (int j = 0; j < rotateBy; j++) {
            temp[index] = arr[j];
            index++;
        }
        for (int i = 0; i < index; i++) {
            System.out.println(temp[i]);
        }
    }


    // 1 2 3 4 5 6 7
    // 3 4 5 6 7 1 2
}
