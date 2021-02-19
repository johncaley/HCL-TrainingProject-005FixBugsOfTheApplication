import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Integer> arrlist;
    private static ArrayList<Integer> expenses;

    public static void main(String[] args) {
        /*System.out.println("Hello World!");*/
        defineInitialValues();
        System.out.println("\n**************************************\n");
        System.out.println("\tWelcome to TheDesk \n");
        System.out.println("**************************************");
        optionsSelection();

    }

    private static void defineInitialValues() {
        arrlist = new ArrayList<Integer>();
        expenses = new ArrayList<Integer>();
        expenses.add(1000);
        expenses.add(2300);
        expenses.add(45000);
        expenses.add(32000);
        expenses.add(110);
        expenses.addAll(arrlist);
    }

    private static void optionsSelection() {
        String[] arr = {"1. I wish to review my expenditure",
                "2. I wish to add my expenditure",
                "3. I wish to delete my expenditure",
                "4. I wish to sort the expenditures",
                "5. I wish to search for a particular expenditure",
                "6. Close the application"
        };
        int[] arr1 = {1,2,3,4,5,6};
        int  slen = arr1.length;
        for(int i=0; i<slen;i++){
            System.out.println(arr[i]);
            // display the all the Strings mentioned in the String array
        }
        System.out.println("\nEnter your choice:\t");
        Scanner sc = new Scanner(System.in);
        int  options =  sc.nextInt();
        for(int j=1;j<=slen;j++){
            if(options==j){
                switch (options){
                    case 1:
                        System.out.println("Your saved expenses are listed below: \n");
                        System.out.println(expenses+"\n");
                        optionsSelection();
                        break;
                    case 2:
                        System.out.println("Enter the value to add your Expense: \n");
                        int value = sc.nextInt();
                        expenses.add(value);
                        System.out.println("Your value is updated\n");
                        expenses.addAll(arrlist);
                        System.out.println(expenses+"\n");
                        optionsSelection();

                        break;
                    case 3:
                        System.out.println("You are about the delete all your expenses! \nConfirm again by selecting the same option...\n");
                        int con_choice = sc.nextInt();
                        if(con_choice==options){
                               expenses.clear();
                            System.out.println(expenses+"\n");
                            System.out.println("All your expenses are erased!\n");
                        } else {
                            System.out.println("Oops... try again!");
                        }
                        optionsSelection();
                        break;
                    case 4:
                        sortExpenses(expenses);
                        optionsSelection();
                        break;
                    case 5:
                        searchExpenses(expenses);
                        optionsSelection();
                        break;
                    case 6:
                        closeApp();
                        break;
                    default:
                        System.out.println("You have made an invalid choice!");
                        break;
                }
            }
        }

    }
    private static void closeApp() {
        System.out.println("Closing your application... \nThank you!");
            }
    private static void searchExpenses(ArrayList<Integer> arrayList) {
        int leng = arrayList.size();
        System.out.println("Enter the expense you need to search:\t");
        Scanner sc = new Scanner(System.in);
        int input =  sc.nextInt();
        linearSearch(arrayList, input);
    }

    private static void linearSearch(ArrayList<Integer> arrayList, int element){
        boolean found = false;
        for (int i = 0; i < arrayList.size(); i++){
            if (arrayList.get(i) == element){
                found = true;
                System.out.println("Value \"" + element + "\" exists in expenses at index \"" + i + "\"\n");
                break;
            }
        }
        if (found == false){
            System.out.println("Value \"" + element + "\" does not exists in expenses\n");
        }
    }

    private static void sortExpenses(ArrayList<Integer> arraylist) {
        //bubblsort(arraylist);
        quicksort(arraylist, 0, arraylist.size()-1);
    }

    private static void bubblsort(ArrayList<Integer> arrayList){
        for (int i = 0; i < arrayList.size(); i++){
            for (int j = 0; j < arrayList.size()-1; j++){
                if (arrayList.get(j) > arrayList.get(j+1)){
                    int temp = arrayList.get(j);
                    arrayList.set(j, arrayList.get(j+1));
                    arrayList.set(j+1, temp);
                }
            }
        }
    }

    private static void quicksort(ArrayList<Integer> arrayList, int low, int high){
        if (low < high){
            int partitionIndex = quicksortPartition(arrayList, low, high);

            quicksort(arrayList, low, partitionIndex-1);
            quicksort(arrayList, partitionIndex+1, high);
        }
    }

    private static int quicksortPartition(ArrayList<Integer> arrayList, int low, int high){
        int pivot = arrayList.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++){
            if (arrayList.get(j) < pivot){
                i++;

                int temp = arrayList.get(i);
                arrayList.set(i, arrayList.get(j));
                arrayList.set(j, temp);
            }
        }

        int temp = arrayList.get(i+1);
        arrayList.set(i+1, arrayList.get(high));
        arrayList.set(high, temp);

        return i+1;
    }
}
