package com.atguigu;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.*;
public class sparsearray {
    public static void main(String[] args) throws Exception{
        //创建原始二维数字11 * 11
        //0：没有子， 1：黑子， 2：蓝子
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[4][5] = 2;
        //输出原始二维数组
        System.out.println("原始二维数组");
        for(int[] row : chessArr1){
            for(int data: row){
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
        //将二维数组转稀疏数组
        //1.遍历二维数组得到非零个数
        int sum = 0;
        for (int i = 0; i < 11; i++){
            for (int j = 0; j < 11; j++){
                if (chessArr1[i][j] != 0){
                    sum++;
                }
            }
        }
        //2.创建对应稀疏数组
        int sparseArr[][] = new int[sum + 1][3];
        //给稀疏数组赋值
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;

        //遍历二维数组，非零值存放到稀疏数组
        int count = 0;//count 记录第几个非零
        for (int i = 0; i < 11; i++){
            for (int j = 0; j < 11; j++){
                if (chessArr1[i][j] != 0){
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }
        //写入文件
        File file = new File("E:\\sparsearray.txt");

        FileWriter out = new FileWriter(file);

        for (int i = 0; i < sparseArr.length; i++){
            out.write(sparseArr[i][0] + "\t");
            out.write(sparseArr[i][1] + "\t");
            out.write(sparseArr[i][2] + "\t");
            out.write("\n");
        }
        out.close();

        //输出稀疏数组的形式
        System.out.println();
        System.out.println("稀疏数组为如下");
        for (int i = 0; i < sparseArr.length; i++){
            System.out.printf("%d\t%d\t%d\t\n", sparseArr[i][0], sparseArr[i][1], sparseArr[i][2]);
        }
        System.out.println();

        //将稀疏数组恢复为原始二维数组
        //读取文件
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        line = in.readLine();
        String[] firstline = line.split("\t");
        int chessArr3[][] = new int[Integer.parseInt(firstline[0])][Integer.parseInt(firstline[1])];



        while ((line = in.readLine()) != null){
            String[] temp = line.split("\t");
            chessArr3[Integer.parseInt(temp[0])][Integer.parseInt(temp[1])] = Integer.parseInt(temp[2]);

        }
        in.close();
/*

        int chessArr2[][] = new int[sparseArr[0][0]][sparseArr[0][1]];

        for(int i = 1; i < sparseArr.length; i++){
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
*/
        System.out.println("恢复后数组");
        for(int[] row5 : chessArr3){
            for(int data: row5){
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }




    }
}
