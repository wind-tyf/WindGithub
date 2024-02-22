package com.example.leetcodes.array;

import java.util.Arrays;

public class leetCode16_threeSumClosest {

    public static void main(String[] args) {
        int[] nums = {4,0,5,-5,3,3,0,-4,-5};
        int target = -2;
//        int[] nums = {0,3,97,102,200};
//        int target = 300;
//        int[] nums = {321,413,82,812,-646,-858,729,609,-339,483,-323,-399,-82,-455,18,661,890,-328,-311,520,-865,-174,55,685,-636,462,-172,-696,-296,-832,766,-808,-763,853,482,411,703,655,-793,-121,-726,105,-966,-471,612,551,-257,836,-94,-213,511,317,-293,279,-571,242,-519,386,-670,-806,-612,-433,-481,794,712,378,-325,-564,477,169,601,971,-300,-431,-152,285,-899,978,-419,708,536,-816,-335,284,384,-922,-941,633,934,497,-351,62,392,-493,-44,-400,646,-912,-864,835,713,-12,322,-228,340,-42,-307,-580,-802,-914,-142,575,-684,-415,718,-579,759,579,732,-645,525,114,-880,-603,-699,-101,-738,-887,327,192,747,-614,393,97,-569,160,782,-69,235,-598,-116,928,-805,-76,-521,671,417,600,-442,236,831,637,-562,613,-705,-158,-237,-299,808,-734,364,919,251,-163,-343,899};
//        int target = 2218;
        int ret = threeSumClosest(nums, target);
        System.out.println("ret:"+ret);
    }

    /**
     * 暴力解法-把所有的组合都找出来，取最小的那个
     * @param nums
     * @param target
     * @return
     */
    public static int threeSumClosest_old(int[] nums, int target) {
        if (3 == nums.length){
            return nums[0]+nums[1]+nums[2];
        }
        int ret = nums[0]+nums[1]+nums[2];
        int dif = ret > target ? Math.abs(ret - target) : Math.abs(target - ret);
        String retStr = "";
        for (int i = 0; i < nums.length-2; i++) {
            for (int j = i+1; j < nums.length-1; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    int t = nums[i]+nums[j]+nums[k];
                    int dt = t > target ? Math.abs(t - target) : Math.abs(target - t);
                    if (dt < dif){
                        ret = t;
                        retStr = nums[i]+","+nums[j]+","+nums[k];
                        dif = dt;
                    }
                }
            }
        }
        System.out.println("retStr:"+retStr);
        return ret;
    }


    /**
     * 优化解法(自建-有问题)
     * @param nums
     * @param target
     * @return
     */
    public static int threeSumClosest_myself_error(int[] nums, int target) {
        if (3 == nums.length){
            return nums[0]+nums[1]+nums[2];
        }
        // 1、先对数组进行排序
        for (int i = 0; i < nums.length-1; i++) {
            int t = i;
            for (int j = i+1; j < nums.length; j++) {
                if (nums[t] > nums[j]){
                    t = j;
                }
            }
            if (t != i){
                int temp = nums[i];
                nums[i] = nums[t];
                nums[t] = temp;
            }
        }
        // 2、首先，前三个最小值若大于target 或者 取后三个最大值小于target，则直接返回即可
        if (nums[0]+nums[1]+nums[2] >= target){
            return nums[0]+nums[1]+nums[2];
        }
        if (nums[nums.length-1]+nums[nums.length-2]+nums[nums.length-3] <= target){
            return nums[nums.length-1]+nums[nums.length-2]+nums[nums.length-3];
        }
        // 3、剩下的情况就是target在数组的「组合和」范围内容中，这时需要找出符合条件的组合
            // 从头开始取第一个小于target的标志值，然后把之后的数据通过双指针形式来一头一尾地找出符合条件的数据(当出现一大一小时，结束)
        int ret = nums[0]+nums[1]+nums[2];
        for (int i = 0; i < nums.length-2 && nums[i] < target; i++) {
            // 声明双指针的头尾
            int s = (i+1 + nums.length-1)/2;
            int e = s+1;
            if (nums[i]+nums[i+1]+nums[i+2] >= target){
                // 后续的最小值都比target大，则直接取后续最小值
                int diff1 = ret > target ? ret-target : target -ret;
                int retOne = nums[i]+nums[i+1]+nums[i+2];
                int diff2 = retOne > target ? retOne-target : target-retOne;
                if (diff1 > diff2){
                    ret = retOne;
                }
                continue;
            }
            if (nums[i]+nums[nums.length-1]+nums[nums.length-2] <= target){
                // 后续的最大值都比target小，则直接取后续最大值
                int diff1 = ret > target ? ret-target : target -ret;
                int retOne = nums[i]+nums[e]+nums[e-1];
                int diff2 = retOne > target ? retOne-target : target-retOne;
                if (diff1 > diff2){
                    ret = retOne;
                }
                continue;
            }
            while (s > i && e < nums.length){
                int p = nums[i]+nums[s]+nums[e];
                if (p > target){
                    // 头指针往前移
                    s--;
                    if (s == i){
                        break;
                    }
                    if (nums[i]+nums[s]+nums[e] == target){
                        return nums[i]+nums[s]+nums[e];
                    }
                    if (nums[i]+nums[s]+nums[e] < target){
                        // 找到临界点,对比并退出
                        // 临界点: 上一个数比target大，但下一个数比target小
                        int diff1 = p-target;
                        int diff2 = nums[i]+nums[s]+nums[e] - target;
                        int retOne = diff1 > diff2 ? nums[i]+nums[s]+nums[e] : p;
                        // 对比整个流程中的最小差值与当前最小差值
                        int diffa = ret > target ? ret-target : target -ret;
                        int diffb = retOne > target ? retOne-target : target-retOne;
                        if (diffa > diffb){
                            ret = retOne;
                        }
                        break;
                    }
                }else if (p < target){
                    // 尾指针往后移
                    e++;
                    if (e == nums.length){
                        break;
                    }
                    if (nums[i]+nums[s]+nums[e] == target){
                        return nums[i]+nums[s]+nums[e];
                    }
                    if (nums[i]+nums[s]+nums[e] > target){
                        // 找到临界点,对比并退出
                        // 临界点: 上一个数比target小，但下一个数比target大
                        int diff1 = p-target;
                        int diff2 = nums[i]+nums[s]+nums[e] - target;
                        int retOne = diff1 > diff2 ? nums[i]+nums[s]+nums[e] : p;
                        // 对比整个流程中的最小差值与当前最小差值
                        int diffa = ret > target ? ret-target : target -ret;
                        int diffb = retOne > target ? retOne-target : target-retOne;
                        if (diffa > diffb){
                            ret = retOne;
                        }
                        break;
                    }
                }else {
                    // 找到相等的直接返回
                    return p;
                }
            }
            // 若以s>=e的形式退出循环，则说明没有临界值，全部大于或小于target【该判断往前移动，提高效率】
            // eg: target=3, nums=[1,2,4,5,6]; target=11, nums=[1,2,3,4,5]
        }
        return ret;
    }

    public static int threeSumClosest(int[] nums, int target){
        if (3 == nums.length){
            return nums[0]+nums[1]+nums[2];
        }

        // 1、先对数组进行排序
        Arrays.sort(nums);
//        for (int i = 0; i < nums.length-1; i++) {
//            int t = i;
//            for (int j = i+1; j < nums.length; j++) {
//                if (nums[t] > nums[j]){
//                    t = j;
//                }
//            }
//            if (t != i){
//                int temp = nums[i];
//                nums[i] = nums[t];
//                nums[t] = temp;
//            }
//        }
        // 2、首先，前三个最小值若大于target 或者 取后三个最大值小于target，则直接返回即可
        if (nums[0]+nums[1]+nums[2] >= target){
            return nums[0]+nums[1]+nums[2];
        }
        if (nums[nums.length-1]+nums[nums.length-2]+nums[nums.length-3] <= target){
            return nums[nums.length-1]+nums[nums.length-2]+nums[nums.length-3];
        }

        int ret = nums[0]+nums[1]+nums[2];
        for (int i = 0; i < nums.length-2; i++) {
            int s = i+1;
            int e = nums.length-1;
            while (s < e){
                int sum = nums[i]+nums[s]+nums[e];
                if (sum == target){
                    return sum;
                }
                if (Math.abs(ret-target) > Math.abs(sum-target)){
                    ret = sum;
                }
                if (sum > target){
                    e--;
                }else{
                    s++;
                }
            }
        }
        return ret;
    }
}
