import java.awt.Color;
import java.util.concurrent.TimeUnit;

import javax.swing.*;

public class Map {
    public static int[] arr;
    public static JPanel[] bars = new JPanel[10];
    public static JLabel[] labels = new JLabel[10];
    public static JFrame frame;
    // Dimensions
    public static int hMap = 700;
    public static int wMap = 1000;
    public static int w;
    public static int scale = 50;
    // Labels
    public static JLabel title;
    public static JLabel lblAlg;
    public static String sAlg = "Algorithm: ";
    public static JLabel lblSteps;
    public static String sSteps = "Steps: ";
    public static int iSteps = 0;

    public Map(int[] arr) {
        Map.arr = arr;
        Init();
        
    }

    public void Init() {
        frame = new JFrame("Sorting Algorithms");
        frame.setLayout(null);
        frame.setSize(wMap, hMap);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        w = frame.getWidth() / arr.length - 20;

        for (int i = 0; i < arr.length; i++) {
            bars[i] = new JPanel();
            bars[i].setBounds(i * (w + 10), 600 - (arr[i] * scale), w, arr[i] * scale);
            bars[i].setBackground(Color.blue);
            bars[i].setVisible(true);
            frame.add(bars[i]);
            System.out.println("bar in position - " + arr[i]);
        }

        // Add Labels
        title = new JLabel("Sort Demo");
        title.setBounds(10, 20, 100,50);
        frame.add(title);
        lblAlg = new JLabel(sAlg);
        lblAlg.setBounds(200, 20, 200,50);
        frame.add(lblAlg);
        lblSteps = new JLabel(sSteps);
        lblSteps.setBounds(400, 20, 200,50);
        frame.add(lblSteps);

        for(int i = 0; i < arr.length; i++){
            labels[i] = new JLabel("<"+arr[i]+">");
            labels[i].setBounds(i * (w + 10), 600, w, 50);
            labels[i].setHorizontalAlignment(JLabel.CENTER);
            frame.add(labels[i]);
        }

        frame.setVisible(true);
    }

    public static void render(String alg, int[] arr) {
        System.out.println("Running Render...");
        lblAlg.setText(sAlg + alg);
        iSteps++;

        
        // Refreshing columns
        for (int i = 0; i < arr.length; i++) {
            bars[i].setBounds(i * (w + 10), 600 - (arr[i] * scale), w, arr[i] * scale);
            System.out.println("bar in position - " + arr[i]);
            labels[i].setText("<"+arr[i]+">");
            lblSteps.setText(sSteps+iSteps);
        }
        // Waiting...
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public  void highlight(int j1, int j2){
        bars[j1].setBackground(Color.green);
        bars[j2].setBackground(Color.green);
    }

    public void refreshColors(){
        for (int i = 0; i < arr.length; i++){
            bars[i].setBackground(Color.blue);
        }
    }

}
