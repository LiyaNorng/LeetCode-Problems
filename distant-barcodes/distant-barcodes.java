class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        //Arrays.sort(barcodes);
        int length = barcodes.length;
        HashMap<Integer, Integer> hash = new HashMap<>();
        
        int [] res = new int [length];
        
        for (int i : barcodes){
            hash.put(i, hash.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> hash.get(b) - hash.get(a));
        heap.addAll(hash.keySet());
        int i = 0;
        for (i = 0; i < length; i += 2){
            res[i] = heap.peek();
            hash.put(heap.peek(), hash.get(heap.peek()) - 1);
            if (hash.get(heap.peek()) == 0){
                hash.remove(heap.poll());
                break;
            }
        }
        i += 2;
        int temp = 0;
        while(!hash.isEmpty()){
            if (i >= length){
                i = 1;
            }
            temp = heap.peek();
            res[i] = temp;
            hash.put(temp, hash.get(temp) - 1);
            if (hash.get(temp) == 0){
                hash.remove(temp);
                heap.poll();
            }
            i += 2; 
        }
        return res;
        
        
    }
}