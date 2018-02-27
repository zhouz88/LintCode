/*
302. Smallest Rectangle Enclosing Black Pixels
DescriptionHintsSubmissionsDiscussSolution
Pick One
An image is represented by a binary matrix with 0 as a white pixel and 1 as a black pixel. The black pixels are connected, i.e., there is only one black region. Pixels are connected horizontally and vertically. Given the location (x, y) of one of the black pixels, return the area of the smallest (axis-aligned) rectangle that encloses all black pixels.

For example, given the following image:

[
  "0010",
  "0110",
  "0100"
]
and x = 0, y = 2,
Return 6.
*/

class Solution {
    public int minArea(char[][] image, int x, int y) {
        int l = 0, r = x;
        while (l <= r) {
            int mid = ((r - l) >> 1) + l;
            if (checkRow(image, mid)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        int startX = l;

        l = x;
        r = image.length - 1;

        while (l <= r) {
            int mid = ((r - l) >> 1) + l;
            if (checkRow(image, mid)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        int endX = r;

        l = 0;
        r = y;
        while (l <= r) {
            int mid = ((r - l) >> 1) + l;
            if (checkCol(image, mid)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        int startY = l;

        l = y;
        r = image[0].length - 1;
        while (l <= r) {
            int mid = ((r - l) >> 1) + l;
            if (checkCol(image, mid)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        int endY = r;
        return (endX - startX + 1) * (endY - startY + 1);//bug 1
    }

    private boolean checkRow(char[][] image, int mid) {
        for (int i  =0; i < image[0].length; i++) {
            if (image[mid][i] == '1') {
                return true;
            }
        }
        return false;
    }

    private boolean checkCol(char[][] image, int mid) {
        for (int i  =0; i < image.length; i++) {
            if (image[i][mid] == '1') {
                return true;
            }
        }
        return false;
    }
}
