import java.util.Scanner;

public class arrays {
    public static void main(String[] args) {
        System.out.println("Bài tập mảng 2 chiều");
        //int [][] b = inputArrays();
        int[][] a = generateMatrix(8, 8, 0, 99);
        //Bài 1: ------------------------------------------------------
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập vào số X để kiểm tra trong mảng: ");
        int x = input.nextInt();
        System.out.println("Mảng random: ");
        printMatrix(a);
        System.out.println("==============");
        if (findX(a, x)) {
            System.out.println("Có số " + x + " trong mảng");
        } else {
            System.out.println("Không có số " + x + " trong mảng , vui lòng thử lại");
        }
        //Bài 2: ----------------------------------------------------
        System.out.println("Mảng random: ");
        printMatrix(a);
        System.out.println("==============");
        if (checkSNTinArrays(a)) {
            System.out.println("Mảng toàn số nguyên tố");
        } else {
            System.out.println("Mảng không phải toàn snt");
        }
        // Bài 3 : ----------------------------------------
        System.out.println("Mảng random: ");
        printMatrix(a);
        System.out.println("==============");
        int numberMax = findMax(a);
        System.out.println("Số lớn nhất trong mảng là: " + numberMax);
        // Bài 4 : ----------------------------------------
        System.out.println("Nhập vào số dòng muốn tính tổng: ");
        int x1 = input.nextInt();
        System.out.println("Nhập vào số cột muốn tính tổng: ");
        int y = input.nextInt();
        System.out.println("Mảng random: ");
        printMatrix(a);
        System.out.println("==============");
        int sumD = sumRowD(a, x1);
        int sumC = sumColC(a, y);
        System.out.println("Tổng các phần tử trên dòng d là: " + sumD);
        System.out.println("Tổng các phần tử trên cột d là: " + sumC);
    }

    public static int[][] inputArrays() {
        int[][] a;
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập vào số dòng: ");
        String row = input.nextLine();
        int n = Integer.parseInt(row);
        System.out.println("Nhập vào số cột: ");
        String col = input.nextLine();
        int m = Integer.parseInt(col);

        a = new int[n][m];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.format("a[%d][%d]=", i, j);
                a[i][j] = input.nextInt();
            }

        }
        return a;
    }

    public static void printMatrix(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.format("%d ", a[i][j]);
            }
            System.out.println();
        }
    }

    public static int[][] generateMatrix(int r, int c, int min, int max) {
        int[][] a = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                a[i][j] = (int) Math.floor(Math.random() * (max - min));
            }
        }
        return a;
    }

    public static boolean findX(int[][] a, int x) {
        boolean check = false;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (x == a[i][j]) {
                    check = true;
                    break;
                }
            }
        }
        return check;
    }

    public static boolean checkSNT(int n) {
        boolean check = false;
        for (int i = 0; i < n / 2; i++) {
            if (n % i == 0) {
                check = true;
                break;
            }
        }
        return check;
    }

    public static boolean checkSNTinArrays(int[][] a) {
        boolean check = true;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (!checkSNT(a[i][j])) {
                    check = false;
                    break;
                }
            }
        }
        return check;
    }

    public static int findMax(int[][] a) {
        int max = a[0][0];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j] > max) {
                    max = a[i][j];
                }
            }
        }
        return max;
    }

    public static int sumRowD(int[][] a, int x) {
        int sum = 0;
        for (int j = 0; j < a[0].length; j++) {
            sum += a[x - 1][j];
        }
        return sum;
    }

    public static int sumColC(int[][] a, int x) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i][x - 1];
        }
        return sum;
    }
}
