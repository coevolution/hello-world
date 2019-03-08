package longestsubstringwithoutrepeat;

public class TryToPrintEnglishAlphabetsWithStars {
    public static void main(String[] args) {

        int n = 9;
        //letter A
        for (int rows = 0; rows < n; rows++) {
            for (int cols = 0; cols <= n / 2; cols++) {
                if (rows == 0 && cols != 0 && cols != n / 2 || rows == n / 2
                    || cols == 0 && rows != 0 || cols == n / 2 && rows != 0) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        System.out.println();


        //letter B
        for (int rows = 0; rows < n; rows++) {
            for (int cols = 0; cols <= n / 2; cols++) {
                if (rows == 0 && cols != n / 2 || rows == n / 2 && cols != n / 2
                    || rows == n - 1 && cols != n / 2 || cols == 0
                    || cols == n / 2 && rows != 0 && rows != n / 2 && rows != n - 1) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        System.out.println("                       ");


        //letter C
        for (int rows = 0; rows < n; rows++) {
            for (int cols = 0; cols < n; cols++) {
                if (rows == 0 && cols != 0 || rows == n - 1 && cols != 0
                    || cols == 0 && rows != 0 && rows != n - 1) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        System.out.println();


        // letter D
        for (int rows = 0; rows < n; rows++) {
            for (int cols = 0; cols < n; cols++) {
                if (rows == 0 && cols != n - 1 && cols != n - 2
                    || rows == n - 1 && cols != n - 1 && rows != n / 4 && cols != n - 2 || cols == 0
                    || cols == n - 1 && rows != 0 && rows != n - 1) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        System.out.println();

        //letter E
        for (int rows = 0; rows < n; rows++) {
            for (int cols = 0; cols < n; cols++) {
                if (rows == 0 || rows == n / 2 && cols <= n / 2 || rows == n - 1 || cols == 0) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }

            }
            System.out.println();
        }
        System.out.println();


        //letter F
        for (int rows = 0; rows < n; rows++) {
            for (int cols = 0; cols < n; cols++) {
                if (rows == 0 || rows == n / 2 && cols <= n / 2 || cols == 0) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        System.out.println("                   ");


        //Letter G
        for (int rows = 0; rows < n; rows++) {
            for (int cols = 0; cols < n; cols++) {
                if (rows == 0 && cols != 0 || rows == n - 1 && cols != 0
                    || cols == 0 && rows != n - 1 && rows != 0
                    || cols == n - 1 && rows != 0 && rows >= n / 2
                    || rows == n / 2 && cols >= n / 2) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

        System.out.println();


        //letter H
        for (int rows = 0; rows < n; rows++) {
            for (int cols = 0; cols < n; cols++) {
                if (rows == n / 2 || cols == 0 || cols == n - 1) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        System.out.println();


        //letter I
        for (int rows = 0; rows < n; rows++) {
            for (int cols = 0; cols < n; cols++) {
                if (rows == 0 || rows == n - 1 || cols == n / 2) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        System.out.println();

        //letter J //try to edit
        for (int rows = 0; rows < n; rows++) {
            for (int cols = 0; cols < n; cols++) {
                if (rows == 0 || cols == n / 2 && rows != n - 1
                    || rows == n - 1 && cols <= n / 2 && cols != n / 2) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        System.out.println();


        //letter K
        for (int rows = 0; rows < n; rows++) {
            for (int cols = 0; cols < n; cols++) {
                if (cols == 0 || rows + cols == n / 2 || rows - cols == n / 2) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        System.out.println();


        //Letter L
        for (int rows = 0; rows < n; rows++) {
            for (int cols = 0; cols < n; cols++) {
                if (rows == n - 1 || cols == 0) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        System.out.println();


        //Letter M
        for (int rows = 0; rows < n; rows++) {
            for (int cols = 0; cols < n; cols++) {
                if (cols == 0 || cols == n - 1 || rows == cols && rows <= n / 2
                    || rows + cols == n - 1 && rows <= n / 2) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        System.out.println();


        //letter N
        for (int rows = 0; rows < n; rows++) {
            for (int cols = 0; cols < n; cols++) {
                if (cols == 0 || cols == n - 1 || rows == cols) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        System.out.println();


        //letter O
        for (int rows = 0; rows < n; rows++) {
            for (int cols = 0; cols < n; cols++) {
                if (cols == 0 && rows != n - 1 && rows != 0
                    || cols == n - 1 && rows != 0 && rows != n - 1
                    || rows == 0 && cols != 0 && cols != n - 1
                    || rows == n - 1 && cols != 0 && cols != n - 1) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        System.out.println();


        //letter P
        for (int rows = 0; rows < n; rows++) {
            for (int cols = 0; cols < n; cols++) {
                if (cols == 0 || cols == n - 1 && rows < n / 2 || rows == n / 2 || rows == 0) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        System.out.println();


        //Letter Q
        for (int rows = 0; rows <= n / 2; rows++) {
            for (int cols = 0; cols <= n / 2; cols++) {
                if (cols == 0 && rows != 0 && rows != n / 2 || cols == n / 2 && rows != 0
                    || rows == n / 2 && cols != 0 || rows == 0 && cols != 0 && cols != n / 2
                    || rows + cols == n - 1 || rows == cols && rows >= n / 4) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        System.out.println();


        //Letter R
        for (int rows = 0; rows < n; rows++) {
            for (int cols = 0; cols < n; cols++) {
                if (cols == 0 || cols == n - 1 && rows < n / 2 && rows != n / 2 && rows != 0
                    || rows == n / 2 && cols != n - 1 || rows == 0 && cols != n - 1
                    || rows == cols && rows >= n / 2) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        System.out.println();


        //letter S
        for (int rows = 0; rows < n; rows++) {
            for (int cols = 0; cols < n; cols++) {
                if (cols == 0 && rows < n / 2 && rows != 0 && rows != n / 2
                    || cols == n - 1 && rows > n / 2 && rows != n / 2 && rows != n - 1
                    || rows == 0 && cols != 0 || rows == n / 2 && cols != n - 1 && cols != 0
                    || rows == n - 1 && cols != n - 1) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        System.out.println();


        //letter T
        for (int rows = 0; rows < n; rows++) {
            for (int cols = 0; cols < n; cols++) {
                if (cols == n / 2 || rows == 0) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        System.out.println();


        //letter U
        for (int rows = 0; rows < n; rows++) {
            for (int cols = 0; cols < n; cols++) {
                if (cols == 0 && rows != n - 1 || rows == n - 1 && cols != 0 && cols != n - 1
                    || cols == n - 1 && rows != n - 1) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        System.out.println();


        //Letter V
        for (int rows = 0; rows <= n / 2; rows++) {
            for (int cols = 0; cols < n; cols++) {
                if (cols == rows || cols + rows == n - 1) {
                    System.out.print("* ");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }


        //letter W
        for (int rows = 0; rows < n; rows++) {
            for (int cols = 0; cols < n; cols++) {
                if (cols == 0 || cols == n - 1 || cols == rows && cols >= n / 2
                    || cols + rows == n - 1 && cols < n / 2) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        System.out.println();


        //Letter X
        for (int rows = 0; rows < n; rows++) {
            for (int cols = 0; cols < n; cols++) {
                if (cols == rows || cols + rows == n - 1) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        System.out.println();


        //letter Y
        for (int rows = 0; rows < n; rows++) {
            for (int cols = 0; cols < n; cols++) {
                if (cols == rows && rows < n / 2 || cols + rows == n - 1 && rows < n / 2
                    || cols == n / 2 && rows >= n / 2) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        System.out.println();


        //letter Z
        for (int rows = 0; rows < n; rows++) {
            for (int cols = 0; cols < n; cols++) {
                if (cols + rows == n - 1 || rows == 0 || rows == n - 1) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        System.out.println();


        System.out.println("__________________Thankyou________________________");
    }
}
