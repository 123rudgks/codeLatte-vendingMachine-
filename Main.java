package com.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
	// write your code here
    String[] beverageName = new String[]{"Coca Cola", "Sprite", "Fanta"};
    int[] beverageCost = new int[]{1500,1200,1000};
    int[] beverageStock = new int[]{2,6,7};
    int numSelected = 0;
    int money = 0;
    int isExist = 0;
    Scanner scanner = new Scanner(System.in);
    
    // 음료 뽑은 이후 다시 처음부터 반복문
    while(isExist==0){
        System.out.println("----------vending machine----------");
        // 메뉴 출력하는 반복문
        for(int index = 0; index < 3; index++) {
            System.out.printf("[%d] %s \nprice:%d amount:%d\n", index + 1, beverageName[index], beverageCost[index], beverageStock[index]);
        }

        System.out.println("\n------------------------------------");
        // 재고와 금액 확인하는 반복문
        do{
            System.out.print("Insert the money: ");
            money = money + scanner.nextInt();

            //음료 번호 입력 후 재고 확인
            do{
                System.out.print("Choose the number of the beverage: ");
                numSelected = scanner.nextInt() - 1; // 메뉴 번호는 1부터 시작하기때문에 index값으로 맞추기 위해 1씩 차감
                if (beverageStock[numSelected] <= 0) { // 재고가 없을 경우
                    System.out.printf("Sorry, there is no stock for [%s] please choose the other beverage\n", beverageName[numSelected]);
                    numSelected=0;
                }
            }while(beverageStock[numSelected] <= 0); // 재고가 없을 경우 물품 선택 다시

            //음료가격과 투입된 금액 비교
            if (money < beverageCost[numSelected]) { // 투입된 금액이 모자랄 경우
                System.out.println("Insufficient cash. insert more money");
                System.out.printf("you are short of %d Won\n", beverageCost[numSelected] - money);
            }
        }while(money < beverageCost[numSelected]); // 투입된 금액이 모잘랄 경우 다시 처음으로

        money = money - beverageCost[numSelected]; // 금액 차감
        beverageStock[numSelected]--; // 재고 차감
        System.out.println("\n------------------------------------");
        System.out.println(String.format("You've got a [%s]!!", beverageName[numSelected]));

        System.out.println(String.format("changes: %d", money));
        System.out.println("Do you want to return the changes? (yes: 1, no: 0)");
        isExist = scanner.nextInt();
        
    }
        System.out.println(String.format("You've got %d changes",money));
        System.out.println("Thank you for using");

    }
}
