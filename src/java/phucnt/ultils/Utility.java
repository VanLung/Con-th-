/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phucnt.ultils;

/**
 *
 * @author PC
 */
public class Utility {
    public static int numberChecker(String text) {
        boolean fine = true;
        //tách ra xét từng kí tự
        for(int i=0; i < text.length(); i++) {
            switch(text.charAt(i)) {
                //nằm trong khoảng 0-9 thì skip
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    break;
                //khác 0-9 thì biến check đổi thành false
                default:
                    fine = false;
                    break;
            }
            if (fine == false) {
                break;
            }
        }
        //check true thì chuyển sẽ ko lỗi
        if (fine)
            return Integer.parseInt(text);
        //check false thì ko chuyển, return con số nào khác nguyên dương
        return -1;
    }
}
