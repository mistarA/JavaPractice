package testExamples

import java.util.*


fun main1(args: Array<String>) {

    val arr = arrayOf(1, 2, 3, 4, 5, 6)
    for (i in arr.indices) {
        var count = 0;
        for (j in 1..arr.lastIndex) {
            if (arr[j] != arr[i]) {
                if (arr[j] > arr[i]) {
                    count++;
                }
            }
        }
        if (count == arr[i]) {
            System.out.print(arr[i]);
            break;
        }
    }
}

fun main(args: Array<String>) {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. */

    val scanner = Scanner(System.`in`)

    var input = "aabcddcb"
    var output = ""
    var i = 1
    while (i < input.length) {
        if (input[i] == input[i - 1]) {
            input = input.substring(0, i - 1) + input.substring(i + 1)
            System.out.println(input)
            i = 0
        }
        System.out.println(input)
        i++
    }

    if (input.length == 0) {
        println("Empty String")
    } else {
        println(input)
    }
    System.out.print(input)

}

