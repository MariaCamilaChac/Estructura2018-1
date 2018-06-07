/**89
99 99 99 99 99 99 99 88 11 11 11 11 11
99 45 36 99 82 53 99 88 11 11 11 11 11
99 52 00 99 86 34 99 88 11 11 11 11 11
99 63 53 99 48 98 99 88 11 11 11 11 11
99 74 62 99 59 73 99 88 11 11 11 11 11
99 58 76 99 64 00 99 88 88 88 88 88 88
99 59 85 99 75 63 99 99 99 99 99 99 99 
99 64 95 99 84 75 99 76 82 00 67 45 83
99 00 75 99 93 83 99 85 96 38 78 86 42
99 63 65 99 53 98 99 99 99 99 99 99 99 
99 85 59 99 75 00 99 36 47 87 86 48 96
99 94 96 99 76 62 99 00 58 87 87 47 74
99 99 99 99 99 99 99 99 99 99 99 99 99 
*/


package TercerCorte;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ChoosingPlace {
    
    public static double CalculateMatrix(int row, int column, int matrix[][]){
      
    	double average = 0, count = 0;
        if (row - 1 >= 0 && column - 1 >= 0 && matrix[row - 1][column - 1] != 99
            && matrix[row - 1][column - 1] != 11 && matrix[row - 1][column - 1] != 88) {
            average += matrix[row - 1][column - 1];
            count++;
        }
        if(row - 1 >= 0 && matrix[row - 1][column] != 99
            && matrix[row - 1][column] != 11 && matrix[row - 1][column] != 88){
            average += matrix[row - 1][column];
            count++;
        }
        if(row - 1 >= 0 && column + 1 < 13 && matrix[row - 1][column + 1] != 99
            && matrix[row - 1][column + 1] != 11 && matrix[row - 1][column + 1] != 88){
            average += matrix[row - 1][column + 1];
            count++;
        }
        if(column + 1 < 13 && matrix[row][column + 1] != 99
            && matrix[row][column + 1] != 11 && matrix[row][column + 1] != 88){
            average += matrix[row][column + 1];
            count++;
        }
        if(row + 1 < 13 && column + 1 < 13 && matrix[row + 1][column + 1] != 99
            && matrix[row + 1][column + 1] != 11 && matrix[row + 1][column + 1] != 88){
            average += matrix[row + 1][column + 1];
            count++;
        }
        if(row + 1 < 13 && matrix[row + 1][column] != 99
            && matrix[row + 1][column] != 11 && matrix[row + 1][column] != 88){
            average += matrix[row + 1][column];
            count++;
        }
        if(row + 1 < 13 && column - 1 >= 0 && matrix[row + 1][column - 1] != 99
            && matrix[row + 1][column - 1] != 11 && matrix[row + 1][column - 1] != 88){
            average += matrix[row + 1][column - 1];
            count++;
        }
        if(column - 1 >= 0 && matrix[row][column - 1] != 99
            && matrix[row][column - 1] != 11 && matrix[row][column - 1] != 88){
            average += matrix[row][column - 1];
            count++;
        }
        return (average/count);
    }
    
    public static int calculateDistance(int row, int column){
        return (row + Math.abs(column - 7));
    }
    
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] cafeteria = new int[13][13];
        int i,j,k = 0;
        int WBJ;
        int Places = 0;
        int lowerDistance;
        double lowerAverage;
        String[] averageAdjacent;
        String input = "";
        
        WBJ = Integer.parseInt(br.readLine());
        
        for (i = 0; i < 13; i++) {
            input = br.readLine();
            for (j = 0; j < 13; j++) {
                if(Integer.parseInt(input.split(" ")[j]) == 0){
                    Places++;
                }
                cafeteria[i][j] = Integer.parseInt(input.split(" ")[j]);
            }
        }
        
        averageAdjacent = new String[Places];
        
        for (i = 0; i < 13; i++) { //calculate the distance and the average for the possible places
            for (j = 0; j < 13; j++) {
                if(cafeteria[i][j] == 0){
                    averageAdjacent[k++] = CalculateMatrix(i, j, cafeteria) + " " + calculateDistance(i, j) + " " + i + " " + j;
                }
            }
        }
        
        lowerAverage = 100;
        lowerDistance = 100;
        for (i = 0; i < Places; i++) {
            if (Double.parseDouble(averageAdjacent[i].split(" ")[0]) < WBJ) {
                if (Double.parseDouble(averageAdjacent[i].split(" ")[0]) <= lowerAverage
                        && Integer.parseInt(averageAdjacent[i].split(" ")[1]) <= lowerDistance) {
                    lowerAverage = Double.parseDouble(averageAdjacent[i].split(" ")[0]);
                    lowerDistance = Integer.parseInt(averageAdjacent[i].split(" ")[1]);
                    input = averageAdjacent[i].split(" ")[2] + " " + averageAdjacent[i].split(" ")[3];
                }
            }
        }

        bw.write("linha > " + (input.split(" ")[0] + 1) + " coluna > " + (input.split(" ")[1] + 1) + "\n");
        bw.flush();
    }
}
