import java.io.*;
import java.util.ArrayList;

public class Main {
    static class CctvPoint {
        int r;
        int c;
        int type;

        CctvPoint(int r, int c, int type) {
            this.r = r;
            this.c = c;
            this.type = type;
        }
    }
    static int N, M;
    static int answer = Integer.MAX_VALUE;
    static ArrayList<CctvPoint> cctvPoints = new ArrayList<>();
    static int[] rotateCounts = {0, 4, 2, 4, 4, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        int[][] map = new int[N][M];
        int cctvIdx = 0;
        int cctv5Idx = 0;

        int[][] type5Cctv = new int[10][2];

        for (int i = 0; i < N; i++) {
            String[] splitLine = br.readLine().split(" ");
            for (int j = 0; j < splitLine.length; j++) {
                int type = Integer.parseInt(splitLine[j]);
                map[i][j] = type;

                if (type >= 1 && type <= 5) {
                    cctvPoints.add(new CctvPoint(i, j, type));
                }
            }
        }

        for (CctvPoint p : cctvPoints) {
            if (p.type == 5) {
                fillRow(map, p.r, p.c);
                fillCol(map, p.r, p.c);
            }
        }

        cctvPoints.removeIf(p -> p.type == 5);

        dfs(map, 0);

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }

    public static void dfs(int[][] map, int cctvIdx) {
        if (answer == 0) {
            return;
        }

        if (cctvIdx == cctvPoints.size()) {
            int invisibleCount = checkInvisibleCount(map);
            if (invisibleCount < answer) {
                answer = invisibleCount;
            }
            return;
        }

        int cctvRow = cctvPoints.get(cctvIdx).r;
        int cctvCol = cctvPoints.get(cctvIdx).c;
        int cctvType = cctvPoints.get(cctvIdx).type;

        int[][] originalMap = deepCopy(map);

        for (int rotate = 0; rotate < rotateCounts[cctvType]; rotate++) {
            fillMap(map, cctvRow, cctvCol, cctvType, rotate);
            dfs(map, cctvIdx + 1);
            map = deepCopy(originalMap);
        }
    }

    public static void fillMap(int[][] map, int row, int col, int type, int rotate) {
        switch (type) {
            case 1:
                if (rotate == 0) {
                    fillRowRight(map, row, col);
                } else if (rotate == 1) {
                    fillColDown(map, row, col);
                } else if (rotate == 2) {
                    fillRowLeft(map, row, col);
                } else if (rotate == 3) {
                    fillColUp(map, row, col);
                }
                break;
            case 2:
                if (rotate == 0) {
                    fillRow(map, row, col);
                } else if (rotate == 1) {
                    fillCol(map, row, col);
                }
                break;
            case 3:
                if (rotate == 0) {
                    fillColUp(map, row, col);
                    fillRowRight(map, row, col);
                } else if (rotate == 1) {
                    fillRowRight(map, row, col);
                    fillColDown(map, row, col);
                } else if (rotate == 2) {
                    fillColDown(map, row, col);
                    fillRowLeft(map, row, col);
                } else if (rotate == 3) {
                    fillRowLeft(map, row, col);
                    fillColUp(map, row, col);
                }
                break;
            case 4:
                if (rotate == 0) {
                    fillRow(map, row, col);
                    fillColUp(map, row, col);
                } else if (rotate == 1) {
                    fillCol(map, row, col);
                    fillRowRight(map, row, col);
                } else if (rotate == 2) {
                    fillRow(map, row, col);
                    fillColDown(map, row, col);
                } else if (rotate == 3) {
                    fillCol(map, row, col);
                    fillRowLeft(map, row, col);
                }
                break;
            case 5:
                fillCol(map, row, col);
                fillRow(map, row, col);
                break;
            default:
                throw new IllegalArgumentException("Invalid type");
        }
    }

    public static void fillRow(int[][] map, int row, int col) {
        fillRowLeft(map, row, col);
        fillRowRight(map, row, col);
    }

    public static void fillCol(int[][] map, int row, int col) {
        fillColDown(map, row, col);
        fillColUp(map, row, col);
    }

    public static void fillRowLeft(int[][] map, int row, int col) {
        for (int i = col - 1; i >= 0; i--) {
            if (map[row][i] == 6) {
                break;
            }
            if (map[row][i] == 0) {
                map[row][i] = -1;
            }
        }
    }

    public static void fillRowRight(int[][] map, int row, int col) {
        for (int i = col + 1; i < M; i++) {
            if (map[row][i] == 6) {
                break;
            }
            if (map[row][i] == 0) {
                map[row][i] = -1;
            }
        }
    }

    public static void fillColUp(int[][] map, int row, int col) {
        for (int i = row - 1; i >= 0; i--) {
            if (map[i][col] == 6) {
                break;
            }
            if (map[i][col] == 0) {
                map[i][col] = -1;
            }
        }
    }

    public static void fillColDown(int[][] map, int row, int col) {
        for (int i = row + 1; i < N; i++) {
            if (map[i][col] == 6) {
                break;
            }
            if (map[i][col] == 0) {
                map[i][col] = -1;
            }
        }
    }


    public static int[][] deepCopy(int[][] map) {
        int[][] tmp = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tmp[i][j] = map[i][j];
            }
        }
        return tmp;
    }

    public static int checkInvisibleCount(int[][] map) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    count++;
                }
            }
        }
        return count;
    }
}
