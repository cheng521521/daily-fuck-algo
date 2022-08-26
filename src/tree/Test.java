package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cpx
 * @Description 杨辉三角
 * @date 2022/8/17
 */
public class Test {
    private List<List<Integer>> listList = new ArrayList<>();


    public List<Integer> traverse(int n) {
        if (n == 1) {
            ArrayList<Integer> integers = new ArrayList<>();
            integers.add(1);
            listList.add(integers);
            return integers;
        }
        n = n - 1;
        List<Integer> integerList = traverse(n);
        List<Integer> result = new ArrayList<>();
        result.add(1);
        for (int i = 0; i < n; i++) {
            if (i == n - 1) {
                result.add(1);
            } else {
                result.add(integerList.get(i) + integerList.get(i + 1));
            }

        }
        listList.add(result);
        return result;
    }

    public static void main(String[] args) {
        Test test = new Test();
        List<Integer> traverse = test.traverse(3);
        for (List<Integer> integers : test.listList) {
            for (Integer integer : integers) {
                System.out.print(integer);
            }
            System.out.println();
        }
    }
}
