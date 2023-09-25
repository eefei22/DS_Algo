// Given an array of integers, return indices of the two numbers such that they add up to a specific target.
// You may assume that each input would have exactly one solution, and you may not use the same element twice.
// Example:
// Given nums = [2, 7, 11, 15], target = 9,
// Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].

class twoSums{
    public static void main (String[] args){
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        int[] resultArr = new int[2];
        resultArr = findSums(numbers, target);

        System.out.print("Results: ");
        for (int i=0; i<2; i++){
            System.out.print(resultArr[i] + " ");
        }
        System.out.println("\n");        
    }

    public static int[] findSums(int[] numbers, int target){
        int[] indexArr = {0, 0};
        for (int i = 0; i<numbers.length; i ++){
            for (int j = 1; j<numbers.length-1; j++){
                if (i!=j){
                    if (numbers[i] + numbers[j] == target){
                        indexArr[0] = i;
                        indexArr[1] = j;
                    }
                }
                
            }
        }
        return indexArr;
    }
}

