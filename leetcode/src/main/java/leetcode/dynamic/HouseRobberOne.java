package leetcode.dynamic;

public class HouseRobberOne {
    //Cannot break houses next to each other
    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {

        int r1=0, r2 = 0; // {r1, r2, -------- }

        for(int i: nums) {
            int temp = Math.max(r1+i, r2);
            r1 = r2;
            r2 = temp;
        }
        return r2;
    }
}
