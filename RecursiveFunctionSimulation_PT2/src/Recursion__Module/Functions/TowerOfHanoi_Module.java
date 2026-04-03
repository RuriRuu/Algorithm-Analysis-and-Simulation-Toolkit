package Recursion__Module.Functions;

public class TowerOfHanoi_Module {
    public static void towerOfHanoi(int n, char from, char to, char target) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + from + " to " + to);
            return;
        }
        towerOfHanoi(n - 1, from, target, to);
        System.out.println("Move disk " + n + " from " + from + " to " + to);
        towerOfHanoi(n - 1, target, to, from);
    }
}
