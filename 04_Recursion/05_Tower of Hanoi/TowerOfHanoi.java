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
