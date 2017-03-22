/*s
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibysad.jineo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import hibysad.PrintOrHearValue.PrintHearValue;

/**
 *
 * @author ajay
 */
public class StringReader {

    String s;
    Scanner scan;
    PrintHearValue p;

    public StringReader() {
        p = new PrintHearValue();
        scan = new Scanner(System.in);
    }

    public String readString() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            s = br.readLine();
        } catch (IOException ex) {
            Logger.getLogger(Jineo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }

    public int readInteger() {
        int s = 0;
        try {
            if (scan.hasNextInt()) {
                s = scan.nextInt();
            } else {
                p.print("Please enter an integer value");
                readInteger();
            }
        } catch (Exception ex) {
            Logger.getLogger(Jineo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }

    public boolean readBoolean() {
        boolean s = false;
        try {
            if (scan.hasNextBoolean()) {
                s = scan.nextBoolean();
            } else {
                p.print("Please enter an boolean value");
                readBoolean();
            }
        } catch (Exception ex) {
            Logger.getLogger(Jineo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }

    public long readLong() {
        long s = 0;
        try {
            if (scan.hasNextLong()) {
                s = scan.nextLong();
            } else {
                p.print("Please enter an long value");
                readLong();
            }
        } catch (Exception ex) {
            Logger.getLogger(Jineo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }

    public float readFloat() {
        float s = 0;
        try {
            if (scan.hasNextFloat()) {
                s = scan.nextFloat();
            } else {
                p.print("Please enter an float value");
                readFloat();
            }
        } catch (Exception ex) {
            Logger.getLogger(Jineo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }

    public double readDouble() {
        double s = 0;
        try {
            if (scan.hasNextDouble()) {
                s = scan.nextDouble();
            } else {
                p.print("Please enter an double value");
                readDouble();
            }
        } catch (Exception ex) {
            Logger.getLogger(Jineo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }
}
