import javax.swing.JOptionPane;

class Main{
    static int[] arr = {9,1,8,2,7,3,6,4,5};
    static Map map;
    public static void main(String[] args) {
        
        map = new Map(arr);
        //bubbleSort();
        insertionSort();
    }

    public static void bubbleSort(){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length-1; j++){
                map.highlight(j, j+1);
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    
                    map.render("BubbleSort", arr);    
                }
                map.refreshColors();
            }
        }
    }

    public static void insertionSort(){
        for (int i = 1; i < arr.length; i++){
            int j = i;
            while(j > 0 && arr[j] < arr[j-1]){
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
                j--;
                if(j-1 >= 0)
                    map.highlight(j, j-1);
                map.render("Insertion Sort", arr);
                map.refreshColors();
            }
        }
    }
}