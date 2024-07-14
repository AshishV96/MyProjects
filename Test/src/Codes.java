import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class Codes {

    public static void swapZeros(int[] nums)  // 1,2,3,0,0,4,0,5,6,7,8,0,9,0
    {

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != 0) continue;

            boolean flag = true;

            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] != 0) {
                    nums[i] = nums[j];
                    nums[j] = 0;
                    flag = false;
                    break;
                }
            }

            if (flag)
                break;

        }
    }

    public static int removeDuplicates(int[] nums) {

//        int[] uniques = new int[nums.length];
        int count = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                nums[count++] = nums[i];

                if (i + 1 == nums.length - 1)
                    nums[count++] = nums[i + 1];
            }
        }
//        nums = uniques;

        return count;
    }

    public static int removeDuplicate(int[] nums) {
        int i = 0;
        int count = 0;
        while(i<nums.length-1)
        {
            int j = i+1;
            while(j<nums.length)
            {
                if(nums[i]==nums[j])
                {
                    count++;
                    int k = j;
                    while(k<nums.length-1)
                    {
                        nums[k] = nums[k+1];
                        k++;
                    }
                    j--;
                }
                j++;
            }
            i++;
        }
        return count;
    }

    public static void main(String[] args) {

        removeDuplicate(new int[] {0,0,1,1,1,2,2,3,3,4});

        merge(new int[]{1,2,3,0,0,0},3,new int[]{2,5,6},3);

        int[] nums = {20, 99, 2, 8, 55};  // 99855201

        int[] sorted = new int[nums.length];

        String indexList = "";

        for (int i = 0; i < sorted.length; i++) {
            int maxFirst = 0;
            int index = 0;
            for (int j = 0; j < nums.length; j++) {

                if (indexList.contains(String.valueOf(j)))
                    continue;

                if (nums[j] / 10 == 0 && maxFirst / 10 == 0) {
                    maxFirst = maxFirst * 10 + nums[j] > nums[j] * 10 + maxFirst ? maxFirst : nums[j];
                    index = maxFirst == nums[j] ? j : index;
                } else if (nums[j] / 10 == 0 && maxFirst / 10 != 0) {
                    maxFirst = maxFirst * 10 + nums[j] > nums[j] * 100 + maxFirst ? maxFirst : nums[j];
                    index = maxFirst == nums[j] ? j : index;
                } else if (nums[j] / 10 != 0 && maxFirst / 10 == 0) {
                    maxFirst = maxFirst * 100 + nums[j] > nums[j] * 10 + maxFirst ? maxFirst : nums[j];
                    index = maxFirst == nums[j] ? j : index;
                } else {
                    maxFirst = maxFirst * 100 + nums[j] > nums[j] * 100 + maxFirst ? maxFirst : nums[j];
                    index = maxFirst == nums[j] ? j : index;
                }
            }
            indexList += index;
            sorted[i] = maxFirst;
        }

        Arrays.stream(sorted).forEach(System.out::println);

//        int[] arr = new int[] {1,2,3,0,0,4,0,5,6,7,8,0,9,0};
//        swapZeros(arr);

//        Arrays.stream(arr).forEach(System.out::println);
//        System.out.println(indexFirst);

//        int maxLast = indexFirst==0?nums[1]:nums[0];
//        int indexLast = indexFirst==0?1:0;
//
//        for(int i=indexLast==1?2:1;i<nums.length;i++)
//        {
//            if(i==indexFirst)
//                continue;
//
//            if(nums[i]/10==0&&maxLast/10==0) {
//                maxLast = maxLast * 10 + nums[i] > nums[i] * 10 + maxLast ? maxLast : nums[i];
//                indexLast = maxLast == nums[i]?i:indexLast;
//            }
//
//            else if(nums[i]/10==0&&maxLast/10!=0) {
//                maxLast = maxLast * 10 + nums[i] > nums[i] * 100 + maxLast ? maxLast : nums[i];
//                indexLast = maxLast == nums[i]?i:indexLast;
//            }
//
//            else if(nums[i]/10!=0&&maxLast/10==0) {
//                maxLast = maxLast * 100 + nums[i] > nums[i] * 10 + maxLast ? maxLast : nums[i];
//                indexLast = maxLast == nums[i] ? i : indexLast;
//            }
//
//            else {
//                maxLast = maxLast * 100 + nums[i] > nums[i] * 100 + maxLast ? maxLast : nums[i];
//                indexLast = maxLast == nums[i] ? i : indexLast;
//            }
//        }
//
//        sorted[sorted.length-1] = maxLast;
//        System.out.println(maxLast+" "+indexLast);


//        Optional<String> opt = Optional.ofNullable(null);
//        System.out.println(opt.orElse("no"));

//        Map samplemap = new TreeMap();
//        samplemap.put(5,null);
//        samplemap.put(3,null);
//        samplemap.put(1,null);
//        samplemap.put(4,null);
//        samplemap.put(2,null);

//        System.out.println(samplemap);

//        int nums[] = {1,1,2,2,3,3,5};

//        System.out.println(removeDuplicates(nums));
//        Arrays.stream(nums).forEach(System.out::println);

    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < nums2.length; i++) {
            for (int j = 0; j < nums1.length; j++) {
                if (nums2[i] < nums1[j] || nums1[j] == 0) {
                    rightShift(nums1, j);
                    nums1[j] = nums2[i];
                    break;
                }
            }
        }
    }

    public static void rightShift(int[] nums, int m) {
        for (int i = nums.length - 1; i > m; i--) {
            nums[i] = nums[i - 1];
        }
    }

    public static void downShift(int[] nums, int m) {
        for (int i = nums.length - 1; i > m; i--) {
            nums[i] = nums[i - 1];
        }
    }

}
