
// задача 1
class Solution {
    public String mergeAlternately(String word1, String word2) {
        final int n = Math.min(word1.length(), word2.length());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; ++i) {
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
        }

        return sb.append(word1.substring(n)).append(word2.substring(n)).toString();
    }
}

// задача 2
class Solution {
    public int removeElement(int[] nums, int val) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            // If the element is not val
            if (nums[i] != val) {
                nums[count++] = nums[i];
            }
        }
        return count;
    }
}

// задача 3
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (j >= 0)
            if (i >= 0 && nums1[i] > nums2[j])
                nums1[k--] = nums1[i--];
            else
                nums1[k--] = nums2[j--];
    }
}

// задача 4
class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder(s).reverse();
        reverseWords(sb, sb.length());
        return cleanSpaces(sb, sb.length());
    }

    private void reverseWords(StringBuilder sb, int n) {
        int i = 0;
        int j = 0;

        while (i < n) {
            while (i < j || i < n && sb.charAt(i) == ' ')
                ++i;
            while (j < i || j < n && sb.charAt(j) != ' ')
                ++j;
            reverse(sb, i, j - 1); // Reverse the word
        }
    }

    private String cleanSpaces(StringBuilder sb, int n) {
        int i = 0;
        int j = 0;

        while (j < n) {
            while (j < n && sb.charAt(j) == ' ')
                ++j;
            while (j < n && sb.charAt(j) != ' ')
                sb.setCharAt(i++, sb.charAt(j++));
            while (j < n && sb.charAt(j) == ' ')
                ++j;
            if (j < n)
                sb.setCharAt(i++, ' ');
        }

        return sb.substring(0, i).toString();
    }

    private void reverse(StringBuilder sb, int l, int r) {
        while (l < r) {
            final char temp = sb.charAt(l);
            sb.setCharAt(l++, sb.charAt(r));
            sb.setCharAt(r--, temp);
        }
    }
}
// Задача 5
class Solution {
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;

        while (l < r) {
            while (l < r && !Character.isLetterOrDigit(s.charAt(l)))
                ++l;
            while (l < r && !Character.isLetterOrDigit(s.charAt(r)))
                --r;
            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r)))
                return false;
            ++l;
            --r;
        }

        return true;
    }
}