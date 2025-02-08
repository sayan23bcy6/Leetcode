import java.util.*;

class NumberContainers {
    private Map<Integer, Integer> indexToNumber;
    private Map<Integer, TreeSet<Integer>> numberToIndices;
    
    public NumberContainers() {
        indexToNumber = new HashMap<>();
        numberToIndices = new HashMap<>();
    }
    
    public void change(int index, int number) {
        if (indexToNumber.containsKey(index)) {
            int oldNumber = indexToNumber.get(index);
            if (oldNumber == number) return;
            numberToIndices.get(oldNumber).remove(index);
            if (numberToIndices.get(oldNumber).isEmpty()) {
                numberToIndices.remove(oldNumber);
            }
        }
        indexToNumber.put(index, number);
        numberToIndices.putIfAbsent(number, new TreeSet<>());
        numberToIndices.get(number).add(index);
    }
    
    public int find(int number) {
        return numberToIndices.containsKey(number) && !numberToIndices.get(number).isEmpty()
                ? numberToIndices.get(number).first()
                : -1;
    }
}
