
```java
public class TowerOfHanoi {
    public static void towerOfHanoi(int n, char source, char destination, char auxiliary) {
        // base case: if there is only one disk, move it from source to destination
        if (n == 1) {
            System.out.println("Move disk 1 from " + source + " to " + destination);
            return;
        }
        
        // move n-1 disks from source to auxiliary using destination as the auxiliary peg
        towerOfHanoi(n - 1, source, auxiliary, destination);
        
        // move the nth disk from source to destination
        System.out.println("Move disk " + n + " from " + source + " to " + destination);
        
        // move the n-1 disks from auxiliary to destination using source as the auxiliary peg
        towerOfHanoi(n - 1, auxiliary, destination, source);
    }

    public static void main(String[] args) {
        int numberOfDisks = 3;
        char sourcePeg = 'A';
        char destinationPeg = 'C';
        char auxiliaryPeg = 'B';
        
        towerOfHanoi(numberOfDisks, sourcePeg, destinationPeg, auxiliaryPeg);
    }
}
```

In this code, the `towerOfHanoi` function takes the number of disks `n`, the source peg, the destination peg, and the auxiliary peg as input and solves the Tower of Hanoi puzzle using recursion.

The function first checks if there is only one disk (base case), in which case it moves the disk from the source peg to the destination peg. Otherwise, it recursively calls itself with `n-1` disks, moving them from the source peg to the auxiliary peg using the destination peg as the auxiliary peg. Then, it moves the `n`th disk from the source peg to the destination peg. Finally, it recursively calls itself again with `n-1` disks, moving them from the auxiliary peg to the destination peg using the source peg as the auxiliary peg.

The `main` function demonstrates the usage of the `towerOfHanoi` function by solving the Tower of Hanoi puzzle for 3 disks, with the source peg 'A', destination peg 'C', and auxiliary peg 'B'.
